package lk.ijse.AADAplication.Controller;

import lk.ijse.AADAplication.Service.StudentService;
import lk.ijse.AADAplication.dto.StudentDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/save" , produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
       return studentService.saveStudent(studentDTO);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/studentdetails/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO getStudentDetails(@PathVariable long id) {
        return studentService.getStudentDetail(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(studentDTO);
    }
}
