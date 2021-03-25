package Model;

import Util.DBConnection;

public class User {
	DBConnection conn = new DBConnection();
private int id;
private String finKod;
private String password;
private String name;
private String type;
public User() {}
public User(int id, String finKod, String password, String name, String type) {
	super();
	this.id = id;
	this.finKod = finKod;
	this.password = password;
	this.name = name;
	this.type = type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFinKod() {
	return finKod;
}
public void setFinKod(String finKod) {
	this.finKod = finKod;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
