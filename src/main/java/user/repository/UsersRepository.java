package user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import user.model.User;


public interface UsersRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
