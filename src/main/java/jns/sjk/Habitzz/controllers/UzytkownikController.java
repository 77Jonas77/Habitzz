package jns.sjk.Habitzz.controllers;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.models.entities.Uzytkownik;
import jns.sjk.Habitzz.services.interfaces.IUzytkownikService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uzytkownik")
public class UzytkownikController {

    private final IUzytkownikService uzytkownikService;

    public UzytkownikController(IUzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Uzytkownik> getUzytkownikById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(uzytkownikService.findById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Uzytkownik> createOrUpdateUzytkownik(@RequestBody Uzytkownik uzytkownik) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(uzytkownikService.save(uzytkownik));
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUzytkownikById(@PathVariable int id) {
        try {
            uzytkownikService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Uzytkownik>> getAllUzytkownicy() {
        try {
            List<Uzytkownik> uzytkownicy = uzytkownikService.findAll();
            return ResponseEntity.ok(uzytkownicy);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
