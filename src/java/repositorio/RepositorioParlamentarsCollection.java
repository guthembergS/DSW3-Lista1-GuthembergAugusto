package repositorio;

import br.com.model.Parlamentar;
import java.util.ArrayList;
import java.util.Collection;

public class RepositorioParlamentarsCollection {

    private Collection<Parlamentar> repositorio = new ArrayList<Parlamentar>();
    private static int id = 0;

    public void inserir(Parlamentar par) {
        par.setCodigo(id++);
        repositorio.add(par);
    }

    public void remover(Parlamentar par) {
        repositorio.remove(par);
    }

    public void alterar(Parlamentar par) {
        Parlamentar p = this.procurarPorCodigo(par.getCodigo());
        repositorio.remove(p);
        repositorio.add(par);
    }

    public Parlamentar procurarPorCodigo(int codigo) {
        for (Parlamentar par : repositorio) {
            if (par.getCodigo() == codigo) {
                return par;
            }
        }
        return null;
    }

    public Collection<Parlamentar> listarTodos() {
        return repositorio;
    }
}
