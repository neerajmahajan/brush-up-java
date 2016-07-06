package com.brush.up.java.servicemix.rest.cxf.spring.webservice.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;

import com.brush.up.java.servicemix.rest.cxf.spring.webservice.exception.CustomerNotFoundException;

public class CustomerNotFoundMapper implements ExceptionMapper<CustomerNotFoundException>{

	@Override
	public Response toResponse(CustomerNotFoundException exception) {
		ResponseBuilder responseBuilderState1 = Response.status(Response.Status.NOT_FOUND);
		ResponseBuilder responseBuilderState2 = responseBuilderState1.header("Content-Type", "application/json");
		ResponseBuilder responseBuilderState3 = responseBuilderState2.entity(exception.getMessage());
		return responseBuilderState3.build();
	}	

}
