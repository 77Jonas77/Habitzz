package jns.sjk.Habitzz.repositories;

import jns.sjk.Habitzz.models.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    @Override
    <S extends Administrator> S saveAndFlush(S entity);

    @Override
    <S extends Administrator> S save(S entity);

    @Override
    void deleteById(Integer integer);

    @Override
    void flush();
}