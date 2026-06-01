package lk.ijse.AADAplication.Service.impl;

import lk.ijse.AADAplication.Entity.School;
import lk.ijse.AADAplication.Repository.SchoolRepository;
import lk.ijse.AADAplication.Service.SchoolService;
import lk.ijse.AADAplication.dto.SchoolDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public SchoolDTO saveSchool() {
        log.info("SchoolServiceImpl - saveSchool() called");
        School school = new School();
        school.setName("ABC School");
        school.setLocation("123 Main St");

        School saveSchool = schoolRepository.save(school);

        SchoolDTO responseDTO = new SchoolDTO();
        log.info("School saved with ID: {}", saveSchool.getSchoolId());

        responseDTO.setSchoolId(saveSchool().getSchoolId());
        responseDTO.setLocation(saveSchool().getLocation());
        responseDTO.setName(saveSchool().getName());

        log.info("SchoolDTO created with ID: {}", responseDTO.getSchoolId());
        return responseDTO;
    }

    @Override
    public List<SchoolDTO> getAllSchools() {
        log.info("Execute method getAllSchools()");
        try {
            List<SchoolDTO> responseList = new java.util.ArrayList<>();

            List<School> schoolList=  schoolRepository.findAll();

            for (School school : schoolList){
                SchoolDTO schoolDTO = new SchoolDTO();
                schoolDTO.setSchoolId(school.getSchoolId());
                schoolDTO.setName(school.getName());
                schoolDTO.setLocation(school.getLocation());
                responseList.add(schoolDTO);
            }
            return responseList;
        } catch (Exception e) {
            log.error("Error occurred while fetching schools: {}", e.getMessage());
            throw e; // Rethrow the exception after logging
        }
    }

    @Override
    public SchoolDTO getSchoolDetails(long id) {
        log.info("Execute method getSchoolDetails() for ID: {}", id);
        try {

            Optional<School> schoolOptional = schoolRepository.findById(id);

            School school = schoolOptional.get();

            SchoolDTO schoolDTO = new SchoolDTO();

            schoolDTO.setSchoolId(school.getSchoolId());
            schoolDTO.setName(school.getName());
            schoolDTO.setLocation(school.getLocation());

            return schoolDTO;
        } catch (Exception e) {
            log.error("Error occurred while fetching school details for ID {}: {}", id, e.getMessage());
            throw e; // Rethrow the exception after logging
        }
    }

    @Override
    public SchoolDTO updateSchool(SchoolDTO schoolDTO) {
        log.info("Execute method updateSchool() for ID: {}", schoolDTO.getSchoolId());
        try {

            if (schoolDTO.getSchoolId() == 0) {
                throw new RuntimeException("School ID must not be null for update operation");
            }
            if (schoolDTO.getLocation()==null){
                throw new RuntimeException("Location must not be null for update operation");
            }
            if (schoolDTO.getName()==null){
                throw new RuntimeException("Name must not be null for update operation");
            }

            Optional<School> schoolOptional = schoolRepository.findById(schoolDTO.getSchoolId());
            if (!schoolOptional.isPresent()){
                throw new RuntimeException("School not found with ID: " + schoolDTO.getSchoolId());
            }

            School school = schoolOptional.get();
            school.setName(schoolDTO.getName());
            school.setLocation(schoolDTO.getLocation());

            School updatedSchool = schoolRepository.save(school);

            SchoolDTO responseDTO = new SchoolDTO();
            responseDTO.setSchoolId(updatedSchool.getSchoolId());
            responseDTO.setName(updatedSchool.getName());
            responseDTO.setLocation(updatedSchool.getLocation());

            return responseDTO;
        } catch (Exception e) {
            log.error("Error occurred while updating school with ID {}: {}", schoolDTO.getSchoolId(), e.getMessage());
            throw e; // Rethrow the exception after logging
        }
    }
}
