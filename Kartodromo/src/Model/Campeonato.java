package Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCampeonato;

    private String nome;
    private Timestamp dataCadastro;
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    private String tipoCorrida;
    private Date dataFinalizacao;
    private String tipoKart;

    @ManyToOne
    private Kartodromo kartodromo;

    public Kartodromo getKartodromo() {
        return kartodromo;
    }

    public void setKartodromo(Kartodromo kartodromo) {
        this.kartodromo = kartodromo;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public String getTipoCorrida() {
        return tipoCorrida;
    }

    public void setTipoCorrida(String tipoCorrida) {
        this.tipoCorrida = tipoCorrida;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public String getTipoKart() {
        return tipoKart;
    }

    public void setTipoKart(String tipoKart) {
        this.tipoKart = tipoKart;
    }
    
    public Campeonato(int idCampeonato, String nome, Timestamp dataCadastro, int totalCorridas, String situacao, String tipoCorrida, Date dataFinalizacao, String tipoKart, Kartodromo kartodromo) {
        this.idCampeonato = idCampeonato;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.situacao = situacao;
        this.tipoCorrida = tipoCorrida;
        this.dataFinalizacao = dataFinalizacao;
        this.tipoKart = tipoKart;
        this.kartodromo = kartodromo;
    }

    public Campeonato() {

    }

}
