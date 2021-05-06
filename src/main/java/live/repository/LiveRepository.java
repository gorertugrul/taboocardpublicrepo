package live.repository;

import org.springframework.stereotype.Repository;
import root.model.TabooCard;
import root.model.TabooCollections;
import root.repository.AbstractRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class LiveRepository extends AbstractRepository {

    @Override
    public String getCollectionName() {
        return TabooCollections.LIVE.getName();
    }

    @Override
    public List<TabooCard> findByIdForAllCard(String id) {
        return Stream.of(getMongoTemplate().findById(id, TabooCard.class, TabooCollections.LIVE.getName()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
