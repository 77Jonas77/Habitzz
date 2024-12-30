package jns.sjk.Habitzz.Repositories;

import jns.sjk.Habitzz.Models.Entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

}