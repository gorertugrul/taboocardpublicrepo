package candidate.repository;


import org.springframework.stereotype.Repository;
import root.model.TabooCollections;
import root.repository.AbstractRepository;

@Repository
public class CandidateRepository extends AbstractRepository {

    @Override
    public String getCollectionName() {
        return TabooCollections.CANDIDATE.getName();
    }

}
