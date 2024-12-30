package jns.sjk.Habitzz.controllers;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.models.entities.Menadzer;
import jns.sjk.Habitzz.services.interfaces.IMenedzerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menadzer")
public class MenadzerController {

    private final IMenedzerService menadzerService;

    public MenadzerController(IMenedzerService menadzerService) {
        this.menadzerService = menadzerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menadzer> getMenadzer(@PathVariable Integer id) {
        try {
            Menadzer menadzer = menadzerService.findById(id);
            return ResponseEntity.ok(menadzer);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Menadzer> createOrUpdateMenadzer(@RequestBody Menadzer menadzer) {
        Menadzer savedMenadzer = menadzerService.save(menadzer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMenadzer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenadzer(@PathVariable Integer id) {
        try {
            menadzerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
