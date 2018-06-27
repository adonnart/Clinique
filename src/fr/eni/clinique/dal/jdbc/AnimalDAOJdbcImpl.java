package fr.eni.clinique.dal.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;

import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.Queries;

public class AnimalDAOJdbcImpl implements DAO<Animal> {

	private static ResultSet rs = null;
	
	public Animal selectById(int id) throws DALException {
		Animal animal = null;
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getQuerySelectById("Animaux", "CodeAnimal", id));
			while (rs.next()) {
				animal = new Animal(
						rs.getString("NomAnimal"),
						rs.getString("Sexe").charAt(0),
						rs.getString("Couleur"),
						rs.getString("Race"),
						rs.getString("Espece"),
						rs.getInt("CodeClient"),
						rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("Archive")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return animal;
	}
	
	public List<Animal> selectAll() throws DALException {
		List<Animal> animalList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getQuerySelectAll("Animaux"));
			while (rs.next()) {
				animalList.add(new Animal(
						rs.getInt("CodeAnimal"),
						rs.getString("NomAnimal"),
						rs.getString("Sexe").charAt(0),
						rs.getString("Couleur"),
						rs.getString("Race"),
						rs.getString("Espece"),
						rs.getInt("CodeClient"),
						rs.getString("Tatouage"),
						rs.getString("Antecedents"),
						rs.getBoolean("Archive")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return animalList;
	}
	
	public void insert(Animal animal) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			if (stm.executeUpdate(Queries.getAnimalQueryInsert(animal), Statement.RETURN_GENERATED_KEYS) == 1) {
				rs = stm.getGeneratedKeys();
				if (rs.next()) {
					animal.setCodeAnimal(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public boolean update(Animal animal) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Queries.getAnimalQueryUpdate(animal));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public boolean delete(Animal animal) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Queries.getAnimalQueryDelete(animal));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

}