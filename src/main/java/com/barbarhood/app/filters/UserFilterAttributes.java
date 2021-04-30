package com.barbarhood.app.filters;

import com.barbarhood.app.constants.ProfileStatus;
import com.barbarhood.app.constants.RoleConstant;
import com.barbarhood.app.payload.request.BarbarhoodPageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFilterAttributes extends BarbarhoodPageRequest {

    private Integer id;
    private RoleConstant roleConstant;
    private ProfileStatus profileStatus;
    private boolean isActive = Boolean.TRUE;

    public static UserFilterAttributes defaultFilter() {
        return new UserFilterAttributes();
    }

}
