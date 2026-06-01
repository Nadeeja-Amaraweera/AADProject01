package lk.ijse.AADAplication.Service;

import lk.ijse.AADAplication.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser();

    List<UserDTO> getUsers();

    UserDTO getUserDetail(long id);

    UserDTO updateUser(UserDTO userDTO);

    void updateUserStatus(UserDTO userDTO);

    void deleteUser(long id);
}
