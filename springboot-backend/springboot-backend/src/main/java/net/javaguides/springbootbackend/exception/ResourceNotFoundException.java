package net.javaguides.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	// privately labeled instance variables
	private String resourceName;
	private String fieldName;
	private Object fieldValue;

	//constructor
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue)
	{
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	// getter & setter functions for all instance variables
	public String getResourceName()
	{
		return resourceName;
	}

	public void setResourceName(String resourceName)
	{
		this.resourceName = resourceName;
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}

	public Object getFieldValue()
	{
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue)
	{
		this.fieldValue = fieldValue;
	}
}
