package jns.sjk.Habitzz.Services.Implementations;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.Models.Entities.Grupa;
import jns.sjk.Habitzz.Repositories.GrupaRepository;
import jns.sjk.Habitzz.Repositories.NawykGrupaRepository;
import jns.sjk.Habitzz.Repositories.UzytkownikGrupaRepository;
import jns.sjk.Habitzz.Services.Interfaces.IGrupaService;
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
            return grupaRepository.save(grupa);
        }
    }

    @Override
    public void deleteById(int id) {
        if (!grupaRepository.existsById(id)) {
            throw new EntityNotFoundException("Grupa o podanym ID nie istnieje");
        }
        uzytkownikGrupaRepository.deleteByGrupaId(id);
        nawykGrupaRepository.deleteByGrupaId(id);
        grupaRepository.deleteById(id);
    }

}


