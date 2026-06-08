package lk.ijse.AADAplication.Controller;

import lk.ijse.AADAplication.Service.DepartmentService;
import lk.ijse.AADAplication.constant.CommonResponse;
import lk.ijse.AADAplication.dto.DepartmentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.AADAplication.constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.AADAplication.constant.ResponseStatusCode.OPERATION_SUCCESS;

@Slf4j
@RestController
@RequestMapping("v1/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        log.info("Department Save Ok");
        DepartmentDTO departmentDTO1 = departmentService.saveDepartment(departmentDTO);

        return new CommonResponse(OPERATION_SUCCESS,departmentDTO1,SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDTO> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.updateDepartment(departmentDTO);
    }

    @GetMapping(value = "/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterDepartment(@RequestParam String departmentName, @RequestParam String departmentLocation){

        List<DepartmentDTO> departmentDTOList =  departmentService.filterDepartment(departmentName,departmentLocation);
        return new CommonResponse(OPERATION_SUCCESS,departmentDTOList,SUCCESS_MESSAGE);
    }


}
