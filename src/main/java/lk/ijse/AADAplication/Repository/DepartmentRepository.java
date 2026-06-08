package lk.ijse.AADAplication.Repository;

import lk.ijse.AADAplication.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "SELECT * FROM department WHERE (?1 IS NULL OR department_name LIKE %?1%) AND (?2 IS NULL OR department_location = %?2%)",nativeQuery = true)
    List<Department> filterDepartment(String departmentName, String departmentLocation);
}
