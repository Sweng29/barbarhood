package com.barbarhood.app.filters;

import com.barbarhood.app.payload.request.BarbarhoodPageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterAttributes extends BarbarhoodPageRequest {

    private Long productId;
    private Long manufacturerId;
    private boolean isActive = Boolean.TRUE;

    public static ProductFilterAttributes defaultFilter() {
        return new ProductFilterAttributes();
    }

}
