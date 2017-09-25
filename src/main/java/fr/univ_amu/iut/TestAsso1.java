package fr.univ_amu.iut;

import com.sun.org.apache.bcel.internal.classfile.Code;
import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by t14001551 on 25/09/17.
 */
public class TestAsso1 {

    // La requete de test
    static final String req = "SELECT *" +
            "FROM PROF ";
    static final String reqProf = "SELECT *" +
            "FROM PROF " +
            "WHERE PROF.MAT_SPEC=?";

    static final String reqModule = "SELECT *" +
            "FROM MODULE " +
            "WHERE CODE=?";


    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion ");
        try (Connection conn = ConnexionUnique.getInstance().getConnexion()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();

            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            // Affichage du resultat
            List<Prof> profs = new ArrayList<>();

            List<Etudiant> etudiants = new ArrayList<>();

            while (rset.next()){
                Prof prof = creerProf(rset);
                profs.add(prof);

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            for (Prof prof:profs){
                System.out.println(prof);
                System.out.println(prof.getMatSpec());
            }


            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }

    private static Prof creerProf(ResultSet rset2) throws SQLException {
        Prof prof = new Prof();
        prof.setNumProf(rset2.getInt("NUM_PROF"));
        prof.setNomProf(rset2.getString("NOM_PROF"));
        prof.setPrenomProf(rset2.getString("PRENOM_PROF"));
        prof.setAdrProf(rset2.getString("ADR_PROF"));
        prof.setCpProf(rset2.getString("CP_PROF"));
        prof.setVilleProf(rset2.getString("VILLE_PROF"));
        Module MatSpec = CreerModule(rset2.);
        prof.setMatSpec(MatSpec);
        return prof;
    }

    private static Module CreerModule(ResultSet rset2) throws SQLException {
        Module MatSpec = new Module();
        MatSpec.setCode(rset2.getString("MAT_SPEC"));
        MatSpec.setLibelle(rset2.getString("LIBELLE"));
        MatSpec.sethCoursPrev(rset2.getInt("H_COURS_PREV"));
        MatSpec.sethCoursRea(rset2.getInt("H_COURS_REA "));
        MatSpec.sethTpPrev(rset2.getInt("H_TP_PREV"));
        MatSpec.sethTpRea(rset2.getInt("H_TP_REA "));
        MatSpec.setDiscipline(rset2.getString("DISCIPLINE"));
        MatSpec.setCoefTest(rset2.getInt("COEFF_TEST"));
        MatSpec.setCoefCc(rset2.getInt("COEFF_CC"));

        Prof Resp = new Prof();
        Resp.setNumProf(rset2.getInt("RESP"));
        MatSpec.setResponsable(Resp);

        return MatSpec;
    }

    private static Module creerModule(String code) throws SQLException {
            Connection conn = ConnexionUnique.getInstance().getConnexion();
            PreparedStatement preparedstmt = conn.createStatement(reqModule);
            preparedstmt.setInt(1, code);
            ResultSet resultSet = preparedstmt.executeQuery();
        return creerModule(resultSet);

    }


    private static Prof creerProf(int numProf) throws SQLException {
        Connection conn = ConnexionUnique.getInstance().getConnexion();
        PreparedStatement preparedstmt = conn.createStatement(reqProf);
        preparedstmt.setInt(1, numProf );
        ResultSet resultSet = preparedstmt.executeQuery();
        return creerProf(resultSet);

    }

    private static Etudiant creerEtudiant(ResultSet rset) throws SQLException {
        Etudiant etudiant = new Etudiant();
        etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
        etudiant.setNomEt(rset.getString("NOM_ET"));
        etudiant.setNumEt(rset.getInt("NUM_ET"));
        etudiant.setCpEt(rset.getString("CP_ET"));
        etudiant.setVilleEt(rset.getString("VILLE_ET"));
        etudiant.setAnnee(rset.getInt("ANNEE"));
        etudiant.setGroupe(rset.getInt("GROUPE"));

        return etudiant;
    }


}

