package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPiloto;
    private String nomePiloto;
    private String apelido;
    private String senhaPiloto;
    private String cpfPiloto;
    private String emailPiloto;
    private int numeroDeStrikesPiloto;
    private int nivel;
    private int pontuacao_nivel;
    private Date dataNascimentoPiloto;
    private boolean ativo;

    public void setPontuacao_nivel(int pontuacao_nivel) {
        this.pontuacao_nivel = pontuacao_nivel;
    }

    public int getPontuacao_nivel() {
        return pontuacao_nivel;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) { this.idPiloto = idPiloto; }

    public String getNomePiloto() { return nomePiloto; }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenhaPiloto() {
        return senhaPiloto;
    }

    public void setSenhaPiloto(String senhaPiloto) { this.senhaPiloto = senhaPiloto; }

    public String getCpfPiloto() {
        return cpfPiloto;
    }

    public void setCpfPiloto(String cpfPiloto) {
        this.cpfPiloto = cpfPiloto;
    }

    public String getEmailPiloto() {
        return emailPiloto;
    }

    public void setEmailPiloto(String emailPiloto) {
        this.emailPiloto = emailPiloto;
    }

    public int getNumeroDeStrikesPiloto() {
        return numeroDeStrikesPiloto;
    }

    public void setNumeroDeStrikesPiloto(int numeroDeStrikesPiloto) {
        this.numeroDeStrikesPiloto = numeroDeStrikesPiloto;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Date getDataNascimentoPiloto() {
        return dataNascimentoPiloto;
    }

    public void setDataNascimentoPiloto(Date dataNascimentoPiloto) {
        this.dataNascimentoPiloto = dataNascimentoPiloto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Piloto(int idPiloto, String nomePiloto, String apelido, String senhaPiloto, String cpfPiloto, String emailPiloto, int numeroDeStrikesPiloto, int numeroDeVitoriasPiloto, Date dataNascimentoPiloto, boolean ativo) {
        this.idPiloto = idPiloto;
        this.nomePiloto = nomePiloto;
        this.apelido = apelido;
        this.senhaPiloto = senhaPiloto;
        this.cpfPiloto = cpfPiloto;
        this.emailPiloto = emailPiloto;
        this.numeroDeStrikesPiloto = numeroDeStrikesPiloto;
        this.nivel = numeroDeVitoriasPiloto;
        this.dataNascimentoPiloto = dataNascimentoPiloto;
        this.ativo = ativo;
    }

    public Piloto() {

    }

    @Override
    public String toString() {
        return "Piloto{" +
                "idPiloto=" + idPiloto +
                ", nomePiloto='" + nomePiloto + '\'' +
                ", apelido='" + apelido + '\'' +
                ", senhaPiloto='" + senhaPiloto + '\'' +
                ", cpfPiloto='" + cpfPiloto + '\'' +
                ", emailPiloto='" + emailPiloto + '\'' +
                ", numeroDeStrikesPiloto=" + numeroDeStrikesPiloto +
                ", nivel=" + nivel +
                ", pontuacao_nivel=" + pontuacao_nivel +
                ", dataNascimentoPiloto=" + dataNascimentoPiloto +
                ", ativo=" + ativo +
                '}';
    }
}
