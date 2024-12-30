package jns.sjk.Habitzz.services.interfaces;

import jns.sjk.Habitzz.models.entities.NawykUzytkownik;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface INawykUzytkownikService {
    NawykUzytkownik findByNawykIdAndUzytkownikId(int nawykId, int uzytkownikId);

    NawykUzytkownik save(NawykUzytkownik nawykUzytkownik) throws BadRequestException;

    void deleteByNawykIdAndUzytkownikId(int nawykId, int uzytkownikId);

    List<NawykUzytkownik> findByUzytkownikId(int uzytkownikId);

    List<NawykUzytkownik> findByNawykId(int nawykId);
}
