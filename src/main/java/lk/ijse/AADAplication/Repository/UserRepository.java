package lk.ijse.AADAplication.Repository;

import lk.ijse.AADAplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM user_table WHERE (?1 IS NULL OR first_name LIKE %?1%) AND (?2 IS NULL OR last_name = %?2%)",nativeQuery = true)
    List<User> filterUsers(String firstName, String lastName);
}
