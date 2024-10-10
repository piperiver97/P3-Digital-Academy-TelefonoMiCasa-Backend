package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.models.User;
import com.factoriaf5.telefono_micasa.models.Zone;
import com.factoriaf5.telefono_micasa.repositories.UserRepository;
import com.factoriaf5.telefono_micasa.repositories.ZoneRepository;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/zone")
public class ZoneController {

    private final ZoneRepository zoneRepository;
    private final UserRepository userRepository;

    @Autowired
    public ZoneController(ZoneRepository zoneRepository, UserRepository userRepository) {
        this.zoneRepository = zoneRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<Zone>> getAllZones() {
        List<Zone> zones = zoneRepository.findAll(); 
        return ResponseEntity.ok(zones); 
    }
    


    @PutMapping("/{zoneId}")
    public ResponseEntity<String> updateZoneForUser(
        @PathVariable("zoneId") Long zoneId, 
        @RequestBody Map<String, Long> request) {
    Long userId = request.get("userId");

    Optional<Zone> zoneOptional = zoneRepository.findById(zoneId);
    if (zoneOptional.isPresent()) {
        Zone zone = zoneOptional.get();

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            zone.setUser(user);
            zoneRepository.save(zone);
            return ResponseEntity.ok("Zona asignada correctamente al usuario.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Zona no encontrada.");
    }
}





}
