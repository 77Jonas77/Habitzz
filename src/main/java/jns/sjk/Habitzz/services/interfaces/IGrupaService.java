package jns.sjk.Habitzz.services.interfaces;

import jns.sjk.Habitzz.models.entities.Grupa;
import org.apache.coyote.BadRequestException;

public interface IGrupaService {
    Grupa findById(int id);

    Grupa save(Grupa grupa) throws BadRequestException;

    void deleteById(int id);
}
