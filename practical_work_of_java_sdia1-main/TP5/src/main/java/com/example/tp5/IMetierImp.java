package com.example.tp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IMetierImp implements IMetier{
    private final Connection con = SingletonConnexionDB.getConnection();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Professeur> retournerProfesseurs() throws SQLException {
        List<Professeur> professeurs = new ArrayList<>();
        ps = con.prepareStatement("select * from professeur");
        rs = ps.executeQuery();
        while(rs.next()) {
            professeurs.add(new Professeur(rs.getInt("id_prof"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("adresse"), rs.getString("telephone"), rs.getString("email"), rs.getDate("date_recrutement"),new Departement(rs.getInt("id_depart"))));
        }
        return professeurs;
    }

    @Override
    public List<Professeur> trouverProfesseurParCin(String s) throws SQLException {
        List<Professeur> plist = new ArrayList<>();
        ps = con.prepareStatement("select * from professeur where cin like ?;");
        ps.setString(1,"%"+s+"%");
        rs = ps.executeQuery();
        while(rs.next()) {
            plist.add(new Professeur(rs.getInt("id_prof"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("adresse"), rs.getString("telephone"), rs.getString("email"), rs.getDate("date_recrutement"), new Departement(rs.getInt("id_depart"))));
        }
        return plist;
    }

    @Override
    public boolean ajouterProfesseur(Professeur p) throws SQLException {
        ps = con.prepareStatement("insert into professeur(nom, prenom, telephone, email, cin, adresse, date_recrutement, id_depart) values(?,?,?,?,?,?,?,?)");
        ps.setString(1, p.getNom());
        ps.setString(2, p.getPrenom());
        ps.setString(3, p.getTelephone());
        ps.setString(4, p.getEmail());
        ps.setString(5, p.getCin());
        ps.setString(6, p.getAdresse());
        ps.setDate(7, new java.sql.Date(p.getDate_recrutement().getTime()));
        ps.setInt(8, p.getDepartement().getId_depart());
        int result = ps.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean supprimerProfesseur(int idProf) throws SQLException {
        ps = con.prepareStatement("delete from professeur where id_prof = ?");
        ps.setInt(1, idProf);
        int result = ps.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean modifierProfesseur(Professeur p) throws SQLException {
        ps = con.prepareStatement("update professeur set nom=?, prenom=?, telephone=?, email=?, cin=?, adresse=?, date_recrutement=?, id_depart=? where id_prof = ?");
        ps.setString(1, p.getNom());
        ps.setString(2, p.getPrenom());
        ps.setString(3, p.getTelephone());
        ps.setString(4, p.getEmail());
        ps.setString(5, p.getCin());
        ps.setString(6, p.getAdresse());
        ps.setDate(7, new java.sql.Date(p.getDate_recrutement().getTime()));
        ps.setInt(8, p.getDepartement().getId_depart());
        ps.setInt(9,p.getId_prof());
        int result = ps.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean affecterProfesseurADepartement(int id_prof, int id_depart) throws SQLException {
        ps = con.prepareStatement("update professeur set id_depart = ? where id_prof = ?");
        ps.setInt(1, id_depart);
        ps.setInt(2, id_prof);
        int result = ps.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean ajouterDepartement(Departement d) throws SQLException {
        ps = con.prepareStatement("insert into departement(nom) values(?);");
        ps.setString(1, d.getNom());
        int result = ps.executeUpdate();
        return result > 0;
    }

    @Override
    public List<Departement> retournerDepartements() throws SQLException {
        List<Departement> departements = new ArrayList<>();
        ps = con.prepareStatement("select * from departement");
        rs = ps.executeQuery();
        while(rs.next()) {
            departements.add(new Departement(rs.getInt("id_depart"), rs.getString("nom"), null));
        }
        return departements;
    }

    @Override
    public boolean supprimerDepartement(int id_depart) throws SQLException {
        ps = con.prepareStatement("delete from departement where id_depart = ?");
        ps.setInt(1, id_depart);
        int result = ps.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean modifierDepartement(Departement d) throws SQLException {
        ps = con.prepareStatement("update departement set nom = ? where id_depart = ?");
        ps.setString(1, d.getNom());
        ps.setInt(2, d.getId_depart());
        int result = ps.executeUpdate();
        return result > 0;
    }

    @Override
    public List<Professeur> afficherProfesseursDeDepartement(int id_depart) throws SQLException {
        List<Professeur> professeurs = new ArrayList<>();
        ps = con.prepareStatement("select * from professeur where id_depart = ?");
        ps.setInt(1, id_depart);
        rs = ps.executeQuery();
        while(rs.next()) {
            professeurs.add(new Professeur(rs.getInt("id_prof"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("adresse"), rs.getString("telephone"), rs.getString("email"), rs.getDate("date_recrutement"),new Departement(rs.getInt("id_depart"))));
        }
        return professeurs;
    }
}
