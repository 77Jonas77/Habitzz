package jns.sjk.Habitzz.Services.Implementations;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.Models.Entities.NawykGrupa;
import jns.sjk.Habitzz.Repositories.NawykGrupaRepository;
import jns.sjk.Habitzz.Services.Interfaces.INawykGrupaService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NawykGrupaService implements INawykGrupaService {

    private final NawykGrupaRepository nawykGrupaRepository;

    public NawykGrupaService(NawykGrupaRepository nawykGrupaRepository) {
        this.nawykGrupaRepository = nawykGrupaRepository;
    }

    @Override
    public NawykGrupa findByNawykIdAndGrupaId(int nawykId, int grupaId) {
        return nawykGrupaRepository.findByNawykIdAndGrupaId(nawykId, grupaId);
    }

    @Override
    public NawykGrupa save(NawykGrupa nawykGrupa) throws BadRequestException {
        if (nawykGrupa.getDataZakonczenia() != null &&
                nawykGrupa.getDataZakonczenia().isBefore(nawykGrupa.getDataRozpoczecia())) {
            throw new BadRequestException("Data zakończenia nie może być przed datą rozpoczęcia");
        }
        return nawykGrupaRepository.save(nawykGrupa);
    }

    @Override
    public void deleteByNawykIdAndGrupaId(int nawykId, int grupaId) {
        NawykGrupa nawykGrupa = findByNawykIdAndGrupaId(nawykId, grupaId);
        if (nawykGrupa == null) {
            throw new EntityNotFoundException("NawykGrupa o podanych ID nie istnieje");
        }
        nawykGrupaRepository.delete(nawykGrupa);
    }

    @Override
    public List<NawykGrupa> findByGrupaId(int grupaId) {
        return nawykGrupaRepository.findByGrupaId(grupaId);
    }

}


