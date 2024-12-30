package jns.sjk.Habitzz.services.interfaces;

import jns.sjk.Habitzz.models.entities.NawykGrupa;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface INawykGrupaService {
    NawykGrupa findByNawykIdAndGrupaId(int nawykId, int grupaId);

    NawykGrupa save(NawykGrupa nawykGrupa) throws BadRequestException;

    void deleteByNawykIdAndGrupaId(int nawykId, int grupaId);

    List<NawykGrupa> findByGrupaId(int grupaId);
}
