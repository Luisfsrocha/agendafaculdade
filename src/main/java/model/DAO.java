package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    /** Módulo de conexão **/
    // Parâmetros de conexão
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = ""; // Sem senha, apenas uma string vazia

    // Método de conexão
    public Connection conectar() {
        Connection con = null;
        try {
            // Carregar o driver
            Class.forName(driver);
            
            // Estabelecer a conexão
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return con;
    }
    
    public class TesteConexao {
        public static void main(String[] args) {
            DAO dao = new DAO();
            dao.conectar();
        }
    }
    
}


