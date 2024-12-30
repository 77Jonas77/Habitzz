package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entities.Grupa;
import jns.sjk.Habitzz.Models.Entities.UzytkownikGrupa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GrupaRepository extends JpaRepository<Grupa, Integer> {
  @Override
  <S extends Grupa> S saveAndFlush(S entity);

  @Override
  void flush();

  @Override
  void deleteById(Integer integer);

  @Override
  Optional<Grupa> findById(Integer integer);

  void deleteByMenadzerId(int id);
}