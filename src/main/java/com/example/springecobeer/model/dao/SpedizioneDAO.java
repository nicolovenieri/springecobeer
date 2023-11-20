package com.example.springecobeer.model.dao;

import com.example.springecobeer.model.mo.Spedizione;

public interface SpedizioneDAO {
    public Spedizione create(
            Long IdSpedizione,
            Integer PesoTot,
            String Corriere,
            String StatoSpedizione
    );
    public void update (Spedizione spedizione);

    public void delete (Spedizione spedizione);
    public Spedizione FindByIdSpedizione(Long IdSpedizione);
}
