package com.mappingProject.service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mappingProject.dto.ProductDto;
import com.mappingProject.dto.Response;
import com.mappingProject.model.Product;
import com.mappingProject.repository.ProductRepository;
import com.mappingProject.utils.ResponseBuilder;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	/////////////// Create Constructor level autowired////////////////
	private final ProductRepository proRepository;
	private final ModelMapper modelMapper;
	private final MailService mailService;
	private final String root ="Product";
	
	public ProductServiceImpl(ProductRepository proRepository, ModelMapper modelMapper, MailService mailService) {
		this.proRepository = proRepository;
		this.modelMapper = modelMapper;
		this.mailService = mailService;
	}
	

	@Override
	public Response save(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		product = proRepository.save(product);
		if(product != null) {
			
			return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root +" Created successfully", null);
		}
		String to[] = {"sizansarder11@gmail.com"};
		mailService.sendNonHtmlMail(to, "Test mail", "Take my salam and cordial love");
		
		return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server Error occures");
	}

	@Override
	public Response update(Long id, ProductDto productDto) {

		Product product = proRepository.findByIdAndIsActiveTrue(id);
		if(product != null) {
			modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			modelMapper.map(productDto, product);
			product = proRepository.save(product);
			if(product != null) {
				
				return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root +" Update successfully", productDto);
			}
			return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server Error occures");
		}
		
		return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND,root+ "Not found");
	}

	@Override
	public Response delete(Long id) {
//		Product product = proRepository.findByIdAndIsActiveTrue(id);
//		if(product == null) {
//			
//			return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND,root+ "Not found");
//		}else {
//			proRepository.delete(product);
//		}
//	
//		return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root +" Deleted successfully", "Deleted");
	///////////////// Delete another way //////////////
		
		Product product = proRepository.findByIdAndIsActiveTrue(id);
		if(product != null) {
			product.setIsActive(false);
			product = proRepository.save(product);
			if(product != null) {
				
				return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root +" Deleted successfully", "Update");
			}
			return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server Error occures");
		}
		
		return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND,root+ "Not found");
		
		
		
	}

	@Override
	public Response getProduct(Long id) {
//		Product product = proRepository.findByIdAndIsActiveTrue(id);
//		if(product != null) {
//			return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root +" find successfully", "Founded");
//		}
//		return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND,root+ "Not found");
		
		/////////// ANother way////////////////////
		
		Product product = proRepository.findByIdAndIsActiveTrue(id);
		if(product != null) {
			modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			ProductDto productDto = modelMapper.map(product, ProductDto.class);
			if(product != null) {
				
				return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root +" Retrieve successfully", productDto);
			}
			//return ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server Error occures");
		}
		
		return ResponseBuilder.getFailResponse(HttpStatus.NOT_FOUND,root+ "Not found");
		
		
	}

	@Override
	public Response getAll() {
		List<Product>products = proRepository.findAllByIsActiveTrue();
		List<ProductDto>productDtos = this.getProducts(products);
		return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root +" Retrieve successfully", productDtos);
	}
	
	
	private List<ProductDto> getProducts(List<Product>products){
		List<ProductDto>productDtos = new ArrayList<>();
		products.forEach(product ->{
			modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			ProductDto productDto = modelMapper.map(product, ProductDto.class);
			productDtos.add(productDto);
		});
		return productDtos;
		
	}
	

}
