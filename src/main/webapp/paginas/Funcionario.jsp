<%--
    Document   : Funcionario
    Created on : 01/02/2020, 01:44:16
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
                <h1 class="cover-heading">Funcionarios!.</h1>
                <br>
                <div class="container text-left">
                    <div>${mensagemSucesso}</div>
                    <div>${mensagemErro}</div>
                    <form action="${pageContext.request.contextPath}/Funcionario-info" method="post" name="cadFuncionarios">
                        <c:if test="${empty funcionarioEditando}">
                            <div class="form-group">
                            <label for="nome">Nome:</label>
                            <input type="text" name="nome" id="nome" required class="form-control" placeholder="Ex.: João Guilherme"/>
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone:</label>
                            <input type="tel" name="telefone" id="telefone" required class="form-control" placeholder="Ex.: 00 0 0000 0000"/>
                        </div>
                        <div class="form-group">
                            <label for="salario">Salario:</label>
                            <div class="input-group-prepend">
                                <div class="input-group-text">R$</div>
                                <input type="tel" name="salario" id="salario" required class="form-control" placeholder="Ex.: 1045,00"/>
                                <div class="input-group-text">,00</div>
                            </div>                                      
                            
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success form-control" type="submit" name="cadastrar">Cadastrar</button>
                        </div>
                        </c:if>
                        <c:if test="${not empty funcionarioEditando}">
                            <input type="hidden" name="id" value="${funcionarioEditando.id}"/>
                            <div class="form-group">
                            <label for="nome">Nome:</label>
                            <input type="text" name="nome" id="nome" required class="form-control" value="${funcionarioEditando.nome}" placeholder="Ex.: João Guilherme"/>
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone:</label>
                            <input type="tel" name="telefone" id="telefone" required class="form-control" value="${funcionarioEditando.telefone}"placeholder="Ex.: 00 0 0000 0000"/>
                        </div>
                        <div class="form-group">
                            <label for="salario">Salario:</label>
                            <div class="input-group-prepend">
                                <div class="input-group-text">R$</div>
                                <input type="tel" name="salario" id="salario" required class="form-control" value="${funcionarioEditando.salario}"placeholder="Ex.: 1045,00"/>
                                <div class="input-group-text">,00</div>
                            </div>                                      
                            
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success form-control" type="submit" name="alterar">Alterar</button>
                        </div>
                        </c:if>
                        
                    </form>
                </div>


                <!-- Button trigger modal -->
                

                <!-- Modal -->
                <div class="modal fade bd-example-modal-lg text-dark" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-centered">
                        <div class="modal-content">
                            <form action="${pageContext.request.contextPath}/Funcionario-info" method="post"> 
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Lista de Funcionarios</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="container text-left">
                                        <table class="table table-hover ">
                                            <thead>
                                                <tr> 
                                                    <th >ID</th>                                               
                                                    <th>Nome</th> 
                                                </tr>

                                            </thead>
                                            <tbody>
                                                <c:forEach var="funcionarios" items="${funcionarios}">
                                                    <tr>        
                                                    <th><label for="gridRadios${funcionarios.id}">${funcionarios.id}</label></th>
                                                    
                                                    <td><label for="gridRadios${funcionarios.id}">${funcionarios.nome}</label></td>
                                                    <td><input type="radio" id="gridRadios${funcionarios.id}" required name="id" value="${funcionarios.id}"></td>
                                                </tr>
                                                    
                                                </c:forEach>
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="modal-footer" >                                 
                                    <button type="button" class="btn btn-warning  mr-auto" data-dismiss="modal" name="cancelar">Cancelar</button>
                                    <button type="submit" class="btn btn-info float-right"  name="editar">Editar</button>
                                    <button type="submit" class="btn btn-danger float-right" name="excluir">Excluir</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>

            </main>
                                <br>
                                <br>
                                <button type="button" class="btn btn-primary form-control" data-toggle="modal" data-target="#exampleModalCenter">
                    Lista de Funcionarios
                </button>

            <jsp:include page="includes/footer.jsp"/>

        </div>
        <jsp:include page="includes/bodyjs.jsp"/>

    </body>
</html>

