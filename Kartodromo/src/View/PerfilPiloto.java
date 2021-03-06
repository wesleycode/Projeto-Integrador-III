package View;

import Bo.AvisoCampeonatoBO;
import Bo.CampeonatoBO;
import Bo.ConviteCampeonatoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.AvisoCampeonato;
import Model.Campeonato;
import Model.ConviteCampeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PerfilPiloto extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnRelatar;
    private JButton btnVoltar;
    private JButton btnVerTodosConvitesEnviados;
    private JButton btnInformacoesCampeonatos;
    private JButton btnGerenciarCampeonatos;
    private JButton btnVerificarCorridas;
    private JButton btnAvaliarKartdromo;
    private JLabel perfilPilotoLabel;
    private JButton btnVerificarconvites_avisos;
    private JLabel CampeonatoParticipandoLabel;
    private JLabel corridasMarcadasLabel;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    private JScrollPane jScrollPaneCorridasParticipando;
    private JTable tableCorridasParticipando;
    private DefaultTableModel tabelamento;
    private JTableHeader headerTabelaCorridasParticipando;
    private JTableHeader headerTabelaTodasAsCorridasMarcadas;
    private InformacoesPiloto informacoesPiloto;
    private Piloto piloto;

    public PerfilPiloto(Piloto piloto) {

        this.piloto = piloto;

        // Instancia de itens //
        initializate();
        // Coloca o tema na tela
        setTheme();
        // Adiciona o item na tela //
        add();
        // Configura o item da tela (btn,label...) //
        configs();
        // Configura esse frame //
        configurateThis();

    }

    public PerfilPiloto() {

        // Instancia de itens //
        initializate();
        // Coloca o tema na tela
        setTheme();
        // Adiciona o item na tela //
        add();
        // Configura o item da tela (btn,label...) //
        configs();
        // Configura esse frame //
        configurateThis();

    }

    private void configurateThis() {

        setUndecorated(true);
        setSize(Info.MINSCREENSIZE);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(Info.APP_NAME);
        setResizable(false);

    }

    private void initializate() {
        btnVerTodosConvitesEnviados = new JButton();
        fundo = new JPanel();
        drawer = new JPanel();
        btnVerificarconvites_avisos = new JButton();
        informacoesPiloto = new InformacoesPiloto();
        btnRelatar = new JButton();
        btnVoltar = new JButton();
        btnInformacoesCampeonatos = new JButton();
        btnGerenciarCampeonatos = new JButton();
        btnVerificarCorridas = new JButton();
        btnAvaliarKartdromo = new JButton();
        CampeonatoParticipandoLabel = new JLabel();
        corridasMarcadasLabel = new JLabel();
        perfilPilotoLabel = new JLabel();
        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();
        jScrollPaneCorridasParticipando = new JScrollPane();
        tableCorridasParticipando = new JTable();
        headerTabelaCorridasParticipando = tableCorridasParticipando.getTableHeader();
        headerTabelaTodasAsCorridasMarcadas = tableTodasAsCorridasMarcadas.getTableHeader();

    }

    private void add() {

        add(btnVerTodosConvitesEnviados);
        add(btnRelatar);
        add(btnVoltar);
        add(btnVerificarconvites_avisos);
        add(btnInformacoesCampeonatos);
        add(btnGerenciarCampeonatos);
        add(btnVerificarCorridas);
        add(btnAvaliarKartdromo);
        add(perfilPilotoLabel);
        add(CampeonatoParticipandoLabel);
        add(corridasMarcadasLabel);
        add(informacoesPiloto);
        add(jScrollPaneCorridasMarcadas);
        add(jScrollPaneCorridasParticipando);
        add(drawer);
        add(fundo);

    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.BRANCO);
            CampeonatoParticipandoLabel.setForeground(Colors.BRANCO);
            corridasMarcadasLabel.setForeground(Colors.BRANCO);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVerTodosConvitesEnviados.setForeground(Colors.CINZAMEDA);
            btnVerTodosConvitesEnviados.setBackground(Colors.CINZAMEDB);
            btnVerificarconvites_avisos.setForeground(Colors.CINZADARKB);
            btnVerificarconvites_avisos.setBackground(Colors.VERDEDARK);
            btnInformacoesCampeonatos.setForeground(Colors.CINZADARKB);
            btnGerenciarCampeonatos.setForeground(Colors.CINZADARKB);
            btnVerificarCorridas.setForeground(Colors.CINZADARKB);
            btnAvaliarKartdromo.setForeground(Colors.CINZADARKB);
            btnRelatar.setForeground(Colors.CINZAMEDA);
            btnRelatar.setBackground(Colors.CINZAMEDB);
            btnInformacoesCampeonatos.setBackground(Colors.VERDEDARK);
            btnGerenciarCampeonatos.setBackground(Colors.VERDEDARK);
            btnVerificarCorridas.setBackground(Colors.VERDEDARK);
            btnAvaliarKartdromo.setBackground(Colors.VERDEDARK);
            headerTabelaCorridasParticipando.setBackground(Colors.CINZAMEDB);
            headerTabelaCorridasParticipando.setForeground(Colors.CINZAMEDA);
            headerTabelaTodasAsCorridasMarcadas.setBackground(Colors.CINZAMEDB);
            headerTabelaTodasAsCorridasMarcadas.setForeground(Colors.CINZAMEDA);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            btnVerTodosConvitesEnviados.setForeground(Colors.CINZAMEDA);
            btnVerTodosConvitesEnviados.setBackground(Colors.CINZAMEDB);
            CampeonatoParticipandoLabel.setForeground(Colors.CINZALIGHTB);
            corridasMarcadasLabel.setForeground(Colors.CINZALIGHTB);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            btnRelatar.setBackground(Colors.CINZAMEDA);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnVerificarconvites_avisos.setForeground(Colors.CINZADARKB);
            btnVerificarconvites_avisos.setBackground(Colors.VERDEDARK);
            btnInformacoesCampeonatos.setBackground(Colors.VERDEDARK);
            btnGerenciarCampeonatos.setBackground(Colors.VERDEDARK);
            btnVerificarCorridas.setBackground(Colors.VERDEDARK);
            btnAvaliarKartdromo.setBackground(Colors.VERDEDARK);
            btnRelatar.setForeground(Colors.CINZAMEDB);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnInformacoesCampeonatos.setForeground(Colors.CINZADARKB);
            btnGerenciarCampeonatos.setForeground(Colors.CINZADARKB);
            btnVerificarCorridas.setForeground(Colors.CINZADARKB);
            btnAvaliarKartdromo.setForeground(Colors.CINZADARKB);
            headerTabelaCorridasParticipando.setBackground(Colors.CINZAMEDA);
            headerTabelaCorridasParticipando.setForeground(Colors.CINZAMEDB);
            headerTabelaTodasAsCorridasMarcadas.setBackground(Colors.CINZAMEDA);
            headerTabelaTodasAsCorridasMarcadas.setForeground(Colors.CINZAMEDB);
        }
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        tableCorridasParticipando.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "CAMPEONATOS PARTICIPANDO", "DATA", "TOTAL DE PARTICIPANTES"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });

        tabelamento = (DefaultTableModel) tableCorridasParticipando.getModel();

        Tabelas.alinharCelulasNoCentro(tableCorridasParticipando);

        PilotoParticipandoCampeonatoBO pilotoParticipandoCampeonatoBO = new PilotoParticipandoCampeonatoBO();

        popularTabela1(pilotoParticipandoCampeonatoBO);

        jScrollPaneCorridasParticipando.setViewportView(tableCorridasParticipando);
        jScrollPaneCorridasParticipando.setBounds(20, 300, 760, 200);

        tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "CAMPEONATOS", "DATA", "N° DE PILOTOS "
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });

        tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();

        Tabelas.alinharCelulasNoCentro(tableTodasAsCorridasMarcadas);

        popularTabela2(pilotoParticipandoCampeonatoBO);

        jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
        jScrollPaneCorridasMarcadas.setBounds(200, 130, 580, 140);

        informacoesPiloto.setBounds(30, 150, 200, 90);
        informacoesPiloto.setPiloto(piloto);

        CampeonatoParticipandoLabel.setText("CAMPEONATOS QUE VOCÊ ESTÁ PARTICIPANDO");
        CampeonatoParticipandoLabel.setBounds(20, 270, 400, 35);

        corridasMarcadasLabel.setText("TODOS OS CAMPEONATOS CRIADOS");
        corridasMarcadasLabel.setBounds(200, 100, 400, 35);

        btnRelatar.setBorderPainted(false);
        btnRelatar.setFocusPainted(false);
        btnRelatar.addActionListener(this);
        btnRelatar.setBounds(570, 30, 220, 35);
        btnRelatar.setText("Relatar Problema");

        btnVerTodosConvitesEnviados.setBorderPainted(false);
        btnVerTodosConvitesEnviados.setFocusPainted(false);
        btnVerTodosConvitesEnviados.addActionListener(this);
        btnVerTodosConvitesEnviados.setBounds(320, 30, 220, 35);
        btnVerTodosConvitesEnviados.setText("Todos os convites enviados");

        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(20, 555, 150, 35);
        btnVoltar.setText("Voltar");

        btnVerificarconvites_avisos.setBorderPainted(false);
        btnVerificarconvites_avisos.setFocusPainted(false);
        btnVerificarconvites_avisos.addActionListener(this);
        btnVerificarconvites_avisos.setBounds(20, 510, 150, 35);
        btnVerificarconvites_avisos.setText("Avisos e Convites");

        btnInformacoesCampeonatos.setBorderPainted(false);
        btnInformacoesCampeonatos.setFocusPainted(false);
        btnInformacoesCampeonatos.addActionListener(this);
        btnInformacoesCampeonatos.setBounds(535, 555, 250, 35);
        btnInformacoesCampeonatos.setText("Informações de campeonatos");

        btnVerificarCorridas.setBorderPainted(false);
        btnVerificarCorridas.setFocusPainted(false);
        btnVerificarCorridas.addActionListener(this);
        btnVerificarCorridas.setBounds(315, 510, 200, 35);
        btnVerificarCorridas.setText("Verificar Seus Campeonatos");

        btnAvaliarKartdromo.setBorderPainted(false);
        btnAvaliarKartdromo.setFocusPainted(false);
        btnAvaliarKartdromo.addActionListener(this);
        btnAvaliarKartdromo.setBounds(315, 555, 200, 35);
        btnAvaliarKartdromo.setText("Avaliar Kartodromo");

        btnGerenciarCampeonatos.setBorderPainted(false);
        btnGerenciarCampeonatos.setFocusPainted(false);
        btnGerenciarCampeonatos.addActionListener(this);
        btnGerenciarCampeonatos.setBounds(535, 510, 250, 35);
        btnGerenciarCampeonatos.setText("Gerenciar Corridas e Campeonatos");

        perfilPilotoLabel.setBounds(20, 30, 500, 35);
        perfilPilotoLabel.setText("PERFIL DO PILOTO");
        perfilPilotoLabel.setFont(Fonts.SANSSERIFMIN);

    }

    private void popularTabela1(PilotoParticipandoCampeonatoBO pilotoParticipandoCampeonatoBO) {
        try {
            List<PilotoParticipandoCampeonato> listaCampeonatoDoPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(piloto);
            if (listaCampeonatoDoPiloto.isEmpty()) {
                tabelamento.addRow(new Object[]{
                        "Nem uma corrida na lista!"
                });
            } else {
                for (PilotoParticipandoCampeonato list : listaCampeonatoDoPiloto) {
                    List<PilotoParticipandoCampeonato> listaTotalPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(list.getCampeonato());
                    tabelamento.addRow(new Object[]{
                            list.getCampeonato().getNome(),
                            Tempo.dateToPadraoBrasil(list.getCampeonato().getDataInicio()),
                            listaTotalPiloto.size()
                    });
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void popularTabela2(PilotoParticipandoCampeonatoBO pilotoParticipandoCampeonatoBO) {
        try {
            List<Campeonato> listaCampeonatos = new CampeonatoBO().listarTodos();
            if (listaCampeonatos.isEmpty()) {
                tabelamento.addRow(new Object[]{
                        "Nem um campeonato na lista!"
                });
            } else {
                for (Campeonato campeonato : listaCampeonatos) {
                    List<PilotoParticipandoCampeonato> listaTotalPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato);
                    tabelamento.addRow(new Object[]{
                            campeonato.getNome(),
                            Tempo.dateToPadraoBrasil(campeonato.getDataInicio()),
                            listaTotalPiloto.size()
                    });

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVerTodosConvitesEnviados) {
            dispose();
            new ConvitesEnviados(piloto);
        }
        if (e.getSource() == btnVoltar) {
            setVisible(false);
            new MenuPrincipal(piloto, true);
        }
        if (e.getSource() == btnVerificarconvites_avisos) {
            verificarAvisos();
        }
        if (e.getSource() == btnRelatar) {
            dispose();
            new RelatarPorEmail(piloto);
        }
        if (e.getSource() == btnInformacoesCampeonatos) {
            dispose();
            new InformacoesCampeonato(piloto);
        }
        if (e.getSource() == btnGerenciarCampeonatos) {
            dispose();
            new GerenciarCampeonato(piloto);
        }
        if (e.getSource() == btnVerificarCorridas) {
            dispose();
            new VerificarCampeonatos(piloto);
        }
        if (e.getSource() == btnAvaliarKartdromo) {
            dispose();
            new AvaliarKartodromo(piloto);
        }
    }

    private void verificarAvisos() {
        try {
            boolean avisoDeNenhumConvite = true;
            for (AvisoCampeonato aviso : new AvisoCampeonatoBO().listarAvisoNaoVizualizados(piloto)) {
                JOptionPane.showMessageDialog(null, "<html>AVISO SOBRE O CAMPEONATO: " + aviso.getCampeonato().getNome()
                        + "<br>DO PILOTO: " + aviso.getPilotoqueenviou().getApelido()
                        + "<br>MENSAGEM: " + aviso.getAviso() + " </html>");
                aviso.setStatusAviso("Vizualizado");
                new AvisoCampeonatoBO().alterar(aviso);
                avisoDeNenhumConvite = false;
            }
            for (ConviteCampeonato convite : new ConviteCampeonatoBO().listarConvitesNaoVizualizadosPorPiloto(piloto)) {

                if (new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(convite.getCampeonato()).size() < Info.MAX_PILOTOS_CAMPEONATO) {
                    int valor = JOptionPane.showConfirmDialog(null,
                            "<html>Você foi convidado por " + convite.getPilotoQueConvidou().getApelido()
                                    + "<br>Dono do email: " + convite.getPilotoQueConvidou().getEmail()
                                    + "<br>Para participar do campeonato: " + convite.getCampeonato().getNome()
                                    + "<br>Na Data " + Tempo.dateToPadraoBrasil(convite.getCampeonato().getDataInicio())
                                    + "<br>Deseja Participar?"
                                    + "<html>",
                            "Convite para Campeonato!",
                            JOptionPane.YES_NO_OPTION);
                    if (valor == 0) {
                        PilotoParticipandoCampeonato pilotoaceitouconvite = new PilotoParticipandoCampeonato();
                        pilotoaceitouconvite.setCampeonato(convite.getCampeonato());
                        pilotoaceitouconvite.setPiloto(piloto);
                        pilotoaceitouconvite.setPontuacao(0);
                        pilotoaceitouconvite.setStatusAdm(false);
                        pilotoaceitouconvite.setPosicao(0);
                        new PilotoParticipandoCampeonatoBO().criar(pilotoaceitouconvite);
                        convite.setStatusConvite("Aceito");
                    } else if (valor == 1) {
                        convite.setStatusConvite("Negado");
                    } else {
                        convite.setStatusConvite("Visualizado");
                    }
                    new ConviteCampeonatoBO().alterar(convite);
                    avisoDeNenhumConvite = false;
                }
            }
            if (avisoDeNenhumConvite) {
                JOptionPane.showMessageDialog(null, "Nenhum aviso ou convite no momento!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage() + ", Não foi possível Fazer a verificação");
        }
    }

} 

