package jns.sjk.Habitzz.Services.Interfaces;

import jns.sjk.Habitzz.Models.Entities.Grupa;
import org.apache.coyote.BadRequestException;

public interface IGrupaService {
    Grupa findById(int id);

    Grupa save(Grupa grupa) throws BadRequestException;

    void deleteById(int id);
}
