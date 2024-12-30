package jns.sjk.Habitzz.Services.Interfaces;

import jns.sjk.Habitzz.Models.Entities.Uzytkownik;
import jns.sjk.Habitzz.Models.Entities.UzytkownikGrupa;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IUzytkownikService {
    Uzytkownik findById(int id);

    Uzytkownik save(Uzytkownik uzytkownik) throws BadRequestException;

    void deleteById(int id);

    List<Uzytkownik> findAll();


}

