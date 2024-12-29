package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entity.Grupa;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface GrupaRepository extends ListCrudRepository<Grupa, Integer> {
    @Override
    List<Grupa> findAll();

    @Override
    <S extends Grupa> S save(S entity);

    @Override
    void deleteById(Integer integer);

}
