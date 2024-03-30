package lk.ijse.SpringBootDemo.controller;

import lk.ijse.SpringBootDemo.reqAndResp.response.JwtAuthResponse;
import lk.ijse.SpringBootDemo.reqAndResp.secure.SignIn;
import lk.ijse.SpringBootDemo.reqAndResp.secure.SignUp;
import lk.ijse.SpringBootDemo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/singUp")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq){
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }
    @PostMapping("/singIn")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq){
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }

}
