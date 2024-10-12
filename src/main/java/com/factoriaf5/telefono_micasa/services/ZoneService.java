package com.factoriaf5.telefono_micasa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.factoriaf5.telefono_micasa.dtos.ZoneDTO;
import com.factoriaf5.telefono_micasa.models.User;
import com.factoriaf5.telefono_micasa.models.Zone;
import com.factoriaf5.telefono_micasa.repositories.UserRepository;
import com.factoriaf5.telefono_micasa.repositories.ZoneRepository;

@Service
public class ZoneService {

    UserRepository userRepository;
    ZoneRepository zoneRepository;

    public ZoneService(UserRepository userRepository, ZoneRepository zoneRepository) {
        this.userRepository = userRepository;
        this.zoneRepository = zoneRepository;
    }

    public List<Zone> getAllZones() {
        List<Zone> zones = zoneRepository.findAll();
        return zones;
    }

    public Zone assignZone(ZoneDTO zoneDTO, Long zoneId) throws Exception {
         try {
             Zone zone = zoneRepository.findById(zoneId).orElseThrow();
             User user = userRepository.findById(zoneDTO.getUserId()).orElseThrow();
             zone.setUser(user);
             Zone zoneUpdate = zoneRepository.save(zone);
             return zoneUpdate;
        } catch (Exception e) {
            throw new Exception("error:" + e.getMessage());
        }
     }

}
  