package lk.ijse.SpringBootDemo.service.impl;

import lk.ijse.SpringBootDemo.Entity.UserEntity;
import lk.ijse.SpringBootDemo.dao.UserRepo;
import lk.ijse.SpringBootDemo.dataConvert.DataConvert;
import lk.ijse.SpringBootDemo.dto.UserDTO;
import lk.ijse.SpringBootDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final DataConvert dataConvert;

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userRepo.save(dataConvert.userDtoConvertToUserEntity(userDTO));
    }
}
