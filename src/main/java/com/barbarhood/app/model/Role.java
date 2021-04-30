package com.barbarhood.app.model;

import com.barbarhood.app.commons.BaseEntity;
import com.barbarhood.app.constants.RoleConstant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private RoleConstant roleConstant;
    private Boolean isActive = Boolean.TRUE;

}
