package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductResponseDto;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreProductService implements IProductService{

    @Autowired
    RestTemplate restTemplate;
    public Product getProductFromResponseDto(ProductResponseDto responseDto){
        Product product = new Product();
        product.setId(responseDto.getId());
        product.setName(responseDto.getTitle());
        product.setPrice(responseDto.getPrice());
        product.setDescription(responseDto.getDescription());
        product.setImage(responseDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(responseDto.getCategory());
        return product;

    }
    @Override
    public Product getSingleProduct(Long id) {

        // I should pass this 'id' to fakestore and get the details of this product.
        // "https://fakestoreapi.com/products/1"


        ProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductResponseDto.class);


        return getProductFromResponseDto(response);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDto[] responseDtoList =
                restTemplate.getForObject("https://fakestoreapi.com/products", ProductResponseDto[].class);

        List<Product> output = new ArrayList<>();
        for (ProductResponseDto productResponseDto:responseDtoList) {
            output.add(getProductFromResponseDto(productResponseDto));
        }
        return output;
    }

    @Override
    public Product updateProduct(Long id, ProductRequestDto productRequestDto) {

        RequestCallback requestCallback = restTemplate.httpEntityCallback(productRequestDto,ProductRequestDto.class);
        HttpMessageConverterExtractor<ProductResponseDto> responseExtractor = new HttpMessageConverterExtractor<>(ProductResponseDto.class, restTemplate.getMessageConverters());
        ProductResponseDto productResponseDto = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return getProductFromResponseDto(productResponseDto);



//        //This is not returning the object that it has modified.
//        restTemplate.put("https://fakestoreapi.com/products/"+id, productRequestDto);
//
//        //But, I want to get the update object.
//        return getSingleProduct(id);
    }
}
