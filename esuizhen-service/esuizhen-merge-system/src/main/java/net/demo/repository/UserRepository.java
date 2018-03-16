package net.demo.repository;

import net.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

/**
 * Created by fqc on 11/29/16.
 */
@RepositoryRestResource
@Component
public interface UserRepository extends JpaRepository<User,Long> {
}
