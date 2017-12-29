<%-- 
    Document   : ajouterAbonne
    Created on : 29 déc. 2017, 01:35:21
    Author     : frukundo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <h1>Créer abonné</h1>
        <form method="get" action="Menu">
            Nom: <input type="text" name="nom" value="" size="20" maxlength="20" /> <br/>         
            Prenom <input type="text" name="prenom" value="" size=“80" maxlength="20" /><br/> 
            <button type="submit" class="btn btn-default">Enregistre</button>             
        </form>
        </div>
    </body>
</html>
