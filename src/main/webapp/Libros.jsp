<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libros</title>
</head>
<body>
<%! String codigo="", titulo="", editorial="", autor="", estado="", paginas=""; %>

<%
if(request.getParameter("codigo")!=null){
	
	codigo = request.getParameter("codigo");
	titulo = request.getParameter("titulo");
	editorial = request.getParameter("editorial");
	autor = request.getParameter("autor");
	paginas = request.getParameter("paginas");
	estado = "disabled";
}

if(request.getParameter("men")!=null){
	String mensaje = request.getParameter("men");
	out.print("<script type='text/javascript'>alert('" + mensaje + "');</script>");
	codigo=""; 
	titulo=""; editorial="";
	autor="";
	estado="";
	paginas=""; 
}
%>
	<form action="Libro" method="post">
	
		<div>
		<label>Codigo Isbn:</label>
		<input type="text" name="isbn" value="<%=codigo%>" <%=estado%> required>
		<input type="hidden" name="cod" value="<%=codigo%>">
		</div>
		
		<div>
		<label>Titulo:</label>
		<input type="text" name="titulo" value="<%=titulo%>" required>
		</div>
		
		<div>
		<label>Editorial:</label>
		<input type="text" name="editorial" value="<%=editorial%>">
		</div>
		
		<div>
		<label>Autor:</label>
		<input type="text" name="autor" value="<%=autor%>" required>
		</div>
		
		<div>
		<label>No_Paginas:</label>
		<input type="text" name="paginas" pattern="[0-9]+" placeholder="000000" value="<%=paginas%>">
		</div>
		
		<div>
		<input type="submit" name="insertar" value="Registrar">
		<input type="submit" name="actualizar" value="Actualizar">
		<input type="submit" name="eliminar" value="Eliminar">
		</div>

	</form>
	<hr>
	<form action="Libro" method="post">
		<fieldset>
			<legend>Consultar Libro</legend>
				<div>
					<label>Codigo Isbn:</label>
					<input type="text" name="codigo">
				</div>
				<input type="submit" name="consultar" value="Consultar">
		</fieldset>
	</form>
	<form action="Libro" method="post" enctype="multipart/form-data">
		<div><label>Archivo:</label><input type="file" name="archivo" value="Examinar" accept="application/vnd.ms-excel"></div>
		<input type="submit" name="cargar" value="Cargar Archivo">
	</form>
</body>
</html>