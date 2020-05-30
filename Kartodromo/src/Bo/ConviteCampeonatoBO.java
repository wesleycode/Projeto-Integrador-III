package Bo;

import Dao.ConviteCampeonatoDAO;
import Model.ConviteCampeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import java.util.List;

public class ConviteCampeonatoBO implements GenericBO<ConviteCampeonato>{
    
    private ConviteCampeonatoDAO conviteDAO;

    public ConviteCampeonatoBO() {

    }

    @Override
    public boolean criar(ConviteCampeonato o) throws Exception {
        if (valida(o)) {
            conviteDAO = new ConviteCampeonatoDAO();
            return conviteDAO.salvar(o);
        }
        return false;
    }

    @Override
    public boolean deletar(ConviteCampeonato o) throws Exception {
        if (valida(o)) {
            conviteDAO = new ConviteCampeonatoDAO();
            return conviteDAO.deletar(o);
        }
        return false;
    }

    @Override
    public boolean alterar(ConviteCampeonato o) throws Exception {
        if (valida(o)) {
            conviteDAO = new ConviteCampeonatoDAO();
            return conviteDAO.alterar(o);
        }
        return false;
    }

    @Override
    public List<ConviteCampeonato> listarPorItem(ConviteCampeonato o) throws Exception {
        if (valida(o)) {
            conviteDAO = new ConviteCampeonatoDAO();
            return conviteDAO.listarTodos(o);
        }
        return null;
    }

    @Override
    public List<ConviteCampeonato> listarTodos() throws Exception {
        conviteDAO = new ConviteCampeonatoDAO();
        return conviteDAO.listarTodos();
    }

    @Override
    public ConviteCampeonato getById(int id) throws Exception {
        if (validaId(id)) {
            conviteDAO = new ConviteCampeonatoDAO();
            return conviteDAO.getById(id);
        }
        return null;
    }

    @Override
    public boolean valida(ConviteCampeonato o) throws Exception {
        /* Fazer validações aqui */
        if (o.getPilotoConvidado().getIdPiloto() < 0) {
            throw new Exception("Piloto Convidado não localizado!");
        } else if (o.getPilotoQueConvidou().getIdPiloto() < 0) {
            throw new Exception("Piloto Que Convidou não localizado!"); 
        } else if (o.getCampeonato().getIdCampeonato() < 0) {
            throw new Exception("Campeonato não localizado!");
        }  else {
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
    
    public List<ConviteCampeonato> listarConvitesNaoVizualizadosPorPiloto(Piloto piloto) throws Exception{
            conviteDAO = new ConviteCampeonatoDAO();
            return conviteDAO.ListarConviteNaoVisualizadosPorPiloto(piloto);

    }
}