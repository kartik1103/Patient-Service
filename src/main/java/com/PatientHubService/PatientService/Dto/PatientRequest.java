package com.PatientHubService.PatientService.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class PatientRequest {

    private String name;
    private String phoneNumber;
    private String email;


}
