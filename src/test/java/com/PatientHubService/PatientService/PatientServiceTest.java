package com.PatientHubService.PatientService;

import static org.mockito.Mockito.*;

import com.PatientHubService.PatientService.Controller.PatientController;
import com.PatientHubService.PatientService.Dto.PatientRequest;
import com.PatientHubService.PatientService.Dto.PatientResponse;
import com.PatientHubService.PatientService.Service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PatientController.class)
class PatientTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @Test
    void testCreatePatient() throws Exception {
        PatientRequest patientRequest = new PatientRequest();
        patientRequest.setName("Kartik Inamadar");
        patientRequest.setPhoneNumber("7406681308");
        patientRequest.setEmail("kartik.inamadar28@gmail.com");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(patientRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(patientService, times(1)).createPatient(patientRequest);
    }

    @Test
    void testGetAllPatients() throws Exception {
        List<PatientResponse> patientList = new ArrayList<>();
        patientList.add(new PatientResponse(1L, "Kartik Inamadar", "1234567890", "Kartik@gmail.com"));

        when(patientService.getAllPatients()).thenReturn(patientList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/patient/allPatients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Kartik Inamadar"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber").value("1234567890"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("Kartik@gmail.com"));
    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
