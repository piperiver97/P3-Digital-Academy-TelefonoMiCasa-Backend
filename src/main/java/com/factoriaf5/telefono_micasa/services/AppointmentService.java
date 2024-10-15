package com.factoriaf5.telefono_micasa.services;



import com.factoriaf5.telefono_micasa.dtos.AppointmentDTO;
import com.factoriaf5.telefono_micasa.models.Appointment;
import com.factoriaf5.telefono_micasa.models.Property;
import com.factoriaf5.telefono_micasa.models.User;
import com.factoriaf5.telefono_micasa.repositories.AppointmentRepository;
import com.factoriaf5.telefono_micasa.repositories.UserRepository;

import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyService propertyService;

    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
    Property property = propertyService.getPropertyById(appointmentDTO.getPropertyId());
    Optional<User> costumer = userRepository.findByUsername(appointmentDTO.getUsername());
    
    Appointment appointment = new Appointment();


    if (property != null) {
        appointment.setName(appointmentDTO.getName());
        appointment.setPhone(appointmentDTO.getPhone());
        appointment.setTimeSlot(appointmentDTO.getTimeSlot());
        appointment.setProperty(property);       
        appointment.setUserId(property.getUser().getId());
        appointment.setCostumerId(costumer.get().getId());

        return appointmentRepository.save(appointment);
    }
    return null;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    public List<Appointment> getAppointmentsByUserId(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }
    
}

