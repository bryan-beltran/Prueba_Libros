package Modelo;

public class PrestamosDTO {

	private int id_Prestamo; 
	private String estudiante; 
	private String libro; 
	private String fecha_Prestamo; 
	private int cant;
	private int total;
	
	public PrestamosDTO(String estudiante, String libro, String fecha_Prestamo, int cant) {
		this.estudiante = estudiante;
		this.libro = libro;
		this.fecha_Prestamo = fecha_Prestamo;
		this.cant = cant;
	}

	public int getId_Prestamo() {
		return id_Prestamo;
	}

	public void setId_Prestamo(int id_Prestamo) {
		this.id_Prestamo = id_Prestamo;
	}

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getFecha_Prestamo() {
		return fecha_Prestamo;
	}

	public void setFecha_Prestamo(String fecha_Prestamo) {
		this.fecha_Prestamo = fecha_Prestamo;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
