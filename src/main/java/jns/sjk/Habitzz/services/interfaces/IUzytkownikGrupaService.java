package jns.sjk.Habitzz.services.interfaces;

import jns.sjk.Habitzz.models.entities.UzytkownikGrupa;

import java.util.List;
import java.util.Optional;

public interface IUzytkownikGrupaService {
    Optional<UzytkownikGrupa> findByUzytkownikIdAndGrupaId(int uzytkownikId, int grupaId);

    UzytkownikGrupa save(UzytkownikGrupa uzytkownikGrupa);

    void deleteByUzytkownikIdAndGrupaId(int uzytkownikId, int grupaId);

    List<UzytkownikGrupa> findByGrupaId(int grupaId);

    List<UzytkownikGrupa> findByUzytkownikId(int uzytkownikId);

}


