package userService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}