package com.example.springecobeer.model.dao;

import com.example.springecobeer.model.dao.exception.DuplicatedObjectException;
import com.example.springecobeer.model.mo.Prodotto;

public interface ProdottoDAO {
    public Prodotto create(
            String Seriale,
            String Nome,
            String Descrizione,
            Integer Prezzo,
            String Alcool,
            String Disponibile,
            String Glutine,
            String Brand,
            String Tipologia
    )throws DuplicatedObjectException;
    public void update(Prodotto prodotto);
    public void delete (Prodotto prodotto);
    public Prodotto FindBySeriale(String Seriale);
    public void Sconto(Prodotto prodotto);
}
