package com.barbarhood.app.service;

import com.barbarhood.app.dto.UserDTO;
import com.barbarhood.app.filters.UserFilterAttributes;
import com.barbarhood.app.model.User;
import com.barbarhood.app.payload.request.EditUserPayload;
import com.barbarhood.app.payload.request.SignUpPayload;
import com.barbarhood.app.payload.request.UserCreationPayload;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDTO signUp(SignUpPayload signUpPayload);
    UserDTO findUserById(Long userId);
    UserDetails loadUserById(Long id);
    String authenticateUser(String usernameEmailOrMobileNumber,String password);
    List<UserDTO> findAllUsers(UserFilterAttributes filterAttributes);
    User findById(Long id);
    UserDTO findCurrentUserDetails();
    Boolean existsByUsernameOrEmailOrMobileNumber(String usernameEmailOrMobileNumber);
    UserDTO updateUser(EditUserPayload editUserPayload);
    ResponseEntity<String> softDeleteUser(Long userId);
    UserDTO createUser(UserCreationPayload userCreationPayload);
}
