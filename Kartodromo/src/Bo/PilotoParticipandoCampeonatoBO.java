package Bo;

import Dao.PilotoParticipandoCampeonatoDAO;
import Model.Campeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;

import java.util.List;

public class PilotoParticipandoCampeonatoBO implements GenericBO<PilotoParticipandoCampeonato> {

    private PilotoParticipandoCampeonatoDAO pilotoDAO;

    public PilotoParticipandoCampeonatoBO() {

    }

    @Override
    public boolean criar(PilotoParticipandoCampeonato o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(PilotoParticipandoCampeonato o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(PilotoParticipandoCampeonato o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.alterar(o);
        }
        return false;
    }

    @Override
    public List<PilotoParticipandoCampeonato> listarPorItem(PilotoParticipandoCampeonato o) throws Exception {
        if (valida(o)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.listarTodos(o);
        }
        return null;
    }

    @Override
    public List<PilotoParticipandoCampeonato> listarTodos() throws Exception {
        pilotoDAO = new PilotoParticipandoCampeonatoDAO();
        return pilotoDAO.listarTodos();
    }

    @Override
    public PilotoParticipandoCampeonato getById(int id) throws Exception {
        if (validaId(id)) {
            pilotoDAO = new PilotoParticipandoCampeonatoDAO();
            return pilotoDAO.getById(id);
        }
        return null;
    }

    @Override
    public boolean valida(PilotoParticipandoCampeonato o) throws Exception {
        if (o.getPiloto().getIdPiloto() < 0) {
            throw new Exception("Piloto não localizado!");
        } else if (o.getCampeonato().getIdCampeonato() < 0) {
            throw new Exception("Campeonato não localizado!");
        } else {
            return true;
        }
    }

    @Override
    public boolean validaId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id nulo");
        } else {
            return true;
        }
    }

    public List<PilotoParticipandoCampeonato> listarTodosPilotosQuePilotoParticipaNoCampeonato(Piloto piloto) throws Exception {
        pilotoDAO = new PilotoParticipandoCampeonatoDAO();
        return pilotoDAO.listarPilotoQueParticipaDeCampeonato(piloto);
    }

    public List<PilotoParticipandoCampeonato> listarCampeonatosParticipaticipando(Piloto piloto, Campeonato campeonato) throws Exception {
        pilotoDAO = new PilotoParticipandoCampeonatoDAO();
        return pilotoDAO.Listarcampeonatosparticipaticipando(piloto, campeonato);
    }

    public List<PilotoParticipandoCampeonato> listarTodosPilotosQuePilotoParticipaNoCampeonato(Campeonato campeonato) throws Exception {
        pilotoDAO = new PilotoParticipandoCampeonatoDAO();
        return pilotoDAO.listarPilotoQueParticipaDeCampeonato(campeonato);
    }

}
