package validator;

import root.model.TabooCard;

import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardFormatter {

    private Locale locale = new Locale("tr", "TR");

    public void formatCard(TabooCard card) {
        card.setMainWord(formatText(card.getMainWord()));
        card.setForbiddenWord1(formatText(card.getForbiddenWord1()));
        card.setForbiddenWord2(formatText(card.getForbiddenWord2()));
        card.setForbiddenWord3(formatText(card.getForbiddenWord3()));
        card.setForbiddenWord4(formatText(card.getForbiddenWord4()));
        card.setForbiddenWord5(formatText(card.getForbiddenWord5()));
        card.setCategory(formatText(card.getCategory()));
        card.setProvider(formatText(card.getProvider()));
        if (card.getDateCreated() == null) {
            card.setDateCreated(new Date());
        }
    }


    private String formatText(String text) {
        return Stream.of(text.trim().split(" "))
                .map(word -> {
                    word = word.trim().toLowerCase(locale);
                    String firstCharacter = "" + word.charAt(0);
                    firstCharacter = firstCharacter.toUpperCase(locale);
                    return firstCharacter + word.substring(1);
                }).collect(Collectors.joining(" "));
    }

}
