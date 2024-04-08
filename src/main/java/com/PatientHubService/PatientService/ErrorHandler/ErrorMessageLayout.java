package com.PatientHubService.PatientService.ErrorHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageLayout {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String statusCode;

    @Getter @Setter
    private String status;

    @Getter @Setter
    private String message;

}
