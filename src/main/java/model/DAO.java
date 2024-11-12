package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,fone,email) values(?,?,?)";
		try {
			// abrir a conexao
			Connection con = conectar();
			// preparar a query para a execução no banco
			PreparedStatement pst = con.prepareStatement(create);
			// subistituir pelo conteudo das variaveis javabeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** crud read **/
	public ArrayList<JavaBeans> listarContatos() {

		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				contatos.add(new JavaBeans(idcon, nome, fone, email));

			}

			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// crud update

	// selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				// setar variaveis javabeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// editar o contato
	public void alterarContato(JavaBeans contato) {
		String create = "update contatos set nome=?,fone=?,email=? where idcon=?";
		try {
			Connection con = conectar ();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//excluir contato crud
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon = ?";
		try {
			Connection con = conectar ();
			PreparedStatement pst = con.prepareStatement(delete); 
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
