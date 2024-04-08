package com.PatientHubService.PatientService.Service;

import com.PatientHubService.PatientService.Dto.PatientRequest;
import com.PatientHubService.PatientService.Dto.PatientResponse;
import com.PatientHubService.PatientService.Dao.PatientRepo;
import com.PatientHubService.PatientService.ErrorHandler.NoDataFound;
import com.PatientHubService.PatientService.Model.Patient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {

    private final PatientRepo patientRepo;

    public void createPatient(PatientRequest patientRequest){

        Patient patient = Patient.builder()
                .name(patientRequest.getName())
                .phoneNumber(patientRequest.getPhoneNumber())
                .email(patientRequest.getEmail())
                .build();

        patientRepo.save(patient);
        log.info("Product " + patient.getId() + " is Created");

    }

    public List<PatientResponse> getAllPatients(){

    List<Patient> patients = patientRepo.findAll();

    return patients.stream().map(this::mapToPatientResponse).toList();

    }

    public void updatePatient(Patient patient){

        patientRepo.save(patient);
        log.info("Patient " + patient.getId() + " is saved");
    }

    public PatientResponse getPatientById(Long id){

        Patient patient = patientRepo.findById(id).orElseThrow(() -> new NoDataFound("No Data fetched from table"));
        log.info("Patient " + patient.getId() + " is fetched from DB");
        return mapToPatientResponse(patient);

    }

    public void deleteById(Long id){

        patientRepo.deleteById(id);
        log.info("Product " + id + " is Deleted");

    }

    private PatientResponse mapToPatientResponse(Patient patient) {

        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .phoneNumber(patient.getPhoneNumber())
                .email(patient.getEmail())
                .build();

    }

}
