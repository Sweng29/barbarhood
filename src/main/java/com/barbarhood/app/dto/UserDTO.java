package com.barbarhood.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.barbarhood.app.constants.ProfileStatus;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long userId;
    private String username;
    private String email;
    private String mobileNumber;
    private String password;
    private Date dateOfBirth;
    private boolean isActive;
    private RoleDTO roleDTO;
    private ProfileStatus profileStatus;
}
