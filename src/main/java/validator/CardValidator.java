package validator;

import root.model.TabooCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardValidator {

    private List<String> errorMessages = new ArrayList<>();
    private List<TabooCard> all;

    public CardValidator(List<TabooCard> all) {
        this.all = all;
    }

    public boolean isValid(TabooCard card) {
        return isFieldIsValid(card) && checkDuplicateFields(card) && checkExistingWords(card);
    }

    private boolean isFieldIsValid(TabooCard tabooCard) {
        boolean b = Stream.of(tabooCard.getMainWord(), tabooCard.getForbiddenWord1(), tabooCard.getForbiddenWord2(),
                tabooCard.getForbiddenWord3(), tabooCard.getForbiddenWord4(),
                tabooCard.getForbiddenWord5(), tabooCard.getCategory(), tabooCard.getProvider())
                .noneMatch(field -> field == null || field.isEmpty());
        if (!b) {
            errorMessages.add("Fields can not be null or empty!");
        }
        return b;
    }

    private boolean checkDuplicateFields(TabooCard tabooCard) {
        boolean valid = Stream.of(tabooCard.getMainWord(), tabooCard.getForbiddenWord1(), tabooCard.getForbiddenWord2(),
                tabooCard.getForbiddenWord3(), tabooCard.getForbiddenWord4(),
                tabooCard.getForbiddenWord5())
                .map(String::toLowerCase)
                .collect(Collectors.toSet()).size() == 6;

        if (!valid) {
            errorMessages.add("Fields must be unique");
        }
        return valid;
    }

    private boolean checkExistingWords(TabooCard card) {
        if (all.contains(card)) {
            errorMessages.add("The word is already exist");
            return false;
        } else {
            return true;
        }

    }


    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
