package jns.sjk.Habitzz.Services.Interfaces;

import jns.sjk.Habitzz.Models.Entities.Nawyk;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface INawykService {
    Optional<Nawyk> findById(int id);

    Nawyk save(Nawyk nawyk);

    void deleteById(int id);
}
