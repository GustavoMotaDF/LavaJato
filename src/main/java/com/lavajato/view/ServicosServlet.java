/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.view;

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
@WebServlet(name = "ServicosServlet", urlPatterns = {"/Servicos-info"})
public class ServicosServlet extends HttpServlet {

    private final ServicoBO servicobo = new ServicoBO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.nonNull(req.getParameter("cadastrar"))) {
            try {
                servicobo.IncluirServico(req.getParameter("nome"),
                        req.getParameter("valor"));

                req.setAttribute("mensagemSucesso", "<div id=\"foo\" class=\"alert alert-success\" role=\"alert\"> <strong> Servico cadastrado com Sucesso! </strong> </div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");

            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" + erro.getMessage() + "</strong></div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            }

        } else if (Objects.nonNull(req.getParameter("excluir"))) {
            try {
                servicobo.ExcluirServico(req.getParameter("id"));
                req.setAttribute("mensagemSucesso", "<div id=\"foo\"  class=\"alert alert-success\" role=\"alert\">Servico Desativado com Sucesso</div>"
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

        } else if (Objects.nonNull(req.getParameter("editar"))) {
            try {
                req.setAttribute("servicoEditando", servicobo.getServico(req.getParameter("id")));
            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" + erro + " edit</strong></div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            }
        } else if (Objects.nonNull(req.getParameter("alterar"))) {
            try {
                servicobo.EditarServico(req.getParameter("id"),
                        req.getParameter("nome"),
                        req.getParameter("valor"));
                req.setAttribute("mensagemSucesso", "<div id=\"foo\" class=\"alert alert-success\" role=\"alert\"> <strong> Servico alterado com Sucesso! </strong> </div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");

            } catch (Exception erro) {
                req.setAttribute("mensagemErro", "<div id=\"foo\" class=\"alert alert-warning\" role=\"alert\"><strong>" + erro.getMessage() + "</strong></div>"
                        + "<script>$().ready(function() {\n"
                        + "	setTimeout(function () {\n"
                        + "		$('#foo').hide(); // \"foo\" é o id do elemento que seja manipular.\n"
                        + "	}, 10000); // O valor é representado em milisegundos.\n"
                        + "});</script>");
            }

        }
        try {
            req.setAttribute("servicos", servicobo.getServicos());
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

        req.getRequestDispatcher("paginas/Servico.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("servicos", servicobo.getServicos());
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
        req.getRequestDispatcher("paginas/Servico.jsp").forward(req, resp);
    }

}
