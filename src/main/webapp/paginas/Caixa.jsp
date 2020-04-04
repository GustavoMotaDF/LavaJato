<%-- 
    Document   : Caixa
    Created on : 01/02/2020, 01:14:28
    Author     : gustavo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-BR">
    <head>
        <jsp:include page="includes/headcss.jsp"/>
        <title>Lava Jato - Caixa</title> 
    </head>

    <body class="text-center Comfortaa"> 
        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto"> 
                <jsp:include page="includes/menu.jsp"/>
            </header>

            <main role="main" class="inner cover bg-cinza">
                <h1 class="cover-heading">Caixa!.</h1>
                
                <div class="container">
                     <div>${mensagemSucesso}</div>
                    <div>${mensagemErro}</div>
                    <form action="${pageContext.request.contextPath}/Caixa-info" method="post" name="realizarVenda">

                        <div class="form-group text-color-dark">

                            <select class="form-control" name="formato" required>
                                <option value="">Pagamento..</option> 
                                <option value="Dinheiro">Dinheiro</option>
                                <option value="Débito">Débito</option>
                                <option value="Crédito">Crédito</option>
                            </select>
                            <br>
                        </div>
                        <div class="form-group text-color-dark">
                            <select class="form-control" id="selectDinheiro" name="idservico" required>
                                <option value="Selecione o Serviço Prestado">Serviço prestado..</option>
                                <c:forEach var="servicos" items="${servicos}">  
                                    <option value="${servicos.id}">${servicos.nome}, Valor:R$${servicos.valor}0</option>   
                                    
                                </c:forEach>                                  
                            </select>     
                        </div>
                         
                        <div class="form-group">
                            <button class="btn btn-success form-control" type="submit" name="vender"><i class="fas fa-dollar-sign"><i class="fas fa-dollar-sign"></i></i>Realizar Venda<i class="fas fa-dollar-sign"></i><i class="fas fa-dollar-sign"></i></button>
                        </div>
                    </form>

                </div>
            </main>
            <jsp:include page="includes/footer.jsp"/>
        </div>    
        <jsp:include page="includes/bodyjs.jsp"/>
    </body>
</html>
