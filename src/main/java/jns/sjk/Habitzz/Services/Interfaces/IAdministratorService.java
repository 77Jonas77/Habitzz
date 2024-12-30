package jns.sjk.Habitzz.Services.Interfaces;

import jns.sjk.Habitzz.Models.Entities.Administrator;
import org.apache.coyote.BadRequestException;

public interface IAdministratorService {
    Administrator findById(int id);

    Administrator save(Administrator administrator) throws BadRequestException;

    void deleteById(int id);
}


