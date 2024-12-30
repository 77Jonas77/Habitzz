package jns.sjk.Habitzz.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jns.sjk.Habitzz.models.entities.Administrator;
import jns.sjk.Habitzz.repositories.AdministratorRepository;
import jns.sjk.Habitzz.services.interfaces.IAdministratorService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorService implements IAdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator findById(int id) {
        return administratorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Administrator not found with id: " + id));
    }

    @Override
    @Transactional
    public Administrator save(Administrator administrator) throws BadRequestException {
        Optional<Administrator> existingAdministrator = administratorRepository.findById(administrator.getId());

        if (existingAdministrator.isPresent()) {
            if (!existingAdministrator.get().getDataUtworzenia().equals(administrator.getDataUtworzenia())) {
                throw new BadRequestException("Nie można zmienić daty utworzenia administratora");
            } else {
                return administratorRepository.save(existingAdministrator.get());
            }
        } else {
            return administratorRepository.save(administrator);
        }
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        if (!administratorRepository.existsById(id)) {
            throw new EntityNotFoundException("Administrator o podanym ID nie istnieje");
        }
        administratorRepository.deleteById(id);
    }
}

