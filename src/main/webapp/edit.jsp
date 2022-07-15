<%-- 
    Document   : edit
    Created on : 14/07/2022, 22:06:13
    Author     : super
--%>

<%@page import="Database.ProductoDAO"%>
<%@page import="Model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar!</h1>

        <%
            String id = (String) session.getAttribute("id");

            Producto prod = ProductoDAO.unique(Integer.parseInt(id));
            request.setAttribute("prod", prod);
        %>

        <form action="ProductoController?op=edit" method="post">
            <input style="display: none;" type="number" id="lid" name="lid" min="0" value="${id}" readonly>
            <input type="text" id="lnombre" name="lnombre" placeholder="Nombre..." value="${prod.nombre}">
            <input type="text" id="lprecio" name="lprecio" placeholder="Precio..." value="${prod.precio}">
            <input type="text" id="ltipo" name="ltipo" placeholder="Tipo..." value="${prod.tipo}">
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
