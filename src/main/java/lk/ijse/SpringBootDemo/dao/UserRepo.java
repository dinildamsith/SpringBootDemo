package lk.ijse.SpringBootDemo.dao;

import lk.ijse.SpringBootDemo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,String> {

    Optional<UserEntity> findByEmail(String email);
}
