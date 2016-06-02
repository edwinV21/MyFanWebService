package sqlConstants;

public final class ConstantsQueries {
	public static final String sqlNewUser= "INSERT INTO USUARIO (login,password,type) VALUES(?,?,?)";
	public static final String sqlNewFan= "INSERT INTO FANATICO (login,password,nombre,fechaNacimiento,genero) VALUES(?,?,?,STR_TO_DATE(?, '%d-%m-%Y'),?)";
	public static final String sqlNewArtist= "INSERT INTO ARTISTA (login,password,nombre,correo) VALUES(?,?,?,?)";
	public static final String sqlLogin= "SELECT * from  USUARIO WHERE login=? AND password=?";
	public static final String sqlprofileFan= "SELECT * from  Fanatico WHERE login=?";
	
	public static final String sqlEditInfoFan= "UPDATE Fanatico SET nombre=?,genero=? ,fechaNacimiento=STR_TO_DATE(?, '%d-%m-%Y') ,ubicacion=?,correo=? WHERE login=? ";


}
