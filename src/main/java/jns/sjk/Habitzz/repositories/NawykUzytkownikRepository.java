package jns.sjk.Habitzz.repositories;

import jns.sjk.Habitzz.models.entities.NawykUzytkownik;
import jns.sjk.Habitzz.models.entities.NawykUzytkownikId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NawykUzytkownikRepository extends JpaRepository<NawykUzytkownik, NawykUzytkownikId> {
    @Override
    void flush();

    @Override
    <S extends NawykUzytkownik> S saveAndFlush(S entity);

    @Override
    List<NawykUzytkownik> findAllById(Iterable<NawykUzytkownikId> nawykUzytkownikIds);

    @Override
    Optional<NawykUzytkownik> findById(NawykUzytkownikId nawykUzytkownikId);

    @Override
    void deleteById(NawykUzytkownikId nawykUzytkownikId);

    NawykUzytkownik findByNawykIdAndUzytkownikId(int nawykId, int uzytkownikId);

    List<NawykUzytkownik> findByUzytkownikId(int uzytkownikId);

    List<NawykUzytkownik> findByNawykId(int nawykId);

    void deleteByUzytkownikId(int id);

    void deleteByNawykId(int id);
}