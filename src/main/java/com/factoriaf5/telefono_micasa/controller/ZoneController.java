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

