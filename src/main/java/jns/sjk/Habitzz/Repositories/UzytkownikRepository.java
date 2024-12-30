package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entities.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer> {
  }