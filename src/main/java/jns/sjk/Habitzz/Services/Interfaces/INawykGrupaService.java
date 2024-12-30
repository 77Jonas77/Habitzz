package jns.sjk.Habitzz.Services.Interfaces;

import jns.sjk.Habitzz.Models.Entities.NawykGrupa;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface INawykGrupaService {
    NawykGrupa findByNawykIdAndGrupaId(int nawykId, int grupaId);

    NawykGrupa save(NawykGrupa nawykGrupa) throws BadRequestException;

    void deleteByNawykIdAndGrupaId(int nawykId, int grupaId);

    List<NawykGrupa> findByGrupaId(int grupaId);
}
