package com.barbarhood.app.mapper;

import com.barbarhood.app.dto.ProductDTO;
import com.barbarhood.app.model.Product;
import com.barbarhood.app.payload.request.CreateProductPayload;
import com.barbarhood.app.payload.request.UpdateProductPayload;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface ProductMapper {

    static ProductDTO map(Product product)
    {
        if (product == null)
            return null;
        return ProductDTO
                .builder()
                .build();
    }

    static List<ProductDTO> map(List<Product> productList)
    {
        if (productList == null || productList.isEmpty())
            return Collections.emptyList();

        return productList
                .stream()
                .filter(Objects::nonNull)
                .map(ProductMapper::map)
                .collect(Collectors.toList());
    }

    static Product mapToProduct(CreateProductPayload createProductPayload)
    {
        return Product
                .builder()
                .productName(createProductPayload.getProductName())
                .productDescription(createProductPayload.getProductDescription())
                .build();
    }

    static Product mapToProduct(UpdateProductPayload updateProductPayload) {
        return Product
                .builder()
                .productName(updateProductPayload.getProductName())
                .productDescription(updateProductPayload.getProductDescription())
                .build();
    }
}
