package lk.ijse.SpringBootDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO {
    private String id;
    private String name;
    private String gender;
    private String address;
}
