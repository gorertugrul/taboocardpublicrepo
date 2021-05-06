package root.repository;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import root.model.TabooCard;
import root.model.TabooCollections;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class AbstractRepository implements ContainsCollection {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<TabooCard> all() {
        return mongoTemplate.findAll(TabooCard.class, getCollectionName());
    }

    public void save(TabooCard card) {
        mongoTemplate.save(card, getCollectionName());
    }

    public Optional<TabooCard> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, TabooCard.class, getCollectionName()));
    }

    public DeleteResult deleteById(String id) {
        return mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), TabooCard.class, getCollectionName());
    }

    public List<TabooCard> allExistingCard() {
        return TabooCollections.cards()
                .flatMap(collection -> mongoTemplate.findAll(TabooCard.class, collection).stream())
                .collect(Collectors.toList());
    }

    public List<TabooCard> findByIdForAllCard(String id) {
        return TabooCollections.cards()
                .map(collection -> mongoTemplate.findById(id, TabooCard.class, collection))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public boolean andExists(String id) {
        return TabooCollections.cards()
                .map(collection -> mongoTemplate.findById(id, TabooCard.class, collection))
                .anyMatch(Objects::nonNull);
    }

    public Date findLastUpdated() {
        Query query = new Query()
                .with(Sort.by(Sort.Order.desc("dateCreated"))).
                        limit(1);
        TabooCard one = mongoTemplate.findOne(query, TabooCard.class, getCollectionName());
        return one == null ? new Date(0) : one.getDateCreated();
    }

    public long countOfDocument() {
        return mongoTemplate.getCollection(getCollectionName()).countDocuments();
    }

    protected MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
}
