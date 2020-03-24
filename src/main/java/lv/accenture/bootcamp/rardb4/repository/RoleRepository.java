package lv.accenture.bootcamp.rardb4.repository;

import lv.accenture.bootcamp.rardb4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
