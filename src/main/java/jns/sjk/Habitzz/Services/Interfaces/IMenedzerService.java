package jns.sjk.Habitzz.Services.Interfaces;

import jns.sjk.Habitzz.Models.Entities.Menadzer;

public interface IMenedzerService {
    Menadzer findById(int id);

    Menadzer save(Menadzer menadzer);

    void deleteById(int id);
}

