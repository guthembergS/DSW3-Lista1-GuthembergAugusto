package br.com.controle;

import br.com.cadastro.FachadaParlamentar;
import br.com.model.Parlamentar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author guto
 */
public class ServletAlteracao extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String id = req.getParameter("codigo");
        int codigo = Integer.parseInt(id);

        Parlamentar func = new Parlamentar(nome);
        func.setCodigo(codigo);
        FachadaParlamentar fachada = FachadaParlamentar.getInstance();
        fachada.alterar(func);
        req.getRequestDispatcher("Exemplo6a").forward(req, resp);
    }
}
