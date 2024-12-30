package jns.sjk.Habitzz.controllers;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.models.entities.UzytkownikGrupa;
import jns.sjk.Habitzz.services.interfaces.IUzytkownikGrupaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uzytkownikGrupa")
public class UzytkownikGrupaController {

    private final IUzytkownikGrupaService uzytkownikGrupaService;

    public UzytkownikGrupaController(IUzytkownikGrupaService uzytkownikGrupaService) {
        this.uzytkownikGrupaService = uzytkownikGrupaService;
    }

    @GetMapping("/{uzytkownikId}/{grupaId}")
    public ResponseEntity<UzytkownikGrupa> getUzytkownikGrupa(
            @PathVariable int uzytkownikId, @PathVariable int grupaId) {
        return uzytkownikGrupaService.findByUzytkownikIdAndGrupaId(uzytkownikId, grupaId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<UzytkownikGrupa> createOrUpdateUzytkownikGrupa(@RequestBody UzytkownikGrupa uzytkownikGrupa) {
        try {
            UzytkownikGrupa savedUzytkownikGrupa = uzytkownikGrupaService.save(uzytkownikGrupa);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUzytkownikGrupa);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{uzytkownikId}/{grupaId}")
    public ResponseEntity<Void> deleteUzytkownikGrupa(
            @PathVariable int uzytkownikId, @PathVariable int grupaId) {
        try {
            uzytkownikGrupaService.deleteByUzytkownikIdAndGrupaId(uzytkownikId, grupaId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/byGrupa/{grupaId}")
    public ResponseEntity<List<UzytkownikGrupa>> getUzytkownikGrupaByGrupaId(@PathVariable int grupaId) {
        List<UzytkownikGrupa> uzytkownikGrupaList = uzytkownikGrupaService.findByGrupaId(grupaId);
        return uzytkownikGrupaList.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(uzytkownikGrupaList);
    }

    @GetMapping("/byUzytkownik/{uzytkownikId}")
    public ResponseEntity<List<UzytkownikGrupa>> getUzytkownikGrupaByUzytkownikId(@PathVariable int uzytkownikId) {
        List<UzytkownikGrupa> uzytkownikGrupaList = uzytkownikGrupaService.findByUzytkownikId(uzytkownikId);
        return uzytkownikGrupaList.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(uzytkownikGrupaList);
    }
}
