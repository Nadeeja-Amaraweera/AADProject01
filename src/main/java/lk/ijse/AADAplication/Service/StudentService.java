package lk.ijse.AADAplication.Service;

import lk.ijse.AADAplication.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudent();

    StudentDTO getStudentDetail(long id);

    StudentDTO updateStudent(StudentDTO studentDTO);
}
