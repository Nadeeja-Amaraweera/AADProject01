package lk.ijse.AADAplication.Service.impl;

import lk.ijse.AADAplication.Entity.Department;
import lk.ijse.AADAplication.Entity.User;
import lk.ijse.AADAplication.Repository.DepartmentRepository;
import lk.ijse.AADAplication.Service.DepartmentService;
import lk.ijse.AADAplication.dto.DepartmentDTO;
import lk.ijse.AADAplication.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        log.info("DepartmentImpl - saveDepartment() called");
        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentLocation(departmentDTO.getDepartmentLocation());

        Department department1 = departmentRepository.save(department);
        log.info("Department Save Successful");

        DepartmentDTO responseDTO = new DepartmentDTO();
        responseDTO.setDepartmentId(department1.getDepartmentId());
        responseDTO.setDepartmentName(department1.getDepartmentName());
        responseDTO.setDepartmentLocation(department1.getDepartmentLocation());

        return departmentDTO;
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        log.info("Executed method getALlDepartment()");

        try {
            List<DepartmentDTO> responseList = new ArrayList<>();

            List<Department> departmentList = departmentRepository.findAll();

            for (Department department : departmentList){
                DepartmentDTO departmentDTO = new DepartmentDTO();
                departmentDTO.setDepartmentId(department.getDepartmentId());
                departmentDTO.setDepartmentName(department.getDepartmentName());
                departmentDTO.setDepartmentLocation(department.getDepartmentLocation());


                responseList.add(departmentDTO);
            }

            return responseList;

        } catch (Exception e){

            throw e;
        }
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentDTO.getDepartmentId());

        if (optionalDepartment.isPresent()){
            Department department = optionalDepartment.get();
            department.setDepartmentName(departmentDTO.getDepartmentName());
            department.setDepartmentLocation(departmentDTO.getDepartmentLocation());

            Department updateDepartment = departmentRepository.save(department);

            DepartmentDTO responseDTO = new DepartmentDTO();
            responseDTO.setDepartmentId(updateDepartment.getDepartmentId());
            responseDTO.setDepartmentName(updateDepartment.getDepartmentName());
            responseDTO.setDepartmentLocation(updateDepartment.getDepartmentLocation());

            return responseDTO;
        } else {
            log.error("No Department found with ID: {}", departmentDTO.getDepartmentId());
            throw new RuntimeException("No Department found with ID: " + departmentDTO.getDepartmentId());
        }
    }

    @Override
    public List<DepartmentDTO> filterDepartment(String departmentName, String departmentLocation) {
        log.info("Filter department");
        try {
            List<DepartmentDTO> responseList = new ArrayList<>();

            List<Department> departmentList = departmentRepository.filterDepartment(departmentName,departmentLocation);

            for (Department department : departmentList){
                DepartmentDTO departmentDTO = new DepartmentDTO();
                departmentDTO.setDepartmentId(department.getDepartmentId());
                departmentDTO.setDepartmentName(department.getDepartmentName());
                departmentDTO.setDepartmentLocation(department.getDepartmentLocation());


                responseList.add(departmentDTO);
            }
            return responseList;
        } catch (Exception e){
            throw e;
        }

    }
}
