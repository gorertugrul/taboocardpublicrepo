package live.service;

import live.repository.LiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.repository.AbstractRepository;
import root.service.AbstractService;

@Service
public class LiveService extends AbstractService {

    @Autowired
    LiveRepository repository;

    @Override
    protected AbstractRepository getRepository() {
        return this.repository;
    }
}
