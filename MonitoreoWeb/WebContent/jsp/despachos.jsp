<%@page import="vos.VoItemVenta"%>
<%@page import="vos.VoVenta"%>
<%@page import="vos.VoDespacho"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Despachos/title>
</head>
<body>

<h1> Despachos </h1>

<% 
	List<VoDespacho> despachos = (List<VoDespacho>) request.getAttribute("despachos");
%>

<% if ( despachos != null ){ %>
<table>
<tr>
<th>
Id
</th>
<th>
Nombre
</th>
<th>
Activo
</th>
<th>
Coordenadas
</th>
</tr>
<% for (VoDespacho despacho: despachos) {%>
	<tr>
	<td>
	  <%= despacho.getId() %>
	</td>
	<td>
	  <%= despacho.getNombre() %>
	</td>
	<td>
	 <% if ( despacho.getEstaActivo() ) {%>
	 	activo
	 <% } else { %>	
	 	inactivo
	 <%} %>
	</td>
	<td>
	  <%= despacho.getCoordenadas() %>
	</td>
	</tr>
<%} %>
</table>
<% } %>


<h1> Ventas sin ordenes de despacho asignada</h1>

<% 
	List<VoVenta> ventassionod = (List<VoVenta>) request.getAttribute("ventassionod");
%>
<% if ( ventassionod != null) { %>
<table>
<tr>
<th>
Codigo
</th>
<th>
Cliente
</th>
<th>
Estado
</th>
<th>
Fecha
</th>
<th>
Items
</th>
<th>
Portal
</th>
</tr>
<%for (VoVenta venta: ventassionod){ %>
<tr>
<td>
<%= venta.getCodigo() %>
</td>
<td>
<%= venta.getCliente().getDni() %>
</td>
<td>
<%= venta.getEstado() %>
</td>
<td>
<%= venta.getFecha().toString() %>
</td>
<td>
<% for (VoItemVenta item: venta.getItemsVenta()) {%>
<%= item.getProducto().getDescripcion() %>
<%} %>
</td>
<td>
<%= venta.getPortal().getCodigo() %>
</td>
</tr>
<%} %>
</table>


<%} %>
</body>
</html>