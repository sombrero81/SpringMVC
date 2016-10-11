<%-- 
    Document   : film_lister
    Created on : 11 oct. 2016, 10:07:00
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
        
        
        <a href="<spring:url value="/ajouter_film"/>">Ajouter film </a>
        <br>
        
        <br>
        <h1>Gestion des films</h1>
        
        <div>
            <c:forEach items="${mesfilms}" var="monfilm">

                iteration
                ${monfilm.titre}
                
                <a href="supprimer_film/${monfilm.id}">Supprimer</a>
                <a href="modifier_film/${monfilm.id}">Editer</a>
                
                
                <br>
            </c:forEach> 
        </div>
        
        
    </body>
</html>
