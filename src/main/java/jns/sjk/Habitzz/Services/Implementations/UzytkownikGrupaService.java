package jns.sjk.Habitzz.Services.Implementations;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.Models.Entities.UzytkownikGrupa;
import jns.sjk.Habitzz.Repositories.UzytkownikGrupaRepository;
import jns.sjk.Habitzz.Services.Interfaces.IUzytkownikGrupaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UzytkownikGrupaService implements IUzytkownikGrupaService {

    private final UzytkownikGrupaRepository uzytkownikGrupaRepository;

    public UzytkownikGrupaService(UzytkownikGrupaRepository uzytkownikGrupaRepository) {
        this.uzytkownikGrupaRepository = uzytkownikGrupaRepository;
    }

    @Override
    public Optional<UzytkownikGrupa> findByUzytkownikIdAndGrupaId(int uzytkownikId, int grupaId) {
        return uzytkownikGrupaRepository.findByUzytkownikIdAndGrupaId(uzytkownikId, grupaId);
    }

    @Override
    public UzytkownikGrupa save(UzytkownikGrupa uzytkownikGrupa) {
        if (uzytkownikGrupa.getUzytkownik() == null || uzytkownikGrupa.getGrupa() == null) {
            throw new IllegalArgumentException("Użytkownik i Grupa nie mogą być puste");
        }
        return uzytkownikGrupaRepository.save(uzytkownikGrupa);
    }

    @Override
    public void deleteByUzytkownikIdAndGrupaId(int uzytkownikId, int grupaId) {
        Optional<UzytkownikGrupa> uzytkownikGrupa = findByUzytkownikIdAndGrupaId(uzytkownikId, grupaId);
        if (uzytkownikGrupa.isEmpty()) {
            throw new EntityNotFoundException("UzytkownikGrupa o podanych ID nie istnieje");
        }
        uzytkownikGrupaRepository.delete(uzytkownikGrupa.get());
    }

    @Override
    public List<UzytkownikGrupa> findByGrupaId(int grupaId) {
        return uzytkownikGrupaRepository.findByGrupaId(grupaId);
    }

    @Override
    public List<UzytkownikGrupa> findByUzytkownikId(int uzytkownikId) {
        return uzytkownikGrupaRepository.findByUzytkownikId(uzytkownikId);
    }

}

