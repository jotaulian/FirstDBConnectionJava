package es.studium.tema7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MisAmigos
{

	public static void main(String[] args)
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/amigos";
		String login = "root";
		String password = "blablabla";
		String sentencia = "SELECT * FROM misamigos";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexión con la BD
			connection = DriverManager.getConnection(url, login, password);
			// Crear una sentencia
			statement = connection.createStatement();
			// Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia
			// SQL
			rs = statement.executeQuery(sentencia);
			
			while (rs.next())
			{
				System.out.println(
						rs.getInt("idAmigo") + "-" + rs.getString("nombreAmigo") + "-" + rs.getInt("telefonoAmigo"));
			}
		} catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-" + cnfe.getMessage());
		} catch (SQLException sqle)
		{
			System.out.println("Error 2-" + sqle.getMessage());
		} finally
		{
			try
			{
				if (connection != null)
				{
					connection.close();
				}
			} catch (SQLException e)
			{
				System.out.println("Error 3-" + e.getMessage());
			}
		}

	}

}
