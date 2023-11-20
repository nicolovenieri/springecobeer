package com.example.springecobeer.model.mo;

import java.sql.Date;

public class Utente {
    private String Username;
    private String Nome;
    private String Cognome;
    private String Password;
    private Date DataDiNascita;
    private String CAP;
    private String Provincia;
    private String Citta;
    private String Via;
    private String Admin;
    private String TipoPagamento;
    private String Cancellato;

    /* 1:N */
    private Ordine[] ordini;


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getDataDiNascita() {
        return DataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        DataDiNascita = dataDiNascita;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public String getCitta() {
        return Citta;
    }

    public void setCitta(String citta) {
        Citta = citta;
    }

    public String getVia() {
        return Via;
    }

    public void setVia(String via) {
        Via = via;
    }

    public String getTipoPagamento() {
        return TipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        TipoPagamento = tipoPagamento;
    }

    public Ordine[] getOrdini() {
        return ordini;
    }

    public void setOrdini(Ordine[] ordini) {
        this.ordini = ordini;
    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String admin) {
        Admin = admin;
    }

    public String isCancellato() {
        return Cancellato;
    }

    public void setCancellato(String cancellato) {
        Cancellato = cancellato;
    }

}
