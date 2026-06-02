package lk.ijse.AADAplication.Repository;

import lk.ijse.AADAplication.Entity.Order;
import lk.ijse.AADAplication.dto.SaveOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
