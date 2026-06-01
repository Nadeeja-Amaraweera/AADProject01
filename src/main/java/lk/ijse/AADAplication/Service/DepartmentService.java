package lk.ijse.AADAplication.Service;

import lk.ijse.AADAplication.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartment();

    DepartmentDTO updateDepartment(DepartmentDTO departmentDTO);

}
