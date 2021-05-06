package root.controller;


import com.mongodb.client.result.DeleteResult;
import constants.Messages;
import org.springframework.web.bind.annotation.*;
import root.model.Response;
import root.model.TabooCard;
import root.service.AbstractService;
import validator.CardFormatter;
import validator.CardValidator;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
public abstract class AbstractController {

    public abstract AbstractService getService();

    @GetMapping("/all")
    public List<TabooCard> all() {
        return getService().all();
    }

    @PostMapping(path = "/addWord", consumes = "application/json", produces = "application/json")
    public Response addCard(@RequestBody TabooCard card) {
        CardValidator validator;
        validator = new CardValidator(findByIdForAllCard(card.getMainWord()));
        if (validator.isValid(card)) {
            new CardFormatter().formatCard(card);
            getService().save(card);
            return new Response(Messages.SUCCESS, "Taboo card added successfully");
        } else {
            return new Response(Messages.ERROR, String.join(". ", validator.getErrorMessages()));
        }
    }

    private List<TabooCard> findByIdForAllCard(String id) {
        return getService().findByIdForAllCard(id);
    }

    @GetMapping("/allExistingCards")
    public List<TabooCard> allExistingCards() {
        return getService().allExistingCard();
    }

    @GetMapping("/findById")
    public Optional<TabooCard> getCard(@RequestParam(name = "id") String id) {
        return getService().findById(id);
    }

    @GetMapping("/delete")
    public Response delete(@RequestParam(name = "id") String id) {
        if (id.contains("-")) {
            String[] idArray = id.split("-");
            if (getService().anyExist(idArray[0]) && "0".equals(idArray[1])) {
                // TODO : DeleteResult mı dönülmeli ?
                DeleteResult deleteResult = getService().deleteById(idArray[0]);
                return new Response(Messages.SUCCESS, idArray[0] + " has been deleted successfully");
            } else {
                return new Response(Messages.WARNING, "There is no word in an " + id + " id!");
            }
        } else {
            return new Response(Messages.ERROR, "Invalid request!");
        }
    }

    @PostMapping(path = "/bulkImport", consumes = "application/json", produces = "application/json")
    public Response bulkImport(@RequestBody List<TabooCard> cards) {
        CardFormatter formatter = new CardFormatter();
        cards.forEach(formatter::formatCard);
        CardValidator validator = new CardValidator(getService().all());
        cards.stream().filter(validator::isValid)
                .forEach(card -> getService().save(card));
        String dataCouldntImport = cards.stream()
                .filter(c -> !validator.isValid(c))
                .map(TabooCard::getMainWord)
                .collect(Collectors.joining(","));
        if (dataCouldntImport.isEmpty()) {
            return new Response(Messages.SUCCESS, "All the taboo cards has been imported successfully");
        } else {
            return new Response(Messages.WARNING, "Some cards could not be imported: " + dataCouldntImport);
        }
    }

    @GetMapping("/lastUpdated")
    public Date findLastUpdated() {
        return getService().findLastUpdated();
    }

    @GetMapping("/count")
    public long countOfDocument() {
        return getService().countOfDocument();
    }

}
