package lk.ijse.AADAplication.Repository;

import lk.ijse.AADAplication.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
