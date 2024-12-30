package jns.sjk.Habitzz.Services.Implementations;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.Models.Entities.Nawyk;
import jns.sjk.Habitzz.Models.Entities.NawykGrupa;
import jns.sjk.Habitzz.Repositories.NawykGrupaRepository;
import jns.sjk.Habitzz.Repositories.NawykRepository;
import jns.sjk.Habitzz.Repositories.NawykUzytkownikRepository;
import jns.sjk.Habitzz.Services.Interfaces.INawykGrupaService;
import jns.sjk.Habitzz.Services.Interfaces.INawykService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NawykService implements INawykService {

    private final NawykRepository nawykRepository;


    public NawykService(NawykRepository nawykRepository, NawykUzytkownikRepository nawykUzytkownikRepository, NawykGrupaRepository nazwykGrupaRepository) {
        this.nawykRepository = nawykRepository;
    }

    @Override
    public Optional<Nawyk> findById(int id) {
        return nawykRepository.findById(id);
    }

    @Override
    public Nawyk save(Nawyk nawyk) {
        Optional<Nawyk> existingNawyk = nawykRepository.findById(nawyk.getId());

        if (existingNawyk.isPresent()) {
            if (!existingNawyk.get().getNazwa().equals(nawyk.getNazwa())) {
                throw new IllegalArgumentException("Nie można zmienić nazwy nawyku");
            }
        }

        return nawykRepository.save(nawyk);
    }

    @Override
    public void deleteById(int id) {
        if (!nawykRepository.existsById(id)) {
            throw new EntityNotFoundException("Nawyk o podanym ID nie istnieje");
        }
        nawykRepository.deleteById(id);
    }
}

