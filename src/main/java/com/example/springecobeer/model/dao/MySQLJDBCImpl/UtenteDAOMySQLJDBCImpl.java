//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springecobeer.model.dao.MySQLJDBCImpl;

import com.example.springecobeer.model.dao.UtenteDAO;
import com.example.springecobeer.model.dao.exception.DuplicatedObjectException;
import com.example.springecobeer.model.mo.Utente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAOMySQLJDBCImpl implements UtenteDAO {
    Connection conn;

    public UtenteDAOMySQLJDBCImpl(Connection conn) {
        this.conn = conn;
    }

    public Utente create(String Username, String Nome, String Cognome, String Password, Date DataDiNascita, String CAP, String Provincia, String Citta, String Via, String Admin, String TipoPagamento, String Cancellato) {
        Utente utente = null;

        try {
            String sql = " INSERT INTO utente    ( Username,      Nome,      Cognome,      Password,      DataDiNascita,      CAP,      Provincia,      Citta,      Via,      Admin,      TipoPagamento,      Cancellato   )  VALUES (?,?,?,?,?,?,?,?,?,'N',?,'N')";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            int i = 1;
            ps.setString(i++, ((Utente)utente).getUsername());
            ps.setString(i++, ((Utente)utente).getNome());
            ps.setString(i++, ((Utente)utente).getCognome());
            ps.setString(i++, ((Utente)utente).getPassword());
            ps.setDate(i++, ((Utente)utente).getDataDiNascita());
            ps.setString(i++, ((Utente)utente).getCAP());
            ps.setString(i++, ((Utente)utente).getProvincia());
            ps.setString(i++, ((Utente)utente).getCitta());
            ps.setString(i++, ((Utente)utente).getVia());
            ps.setString(i++, ((Utente)utente).getTipoPagamento());
            ResultSet resultSet = ps.executeQuery();
            boolean exist = resultSet.next();
            resultSet.close();
            if (exist) {
                throw new DuplicatedObjectException("ContactDAOJDBCImpl.create: Tentativo di inserimento di un utente già esistente.");
            }

            ps.close();
        } catch (SQLException var19) {
            throw new RuntimeException(var19);
        } catch (DuplicatedObjectException var20) {
            throw new RuntimeException(var20);
        }

        ((Utente)utente).setUsername(Username);
        ((Utente)utente).setNome(Nome);
        ((Utente)utente).setCognome(Cognome);
        ((Utente)utente).setPassword(Password);
        ((Utente)utente).setDataDiNascita(DataDiNascita);
        ((Utente)utente).setCAP(CAP);
        ((Utente)utente).setProvincia(Provincia);
        ((Utente)utente).setCitta(Citta);
        ((Utente)utente).setVia(Via);
        ((Utente)utente).setAdmin(Admin);
        ((Utente)utente).setTipoPagamento(TipoPagamento);
        ((Utente)utente).setCancellato(Cancellato);
        return (Utente)utente;
    }

    public void update(Utente utente) {
        try {
            String sql = " UPDATE utente  SET    Nome = ?,    Cognome = ?,    Password = ?,    DataDiNascita = ?,    Cap = ?,    Provincia = ?,    Città = ?,    Via = ?,    TipoPagamento = ?  WHERE    username = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            int i = 1;
            ps.setString(i++, utente.getNome());
            ps.setString(i++, utente.getCognome());
            ps.setString(i++, utente.getPassword());
            ps.setDate(i++, utente.getDataDiNascita());
            ps.setString(i++, utente.getCAP());
            ps.setString(i++, utente.getProvincia());
            ps.setString(i++, utente.getCitta());
            ps.setString(i++, utente.getVia());
            ps.setString(i++, utente.getTipoPagamento());
            ps.executeUpdate();
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }

    public void delete(Utente utente) {
        try {
            String sql = " UPDATE utente  SET cancellato='Y'  WHERE  username=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, utente.getUsername());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    public Utente findLoggedUser() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Utente FindByUsername(String Username) {
        Utente utente = null;

        try {
            String sql = " SELECT *    FROM utente  WHERE    Username = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, Username);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                utente = this.read(resultSet);
            }

            resultSet.close();
            ps.close();
            return utente;
        } catch (SQLException var6) {
            throw new RuntimeException(var6);
        }
    }

    public void AdminMaker(Utente utente) {
        try {
            String sql = " UPDATE utente  SET Admin='Y'  WHERE  username=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, utente.getUsername());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    Utente read(ResultSet rs) {
        Utente utente = new Utente();

        try {
            utente.setUsername(rs.getString("Username"));
        } catch (SQLException var15) {
        }

        try {
            utente.setNome(rs.getString("Nome"));
        } catch (SQLException var14) {
        }

        try {
            utente.setCognome(rs.getString("Cognome"));
        } catch (SQLException var13) {
        }

        try {
            utente.setPassword(rs.getString("Password"));
        } catch (SQLException var12) {
        }

        try {
            utente.setDataDiNascita(rs.getDate("DataDiNascita"));
        } catch (SQLException var11) {
        }

        try {
            utente.setCAP(rs.getString("CAP"));
        } catch (SQLException var10) {
        }

        try {
            utente.setProvincia(rs.getString("Provincia"));
        } catch (SQLException var9) {
        }

        try {
            utente.setCitta(rs.getString("Città"));
        } catch (SQLException var8) {
        }

        try {
            utente.setVia(rs.getString("Via"));
        } catch (SQLException var7) {
        }

        try {
            utente.setAdmin(rs.getString("Admin"));
        } catch (SQLException var6) {
        }

        try {
            utente.setTipoPagamento(rs.getString("TipoPagamento"));
        } catch (SQLException var5) {
        }

        try {
            utente.setCancellato(rs.getString("Cancellato"));
        } catch (SQLException var4) {
        }

        return utente;
    }
}
