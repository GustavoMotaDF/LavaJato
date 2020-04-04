<%-- 
    Document   : PagarSalario
    Created on : 01/02/2020, 01:16:23
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

      <main role="main" class="inner cover bg-cinza">
        <h1 class="cover-heading">Pagar Salários!.</h1>
        <div class="container">
            <form action="" method="post">
                <div class="form-group">
                    <select class="form-control" name="funcionario" id="funcionario" required>
                        <option value="">Selecione..</option>
                        <option disabled value="">------------------------------------------</option>
                        <option value="">Pagar de Todos</option>
                        <option disabled value="">------------------------------------------</option>
                        <option value="">Gustavo</option>
                        <option value="">Leandro</option>
                        <option value="">João</option> 
                    </select>
                </div>
                <div class="form-group">
                    <button class="btn btn-success form-control" name="cadastrar"><i class="fas fa-check-circle"></i>Pagar Salário</button>             

                </div>
            </form>
            
        </div>
      </main>

        <jsp:include page="includes/footer.jsp"/>
        
    </div>
        <jsp:include page="includes/bodyjs.jsp"/>
  </body>
</html>
