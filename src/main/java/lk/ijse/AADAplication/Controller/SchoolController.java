package lk.ijse.AADAplication.Controller;

import lk.ijse.AADAplication.Service.SchoolService;
import lk.ijse.AADAplication.dto.SchoolDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public SchoolDTO saveSchool(){
        return schoolService.saveSchool();
    }

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SchoolDTO> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping(value = "/schooldetails/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public SchoolDTO getSchoolDetails(@PathVariable long id) {
        return schoolService.getSchoolDetails(id);
    }

    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public SchoolDTO updateSchool(@RequestBody SchoolDTO schoolDTO) {
        return schoolService.updateSchool(schoolDTO);
    }

}
