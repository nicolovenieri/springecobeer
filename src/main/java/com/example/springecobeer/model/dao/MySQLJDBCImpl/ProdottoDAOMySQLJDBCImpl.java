package com.example.springecobeer.model.dao.MySQLJDBCImpl;

import com.example.springecobeer.model.dao.ProdottoDAO;
import com.example.springecobeer.model.dao.exception.DuplicatedObjectException;
import com.example.springecobeer.model.mo.Prodotto;
import com.example.springecobeer.model.mo.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdottoDAOMySQLJDBCImpl implements ProdottoDAO {
    Connection conn;
    public ProdottoDAOMySQLJDBCImpl (Connection conn) {
        this.conn = conn;
    }

    @Override
    public Prodotto create(
            String Seriale,
            String Nome,
            String Descrizione,
            Integer Prezzo,
            String Alcool,
            String Disponibile,
            String Glutine,
            String Brand,
            String Tipologia
    ) throws DuplicatedObjectException {
        PreparedStatement ps;
        Prodotto prodotto = new Prodotto();
        prodotto.setSeriale(Seriale);
        prodotto.setNome(Nome);
        prodotto.setDescrizione(Descrizione);
        prodotto.setPrezzo(Prezzo);
        prodotto.setAlcool(Alcool);
        prodotto.setDisponibile(Disponibile);
        prodotto.setGlutine(Glutine);
        prodotto.setBrand(Brand);
        prodotto.setTipologia(Tipologia);

        try {
            String sql
                    = " SELECT Seriale "
                    + " FROM prodotto "
                    + " WHERE "
                    + " Nome = ? AND"
                    + " Descrizione = ? AND"
                    + " Prezzo = ? AND"
                    + " Alcool = ? AND"
                    + " Glutine = ? AND"
                    + " Brand = ? AND"
                    + " Tipologia = ? AND"
                    + " Disponibile = ? ";

            ps = conn.prepareStatement(sql);
            int i = 1;
            ps.setString(i++, prodotto.getNome());
            ps.setString(i++, prodotto.getDescrizione());
            ps.setInt(i++, prodotto.getPrezzo());
            ps.setString(i++, prodotto.isAlcool());
            ps.setString(i++, prodotto.isGlutine());
            ps.setString(i++, prodotto.getBrand());
            ps.setString(i++, prodotto.getTipologia());
            ps.setString(i++, prodotto.isDisponibile());

            ResultSet resultSet = ps.executeQuery();

            boolean exist;
            exist = resultSet.next();
            resultSet.close();

            if (exist) {
                throw new DuplicatedObjectException("ContactDAOJDBCImpl.create: Tentativo di inserimento di un prodotto già esistente.");
            }
            //INSERISCO IL PRODOTTO CON IL SUO SERIALE
            sql
                    = " INSERT INTO prodotto "
                    + "   ( Nome,"
                    + "     Descrizione,"
                    + "     Brand,"
                    + "     Prezzo,"
                    + "     Alcool,"
                    + "     Disponibile,"
                    + "     Glutine,"
                    + "     Tipologia,"
                    + "     Seriale "
                    + "   ) "
                    + " VALUES (?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            i = 1;
            ps.setString(i++, prodotto.getNome());
            ps.setString(i++, prodotto.getDescrizione());
            ps.setString(i++, prodotto.getBrand());
            ps.setInt(i++, prodotto.getPrezzo());
            ps.setString(i++, prodotto.isAlcool());
            ps.setString(i++, "si");
            ps.setString(i++, prodotto.isGlutine());
            ps.setString(i++, prodotto.getTipologia());
            ps.setString(i++, prodotto.getSeriale());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prodotto;
    }

    @Override
    public void update(Prodotto prodotto) {
        PreparedStatement ps;

        try {

            String sql
                    = " SELECT * "
                    + " FROM prodotto "
                    + " WHERE "
                    + " seriale = ? ";

            ps = conn.prepareStatement(sql);
            int i = 1;
            ps.setString(i++, prodotto.getSeriale());

            ResultSet resultSet = ps.executeQuery();

            boolean exist;
            exist = resultSet.next();
            resultSet.close();

            if (exist==false) {
                throw new DuplicatedObjectException("ProductDAOJDBCImpl.update: Tentativo di aggiornamento in un prodotto non esistente.");
            }

            sql
                    = " UPDATE prodotto "
                    + " SET "
                    + "   Nome = ?, "
                    + "   Descrizione = ?, "
                    + "   Brand = ?, "
                    + "   Prezzo = ?, "
                    + "   Alcool = ?, "
                    + "   Disponibile = ?, "
                    + "   Glutine = ?, "
                    + "   Tipologia = ? "
                    + " WHERE "
                    + "   Seriale = ? ";

            ps = conn.prepareStatement(sql);
            i = 1;
            ps.setString(i++, prodotto.getNome());
            ps.setString(i++, prodotto.getDescrizione());
            ps.setString(i++, prodotto.getBrand());
            ps.setInt(i++, prodotto.getPrezzo());
            ps.setString(i++, prodotto.isAlcool());
            ps.setString(i++, "N");//se modifico non modifico la disponibilità
            ps.setString(i++, prodotto.isGlutine());
            ps.setString(i++, prodotto.getTipologia());
            ps.setString(i++, prodotto.getSeriale());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DuplicatedObjectException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void delete(Prodotto prodotto) {
        PreparedStatement ps;

        try {
            String sql
                    = " SELECT * "
                    + " FROM prodotto "
                    + " WHERE "
                    + " seriale = ? ";

            ps = conn.prepareStatement(sql);
            int i = 1;
            ps.setString(i++, prodotto.getSeriale());

            ResultSet resultSet = ps.executeQuery();

            boolean exist;
            exist = resultSet.next();
            resultSet.close();

            if (exist==false) {
                throw new DuplicatedObjectException("ProductDAOJDBCImpl.update: Tentativo di cancellazione di un prodotto non esistente.");
            }

            sql
                    = " UPDATE prodotto "
                    + " SET Disponibile='N' "
                    + " WHERE "
                    + " Seriale=?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, prodotto.getSeriale());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DuplicatedObjectException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Prodotto FindBySeriale(String Seriale) {
        PreparedStatement ps;
        Prodotto prodotto = null;
        try {

            String sql
                    = " SELECT * "
                    + "   FROM prodotto "
                    + " WHERE "
                    + "   Seriale = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, Seriale);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                prodotto = read(resultSet);
            }
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return prodotto;
    }

    @Override
    public void Sconto(Prodotto prodotto) {
        PreparedStatement ps;

        try {

            String sql
                    = " SELECT * "
                    + " FROM prodotto "
                    + " WHERE "
                    + " seriale = ? ";

            ps = conn.prepareStatement(sql);
            int i = 1;
            ps.setString(i++, prodotto.getSeriale());

            ResultSet resultSet = ps.executeQuery();

            boolean exist;
            exist = resultSet.next();
            resultSet.close();

            if (exist==false) {
                throw new DuplicatedObjectException("ProductDAOJDBCImpl.update: Tentativo di scontare un prodotto non esistente.");
            }

            sql
                    = " UPDATE prodotto "
                    + " SET "
                    + "   Scontato = ?, "
                    + "   Prezzo_Scontato = ? "
                    + " WHERE "
                    + "   Seriale = ? ";

            ps = conn.prepareStatement(sql);
            i = 1;
            ps.setString(i++, prodotto.getScontato());
            ps.setInt(i++, prodotto.getPrezzoScontato());
            ps.setString(i++, prodotto.getSeriale());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DuplicatedObjectException e) {
            throw new RuntimeException(e);
        }

    }

    Prodotto read(ResultSet rs){

        Prodotto prodotto = new Prodotto();
        try {
            prodotto.setSeriale(rs.getString("Seriale"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setNome(rs.getString("Nome"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setDescrizione(rs.getString("Descrizione"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setPrezzo(rs.getInt("Prezzo"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setAlcool(rs.getString("Alcool"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setGlutine(rs.getString("Glutine"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setBrand(rs.getString("Brand"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setTipologia(rs.getString("Tipologia"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setDisponibile(rs.getString("Disponibile"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setScontato(rs.getString("Scontato"));
        } catch (SQLException sqle) {
        }
        try {
            prodotto.setPrezzoScontato(rs.getInt("Prezzo_Scontato"));
        } catch (SQLException sqle) {
        }

        return prodotto;
    }
}
