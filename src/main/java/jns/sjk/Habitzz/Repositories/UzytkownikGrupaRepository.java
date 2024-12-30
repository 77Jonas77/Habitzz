package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entities.UzytkownikGrupa;
import jns.sjk.Habitzz.Models.Entities.UzytkownikGrupaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UzytkownikGrupaRepository extends JpaRepository<UzytkownikGrupa, UzytkownikGrupaId> {
    @Override
    void flush();

    @Override
    <S extends UzytkownikGrupa> S saveAndFlush(S entity);

    @Override
    Optional<UzytkownikGrupa> findById(UzytkownikGrupaId uzytkownikGrupaId);

    @Override
    void deleteById(UzytkownikGrupaId uzytkownikGrupaId);

    List<UzytkownikGrupa> findByUzytkownikId(int uzytkownikId);

    Optional<UzytkownikGrupa> findByUzytkownikIdAndGrupaId(int uzytkownikId, int grupaId);

    List<UzytkownikGrupa> findByGrupaId(int grupaId);

//    void delete(Optional<UzytkownikGrupa> uzytkownikGrupa);

    void deleteByGrupaId(int id);

    void deleteByUzytkownikId(int id);
}