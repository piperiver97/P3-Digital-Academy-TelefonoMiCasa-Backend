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
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PropertyService propertyService;

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

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
}
