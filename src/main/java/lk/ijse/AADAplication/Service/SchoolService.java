package lk.ijse.AADAplication.Service;

import lk.ijse.AADAplication.dto.SchoolDTO;
import lk.ijse.AADAplication.dto.StudentDTO;

import java.util.List;

public interface SchoolService {
    SchoolDTO saveSchool();

    List<SchoolDTO> getAllSchools();

    SchoolDTO getSchoolDetails(long id);

    SchoolDTO updateSchool(SchoolDTO schoolDTO);
}
