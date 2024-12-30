package jns.sjk.Habitzz.Services.Implementations;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.Models.Entities.Uzytkownik;
import jns.sjk.Habitzz.Repositories.NawykUzytkownikRepository;
import jns.sjk.Habitzz.Repositories.UzytkownikGrupaRepository;
import jns.sjk.Habitzz.Repositories.UzytkownikRepository;
import jns.sjk.Habitzz.Services.Interfaces.IUzytkownikService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UzytkownikService implements IUzytkownikService {

    private final UzytkownikRepository uzytkownikRepository;
    private final UzytkownikGrupaRepository uzytkownikGrupaRepository;
    private final NawykUzytkownikRepository nawykUzytkownikRepository;


    public UzytkownikService(UzytkownikRepository uzytkownikRepository, UzytkownikGrupaRepository uzytkownikGrupaRepository, NawykUzytkownikRepository nawykUzytkownikRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
        this.uzytkownikGrupaRepository = uzytkownikGrupaRepository;
        this.nawykUzytkownikRepository = nawykUzytkownikRepository;
    }

    @Override
    public Uzytkownik findById(int id) {
        return uzytkownikRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public Uzytkownik save(Uzytkownik uzytkownik) throws BadRequestException {
        if (uzytkownik.getNazwaUzytkownika().contains(" ")) {
            throw new BadRequestException("Login nie może zawierać spacji.");
        }

        if (uzytkownikRepository.existsByNazwaUzytkownika(uzytkownik.getNazwaUzytkownika())) {
            Uzytkownik existingUser = uzytkownikRepository.findByNazwaUzytkownika(uzytkownik.getNazwaUzytkownika());

            if (!existingUser.getNazwaUzytkownika().equals(uzytkownik.getNazwaUzytkownika())) {
                throw new BadRequestException("Login cannot be changed.");
            }
        }

        if (uzytkownik.getDataUrodzenia() != null && uzytkownik.getDataUrodzenia().isAfter(LocalDate.now().minusYears(5))) {
            throw new BadRequestException("User must be at least 5 years old.");
        }

        if (!uzytkownik.getImie().matches("[a-zA-Z]+") || !uzytkownik.getNazwisko().matches("[a-zA-Z]+")) {
            throw new BadRequestException("Imię i nazwisko mogą zawierać tylko litery.");
        }

        if (uzytkownik.getHaslo().contains(" ")) {
            throw new BadRequestException("Hasło nie może zawierać spacji.");
        }

        return uzytkownikRepository.save(uzytkownik);
    }

    @Override
    public void deleteById(int id) {
        uzytkownikRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot delete. User not found with id: " + id));
        uzytkownikGrupaRepository.deleteByUzytkownikId(id);
        nawykUzytkownikRepository.deleteByUzytkownikId(id);
        uzytkownikRepository.deleteById(id);
    }

    @Override
    public List<Uzytkownik> findAll() {
        List<Uzytkownik> users = uzytkownikRepository.findAll();
        if (users.isEmpty()) {
            throw new EntityNotFoundException("No users found.");
        }
        return users;
    }

}




