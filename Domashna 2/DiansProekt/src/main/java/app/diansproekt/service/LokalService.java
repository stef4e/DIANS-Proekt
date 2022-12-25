package app.diansproekt.service;

import app.diansproekt.model.Lokal;

import java.util.List;

public interface LokalService {

    Lokal findByName(String name);
    List<Lokal> findAll();
}
