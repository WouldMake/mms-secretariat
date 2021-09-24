package br.com.mesttra.secretariat.data;

import br.com.mesttra.secretariat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    @Query("select u from User u left join fetch u.roles where u.id = :id")
    Optional<User> findByIdWithJoinFetch(Long id);

}