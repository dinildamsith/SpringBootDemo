package lk.ijse.SpringBootDemo.reqAndResp.secure;

import lk.ijse.SpringBootDemo.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUp {
    private String name;
    private String email;
    private String password;
    private Role role;
}
