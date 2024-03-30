package lk.ijse.SpringBootDemo.dao;

import lk.ijse.SpringBootDemo.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {
}
