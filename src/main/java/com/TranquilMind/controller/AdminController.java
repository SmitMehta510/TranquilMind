package com.TranquilMind.controller;

import com.TranquilMind.service.DoctorService;
import com.TranquilMind.service.ModeratorService;
import com.TranquilMind.service.PatientService;
import com.TranquilMind.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ModeratorService moderatorService;

    @Autowired
    private ResponderService responderService;

    @GetMapping("/patients")
    public ResponseEntity<?> getAllPatients(){
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/doctors")
    public ResponseEntity<?> getAllDoctors(){
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/moderators")
    public ResponseEntity<?> getAllModerators(){
        return new ResponseEntity<>(moderatorService.getAllModerators(), HttpStatus.OK);
    }
    @GetMapping("/responders")
    public ResponseEntity<?> getAllResponders(){
        return new ResponseEntity<>(responderService.getAllResponders(), HttpStatus.OK);
    }

    @GetMapping("/disabled-doctors")
    public ResponseEntity<?> getDisabledDoctors(){
        return new ResponseEntity<>(doctorService.getDisabledDoctors(),HttpStatus.OK);
    }

}
