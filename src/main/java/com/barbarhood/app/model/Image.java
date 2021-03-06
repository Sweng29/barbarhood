package com.barbarhood.app.model;

import com.barbarhood.app.commons.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "images")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity {

    private String imageName;
    private String imageType;
    private String imageUrl;
    private Boolean isActive;
    @ManyToOne
    private Product product;
}
