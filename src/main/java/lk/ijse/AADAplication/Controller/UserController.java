package lk.ijse.AADAplication.Controller;

import lk.ijse.AADAplication.Service.UserService;
import lk.ijse.AADAplication.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping(value = "save", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO updateUserData(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @PatchMapping(value = "update/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateUserStatus(@RequestBody UserDTO userDTO) {
        userService.updateUserStatus(userDTO);
        return "Update OK";
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "Delete OK";
    }

    @GetMapping(value = "/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> filterUser(@RequestParam String firstName, @RequestParam String lastName){
        return userService.filterUsers(firstName,lastName);
    }

}
