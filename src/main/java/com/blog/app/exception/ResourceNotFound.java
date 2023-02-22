package com.blog.app.exception;


//@ResponseStatus will give the specified http reposnse code for the exception
//resourcenotfound will be like in which id is not found in the post
//whenever we create customexcep extend with runtime exception is used

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    private String resourceName;
    private String fieldName;

    private long fieldValue;


    public ResourceNotFound(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found %s : %s",resourceName,fieldName,fieldValue)); //Post not found with id:1
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}
