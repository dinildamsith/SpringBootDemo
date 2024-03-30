package lk.ijse.SpringBootDemo.service.impl;

import lk.ijse.SpringBootDemo.Entity.Role;
import lk.ijse.SpringBootDemo.Entity.UserEntity;
import lk.ijse.SpringBootDemo.dao.UserRepo;
import lk.ijse.SpringBootDemo.dataConvert.DataConvert;
import lk.ijse.SpringBootDemo.dto.UserDTO;
import lk.ijse.SpringBootDemo.reqAndResp.response.JwtAuthResponse;
import lk.ijse.SpringBootDemo.reqAndResp.secure.SignIn;
import lk.ijse.SpringBootDemo.reqAndResp.secure.SignUp;
import lk.ijse.SpringBootDemo.service.AuthenticationService;
import lk.ijse.SpringBootDemo.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {

    private final UserRepo userRepo;
    private final JWTService jwtService;
    private final DataConvert dataConvert;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        UserEntity userByEmail = userRepo.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Not Found User Mail"));
        String generatedToken = jwtService.generateToken(userByEmail);

        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDTO userDTO = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .name(signUp.getName())
                .role(Role.valueOf(String.valueOf(signUp.getRole())))
                .password(passwordEncoder.encode(signUp.getPassword()))
                .build();
        UserEntity save = userRepo.save(dataConvert.userDtoConvertToUserEntity(userDTO));
        String s = jwtService.generateToken(save);
        return JwtAuthResponse.builder().token(s).build();

    }
}
