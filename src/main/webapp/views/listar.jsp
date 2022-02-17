<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listar Productos</title>
	<link rel="stylesheet" href="views/producto.css">
</head>
<body>
	<h1>Listar Productos</h1>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<td>Cantidad</td>
			<td>Precio</td>
			<td>Fecha Creación</td>
			<td>Fecha Actualización</td>
			<td>Acción</td>
		</tr>
		<c:forEach items="${lista}" var="producto">
		<tr>
	    	<td> <a href="producto?opcion=meditar&id=<c:out value="${producto.id}"></c:out>"> <c:out value="${producto.id}"></c:out> </a> </td>
			<td><c:out value="${producto.nombre}"></c:out></td>
			<td><c:out value="${producto.cantidad}"></c:out></td>
			<td><c:out value="${producto.precio}"></c:out></td>
			<td><c:out value="${producto.fecha_crear}"></c:out></td>
			<td><c:out value="${producto.fecha_actualizar}"></c:out></td>
            <td> <a href="producto?opcion=eliminar&id=<c:out value="${producto.id}"></c:out>">Eliminar</a> </td>			
		</tr>	
		</c:forEach>
	</table>
</body>
</html>