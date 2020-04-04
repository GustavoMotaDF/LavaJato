/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.view;

import com.lavajato.negocio.CaixaBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios-info"})
public class Relatorios extends HttpServlet {
private final CaixaBO caixabo = new CaixaBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        req.setAttribute("relatorioHoje", caixabo.relatorioHoje());
        req.setAttribute("relatorioOntem", caixabo.relatorioOntem());
        req.setAttribute("relatorio7Dia", caixabo.relatorio7Dias());
        req.setAttribute("relatorioAno", caixabo.relatorioAno());
        req.setAttribute("relatorioMes", caixabo.relatorioMes());
        

    } catch (Exception ex) {
         
    }
     req.getRequestDispatcher("paginas/Relatorios.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        req.setAttribute("relatorioHoje", caixabo.relatorioHoje());
        req.setAttribute("relatorioOntem", caixabo.relatorioOntem());
        req.setAttribute("relatorio7Dia", caixabo.relatorio7Dias());
        req.setAttribute("relatorioAno", caixabo.relatorioAno());
        req.setAttribute("relatorioMes", caixabo.relatorioMes());
    } catch (Exception ex) {
        
    }
      req.getRequestDispatcher("paginas/Relatorios.jsp").forward(req, resp);
    }


}
