package com.barbarhood.app.service;

import com.barbarhood.app.dto.ProductDTO;
import com.barbarhood.app.filters.ProductFilterAttributes;
import com.barbarhood.app.model.Product;
import com.barbarhood.app.payload.request.CreateProductPayload;
import com.barbarhood.app.payload.request.UpdateProductPayload;
import java.util.List;

public interface ProductService {

    ProductDTO createProduct(CreateProductPayload createProductPayload);
    ProductDTO updateProduct(UpdateProductPayload updateProductPayload);
    ProductDTO findProductById(Long productId);
    ProductDTO deleteProductById(Long productId);

    Product findProductGivenId(Long productId);

    List<ProductDTO> findAllProducts(ProductFilterAttributes filterAttributes);
}
