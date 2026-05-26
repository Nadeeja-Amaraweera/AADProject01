package lk.ijse.AADAplication.Repository;

import lk.ijse.AADAplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}
