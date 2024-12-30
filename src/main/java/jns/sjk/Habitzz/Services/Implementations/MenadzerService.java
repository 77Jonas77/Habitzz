package jns.sjk.Habitzz.Services.Implementations;
import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.Models.Entities.Menadzer;
import jns.sjk.Habitzz.Repositories.GrupaRepository;
import jns.sjk.Habitzz.Repositories.MenadzerRepository;
import jns.sjk.Habitzz.Services.Interfaces.IMenedzerService;
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
    public Menadzer save(Menadzer menadzer) {
        return menadzerRepository.save(menadzer);
    }

    @Override
    public void deleteById(int id) {
        if (!menadzerRepository.existsById(id)) {
            throw new EntityNotFoundException("Menadżer o podanym ID nie istnieje");
        }
        grupaRepository.deleteByMenadzerId(id);
        menadzerRepository.deleteById(id);
    }
}


