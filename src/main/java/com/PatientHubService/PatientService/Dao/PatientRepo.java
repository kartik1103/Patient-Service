package com.PatientHubService.PatientService.Dao;

import com.PatientHubService.PatientService.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
}
