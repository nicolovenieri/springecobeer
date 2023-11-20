package com.example.springecobeer.model.dao;

import com.example.springecobeer.model.mo.Ordine;
import com.example.springecobeer.model.mo.Prodotto;
import com.example.springecobeer.model.mo.Spedizione;
import com.example.springecobeer.model.mo.Utente;

import java.util.ArrayList;

public interface OrdineDAO {
    public Ordine create(
            Integer id_ordine,
            Utente utente,
            ArrayList<Prodotto> prodotti,
            String Pagato,
            Integer PrezzoTot
    );
    public void update(Ordine ordine);
    public void delete(Ordine ordine);
    public Ordine FindByIdOrdine(Long id_ordine);

}
