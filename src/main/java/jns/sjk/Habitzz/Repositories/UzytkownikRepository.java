package jns.sjk.Habitzz.Repositories;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jns.sjk.Habitzz.Models.Entities.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer> {
    @Override
    <S extends Uzytkownik> S saveAndFlush(S entity);

    @Override
    <S extends Uzytkownik> S save(S entity);

    @Override
    void deleteById(Integer integer);

    @Override
    void flush();

    boolean existsByNazwaUzytkownika(@Size(max = 50) @NotNull String nazwaUzytkownika);

    Uzytkownik findByNazwaUzytkownika(@Size(max = 50) @NotNull String nazwaUzytkownika);
}