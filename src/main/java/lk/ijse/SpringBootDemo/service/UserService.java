package lk.ijse.SpringBootDemo.service;

import lk.ijse.SpringBootDemo.Entity.UserEntity;
import lk.ijse.SpringBootDemo.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();
    void saveUser(UserDTO userDTO);
}
