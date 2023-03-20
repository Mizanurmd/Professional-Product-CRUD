package com.mappingProject.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.mappingProject.dto.ErrorResponseDto;
import com.mappingProject.dto.Response;

public final class ResponseBuilder {

	public ResponseBuilder() {}
	
	///////// Create a custom Response here////////
	
	public static List<ErrorResponseDto> getCustomError(BindingResult result){
		List<ErrorResponseDto>dtoList = new ArrayList<>();
		result.getFieldErrors().forEach(fieldError ->{
			ErrorResponseDto dto = ErrorResponseDto.builder()
					.field(fieldError.getField())
					.message(fieldError.getDefaultMessage()).build();
					dtoList.add(dto);
			
		});
	
		return dtoList;
	}
	/////////// Create fail Response here
	public static Response getFailResponse(HttpStatus status, String message) {
		return Response.builder()
			.message(message)
			.status(status.getReasonPhrase())
			.statusCode(status.value())
			.timestamp(new Date().getTime()).build();
		
	}
/////////// Create Success Response here
public static Response getSuccessResponse(HttpStatus status, String message, Object content) {
	return Response.builder()
		.message(message)
		.content(content)
		.statusCode(status.value())
		.timestamp(new Date().getTime()).build();
	
}
	
//////////Create Success Response here
public static Response getSuccessResponse(HttpStatus status, String message, Object content, int numberOfElement) {
return Response.builder()
.message(message)
.numberOfElement(numberOfElement)
.statusCode(status.value())
.timestamp(new Date().getTime()).build();

}

//////////Create Success Response here
public static Response getSuccessResponse(HttpStatus status, String message, Object content, int numberOfElement, Long rowCount) {
return Response.builder()
.message(message)
.rowCount(rowCount)
.statusCode(status.value())
.timestamp(new Date().getTime()).build();

}

	
}
