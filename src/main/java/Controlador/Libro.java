package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.LibroDAO;
import Modelo.LibroDTO;

/**
 * Servlet implementation class Libro
 */
@WebServlet("/Libro")
public class Libro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Libro() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroDAO libDao = new LibroDAO();
		
		/*METODO INSERTAR*/
		if (request.getParameter("insertar") != null) {
			String codigo, titulo, editorial, autor, paginas;
			
			codigo = request.getParameter("isbn");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			autor = request.getParameter("autor");
			paginas = request.getParameter("paginas");

			LibroDTO lib = new LibroDTO(codigo, titulo, editorial, autor, paginas);

			if (libDao.Insertar_Libro(lib)) {
				response.sendRedirect("Libros.jsp?men=Se registro el libro");
			} else {
				response.sendRedirect("Libros.jsp?men=No se registro el libro");
			}
		}
		
		/* METODO CONSULTAR */
		if (request.getParameter("consultar") != null) {
			String codigo, titulo, editorial, autor, paginas;
			codigo = request.getParameter("codigo");
			LibroDTO lib = libDao.Buscar_Libro(codigo);

			if (lib != null) {
				codigo = lib.getIsbn();
				titulo = lib.getTitulo();
				editorial = lib.getEditorial();
				autor =  lib.getAutor();
				paginas = lib.getNo_paginas();
				
				response.sendRedirect("Libros.jsp?codigo=" + codigo + "&&titulo=" + titulo + "&&editorial=" + editorial
						+ "&&autor=" + autor + "&&paginas=" + paginas);
			} else {
				response.sendRedirect("Libros.jsp?men=Libro no registrado");
			}
		}
		
		/*METODO ACTUALIZAR*/
		if (request.getParameter("actualizar") != null) {
			String codigo, titulo, editorial, autor, paginas;
			
			codigo = request.getParameter("cod");
			titulo = request.getParameter("titulo");
			editorial = request.getParameter("editorial");
			autor = request.getParameter("autor");
			paginas = request.getParameter("paginas");
			
			LibroDTO lib = new LibroDTO(codigo, titulo, editorial, autor, paginas);			

			if (libDao.Actualizar_Libro(lib)) {
				response.sendRedirect("Libros.jsp?men=Se actualizo el libro");
			} else {
				response.sendRedirect("Libros.jsp?men=No se actualizo el libro");
			}
		}
		
		/*METODO ELIMINAR*/
		if (request.getParameter("eliminar") != null) {
			String codigo;
			codigo = request.getParameter("cod");
			int op=JOptionPane.showConfirmDialog(null, "Deseas eliminar el libro con ISBN: " + codigo);
			if(op==0) {
				if (libDao.Eliminar_Libro(codigo)) {
					response.sendRedirect("Libros.jsp?men=Libro Eliminado");
				}else {
					response.sendRedirect("Libros.jsp?men=Libro no Eliminado");
				}
			}else if(op==1){
					response.sendRedirect("Libros.jsp?");
				}else {
					response.sendRedirect("Libros.jsp?men=A");
				}
		}
		
	}

}
