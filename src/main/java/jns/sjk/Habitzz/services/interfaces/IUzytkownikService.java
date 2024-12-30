package jns.sjk.Habitzz.services.interfaces;

import jns.sjk.Habitzz.models.entities.Uzytkownik;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface IUzytkownikService {
    Uzytkownik findById(int id);

    Uzytkownik save(Uzytkownik uzytkownik) throws BadRequestException;

    void deleteById(int id);

    List<Uzytkownik> findAll();


}

