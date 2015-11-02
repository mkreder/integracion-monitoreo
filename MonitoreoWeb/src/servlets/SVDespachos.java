package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessDelegate.BD;
import vos.VoDespacho;
import vos.VoVenta;

/**
 * Servlet implementation class SVDespachos
 */
@WebServlet("/SVDespachos")
public class SVDespachos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVDespachos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action") == null ) {
			ArrayList<VoDespacho> despachos = BD.getInstancia().obtenerDespachosActivos();
			ArrayList<VoVenta> ventassionod = BD.getInstancia().obtenerVentasSinOrdenesDeDespacho();
			request.setAttribute("despachos", despachos);
			request.setAttribute("ventassionod", ventassionod);
			request.getRequestDispatcher("despachos.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
