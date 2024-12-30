package jns.sjk.Habitzz.controllers;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.models.entities.NawykUzytkownik;
import jns.sjk.Habitzz.services.interfaces.INawykUzytkownikService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nawykUzytkownik")
public class NawykUzytkownikController {

    private final INawykUzytkownikService nawykUzytkownikService;

    public NawykUzytkownikController(INawykUzytkownikService nawykUzytkownikService) {
        this.nawykUzytkownikService = nawykUzytkownikService;
    }

    @GetMapping("/{nawykId}/{uzytkownikId}")
    public ResponseEntity<NawykUzytkownik> getNawykUzytkownik(
            @PathVariable int nawykId, @PathVariable int uzytkownikId) {
        NawykUzytkownik nawykUzytkownik = nawykUzytkownikService.findByNawykIdAndUzytkownikId(nawykId, uzytkownikId);
        return nawykUzytkownik != null ?
                ResponseEntity.ok(nawykUzytkownik) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<NawykUzytkownik> createOrUpdateNawykUzytkownik(@RequestBody NawykUzytkownik nawykUzytkownik) {
        try {
            NawykUzytkownik savedNawykUzytkownik = nawykUzytkownikService.save(nawykUzytkownik);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedNawykUzytkownik);
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{nawykId}/{uzytkownikId}")
    public ResponseEntity<Void> deleteNawykUzytkownik(
            @PathVariable int nawykId, @PathVariable int uzytkownikId) {
        try {
            nawykUzytkownikService.deleteByNawykIdAndUzytkownikId(nawykId, uzytkownikId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/byUzytkownik/{uzytkownikId}")
    public ResponseEntity<List<NawykUzytkownik>> getNawykUzytkownikByUzytkownikId(@PathVariable int uzytkownikId) {
        List<NawykUzytkownik> nawykiUzytkownika = nawykUzytkownikService.findByUzytkownikId(uzytkownikId);
        return nawykiUzytkownika.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(nawykiUzytkownika);
    }

    //not useful
    @GetMapping("/byNawyk/{nawykId}")
    public ResponseEntity<List<NawykUzytkownik>> getNawykUzytkownikByNawykId(@PathVariable int nawykId) {
        List<NawykUzytkownik> nawykiUzytkownika = nawykUzytkownikService.findByNawykId(nawykId);
        return nawykiUzytkownika.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(nawykiUzytkownika);
    }
}
