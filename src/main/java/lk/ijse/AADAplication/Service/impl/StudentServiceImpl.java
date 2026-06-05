package lk.ijse.AADAplication.Service.impl;

import lk.ijse.AADAplication.Entity.School;
import lk.ijse.AADAplication.Entity.Student;
import lk.ijse.AADAplication.Repository.SchoolRepository;
import lk.ijse.AADAplication.Repository.StudentRepository;
import lk.ijse.AADAplication.Service.StudentService;
import lk.ijse.AADAplication.dto.SchoolDTO;
import lk.ijse.AADAplication.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;


    public StudentServiceImpl(StudentRepository studentRepository,SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        log.info("StudentServiceImpl - saveStudent() called");
        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setDob(studentDTO.getDob());
        student.setAddress(studentDTO.getAddress());

        Optional<School> schoolOptional = schoolRepository.findById(studentDTO.getSchoolId());
        if (!schoolOptional.isPresent()) {
            throw new RuntimeException("School not found with ID: " + studentDTO.getSchoolId());
        }

        School school = schoolOptional.get();
        student.setSchool(school);

        Student saveStudent = studentRepository.save(student);

        StudentDTO responseDTO = new StudentDTO();
        log.info("Student saved with ID: {}", saveStudent.getStudentId());

        responseDTO.setStudentId(saveStudent.getStudentId());
        responseDTO.setFirstName(saveStudent.getFirstName());
        responseDTO.setLastName(saveStudent.getLastName());
        responseDTO.setDob(saveStudent.getDob());
        responseDTO.setAddress(saveStudent.getAddress());
        responseDTO.setSchoolId(saveStudent.getSchool().getSchoolId());

        log.info("StudentDTO created with ID: {}", responseDTO.getStudentId());
        return responseDTO;
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        log.info("Execute method getAllStudent()");
        try {
            List<StudentDTO> responseList = new java.util.ArrayList<>();

            List<Student> studentList=  studentRepository.findAll();

            for (Student student : studentList){
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setStudentId(student.getStudentId());
                studentDTO.setFirstName(student.getFirstName());
                studentDTO.setLastName(student.getLastName());
                studentDTO.setDob(student.getDob());
                studentDTO.setAddress(student.getAddress());
                studentDTO.setSchoolId(student.getSchool().getSchoolId());

                responseList.add(studentDTO);
            }
            return responseList;
        } catch (Exception e) {
            log.error("Error in getAllStudent: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public StudentDTO getStudentDetail(long id) {
        log.info("Execute method getStudentDetail() for ID: {}", id);
        try {

            Optional<Student> studentOptional = studentRepository.findById(id);
            if (!studentOptional.isPresent()){
                throw new RuntimeException("Student not found with ID: " + id);
            }

            Student student = studentOptional.get();

            StudentDTO studentDTO = new StudentDTO();

            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setFirstName(student.getFirstName());
            studentDTO.setLastName(student.getLastName());
            studentDTO.setDob(student.getDob());
            studentDTO.setAddress(student.getAddress());
            studentDTO.setSchoolId(student.getSchool().getSchoolId());

            return studentDTO;
        } catch (Exception e) {
            log.error("Error in getStudentDetail for ID {}: {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        log.info("Execute method updateStudent() for ID: {}", studentDTO.getStudentId());
        try {

            if (studentDTO.getStudentId() == 0) {
                throw new IllegalArgumentException("Student ID must be provided for update.");
            }
            if (studentDTO.getFirstName() == null || studentDTO.getLastName() == null) {
                throw new IllegalArgumentException("First name and last name must be provided.");
            }
            if (studentDTO.getDob() == null) {
                throw new IllegalArgumentException("Date of birth must be provided.");
            }
            if (studentDTO.getAddress() == null) {
                throw new IllegalArgumentException("Address must be provided.");
            }

            Optional<Student> studentOptional = studentRepository.findById(studentDTO.getStudentId());
            if (!studentOptional.isPresent()){
                throw new RuntimeException("Student not found with ID: " + studentDTO.getStudentId());
            }

            Student student = studentOptional.get();
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setDob(studentDTO.getDob());
            student.setAddress(studentDTO.getAddress());

            Optional<School> schoolOptional = schoolRepository.findById(studentDTO.getSchoolId());
            if (!schoolOptional.isPresent()) {
                throw new RuntimeException("School not found with ID: " + studentDTO.getSchoolId());
            }
            School school = schoolOptional.get();
            student.setSchool(school);

            Student updatedStudent = studentRepository.save(student);

            StudentDTO responseDTO = new StudentDTO();

            responseDTO.setStudentId(updatedStudent.getStudentId());
            responseDTO.setFirstName(updatedStudent.getFirstName());
            responseDTO.setLastName(updatedStudent.getLastName());
            responseDTO.setDob(updatedStudent.getDob());
            responseDTO.setAddress(updatedStudent.getAddress());
            responseDTO.setSchoolId(updatedStudent.getSchool().getSchoolId());

            log.info("Student updated with ID: {}", responseDTO.getStudentId());
            return responseDTO;
        } catch (Exception e) {
            log.error("Error in updateStudent for ID {}: {}", studentDTO.getStudentId(), e.getMessage());
            throw e;
        }
    }
}
