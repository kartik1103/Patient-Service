package com.PatientHubService.PatientService.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    ErrorMessageLayout errorMessageLayout = new ErrorMessageLayout();

    public ResponseEntity<Object> NoData(NoDataFound ex, WebRequest webRequest){
        errorMessageLayout.setId(101);
        errorMessageLayout.setMessage(ex.getLocalizedMessage());
        errorMessageLayout.setStatus("NOT_FOUND");
        errorMessageLayout.setStatusCode("404");
        return new ResponseEntity<>(errorMessageLayout, HttpStatus.NOT_FOUND);
    }

}
