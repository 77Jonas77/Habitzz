package jns.sjk.Habitzz.repositories;

import jns.sjk.Habitzz.models.entities.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenadzerRepository extends JpaRepository<Menadzer, Integer> {
    @Override
    <S extends Menadzer> S saveAndFlush(S entity);

    @Override
    <S extends Menadzer> S save(S entity);

    @Override
    void deleteById(Integer integer);

    @Override
    void flush();
}