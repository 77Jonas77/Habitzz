package jns.sjk.Habitzz.Services.Interfaces;

import jns.sjk.Habitzz.Models.Entities.NawykUzytkownik;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface INawykUzytkownikService {
    NawykUzytkownik findByNawykIdAndUzytkownikId(int nawykId, int uzytkownikId);

    NawykUzytkownik save(NawykUzytkownik nawykUzytkownik) throws BadRequestException;

    void deleteByNawykIdAndUzytkownikId(int nawykId, int uzytkownikId);

    List<NawykUzytkownik> findByUzytkownikId(int uzytkownikId);

    List<NawykUzytkownik> findByNawykId(int nawykId);
}
