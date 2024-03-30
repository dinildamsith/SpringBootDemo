package lk.ijse.SpringBootDemo.dto;

import lk.ijse.SpringBootDemo.Entity.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
