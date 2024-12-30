package jns.sjk.Habitzz.services.interfaces;

import jns.sjk.Habitzz.models.entities.Nawyk;

import java.util.Optional;

public interface INawykService {
    Optional<Nawyk> findById(int id);

    Nawyk save(Nawyk nawyk);

    void deleteById(int id);
}
