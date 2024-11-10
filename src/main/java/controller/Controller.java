package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;

@WebServlet(urlPatterns = { "/Controller", "/main" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao = new DAO();

	public Controller() {
		super();
	}

	// Método que recebe as requisições do tipo GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obter a ação solicitada (caminho do servlet)
		String action = request.getServletPath();
		System.out.println("Ação solicitada: " + action);

		if (action.equals("/main")) {
			// Chama o método para listar os contatos
			contatos(request, response);
		}
	}

	// Método para listar os contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("agenda.jsp");
	}
}
