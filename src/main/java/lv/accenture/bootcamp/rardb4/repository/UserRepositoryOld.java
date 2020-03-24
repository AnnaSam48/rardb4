package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryOld extends CrudRepository<User, Long> {
}
