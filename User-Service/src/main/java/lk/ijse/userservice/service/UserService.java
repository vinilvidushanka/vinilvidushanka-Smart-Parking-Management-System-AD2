package lk.ijse.userservice.service;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;

import java.util.List;

public interface UserService {
    int registerUser(UserDTO userDTO);
    List<User> getAllUsers();
    User getUserById(Integer id);
    User findByEmail(String email);
    User updateUser(Integer id, UserDTO dto);
    UserDTO loadUserDetailsByUsername(String email);
}
