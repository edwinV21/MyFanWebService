package myfan.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "Fanatico")
public class FanaticoEntity {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
@Id
private String login;
@NotNull
  private String password;
@NotNull
  private String nombre;
  
  
  //private ArrayList<String> generosF;
  //    private Image foto;


public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

  


  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  

 
  
  
} // class User
