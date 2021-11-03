package Modelo;

public class LibroDTO {
	
	private String Isbn; 
	private String Titulo; 
	private String Editorial; 
	private String Autor; 
	private String No_paginas;
	
	public LibroDTO(String isbn, String titulo, String editorial, String autor, String no_paginas) {
		super();
		Isbn = isbn;
		Titulo = titulo;
		Editorial = editorial;
		Autor = autor;
		No_paginas = no_paginas;
	}

	public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String isbn) {
		Isbn = isbn;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getNo_paginas() {
		return No_paginas;
	}

	public void setNo_paginas(String no_paginas) {
		No_paginas = no_paginas;
	} 
	
}
