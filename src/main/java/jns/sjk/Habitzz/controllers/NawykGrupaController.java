package jns.sjk.Habitzz.controllers;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.models.entities.NawykGrupa;
import jns.sjk.Habitzz.services.interfaces.INawykGrupaService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nawyk-grupa")
public class NawykGrupaController {

    private final INawykGrupaService nawykGrupaService;

    public NawykGrupaController(INawykGrupaService nawykGrupaService) {
        this.nawykGrupaService = nawykGrupaService;
    }

    @GetMapping("/grupa/{grupaId}")
    public ResponseEntity<List<NawykGrupa>> getNawykiGrupy(@PathVariable int grupaId) {
        List<NawykGrupa> nawykGrupaList = nawykGrupaService.findByGrupaId(grupaId);
        return ResponseEntity.ok(nawykGrupaList);
    }

    @GetMapping("/{nawykId}/{grupaId}")
    public ResponseEntity<NawykGrupa> getNawykGrupa(@PathVariable int nawykId, @PathVariable int grupaId) {
        NawykGrupa nawykGrupa = nawykGrupaService.findByNawykIdAndGrupaId(nawykId, grupaId);
        if (nawykGrupa != null) {
            return ResponseEntity.ok(nawykGrupa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<NawykGrupa> createOrUpdateNawykGrupa(@RequestBody NawykGrupa nawykGrupa) {
        try {
            NawykGrupa savedNawykGrupa = nawykGrupaService.save(nawykGrupa);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedNawykGrupa);
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{nawykId}/{grupaId}")
    public ResponseEntity<Void> deleteNawykGrupa(@PathVariable int nawykId, @PathVariable int grupaId) {
        try {
            nawykGrupaService.deleteByNawykIdAndGrupaId(nawykId, grupaId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
