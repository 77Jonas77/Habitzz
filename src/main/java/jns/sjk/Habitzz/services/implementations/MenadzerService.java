package jns.sjk.Habitzz.services.implementations;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jns.sjk.Habitzz.models.entities.Menadzer;
import jns.sjk.Habitzz.repositories.GrupaRepository;
import jns.sjk.Habitzz.repositories.MenadzerRepository;
import jns.sjk.Habitzz.services.interfaces.IMenedzerService;
import org.springframework.stereotype.Service;

@Service
public class MenadzerService implements IMenedzerService {

    private final MenadzerRepository menadzerRepository;
    private final GrupaRepository grupaRepository;

    public MenadzerService(MenadzerRepository menadzerRepository, GrupaRepository grupaRepository) {
        this.menadzerRepository = menadzerRepository;
        this.grupaRepository = grupaRepository;
    }

    @Override
    public Menadzer findById(int id) {
        return menadzerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Menadżer o podanym ID nie istnieje: " + id));
    }

    @Override
    @Transactional
    public Menadzer save(Menadzer menadzer) {
        return menadzerRepository.save(menadzer);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        if (!menadzerRepository.existsById(id)) {
            throw new EntityNotFoundException("Menadżer o podanym ID nie istnieje");
        }
        grupaRepository.deleteByMenadzerId(id);
        menadzerRepository.deleteById(id);
    }
}


