package com.example.springecobeer.model.dao.MySQLJDBCImpl;

import com.example.springecobeer.model.dao.OrdineDAO;
import com.example.springecobeer.model.mo.Ordine;
import com.example.springecobeer.model.mo.Prodotto;
import com.example.springecobeer.model.mo.Spedizione;
import com.example.springecobeer.model.mo.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDAOMySQLJDBCImpl implements OrdineDAO {
    Connection conn;
    public OrdineDAOMySQLJDBCImpl (Connection conn) {
        this.conn = conn;
    }

    @Override
    public Ordine create(Integer id_ordine,
                         Utente utente,
                         ArrayList<Prodotto> prodotti,
                         String Pagato,
                         Integer PrezzoTot) {

        PreparedStatement ps;
        Ordine ordine = new Ordine();

        try {
            int i = 0;
            String sql
                    = "INSERT INTO " +
                    " ordine " +
                    " (Pagato," +
                    " User_ID) " +
                    "VALUES (?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(i++,ordine.getId_ordine());



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //ordine.setId_ordine(id_ordine);
        ordine.setPagato(Pagato);
        ordine.setUtente(utente);
        ordine.setPrezzoTot(PrezzoTot);

        //QUESTA ROBA VA INSERITA POI IN UN ALTRA FUNZIONE CHE SI CHIAMA INSERISCIPRODOTTI
        for (int j = 0; j < prodotti.size(); j++) {
            try {
                int i = 0;
                String sql
                        = "INSERT INTO " +
                        " contiene " +
                        " (Order_ID," +
                        " Seriale) " +
                        "VALUES (?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(i++,ordine.getId_ordine());
                ps.setString(i++,prodotti.get(j).getSeriale());


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        ordine.setProdotti(prodotti);
        return ordine;
    }

    @Override
    public void update(Ordine ordine) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Ordine ordine) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Ordine FindByIdOrdine(Long id_ordine) {
        return null;
    }

}
