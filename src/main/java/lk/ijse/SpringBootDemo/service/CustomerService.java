package lk.ijse.SpringBootDemo.service;

import lk.ijse.SpringBootDemo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String updateCustomerId , CustomerDTO customerDTO);
    void deleteCustomer(String id);

    List<CustomerDTO> getAllCustomers();

}
