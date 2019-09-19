package br.com.cadastro;

import br.com.model.Parlamentar;
import java.util.Collection;
import repositorio.RepositorioParlamentarsCollection;
//import repositorio.RepositorioFuncionariosCollection;

public class FachadaParlamentar {

    private static FachadaParlamentar fachada;
    private RepositorioParlamentarsCollection repositorio;

    static {
        fachada = new FachadaParlamentar();
    }

    private FachadaParlamentar() {
        repositorio = new RepositorioParlamentarsCollection();
    }

    public static FachadaParlamentar getInstance() {
        return fachada;
    }

    public void inserir(Parlamentar par) {
        repositorio.inserir(par);
    }

    public void remover(Parlamentar par) {
        repositorio.remover(par);
    }

    public void alterar(Parlamentar par) {
        repositorio.alterar(par);
    }

    public Parlamentar procurarPorCodigo(int codigo) {
        return repositorio.procurarPorCodigo(codigo);
    }

    public Collection<Parlamentar> listarTodos() {
        return repositorio.listarTodos();
    }
}
