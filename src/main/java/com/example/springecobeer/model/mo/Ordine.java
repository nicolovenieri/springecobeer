package com.example.springecobeer.model.mo;

import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

import java.util.ArrayList;

public class Ordine {
    private Integer id_ordine;
    private String Pagato;
    private Integer PrezzoTot;
    private String Cancellato;
    /* 1:N */
    private Utente utente;
    /* N:M */
    private ArrayList<Prodotto> prodotti;
    private Spedizione spedizione;

    public Integer getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(Integer id_ordine) {
        this.id_ordine = id_ordine;
    }

    public String isPagato() {
        return Pagato;
    }

    public void setPagato(String pagato) {
        Pagato = pagato;
    }

    public Integer getPrezzoTot() {
        return PrezzoTot;
    }

    public void setPrezzoTot(Integer prezzoTot) {
        PrezzoTot = prezzoTot;
    }

    public String getCancellato() {
        return Cancellato;
    }

    public void setCancellato(String cancellato) {
        Cancellato = cancellato;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ArrayList<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(ArrayList<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public Spedizione getSpedizione() {
        return spedizione;
    }

    public void setSpedizione(Spedizione spedizione) {
        this.spedizione = spedizione;
    }
}
