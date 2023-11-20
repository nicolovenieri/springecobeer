package com.example.springecobeer.model.dao.CookieImpl;

import com.example.springecobeer.model.dao.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class CookieDAOFactory extends DAOFactory {
    private Map factoryParameters;
    private HttpServletRequest request;
    private HttpServletResponse response;
    public CookieDAOFactory(Map factoryParameters) {
        this.factoryParameters=factoryParameters;
    }
    @Override
    public void beginTransaction() {
        try {
            this.request=(HttpServletRequest) factoryParameters.get("request");
            this.response=(HttpServletResponse) factoryParameters.get("response");;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void commitTransaction() {

    }

    @Override
    public void rollbackTransaction() {

    }

    @Override
    public void closeTransaction() {

    }

    @Override
    public UtenteDAO getUtenteDAO() {
        return new UtenteDAOCookieImpl(request,response);
    }

    @Override
    public ProdottoDAO getProdottoDAO() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public SpedizioneDAO getSpedizioneDAO() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public OrdineDAO getOrdineDAO() {
        throw new UnsupportedOperationException("Not supported.");
    }
}
