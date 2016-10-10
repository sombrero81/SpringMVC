<%-- 
    Document   : genre_lister
    Created on : 10 oct. 2016, 11:03:01
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>liste des genres</h1>



        <div>
            <c:forEach items="${mesGenres}" var="monGenre">

                iteration
                ${monGenre.nom}
                <br>
            </c:forEach> 
        </div>

    </body>
</html>
