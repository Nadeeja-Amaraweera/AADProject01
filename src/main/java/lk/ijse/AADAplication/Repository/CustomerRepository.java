package lk.ijse.AADAplication.Repository;

import lk.ijse.AADAplication.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
