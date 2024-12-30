package jns.sjk.Habitzz.services.interfaces;

import jns.sjk.Habitzz.models.entities.Administrator;
import org.apache.coyote.BadRequestException;

public interface IAdministratorService {
    Administrator findById(int id);

    Administrator save(Administrator administrator) throws BadRequestException;

    void deleteById(int id);
}


