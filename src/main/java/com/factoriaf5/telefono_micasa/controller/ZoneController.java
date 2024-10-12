package com.factoriaf5.telefono_micasa.controller;

import com.factoriaf5.telefono_micasa.dtos.ZoneDTO;
import com.factoriaf5.telefono_micasa.models.Zone;
import com.factoriaf5.telefono_micasa.services.ZoneService;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/zone")
public class ZoneController {

    private final ZoneService zoneService;


    public ZoneController( ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping
    public ResponseEntity<List<Zone>> getAllZones() {
        return ResponseEntity.ok(zoneService.getAllZones());
    }

    @PutMapping("/{zoneId}")
   public ResponseEntity<Zone> updateZoneForUser(
         @PathVariable("zoneId") Long zoneId,
               @RequestBody ZoneDTO zoneDTO) throws Exception {
                   Zone zone = zoneService.assignZone(zoneDTO, zoneId);
    
                   return ResponseEntity.status(200).body(zone);
           
        }
}




//

 // Optional<Zone> zoneOptional = zoneRepository.findById(zoneId);
        // if (zoneOptional.isPresent()) {
        //     Zone zone = zoneOptional.get();

        //     Optional<User> userOptional = userRepository.findById(userId);
        //     if (userOptional.isPresent()) {
        //         User user = userOptional.get();

        //         zone.setUser(user);
        //         zoneRepository.save(zone);
        //         return ResponseEntity.ok("Zona asignada correctamente al usuario.");
        //     } else {
        //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        //     }
        // } else {
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Zona no encontrada.");
        // }