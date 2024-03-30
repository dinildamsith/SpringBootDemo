package lk.ijse.SpringBootDemo.reqAndResp.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignIn {
    private String email;
    private String password;
}
