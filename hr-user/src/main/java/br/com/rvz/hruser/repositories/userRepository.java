package br.com.rvz.hruser.repositories;

import br.com.rvz.hruser.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long> {
}