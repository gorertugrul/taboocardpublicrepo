package candidate.service;

import candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.repository.AbstractRepository;
import root.service.AbstractService;

@Service
public class CandidateService extends AbstractService {

    @Autowired
    CandidateRepository repository;

    @Override
    protected AbstractRepository getRepository() {
        return this.repository;
    }
}
