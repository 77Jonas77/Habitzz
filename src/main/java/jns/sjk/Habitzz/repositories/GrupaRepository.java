package jns.sjk.Habitzz.repositories;

import jns.sjk.Habitzz.models.entities.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;

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