package jns.sjk.Habitzz.controllers;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.models.entities.Administrator;
import jns.sjk.Habitzz.services.interfaces.IAdministratorService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/administrator")
public class AdministratorController {

    private final IAdministratorService administratorService;

    public AdministratorController(IAdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministrator(@PathVariable Integer id) {
        try {
            Administrator administrator = administratorService.findById(id);
            return ResponseEntity.ok(administrator);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Administrator> createOrUpdateAdministrator(@RequestBody Administrator administrator) {
        try {
            Administrator savedAdministrator = administratorService.save(administrator);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAdministrator);
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Integer id) {
        try {
            administratorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
