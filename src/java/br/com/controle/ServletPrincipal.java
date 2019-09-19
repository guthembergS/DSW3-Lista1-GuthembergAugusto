package br.com.controle;

import br.com.cadastro.FachadaParlamentar;
import br.com.model.Parlamentar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author guto
 */
public class ServletPrincipal extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        FachadaParlamentar fachada = FachadaParlamentar.getInstance();
        resp.setContentType("text/plain");
        JSONArray json = new JSONArray(fachada.listarTodos());
        resp.getWriter().write(json.toString());
    }

    public static void main(String[] args) {
        FachadaParlamentar fachada = FachadaParlamentar.getInstance();
        Parlamentar f1 = new Parlamentar("Joao","pe","PT","Indeciso");
        fachada.inserir(f1);
        JSONArray json = new JSONArray(fachada.listarTodos());
        System.out.println(json.toString());
        JSONObject obj = new JSONObject(f1);
        System.out.println(obj.toString());
    }
}
