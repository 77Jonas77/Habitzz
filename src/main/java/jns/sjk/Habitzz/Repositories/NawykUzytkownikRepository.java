package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entities.NawykUzytkownik;
import jns.sjk.Habitzz.Models.Entities.NawykUzytkownikId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NawykUzytkownikRepository extends JpaRepository<NawykUzytkownik, NawykUzytkownikId> {
}