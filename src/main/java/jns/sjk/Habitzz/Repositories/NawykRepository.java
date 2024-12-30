package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entities.Nawyk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface NawykRepository extends JpaRepository<Nawyk, Integer> {
    @Override
    <S extends Nawyk> S saveAndFlush(S entity);

    @Override
    void flush();

    @Override
    List<Nawyk> findAll();

    @Override
    Optional<Nawyk> findById(Integer integer);

    @Override
    void deleteById(Integer integer);
}