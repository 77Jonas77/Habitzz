package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entity.Administrator;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AdministratorRepository extends ListCrudRepository<Administrator, Integer> {
    @Override
    List<Administrator> findAll();

    @Override
    <S extends Administrator> S save(S entity);

    @Override
    void deleteById(Integer integer);
}
