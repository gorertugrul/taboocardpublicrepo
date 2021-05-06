package root.service;


import com.mongodb.client.result.DeleteResult;
import org.springframework.stereotype.Service;
import root.model.TabooCard;
import root.repository.AbstractRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public abstract class AbstractService {
    protected abstract AbstractRepository getRepository();

    public List<TabooCard> all() {
        return getRepository().all();
    }

    public void save(TabooCard card) {
        getRepository().save(card);
    }

    public Optional<TabooCard> findById(String id) {
        return getRepository().findById(id);
    }

    public boolean anyExist(String id) {
        return getRepository().andExists(id);
    }

    public Date findLastUpdated() {
        return getRepository().findLastUpdated();
    }

    public long countOfDocument() {
        return getRepository().countOfDocument();
    }

    public DeleteResult deleteById(String id) {
        return getRepository().deleteById(id);
    }

    public List<TabooCard> allExistingCard() {
        return getRepository().allExistingCard();
    }

    public List<TabooCard> findByIdForAllCard(String id) {
        return getRepository().findByIdForAllCard(id);
    }
}
