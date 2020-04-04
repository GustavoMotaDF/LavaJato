<%-- 
    Document   : Inicio
    Created on : 01/02/2020, 01:19:21
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-BR">
  <head>
    <jsp:include page="includes/headcss.jsp"/>
    <title>Lava Jato - Inicio</title> 
  </head>
   
  <body class="text-center Comfortaa">     

    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto"> 
          <jsp:include page="includes/menu.jsp"/>
      </header>

      <main role="main" class="inner cover">
        <h1 class="cover-heading bemvindo titulo">Olá, Bem vindo(a)!.</h1>
        
      </main>

       <jsp:include page="includes/footer.jsp"/>
        
    </div>
        <jsp:include page="includes/bodyjs.jsp"/>

  </body>
</html>
