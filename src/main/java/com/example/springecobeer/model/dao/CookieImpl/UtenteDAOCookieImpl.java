package com.example.springecobeer.model.dao.CookieImpl;

import com.example.springecobeer.model.dao.UtenteDAO;
import com.example.springecobeer.model.mo.Utente;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Date;

public class UtenteDAOCookieImpl implements UtenteDAO {
    HttpServletRequest request;
    HttpServletResponse response;
    public UtenteDAOCookieImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
    @Override
    public Utente create(String Username, String Nome, String Cognome, String Password, Date DataDiNascita, String CAP, String Provincia, String Citta, String Via, String Admin, String TipoPagamento, String Cancellato) {
        Utente utenteloggato = new Utente();
        utenteloggato.setUsername(Username);
        utenteloggato.setNome(Nome);
        utenteloggato.setCognome(Cognome);

        Cookie cookie;
        cookie = new Cookie("UtenteLoggato", encode(utenteloggato)); //aggiungiamo encode in seguito
        cookie.setPath("/");
        response.addCookie(cookie);

        return utenteloggato;
    }

    @Override
    public void update(Utente utenteloggato) {
        Cookie cookie;
        cookie = new Cookie("UtenteLoggato", encode(utenteloggato));
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public void delete(Utente utente) {
        Cookie cookie;
        cookie = new Cookie("UtenteLoggato", ""); //setto a nullo il cookie e metto tempo di vita 0 e di conseguenza lo uccido
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public Utente findLoggedUser() {
        Cookie[] cookies = request.getCookies();
        Utente UtenteLoggatto = null;

        if (cookies != null) {
            for (int i = 0; i < cookies.length && UtenteLoggatto == null; i++) {
                if (cookies[i].getName().equals("UtenteLoggato")) {
                    UtenteLoggatto = decode(cookies[i].getValue());
                }
            }
        }

        return UtenteLoggatto;
    }

    @Override
    public Utente FindByUsername(String Username) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void AdminMaker(Utente utente) {
        throw new UnsupportedOperationException("Not supported.");
    }

    private String encode(Utente utenteloggato) {

        String encodedUtenteLoggato;
        encodedUtenteLoggato = utenteloggato.getUsername() + "#" + utenteloggato.getNome() + "#" + utenteloggato.getCognome();
        return encodedUtenteLoggato;

    }

    private Utente decode(String encodedUtenteLoggato) {

        Utente UtenteLoggato = new Utente();

        String[] values = encodedUtenteLoggato.split("#");

        UtenteLoggato.setUsername(values[0]);
        UtenteLoggato.setNome(values[1]);
        UtenteLoggato.setCognome(values[2]);

        return UtenteLoggato;

    }
}
