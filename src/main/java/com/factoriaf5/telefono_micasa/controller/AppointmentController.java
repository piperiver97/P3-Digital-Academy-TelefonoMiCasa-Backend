package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.dtos.AppointmentDTO;
import com.factoriaf5.telefono_micasa.models.Appointment;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.services.AppointmentService;
import com.factoriaf5.telefono_micasa.services.PropertyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@Validated @RequestBody AppointmentDTO appointmentDTO) {
        try {
            Appointment savedAppointment = appointmentService.createAppointment(appointmentDTO);
            return ResponseEntity.ok(savedAppointment);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
      
    }
    

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByUserId(@PathVariable Long userId) {
    List<Appointment> appointments = appointmentService.getAppointmentsByUserId(userId);
    return ResponseEntity.ok(appointments);
    }
}


