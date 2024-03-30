package lk.ijse.SpringBootDemo.dataConvert;


import lk.ijse.SpringBootDemo.Entity.CustomerEntity;
import lk.ijse.SpringBootDemo.Entity.UserEntity;
import lk.ijse.SpringBootDemo.dto.CustomerDTO;
import lk.ijse.SpringBootDemo.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataConvert {
    private final ModelMapper modelMapper;

    // Customer Mapping
    public CustomerDTO customerEntityConvertCustomerDTO(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity customerDTOConvertCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    // User Mapping
    public UserEntity userDtoConvertToUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO userEntityConvertToUserDto(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

}
