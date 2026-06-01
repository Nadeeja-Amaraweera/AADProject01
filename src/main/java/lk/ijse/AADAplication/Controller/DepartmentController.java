package lk.ijse.AADAplication.Controller;

import lk.ijse.AADAplication.Service.DepartmentService;
import lk.ijse.AADAplication.dto.DepartmentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        log.info("Department Save Ok");
        return departmentService.saveDepartment(departmentDTO);
    }

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDTO> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.updateDepartment(departmentDTO);
    }


}
