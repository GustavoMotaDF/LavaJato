<%-- 
    Document   : Relatorios
    Created on : 03/02/2020, 18:07:46
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/headcss.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lava Jato - Relatorios</title>
    </head>
    <body class="text-center Comfortaa">     

    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto"> 
          <jsp:include page="includes/menu.jsp"/>
      </header>

      <main role="main" class="inner cover">
        <div class="accordion bg-cinza" id="accordionExample">
            <div class="card bg-cinza">
              <div class="card-header" id="headingOne">
                <h2 class="mb-0">
                  <button class="btn btn-light collapsed" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    Relatorios sobre Vendas
                  </button>
                </h2>
              </div>

              <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card bg-cinza">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="#" class="btn btn-info form-control" data-toggle="modal" data-target="#exampleModal">Anos</a><br><hr>
                              
                          <!-- Modal anos-->
                          <div class="modal fade text-dark" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel">Anos</h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <c:forEach var="relatorioAno" items="${relatorioAno}">
                                        <div class="col-md-6">
                                            Ano: ${relatorioAno[0]}<br>
                                            Valor: R$ ${relatorioAno[1]}0
                                        </div>
                                        </c:forEach>                         
                                    </div> 
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                              </div>
                            </div>
                          </div>
                            
                            
                            
                            
                            <a href="#" class="btn btn-info form-control" data-toggle="modal" data-target="#exampleModalmes">Meses</a><br><hr>
                              
                          <!-- Modal anos-->
                          <div class="modal fade text-dark" id="exampleModalmes" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel">Ano ${relatorioMes[0][0]}</h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-hover table-striped">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>Mês</th>
                                                <th>Valor Bruto</th>
                                                <th>Quantidade de Vendas</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="relatorioMes" items="${relatorioMes}"> 
                                            <tr>
                                                <td>${relatorioMes[2]}</td>
                                                <td>R$ ${relatorioMes[3]}0</td>
                                                <td>${relatorioMes[1]}</td>
                                            </tr>
                                            </c:forEach>     
                                        </tbody>
                                    </table>
                                     
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="col-md-6">
                            <a href="#" class="btn btn-info form-control" data-toggle="modal" data-target="#exampleModal7dias">Ultimos 7 dias</a><br><hr>
                              
                          <!-- Modal anos-->
                          <div class="modal fade text-dark" id="exampleModal7dias" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                            <div class="modal-dialog modal-lg" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel">Ultimos 7 dias</h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-hover table-striped">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>Serviço Prestado</th>
                                                <th>Data</th>
                                                <th>Formato</th>
                                                <th>Valor</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="relatorio7Dia" items="${relatorio7Dia}"> 
                                            <tr>
                                                <td>${relatorio7Dia[0]}</td>
                                                <td>${relatorio7Dia[1]}</td>
                                                <td>${relatorio7Dia[2]}</td>
                                                <td>R$ ${relatorio7Dia[3]}0</td>
                                            </tr>
                                            </c:forEach>     
                                        </tbody>
                                    </table>
                                     
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                              </div>
                            </div>
                          </div>
                            
                            <a href="#" class="btn btn-info form-control" data-toggle="modal" data-target="#exampleModalOntem">Ontem</a><br><hr>
                              
                          <!-- Modal anos-->
                          <div class="modal fade text-dark" id="exampleModalOntem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                            <div class="modal-dialog modal-lg" role="document">
                              <div class="modal-content ">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel">Ontem </h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-hover table-striped">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>Serviço Prestado</th>
                                                <th>Data</th>
                                                <th>Formato</th>
                                                <th>Valor</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="relatorioOntem" items="${relatorioOntem}"> 
                                            <tr>
                                                <td>${relatorioOntem[0]}</td>
                                                <td>${relatorioOntem[1]}</td>
                                                <td>${relatorioOntem[2]}</td>
                                                <td>R$ ${relatorioOntem[3]}0</td>
                                            </tr>
                                            </c:forEach>     
                                        </tbody>
                                    </table>
                                     
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>                        
                    </div> 
                    
                    <a href="#" class="btn btn-info form-control" data-toggle="modal" data-target="#exampleModalHoje">Hoje</a><br><hr>
                          <!-- Modal anos-->
                          <div class="modal fade text-dark" id="exampleModalHoje" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                            <div class="modal-dialog modal-lg" role="document">
                              <div class="modal-content ">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel">Ontem </h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-hover table-striped">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>Serviço Prestado</th>
                                                <th>Data</th>
                                                <th>Formato</th>
                                                <th>Valor</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="relatorioHoje" items="${relatorioHoje}"> 
                                            <tr>
                                                <td>${relatorioHoje[0]}</td>
                                                <td>${relatorioHoje[1]}</td>
                                                <td>${relatorioHoje[2]}</td>
                                                <td>R$ ${relatorioHoje[3]}0</td>
                                            </tr>
                                            </c:forEach>     
                                        </tbody>
                                    </table>
                                     
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                              </div>
                            </div>
                          </div>

                 </div>
              </div>
            </div>
            <div class="card bg-cinza">
              <div class="card-header" id="headingTwo">
                <h2 class="mb-0">
                  <button class="btn btn-light collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Relatorios sobre Despesas
                  </button>
                </h2>
              </div>
              <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                <div class="card bg-cinza">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="#" class="btn btn-info form-control" >Anos</a><br><hr>
                            <a href="#" class="btn btn-info form-control" >Meses</a><br>
                        </div>
                        <div class="col-md-6">
                            <a href="#" class="btn btn-info form-control" >Ultimos 7 dias</a><br><hr>
                            <a href="#" class="btn btn-info form-control" >Ontem</a><br>
                        </div>                        
                    </div> 
                    <hr><a href="#" class="btn btn-info form-control" >Hoje</a><br>

                 </div>
              </div>
            </div>
            <div class="card bg-cinza">
              <div class="card-header" id="headingThree">
                <h2 class="mb-0">
                  <button class="btn btn-light collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Relatorios Group Item #3
                  </button>
                </h2>
              </div>
              <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                <div class="card bg-cinza">
                    <div class="row">
                        <div class="col-md-6">
                            <a href="#" class="btn btn-info form-control" >Anos</a><br><hr>
                            <a href="#" class="btn btn-info form-control" >Meses</a><br>
                        </div>
                        <div class="col-md-6"> 
                            <a href="#" class="btn btn-info form-control" >Ultimos 7 dias</a><br><hr>
                            <a href="#" class="btn btn-info form-control" >Ontem</a><br>
                        </div>                        
                    </div> 
                    <hr><a href="#" class="btn btn-info form-control" >Hoje</a><br>

                 </div>
              </div>
            </div>
         </div>
          
        
      </main>

       <jsp:include page="includes/footer.jsp"/>
        
    </div>
        <jsp:include page="includes/bodyjs.jsp"/>

  </body>
</html>
