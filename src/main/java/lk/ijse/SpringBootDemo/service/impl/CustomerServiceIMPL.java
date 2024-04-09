package lk.ijse.SpringBootDemo.service.impl;

import lk.ijse.SpringBootDemo.dao.CustomerRepo;
import lk.ijse.SpringBootDemo.dataConvert.DataConvert;
import lk.ijse.SpringBootDemo.dto.CustomerDTO;
import lk.ijse.SpringBootDemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepo customerRepo;
    private final DataConvert dataConvert;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        System.out.println(customerDTO);
        customerRepo.save(dataConvert.customerDTOConvertCustomerEntity(customerDTO));
    }

    @Override
    public void updateCustomer(String updateCustomerId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return dataConvert.toCustomerDTOList(customerRepo.findAll());
    }
}
