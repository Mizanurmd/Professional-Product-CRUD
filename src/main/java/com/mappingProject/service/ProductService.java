package com.mappingProject.service;





import com.mappingProject.dto.ProductDto;
import com.mappingProject.dto.Response;


public interface ProductService {
	
	Response save(ProductDto productDto);
	Response update(Long id, ProductDto productDto);
	Response delete(Long id);
	Response getProduct(Long id);
	Response getAll();
	

}
