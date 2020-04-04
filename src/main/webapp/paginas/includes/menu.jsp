<%-- 
    Document   : menu
    Created on : 01/02/2020, 00:50:38
    Author     : gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<nav class="mb-1 navbar navbar-expand-lg navbar-dark info-color">
    <a class="navbar-brand " href="#"><h3 class="titulo">Lava Jato</h3> </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-4"
            aria-controls="navbarSupportedContent-4" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-4">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active"><a href="/LavaJato/Inicio" class="nav-link"> <i class="fas fa-home"></i>Inicio</a></li>
            <li class="nav-item active"><a href="/LavaJato/Caixa-info" class="nav-link" > <i class="fas fa-hand-holding-usd"></i><i class="fas fa-plus-circle"></i>Caixa</a></li>
            <li class="nav-item dropdown active ">
                <a class="nav-link dropdown-toggle-right ponteiro" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-hand-holding-usd"></i><i class="fas fa-minus-circle"></i>Despesas</a>
                <div class="bg-secondary dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink-4">
                    <a class="dropdown-item text-light " href="/LavaJato/Despesa-info"><i class="fas fa-list-alt"></i>Despesas</a>
                    <a class="dropdown-item text-light" href="/LavaJato/PagarSalario-info"><i class="fas fa-door-closed"></i>Pagar Salarios</a>
                </div>
            </li>

            <li class="nav-item active"><a href="/LavaJato/Servicos-info" class="nav-link"><i class="far fa-edit"></i>Serviços</a></li>

            <li class="nav-item dropdown active  ">
                <a class="nav-link dropdown-toggle-right ponteiro" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user"></i>Opções</a>
                <div class="bg-secondary dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink-4">
                    <a class="dropdown-item text-light " href="/LavaJato/Relatorios-info"><i class="fas fa-list-alt"></i>Relatorios</a>
                    <a class="dropdown-item text-light " href="/LavaJato/Funcionario-info"><i class="fas fa-users-cog"></i>Funcionarios</a>
                </div>
            </li>
        </ul>
    </div>
</nav> 
