<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Database.ProductoDAO"%>
<%@page import="Model.Producto"%>
<%@page import="java.util.List"%>
<%
    //List<Producto> list = ProductoDAO.listar("id", "ASC", "10");
    //request.setAttribute("list", list);
    
    List<Producto> list = null;
    
    if(session.getAttribute("access") != null){
        request.setAttribute("list", list);
    }else{
        list = (List<Producto>) request.getAttribute("list");
        response.sendRedirect("/productos/ProductoController?op=init");
    }
    
%>  

<%--
<%@include file="/view/partials/footer.jsp"%>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5cb9f420b0.js" crossorigin="anonymous"></script>
        <style>
            tr td{
                padding: 0.1em !important;
                margin: 0.1rem !important;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">

            <div class="d-flex">
                <h2 class="">Lista de Productos</h2>
                <!-- <a style="margin-bottom: 3px;" class="mx-2 align-self-center" href=""><i class="fa-solid fa-square-plus fa-xl"></i></a> -->
            </div>

            <form action="ProductoController?op=nuevo" method="post">
                <input type="text" id="lnombre" name="lnombre" placeholder="Nombre...">
                <input type="text" id="lprecio" name="lprecio" placeholder="Precio...">
                <input type="text" id="ltipo" name="ltipo" placeholder="Tipo...">
                <input type="submit" value="Crear">
            </form>

            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Edit</th>
                    </tr>
                </thead>
                <tbody class="align-middle">
                    <c:forEach var="item" items="${list}">
                        <tr>
                            <th scope="row">${item.id}</th>
                            <td>${item.nombre}</td>
                            <td>${item.precio}</td>
                            <td>${item.tipo}</td>
                            <td class="d-inline-flex w-100">
                                <h4 class="card-title d-flex justify-content-between align-items-center mx-2"><a href="ProductoController?op=editar&id=${item.id}"><i class="fa fa-pencil"></i></a></h4>
                                <h4 class="card-title d-flex justify-content-between align-items-center"><a href="ProductoController?op=eliminar&id=${item.id}"><i class="fa-solid fa-trash"></i></a></h4>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
