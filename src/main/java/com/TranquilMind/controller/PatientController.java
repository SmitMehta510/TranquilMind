package com.TranquilMind.controller;

import com.TranquilMind.dto.PatientDto;
import com.TranquilMind.dto.PatientRegisterDto;
import com.TranquilMind.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@RequestBody PatientRegisterDto patientRegisterDto){
        return patientService.createPatient(patientRegisterDto);
    }

    @GetMapping("/patientbyid/{id}")
    public PatientDto patientById(@PathVariable Long id){
        return patientService.getPatientDtoByUserId(id);
    }

    @PutMapping("/updatepatient/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody PatientRegisterDto newPatientDetails){
        return new ResponseEntity<>(patientService.updatePatient(id, newPatientDetails), HttpStatus.OK);
    }

    @DeleteMapping("/deletepatient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable String id){
        System.out.println("Id received is " + id );
        return new ResponseEntity<>(patientService.deletePatient(Long.parseLong(id)),HttpStatus.GONE);
    }

    @GetMapping("/get-quiz-score")
    public ResponseEntity<?> getQuizScore(Long userid){
        return new ResponseEntity<>(patientService.getQuizzes(userid), HttpStatus.OK);
    }

    @GetMapping("/my-posts")
    public ResponseEntity<?> getMyPosts(Long userid){
        return new ResponseEntity<>(patientService.getPosts(userid), HttpStatus.OK);
    }
}
