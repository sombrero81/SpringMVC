<%-- 
    Document   : genre_lister
    Created on : 10 oct. 2016, 11:03:01
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <a href="<spring:url value="/ajouter_genre"/>">Ajouter genre </a>
        <br>
        <h1>liste des genres</h1>
        
        
        <div>
            <c:forEach items="${mesGenres}" var="monGenre">

                iteration
                ${monGenre.nom}
                
                <a href="supprimer_genre/${monGenre.id}">Supprimer</a>
                <a href="modifier_genre/${monGenre.id}">Editer</a>
                
                
                <br>
            </c:forEach> 
        </div>

    </body>
</html> 
