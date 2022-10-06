package br.com.mefit.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.mefit.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
