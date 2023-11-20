package com.example.springecobeer.model.dao.MySQLJDBCImpl;

import com.example.springecobeer.model.dao.SpedizioneDAO;
import com.example.springecobeer.model.mo.Spedizione;

import java.sql.Connection;

public class SpedizioneDAOMySQLJDBCImpl implements SpedizioneDAO {
    Connection conn;
    public SpedizioneDAOMySQLJDBCImpl (Connection conn) {
        this.conn = conn;
    }

    @Override
    public Spedizione create(Long IdSpedizione, Integer PesoTot, String Corriere, String StatoSpedizione) {
        return null;
    }

    @Override
    public void update(Spedizione spedizione) {

    }

    @Override
    public void delete(Spedizione spedizione) {

    }

    @Override
    public Spedizione FindByIdSpedizione(Long IdSpedizione) {
        return null;
    }
}
