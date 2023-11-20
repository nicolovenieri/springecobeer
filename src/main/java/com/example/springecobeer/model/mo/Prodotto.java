package com.example.springecobeer.model.mo;

public class Prodotto {
    private String Seriale;
    private String Nome;
    private String Descrizione;
    private Integer Prezzo;
    private String Alcool;
    private String Disponibile;
    private String Glutine;
    private String Brand;
    private String Tipologia;
    private Boolean Cancellato;
    private String Scontato;
    private Integer PrezzoScontato;
    /* N:M */
    private Ordine[] ordini;

    public String getSeriale() {
        return Seriale;
    }

    public void setSeriale(String seriale) {
        Seriale = seriale;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public Integer getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        Prezzo = prezzo;
    }

    public String isAlcool() {
        return Alcool;
    }

    public void setAlcool(String alcool) {
        Alcool = alcool;
    }

    public String isDisponibile() {
        return Disponibile;
    }

    public void setDisponibile(String disponibile) {
        Disponibile = disponibile;
    }

    public String isGlutine() {
        return Glutine;
    }

    public void setGlutine(String glutine) {
        Glutine = glutine;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getTipologia() {
        return Tipologia;
    }

    public void setTipologia(String tipologia) {
        Tipologia = tipologia;
    }

    public Boolean getCancellato() {
        return Cancellato;
    }

    public void setCancellato(Boolean cancellato) {
        Cancellato = cancellato;
    }

    public Ordine[] getOrdini() {
        return ordini;
    }

    public void setOrdini(Ordine[] ordini) {
        this.ordini = ordini;
    }

    public String getAlcool() {
        return Alcool;
    }

    public String getDisponibile() {
        return Disponibile;
    }

    public String getGlutine() {
        return Glutine;
    }

    public String getScontato() {
        return Scontato;
    }

    public void setScontato(String scontato) {
        Scontato = scontato;
    }

    public Integer getPrezzoScontato() {
        return PrezzoScontato;
    }

    public void setPrezzoScontato(Integer prezzoScontato) {
        PrezzoScontato = prezzoScontato;
    }
}
