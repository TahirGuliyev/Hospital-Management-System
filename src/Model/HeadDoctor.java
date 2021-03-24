package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HeadDoctor extends User {

	Connection con = conn.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public HeadDoctor() {
	}

	public HeadDoctor(int id, String finKod, String password, String name, String type) {
		super(id, finKod, password, name, type);
	}

	public ArrayList<User> getDoctorList() throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE type = 'hekim'");
			while (rs.next()) {
				obj = new User(rs.getInt("id"), rs.getString("finkod"), rs.getString("password"), rs.getString("name"),
						rs.getString("type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<User> getClinicDoctorList(int clinic_id) throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT u.id, u.finkod, u.password, u.name, u.type FROM employee e LEFT JOIN user u ON e.user_id = u.id WHERE clinic_id = "+clinic_id);
			while (rs.next()) {
				obj = new User(rs.getInt("u.id"), rs.getString("u.finkod"), rs.getString("u.password"), rs.getString("u.name"),
						rs.getString("type"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addDoctor(String finkod, String password, String name) {
		String query = "INSERT INTO user" + "(finkod, password, name, type) VALUES" + "(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, finkod);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, "hekim");
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}

	public boolean deleteDoctor(int id) {
		String query = "DELETE FROM user WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}

	public boolean updateDoctor(int id, String finkod, String password, String name) {
		String query = "UPDATE user SET name = ?, finkod = ?, password = ? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, finkod);
			preparedStatement.setString(3, password);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}

	public boolean addWorker(int user_id, int clinic_id) {
		String query = "INSERT INTO employee" + "(useri_id, clinic_id) VALUES" + "(?,?)";
		boolean key = false;
		int count = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM employee WHERE clinic_id=" + clinic_id + "AND user_id=" + user_id);
			while (rs.next()) {
				count++;
			}
			if (count == 0) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, user_id);
				preparedStatement.setInt(2, clinic_id);
				preparedStatement.executeUpdate();
			}
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}

}
