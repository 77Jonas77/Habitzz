package jns.sjk.Habitzz.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jns.sjk.Habitzz.models.entities.NawykUzytkownik;
import jns.sjk.Habitzz.repositories.NawykUzytkownikRepository;
import jns.sjk.Habitzz.services.interfaces.INawykUzytkownikService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NawykUzytkownikService implements INawykUzytkownikService {

    private final NawykUzytkownikRepository nawykUzytkownikRepository;

    public NawykUzytkownikService(NawykUzytkownikRepository nawykUzytkownikRepository) {
        this.nawykUzytkownikRepository = nawykUzytkownikRepository;
    }

    @Override
    public NawykUzytkownik findByNawykIdAndUzytkownikId(int nawykId, int uzytkownikId) {
        return nawykUzytkownikRepository.findByNawykIdAndUzytkownikId(nawykId, uzytkownikId);
    }

    @Override
    @Transactional
    public NawykUzytkownik save(NawykUzytkownik nawykUzytkownik) throws BadRequestException {
        Optional<NawykUzytkownik> existingNawykUzytkownik = nawykUzytkownikRepository.findById(nawykUzytkownik.getId());

        if (existingNawykUzytkownik.isPresent()) {
            NawykUzytkownik existing = existingNawykUzytkownik.get();
            if (existing.getDataRozpoczecia().isAfter(nawykUzytkownik.getDataZakonczenia())) {
                throw new BadRequestException("Data rozpoczęcia nie może być po dacie zakończenia");
            }
        }

        return nawykUzytkownikRepository.save(nawykUzytkownik);
    }

    @Override
    @Transactional
    public void deleteByNawykIdAndUzytkownikId(int nawykId, int uzytkownikId) {
        NawykUzytkownik nawykUzytkownik = findByNawykIdAndUzytkownikId(nawykId, uzytkownikId);
        if (nawykUzytkownik == null) {
            throw new EntityNotFoundException("NawykUzytkownik o podanych ID nie istnieje");
        }
        nawykUzytkownikRepository.delete(nawykUzytkownik);
    }

    @Override
    public List<NawykUzytkownik> findByUzytkownikId(int uzytkownikId) {
        return nawykUzytkownikRepository.findByUzytkownikId(uzytkownikId);
    }

    @Override
    public List<NawykUzytkownik> findByNawykId(int nawykId) {
        return nawykUzytkownikRepository.findByNawykId(nawykId);
    }
}

