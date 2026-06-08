package lk.ijse.AADAplication.Service.impl;

import lk.ijse.AADAplication.Entity.User;
import lk.ijse.AADAplication.Repository.UserRepository;
import lk.ijse.AADAplication.Service.UserService;
import lk.ijse.AADAplication.dto.UserDTO;
import lk.ijse.AADAplication.enumaration.UserStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDTO saveUser() {
        log.info("UserServiceImpl - saveUser() called");
        User user = new User();
        user.setFirstName("Nadeeja");
        user.setLastName("Amaraweera");
        user.setDob(new Date());
        user.setUserStatus(UserStatus.ACTIVE);

        User saveUser = userRepository.save(user);

        UserDTO responseDTO = new UserDTO();
        log.info("User saved with ID: {}");

        responseDTO.setUserId(saveUser.getUserId());
        responseDTO.setFirstName(saveUser.getFirstName());
        responseDTO.setLastName(saveUser.getLastName());
        responseDTO.setDob(saveUser.getDob());
        responseDTO.setUserStatus(saveUser.getUserStatus());

        log.info("UserDTO created with ID: {}");
        return responseDTO;
    }

    @Override
    public List<UserDTO> getUsers() {
        log.info("Execute method getUsers()");
        try {
            List<UserDTO> responseList = new ArrayList<>();

            List<User> userList=  userRepository.findAll();


            for (User user : userList){
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(user.getUserId());
                userDTO.setFirstName(user.getFirstName());
                userDTO.setLastName(user.getLastName());
                userDTO.setDob(user.getDob());
                userDTO.setUserStatus(user.getUserStatus());

                responseList.add(userDTO);
            }

            return responseList;


        } catch (Exception e){
            log.info("Error message getUsers()"+e.getMessage());
            throw e;
        }
    }

    @Override
    public UserDTO getUserDetail(long id) {
        log.info("Get User Derail"+id);
        try {

           Optional<User> optionalUser = userRepository.findById(id);
           if (!optionalUser.isPresent()){
               throw new RuntimeException("Can not find the user");
           }

           User user = optionalUser.get();

           UserDTO userDTO = new UserDTO();

           userDTO.setUserId(user.getUserId());
           userDTO.setFirstName(user.getFirstName());
           userDTO.setLastName(user.getLastName());
           userDTO.setUserStatus(user.getUserStatus());
           userDTO.setDob(user.getDob());

           return userDTO;

        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        log.info("Update User Detail" + userDTO.getUserId());
        try {
            Optional<User> optionalUser = userRepository.findById(userDTO.getUserId());
            if (!optionalUser.isPresent()){
                throw new RuntimeException("Can not find the user");
            }

            User user = optionalUser.get();

            user.setUserId(userDTO.getUserId());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setDob(userDTO.getDob());
            user.setUserStatus(userDTO.getUserStatus());

            User saveUser = userRepository.save(user);

             UserDTO responseDTO = new UserDTO();

             responseDTO.setUserId(saveUser.getUserId());
             responseDTO.setFirstName(saveUser.getFirstName());
             responseDTO.setLastName(saveUser.getLastName());
             responseDTO.setDob(saveUser.getDob());
             responseDTO.setUserStatus(saveUser.getUserStatus());

             return responseDTO;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void updateUserStatus(UserDTO userDTO) {
        log.info("Update User Status"+userDTO.getUserId());
        try {
            Optional<User> optionalUser = userRepository.findById(userDTO.getUserId());
            if (!optionalUser.isPresent()) {
                throw new RuntimeException("Can not find the user");
            }

            if (userDTO.getUserStatus() == null) {
                throw new RuntimeException("User status cannot be null");
            }
            User user = optionalUser.get();
            user.setUserStatus(userDTO.getUserStatus());
            userRepository.save(user);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteUser(long id) {
        log.info("Delete User"+id);
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (!optionalUser.isPresent()) {
                throw new RuntimeException("Can not find the user");
            }

            User user = optionalUser.get();
            user.setUserStatus(UserStatus.DELETE);

            userRepository.save(user);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<UserDTO> filterUsers(String firstName,String lastName) {
        log.info("Filter User with firstName: {} and lastName: {}", firstName, lastName);
        try {

            List<UserDTO> responseList = new ArrayList<>();

            List<User> userList = userRepository.filterUsers(firstName,lastName);

            for (User user : userList){
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(user.getUserId());
                userDTO.setFirstName(user.getFirstName());
                userDTO.setLastName(user.getLastName());
                userDTO.setDob(user.getDob());
                userDTO.setUserStatus(user.getUserStatus());

                responseList.add(userDTO);
            }
            return responseList;

        }catch (Exception e){
            throw e;
        }

    }

}
