package lk.ijse.SpringBootDemo.controller;

import lk.ijse.SpringBootDemo.dto.CustomerDTO;
import lk.ijse.SpringBootDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
@Autowired
    private CustomerService customerService;

    @GetMapping
    String helloCustomer(){
        return "Hi Customer...";
    }

    @PostMapping(consumes = "application/json")
    public void saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
    }

}
