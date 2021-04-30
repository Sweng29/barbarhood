package com.barbarhood.app.service.impl;

import com.barbarhood.app.dto.ProductDTO;
import com.barbarhood.app.exception.BadRequestException;
import com.barbarhood.app.exception.error.ProductErrorType;
import com.barbarhood.app.filters.ProductFilterAttributes;
import com.barbarhood.app.helper.PageUtils;
import com.barbarhood.app.mapper.ProductMapper;
import com.barbarhood.app.model.Product;
import com.barbarhood.app.payload.request.CreateProductPayload;
import com.barbarhood.app.payload.request.UpdateProductPayload;
import com.barbarhood.app.repository.ProductRepository;
import com.barbarhood.app.service.ProductService;
import com.barbarhood.app.specifications.ProductSpecification;
import com.barbarhood.app.validator.ProductValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(CreateProductPayload createProductPayload) {
        ProductValidator.validateCreateProductPayload(createProductPayload);
        Product product = ProductMapper.mapToProduct(createProductPayload);
        return ProductMapper.map(productRepository.save(product));
    }

    @Override
    public ProductDTO updateProduct(UpdateProductPayload updateProductPayload) {
        ProductValidator.validateUpdateProductPayload(updateProductPayload);
        Product product = ProductMapper.mapToProduct(updateProductPayload);
        return ProductMapper.map(productRepository.save(product));
    }

    @Override
    public ProductDTO findProductById(Long productId) {
        Product product = findProductGivenId(productId);
        return ProductMapper.map(product);
    }

    @Override
    public ProductDTO deleteProductById(Long productId) {
        Product product = findProductGivenId(productId);
        product.setIsActive(Boolean.FALSE);
        return ProductMapper.map(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> findAllProducts(ProductFilterAttributes filterAttributes) {
        Pageable pageable = PageUtils.createPageWithSort(filterAttributes);
        Page<Product> page = productRepository.findAll(
                ProductSpecification.filter(filterAttributes),
                pageable);
        return page.map(ProductMapper::map).getContent();
    }

    @Override
    public Product findProductGivenId(Long productId)
    {
        return productRepository.findById(productId)
                .orElseThrow(
                        () -> new BadRequestException(
                                ProductErrorType
                                        .PRODUCT_NOT_AVAILABLE_WITH_ID
                                        .getErrorMessage())
                );
    }
}
