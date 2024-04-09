package lk.ijse.SpringBootDemo.service;

import lk.ijse.SpringBootDemo.reqAndResp.response.JwtAuthResponse;
import lk.ijse.SpringBootDemo.reqAndResp.secure.SignIn;
import lk.ijse.SpringBootDemo.reqAndResp.secure.SignUp;
import org.springframework.stereotype.Service;


public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);

    JwtAuthResponse refreshToken(String accessToken);
}
