package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.dtos.AppointmentDTO;
import com.factoriaf5.telefono_micasa.models.Appointment;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.services.AppointmentService;
import com.factoriaf5.telefono_micasa.services.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays; // Importar Arrays
import java.util.List; 
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PropertyService propertyService;

       private static final List<String> VALID_TIME_SLOTS = Arrays.asList(
        "09:00-12:00",
        "12:00-14:00",
        "16:00-18:00",
        "18:00-20:00"
    );

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@Validated @RequestBody AppointmentDTO appointmentDTO) {
        // Fetch the Property by its ID
        Property property = propertyService.getPropertyById(appointmentDTO.getPropertyId());

        if (property != null) {
            // Create the Appointment and set the property
            Appointment appointment = new Appointment(
                appointmentDTO.getName(),
                appointmentDTO.getPhone(),
                appointmentDTO.getTimeSlot(),
                property
            );

            Appointment savedAppointment = appointmentService.createAppointment(appointment);
            return ResponseEntity.ok(savedAppointment);
        } else {
            return ResponseEntity.badRequest().body(null);  // Return 400 Bad Request if property not found
        }
    }
}
