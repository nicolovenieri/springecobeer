package com.example.springecobeer.model.dao;

import com.example.springecobeer.model.mo.Utente;

import java.sql.Date;

public interface UtenteDAO {
    public Utente create(
            String Username,
            String Nome,
            String Cognome,
            String Password,
            Date DataDiNascita,
            String CAP,
            String Provincia,
            String Citta,
            String Via,
            String Admin,
            String TipoPagamento,
            String Cancellato
    );
    public void update (Utente utente);

    public void delete (Utente utente);

    public Utente findLoggedUser();

    public Utente FindByUsername(String Username);

    public void AdminMaker(Utente utente);
}
