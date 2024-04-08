package com.PatientHubService.PatientService.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class PatientResponse {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

}
