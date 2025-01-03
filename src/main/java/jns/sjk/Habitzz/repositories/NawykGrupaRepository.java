package jns.sjk.Habitzz.repositories;

import jns.sjk.Habitzz.models.entities.NawykGrupa;
import jns.sjk.Habitzz.models.entities.NawykGrupaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NawykGrupaRepository extends JpaRepository<NawykGrupa, NawykGrupaId> {
    @Override
    <S extends NawykGrupa> S saveAndFlush(S entity);

    @Override
    void flush();

    @Override
    Optional<NawykGrupa> findById(NawykGrupaId nawykGrupaId);

    @Override
    void deleteById(NawykGrupaId nawykGrupaId);

    NawykGrupa findByNawykIdAndGrupaId(int nawykId, int grupaId);

    List<NawykGrupa> findByGrupaId(int grupaId);

    void deleteByGrupaId(int id);

    void deleteByNawykId(int id);
}