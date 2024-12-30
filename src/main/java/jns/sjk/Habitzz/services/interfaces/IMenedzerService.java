package jns.sjk.Habitzz.services.interfaces;

import jns.sjk.Habitzz.models.entities.Menadzer;

public interface IMenedzerService {
    Menadzer findById(int id);

    Menadzer save(Menadzer menadzer);

    void deleteById(int id);
}

