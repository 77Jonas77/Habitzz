package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entities.Administrator;
import jns.sjk.Habitzz.Models.Entities.Menadzer;
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