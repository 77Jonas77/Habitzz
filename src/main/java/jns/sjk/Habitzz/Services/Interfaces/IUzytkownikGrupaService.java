package jns.sjk.Habitzz.Services.Interfaces;

import jakarta.transaction.Transactional;
import jns.sjk.Habitzz.Models.Entities.UzytkownikGrupa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUzytkownikGrupaService {
    Optional<UzytkownikGrupa> findByUzytkownikIdAndGrupaId(int uzytkownikId, int grupaId);

    UzytkownikGrupa save(UzytkownikGrupa uzytkownikGrupa);

    void deleteByUzytkownikIdAndGrupaId(int uzytkownikId, int grupaId);

    List<UzytkownikGrupa> findByGrupaId(int grupaId);

    List<UzytkownikGrupa> findByUzytkownikId(int uzytkownikId);

}


