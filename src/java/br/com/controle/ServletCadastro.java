package br.com.controle;

import br.com.cadastro.FachadaParlamentar;
import br.com.model.Parlamentar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guto
 */
public class ServletCadastro extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nome = req.getParameter("nome");

        Parlamentar par = new Parlamentar(nome);
        FachadaParlamentar fachada = FachadaParlamentar.getInstance();
        fachada.inserir(par);
        req.getRequestDispatcher("ServletPrincipal").forward(req, resp);
    }
}
