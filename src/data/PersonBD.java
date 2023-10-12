package data;

import app.models.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.CaException;
import util.ServiceLocator;

public class PersonBD {

    public PersonBD() {
    }

    public void insert(Person person) throws CaException {
        try {
            String staSQL = "INSERT INTO people (k_id, n_name, n_last_name, "
                    + "n_email, k_position) VALUES (?,?,?,?,?)";

            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);

            prepStmt.setString(1, person.getId());
            prepStmt.setString(2, person.getName());
            prepStmt.setString(3, person.getLastName());
            prepStmt.setString(4, person.getEmail());
            prepStmt.setString(5, person.getPosition());

            prepStmt.executeUpdate();
            prepStmt.close();

            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("personBD", "Creation Failed! Record not created" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void delete(String id) throws CaException {
        try {
            String staSQL = "DELETE FROM people WHERE k_id = ?";

            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);

            prepStmt.setString(1, id);

            prepStmt.executeUpdate();
            prepStmt.close();

            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("personBD", "Delete Failed! Record not deleted" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public Person getById(String id) throws CaException {
        Person person = null;
        try {
            String staSQL = "SELECT * FROM people WHERE k_id = ?";

            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);

            prepStmt.setString(1, id);

            ResultSet rs = prepStmt.executeQuery();
            person = new Person();
            while (rs.next()) {
                person.setId(rs.getString(1));
                person.setName(rs.getString(2));
                person.setLastName(rs.getString(3));
                person.setEmail(rs.getString(4));
                person.setPosition(rs.getString(5));
            }

        } catch (SQLException e) {
            throw new CaException("personBD", "getById Failed!" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return person;
    }
    
    public void update(Person person) throws CaException {
        try {
            String staSQL = "UPDATE people SET n_name = ?, n_last_name = ?, "
                    + "n_email = ?, k_position = ? WHERE k_id = ?";

            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);

            prepStmt.setString(1, person.getName());
            prepStmt.setString(2, person.getLastName());
            prepStmt.setString(3, person.getEmail());
            prepStmt.setString(4, person.getPosition());
            prepStmt.setString(5, person.getId());

            prepStmt.executeUpdate();
            prepStmt.close();

            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("personBD", "Update Failed! Record not updated" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public ArrayList<Person> getAll() throws CaException {        
        ArrayList<Person> people = new ArrayList<>();
        try {
            String staSQL = "SELECT * FROM people";

            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);

            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getString(1));
                person.setName(rs.getString(2));
                person.setLastName(rs.getString(3));
                person.setEmail(rs.getString(4));
                person.setPosition(rs.getString(5));
                people.add(person);
            }
            
        } catch (SQLException e) {
            throw new CaException("personBD", "getById Failed!" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return people;
    }

}
