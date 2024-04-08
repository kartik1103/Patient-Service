package com.PatientHubService.PatientService.Controller;

import com.PatientHubService.PatientService.Dto.PatientRequest;
import com.PatientHubService.PatientService.Dto.PatientResponse;
import com.PatientHubService.PatientService.Model.Patient;
import com.PatientHubService.PatientService.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPatient(@RequestBody PatientRequest patientRequest){
        patientService.createPatient(patientRequest);
    }

    @GetMapping("allPatients")
    @ResponseStatus(HttpStatus.OK)
    public List<PatientResponse> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "patients", key = "#id")
    @ResponseStatus(HttpStatus.OK)
    public PatientResponse getPatientById(@PathVariable Long id){
       return patientService.getPatientById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updatePatientDetails(@RequestBody Patient patient){
        patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deleteById(id);
    }

}
