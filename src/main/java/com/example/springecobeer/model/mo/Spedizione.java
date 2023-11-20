package com.example.springecobeer.model.mo;

public class Spedizione {
    private Long IdSpedizione;
    private Integer PesoTot;;
    private String Corriere;
    private String StatoSpedizione;
    private Boolean Cancellato;
    /* 1:1 */
    private Ordine ordine;

    public Long getIdSpedizione() {
        return IdSpedizione;
    }

    public void setIdSpedizione(Long idSpedizione) {
        IdSpedizione = idSpedizione;
    }

    public Integer getPesoTot() {
        return PesoTot;
    }

    public void setPesoTot(Integer pesoTot) {
        PesoTot = pesoTot;
    }

    public String getCorriere() {
        return Corriere;
    }

    public void setCorriere(String corriere) {
        Corriere = corriere;
    }

    public String getStatoSpedizione() {
        return StatoSpedizione;
    }

    public void setStatoSpedizione(String statoSpedizione) {
        StatoSpedizione = statoSpedizione;
    }

    public Boolean getCancellato() {
        return Cancellato;
    }

    public void setCancellato(Boolean cancellato) {
        Cancellato = cancellato;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }
}
