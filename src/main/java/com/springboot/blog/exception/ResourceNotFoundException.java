package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException  {

    private String resourceName;
    private String fieldValue;
    private String filedName;

    public ResourceNotFoundException(String resourceName, String fieldValue, String filedName) {
        super(String.format("%s not found with %s : '%s'", resourceName, filedName, fieldValue));
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
        this.filedName = filedName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public String getFiledName() {
        return filedName;
    }
}
