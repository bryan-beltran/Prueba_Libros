package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.LibroDAO;
import Modelo.LibroDTO;
import Modelo.PrestamosDAO;
import Modelo.PrestamosDTO;

/**
 * Servlet implementation class Prestamos
 */
@WebServlet("/Prestamos")
public class Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("consultarLib")!=null) {
			String isbn = request.getParameter("libro");
			LibroDAO libDao = new LibroDAO();
			LibroDTO lib = libDao.Buscar_Libro(isbn);
			
			if(lib!=null) {
				String titulo = lib.getTitulo();
				isbn = lib.getIsbn();
				response.sendRedirect("Prestamos.jsp?titulo="+titulo+"&&isbn="+isbn);
			}else {
				response.sendRedirect("Prestamos.jsp?men=El libro no se encontro");
			}
			
		}
		
		if(request.getParameter("registrar") !=null) {
			String isbn,estudiante,fecha;
			int cantidad;
			isbn =request.getParameter("isbn");
			estudiante=request.getParameter("est");
			fecha=request.getParameter("fecha");
			cantidad = Integer.parseInt(request.getParameter("cant"));
			PrestamosDTO pDto = new PrestamosDTO(estudiante, isbn, fecha, cantidad);
			PrestamosDAO pDao = new PrestamosDAO();
			
			if(pDao.Inserta_prestamo(pDto)) {
				response.sendRedirect("Prestamos.jsp?men=Prestamo resgistrado correctamente");
			}else {
				response.sendRedirect("Prestamos.jsp?men=El prestamo no se resgistro");
			}
		}
		
	}

}
