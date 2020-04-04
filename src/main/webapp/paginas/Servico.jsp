<%-- 
    Document   : Servico
    Created on : 01/02/2020, 01:21:54
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-BR">
    <head>
        <jsp:include page="includes/headcss.jsp"/>
        <title>Lava Jato - Serviços</title> 
    </head>


    <body class="text-center Comfortaa">  
        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto"> 
                <jsp:include page="includes/menu.jsp"/>
            </header>

            <main role="main" class="inner cover bg-cinza ">
                <h1 class="cover-heading border-bottom ">Serviços!</h1>
                <br>
                <div class="container text-left"> 
                    <div>${mensagemSucesso}</div>
                    <div>${mensagemErro}</div>
                    <form action="${pageContext.request.contextPath}/Servicos-info" method="post"> 
                        <c:if test="${empty servicoEditando}">
                            <div class="form-group">               
                                <label for="servico">Serviço:</label>
                                <input type="text" name="nome" id="servico" class="form-control" required/>              
                            </div>
                            <div class="form-group">               
                                <label for="valor">Valor:</label>
                                <div class="input-group-prepend">
                                    <div class="input-group-text">R$</div>
                                    <input type="text" name="valor" id="valor" class="form-control " required/> 
                                    <div class="input-group-text">,00</div>
                                </div>                                      
                            </div>
                            <div class="form-group">               
                                <button class="btn btn-success form-control" name="cadastrar"><i class="fas fa-check-circle"></i>Cadastrar Serviço</button>             
                            </div>
                            
                        </c:if>
                        <c:if test="${not empty servicoEditando}">
                            <input type="hidden" name="id" value="${servicoEditando.id}"/>
                            <div class="form-group">               
                                <label for="servico">Serviço:</label>
                                <input type="text" name="nome" id="servico" class="form-control" value="${servicoEditando.nome}" required/>              
                            </div>
                            <div class="form-group">               
                                <label for="valor">Valor:</label>
                                <div class="input-group-prepend">
                                    <div class="input-group-text">R$</div>
                                    <input type="text" name="valor" id="valor" class="form-control " value="${servicoEditando.valor}" required/> 
                                    <div class="input-group-text">,00</div>
                                </div>                                      
                            </div>
                            <div class="form-group">               
                                <button class="btn btn-success form-control" name="alterar"><i class="fas fa-check-circle"></i>Alterar informação do Serviço</button>             
                            </div>
                        </c:if>

                    </form>                   
                </div> 

            </main>
            <br>
            <button type="button" class="btn btn-info form-control" data-toggle="modal" data-target="#exampleModalCenter">
                Ver Todos os Serviços
            </button>
            <div class="modal fade bd-example-modal-lg text-dark" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg modal-dialog-centered">

                    <div class="modal-content">
                        <form action="${pageContext.request.contextPath}/Servicos-info" method="post"> 
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Lista de Serviços</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <div class="container text-left">
                                    <table class="table table-hover table-responsive-sm">
                                        <thead>
                                            <tr>
                                                <th >ID</th>
                                                <th >Serviço</th>
                                                <th >Valor</th>                   
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="servicos" items="${servicos}">  
                                            <tr>
                                                <th><label for="gridRadios${servicos.id}">${servicos.id}</label></th>
                                                <td><label for="gridRadios${servicos.id}">${servicos.nome}</label></td>
                                                <td><label for="gridRadios${servicos.id}">R$${servicos.valor}0</label></td>
                                                <td><input type="radio" name="id" id="gridRadios${servicos.id}" value="${servicos.id}"></td>
                                            </tr>    
                                            </c:forEach>
                                        </tbody>
                                    </table>          
                                </div>
                            </div>
                            <div class="modal-footer" >                                 
                                <button type="button" class="btn btn-warning  mr-auto" data-dismiss="modal" name="cancelar">Cancelar</button>
                                <button type="submit" class="btn btn-info float-right" name="editar">Editar</button>
                                <button type="submit" class="btn btn-danger float-right" name="excluir">Excluir</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>

            <jsp:include page="includes/footer.jsp"/>

        </div>
        <jsp:include page="includes/bodyjs.jsp"/>
    </body>
</html>
