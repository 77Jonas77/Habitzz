package jns.sjk.Habitzz.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jns.sjk.Habitzz.models.entities.Grupa;
import jns.sjk.Habitzz.repositories.GrupaRepository;
import jns.sjk.Habitzz.repositories.NawykGrupaRepository;
import jns.sjk.Habitzz.repositories.UzytkownikGrupaRepository;
import jns.sjk.Habitzz.services.interfaces.IGrupaService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GrupaService implements IGrupaService {

    private final GrupaRepository grupaRepository;
    private final UzytkownikGrupaRepository uzytkownikGrupaRepository;
    private final NawykGrupaRepository nawykGrupaRepository;

    public GrupaService(GrupaRepository grupaRepository, UzytkownikGrupaRepository uzytkownikGrupaRepository, NawykGrupaRepository nawykGrupaRepository) {
        this.grupaRepository = grupaRepository;
        this.uzytkownikGrupaRepository = uzytkownikGrupaRepository;
        this.nawykGrupaRepository = nawykGrupaRepository;
    }

    @Override
    public Grupa findById(int id) {
        return grupaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Grupa o podanym ID nie istnieje " + id));
    }

    @Override
    @Transactional
    public Grupa save(Grupa grupa) throws BadRequestException {
        Optional<Grupa> existingGrupa = grupaRepository.findById(grupa.getId());

        if (existingGrupa.isPresent()) {
            if (!existingGrupa.get().getDataUtworzenia().equals(grupa.getDataUtworzenia())) {
                throw new BadRequestException("Nie można zmienić daty utworzenia grupy");
            } else {
                existingGrupa.get().setOpis(grupa.getOpis());
                return grupaRepository.save(existingGrupa.get());
            }
        } else {
            if(grupa.getNazwaGrupy().isEmpty() || grupa.getNazwaGrupy().isBlank()){
                throw new BadRequestException("Nazwa grupy nie może być pusta");
            }
            return grupaRepository.save(grupa);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        if (!grupaRepository.existsById(id)) {
            throw new EntityNotFoundException("Grupa o podanym ID nie istnieje");
        }
        uzytkownikGrupaRepository.deleteByGrupaId(id);
        nawykGrupaRepository.deleteByGrupaId(id);
        grupaRepository.deleteById(id);
    }

}


