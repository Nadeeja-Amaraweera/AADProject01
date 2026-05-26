package lk.ijse.AADAplication.Controller;

import lk.ijse.AADAplication.Service.UserService;
import lk.ijse.AADAplication.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(){
        return userService.saveUser();
    }

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping(value = "/userdetails/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUserDetails(@PathVariable long id){
        return userService.getUserDetail(id);
    }
}
