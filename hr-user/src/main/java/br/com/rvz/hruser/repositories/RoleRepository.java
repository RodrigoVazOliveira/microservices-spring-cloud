package br.com.rvz.hruser.repositories;

import br.com.rvz.hruser.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}