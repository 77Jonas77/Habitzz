package jns.sjk.Habitzz.Services.Implementations;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.Exceptions.ResourceNotFoundException;
import jns.sjk.Habitzz.Models.Entities.Administrator;
import jns.sjk.Habitzz.Repositories.AdministratorRepository;
import jns.sjk.Habitzz.Services.Interfaces.IAdministratorService;
import org.apache.coyote.BadRequestException;
import org.hibernate.metamodel.mapping.EntityIdentifierMapping;
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
    public void deleteById(int id) {
        if (!administratorRepository.existsById(id)) {
            throw new EntityNotFoundException("Administrator o podanym ID nie istnieje");
        }
        administratorRepository.deleteById(id);
    }
}

