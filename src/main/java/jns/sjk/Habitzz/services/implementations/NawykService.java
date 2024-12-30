package jns.sjk.Habitzz.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jns.sjk.Habitzz.models.entities.Nawyk;
import jns.sjk.Habitzz.repositories.NawykGrupaRepository;
import jns.sjk.Habitzz.repositories.NawykRepository;
import jns.sjk.Habitzz.repositories.NawykUzytkownikRepository;
import jns.sjk.Habitzz.services.interfaces.INawykService;
import org.springframework.stereotype.Service;

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
    @Transactional
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
    @Transactional
    public void deleteById(int id) {
        if (!nawykRepository.existsById(id)) {
            throw new EntityNotFoundException("Nawyk o podanym ID nie istnieje");
        }
        nawykRepository.deleteById(id);
    }
}

