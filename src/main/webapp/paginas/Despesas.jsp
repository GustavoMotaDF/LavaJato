<%-- 
    Document   : Despesas
    Created on : 01/02/2020, 01:00:09
    Author     : gustavo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!doctype html>
<html lang="pt-BR">
    <head> 
        <jsp:include page="includes/headcss.jsp"/>
        <title>Lava Jato - Despesas</title> 
    </head>

    <body class="text-center Comfortaa">  
        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto"> 
                <jsp:include page="includes/menu.jsp"/>
            </header>

            <main role="main" class="inner cover bg-cinza">
                <h1 class="cover-heading ">Despesas!.</h1>
                <div>${mensagemSucesso}</div>
                <div>${mensagemErro}</div>
                <form action="${pageContext.request.contextPath}/Despesa-info" method="post" name="realizarVenda">
                    <c:if test="${empty despesaEditando}">
                        <div class="container text-left">
                            <div class="form-group "> 
                                <label for="despesa">Despesa:</label>
                                <input type="text" name="despesa" id="despesa" class="form-control" placeholder="Ex.: Esponja" required/>
                                <small id="despesa" class="form-text  ">Em caso de vale, escreva o nome do funcionario. </small>

                            </div> 
                            <div class="form-group">
                                <label for="valor">Valor:</label>
                                <div class="input-group-prepend">
                                    <div class="input-group-text">R$</div>
                                    <input type="text" name="valor" id="valor" class="form-control" required placeholder="0"/> 
                                    <div class="input-group-text">,00</div>
                                </div> 
                            </div>
                            <div  class="form-group">
                                <label for="tipodespesa">Selecione o Tipo de Despesa</label>
                                <Select class="form-control" name="tipodespesa" id="tipodespesa" required>
                                    <option value="">Selecione o Tipo de Despesa</option> 
                                    <option value="Vale(Funcionario)">Vale(Funcionario)</option>
                                    <option value="Pessoal(João-Marina)">Pessoal(João-Marina)</option>
                                    <option value="Material de Trabalho">Material de Trabalho</option>
                                </Select>
                            </div>
                            <div  class="form-group">
                                <label for="data">Data de Saída:</label>
                                <input type="date" name="datadespesa" id="data" class="form-control" required="Preencha a data!"/>
                            </div>

                            <div class="form-group">
                                <button class="btn btn-success form-control" type="submit" name="cadastrar"><i class="fas fa-check-circle"></i>Cadastrar Despesa</button>             
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty despesaEditando}">
                        <input type="hidden" name="id" value="${despesaEditando.id}"/>
                        <div class="container text-left">
                            <div class="form-group "> 
                                <label for="despesa">Despesa:</label>
                                <input type="text" name="despesa" id="despesa" class="form-control" value="${despesaEditando.despesa}" placeholder="Ex.: Esponja" required/>
                                <small id="despesa" class="form-text  ">Em caso de vale, escreva o nome do funcionario. </small>

                            </div> 
                            <div class="form-group">
                                <label for="valor">Valor:</label>
                                <div class="input-group-prepend">
                                    <div class="input-group-text">R$</div>
                                    <input type="text" name="valor" id="valor" class="form-control" value="${despesaEditando.valor}0" required placeholder="0"/> 
                                    <div class="input-group-text">,00</div>
                                </div> 
                            </div>
                            <div  class="form-group">
                                <label for="tipodespesa">Selecione o Tipo de Despesa</label>
                                <Select class="form-control" name="tipodespesa" id="tipodespesa" required>
                                    <option value="${despesaEditando.tipodespesa}">${despesaEditando.tipodespesa}</option>
                                    <option value="">Selecione o Tipo de Despesa</option> 
                                    <option value="Vale(Funcionario)">Vale(Funcionario)</option>
                                    <option value="Pessoal(João-Marina)">Pessoal(João-Marina)</option>
                                    <option value="Material de Trabalho">Material de Trabalho</option>
                                </Select>
                            </div>
                            <div  class="form-group">
                                <label for="data">Data de Saída:</label>
                                <input type="date" name="datadespesa" id="data" class="form-control" value="${despesaEditando.datadespesa}" required="Preencha a data!"/>
                            </div>


                            <div class="form-group">
                                <button class="btn btn-success form-control" type="submit" name="alterar"><i class="fas fa-check-circle"></i>Alterar Despesa</button>             
                            </div>
                        </div>
                    </c:if>

                </form>

                <div class="modal fade bd-example-modal-lg text-dark" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-centered">
                        <div class="modal-content">
                            <form action="${pageContext.request.contextPath}/Despesa-info" method="post" name="realizarVenda">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Lista de Despesas</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="container text-left">
                                        <table class="table table-hover table-responsive-sm">
                                            <thead>
                                                <tr>
                                                    <th>Despesa</th>
                                                    <th>Tipo</th>
                                                    <th>Valor</th>
                                                    <th>Data</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="despesa" items="${despesas}">
                                                    <tr> 
                                                        <td>${despesa.despesa}</td>
                                                        <td>${despesa.tipodespesa}</td>
                                                        <td>R$${despesa.valor}0</td>                                                         
                                                        <td>${despesa.datadespesa}</td>
                                                       
                                                        <td><input type="radio" name="id"  value="${despesa.id}"  ></td>
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
                Lista de Despesas
            </button>
            <br>

            <jsp:include page="includes/footer.jsp"/>
        </div>

        <jsp:include page="includes/bodyjs.jsp"/>
    </body>
</html>

