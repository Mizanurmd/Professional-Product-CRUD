package com.mappingProject.controller;




import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mappingProject.apiConfig.ApiController;
import com.mappingProject.dto.ProductDto;
import com.mappingProject.dto.Response;

import com.mappingProject.service.ProductService;
import com.mappingProject.utils.ResponseBuilder;
import com.mappingProject.utils.UrlConstraint;

import jakarta.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.ProductManagement.ROOT)
public class ProductContoller {

	/////////////// Constructor level Autowired here//////////
	private final ProductService proServ;

	public ProductContoller(ProductService proServ) {
		this.proServ = proServ;

	}

	////////////// Create save controller here /////////////
	@PostMapping(UrlConstraint.ProductManagement.CREATE)
	public Response create(@Valid @RequestBody ProductDto productDto, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseBuilder.getFailResponse(HttpStatus.CREATED, null);
		}

		return proServ.save(productDto);
	}

	////////////// Upadte save controller here /////////////
	@PutMapping(UrlConstraint.ProductManagement.UPDATE)
	public Response update(@PathVariable("id") Long id, @Valid @RequestBody ProductDto productDto,
			BindingResult result) {
		if (result.hasErrors()) {
			return ResponseBuilder.getFailResponse(HttpStatus.CREATED, "Updated");
		}

		return proServ.update(id, productDto);
	}

	/////////////////// Get single Product controller here//////////////////////
//	@GetMapping(UrlConstraint.ProductManagement.UPDATE)
//	public Response getSingleProduct(@PathVariable("id") Long id) {
//		return proServ.getProduct(id);
//	}
	@GetMapping(UrlConstraint.ProductManagement.GET)
	public Response get(@PathVariable("id") Long id) {
		return proServ.getProduct(id);
	}

	

/////////////////// Get All Product controller here///////////////////
 
	@GetMapping(UrlConstraint.ProductManagement.GET_ALL)
	public Response getAll() {
		return proServ.getAll();
	}
	

	/////////////////// Get Delete Product controller here//////////////////////
//	 @DeleteMapping(UrlConstraint.ProductManagement.UPDATE)
//	 public Response deleteProduct(@PathVariable("id")Long id) {
//		 
//		 return proServ.delete(id);
//	 }

//////////////Upadte save controller here /////////////
	@DeleteMapping(UrlConstraint.ProductManagement.DELETE)
	public Response deleteProduct(@PathVariable("id") Long id) {
		return proServ.delete(id);
	}

}
