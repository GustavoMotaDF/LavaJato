/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.view;

import com.lavajato.negocio.CaixaBO;
import com.lavajato.negocio.ServicoBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "CaixaServlet", urlPatterns = {"/Caixa-info"})
public class CaixaServlet extends HttpServlet {
    private final ServicoBO servicobo = new ServicoBO();
    private final CaixaBO caixabo = new CaixaBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.nonNull(req.getParameter("vender"))) {
            try {
                caixabo.RealizarVenda(  req.getParameter("idservico"),
                                        req.getParameter("formato"));
                                                                                

                req.setAttribute("mensagemSucesso", "<div id=\"foo\" class=\"alert alert-success\" role=\"alert\"> <strong> Venda realizada com sucesso! </strong> </div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");

            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" +erro.getMessage()+ "</strong></div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            }

        }else if (Objects.nonNull(req.getParameter("excluir"))) {
            try {
                caixabo.ExcluirVenda(req.getParameter("id"));
                req.setAttribute("mensagemSucesso", "<div id=\"foo\"  class=\"alert alert-success\" role=\"alert\">Venda Arquivada com Sucesso</div>"
                        + "<script>\n"
                        + "                    $().ready(function () {\n"
                        + "                        setTimeout(function () {\n"
                        + "                            $('#foo').hide();\n"
                        + "                        }, 10000);\n"
                        + "                    });\n"
                        + "                </script>\n"
                        + "");

            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\"  class=\"alert alert-warning\" role=\"alert\">" + erro.getMessage() + "</div>"
                        + "<script>\n"
                        + "                    $().ready(function () {\n"
                        + "                        setTimeout(function () {\n"
                        + "                            $('#foo').hide();\n"
                        + "                        }, 10000);\n"
                        + "                    });\n"
                        + "                </script>\n"
                        + "");

            }

        }else if (Objects.nonNull(req.getParameter("editar"))) {
            try {
                req.setAttribute("caixaEditando", caixabo.getVenda(req.getParameter("id")));
            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" +erro+" </strong></div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            }
        }else if (Objects.nonNull(req.getParameter("alterar"))) {
            try {
                caixabo.EditarVenda(req.getParameter("id"),
                                        req.getParameter("idservico"),
                                        req.getParameter("formato"));
                req.setAttribute("mensagemSucesso", "<div id=\"foo\" class=\"alert alert-success\" role=\"alert\"> <strong> Venda alterada com Sucesso! </strong> </div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");

            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" + erro+ "</strong></div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            }

        }try {
            req.setAttribute("servicos", servicobo.getServicos());
            req.setAttribute("relatorioAno", caixabo.relatorioAno());
        } catch (Exception erro) {
            req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\">" + erro.getMessage() + "</div>"
                    + "<script>\n"
                    + "                    $().ready(function () {\n"
                    + "                        setTimeout(function () {\n"
                    + "                            $('#foo').hide();\n"
                    + "                        }, 10000);\n"
                    + "                    });\n"
                    + "                </script>\n"
                    + "");
        }

        req.getRequestDispatcher("paginas/Caixa.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("servicos", servicobo.getServicos());
            req.setAttribute("relatorioAno", caixabo.relatorioAno());
        } catch (Exception erro) {
            req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\">" + erro+ "</div>"
                    + "<script>\n"
                    + "                    $().ready(function () {\n"
                    + "                        setTimeout(function () {\n"
                    + "                            $('#foo').hide();\n"
                    + "                        }, 10000);\n"
                    + "                    });\n"
                    + "                </script>\n"
                    + "");
        }

        req.getRequestDispatcher("paginas/Caixa.jsp").forward(req, resp);
    }
 
}
