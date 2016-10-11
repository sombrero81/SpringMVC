<%-- 
    Document   : ajouter_genre
    Created on : 10 oct. 2016, 16:42:37
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajout film</h1>
        
        <div>
            
            
            
            <form:form  modelAttribute="nouveauFilm"> 
                
                
                <label>Titre du film</label>
                <form:input path="titre"/>
                <br>  
                <label>Annee de prod</label>
                <form:input path="anneeProd"/>
                <br> 
                
                <label>synopsis</label>
                <form:textarea path="synopsis"/>
                <br>
                
                <label>Genre</label>
                <form:select path="genre.id" items="${genres}" itemLabel="nom" itemValue="id"/>
                
                
                
                <input type="submit" value="Ajouter"/>
                    
            </form:form>
        </div>
        
        
        
    </body>
</html>
