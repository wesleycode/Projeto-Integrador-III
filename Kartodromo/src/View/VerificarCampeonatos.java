package View;

import Bo.CampeonatoBO;
import Bo.ConviteCampeonatoBO;
import Bo.PilotoBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.ConviteCampeonato;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VerificarCampeonatos extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnDesinscrever;
    private JButton btnVoltar;
    private JButton btnConvidarPiloto;
    private JButton btnEnviarAviso;
    private JButton btnVerHistorico;
    private JButton btnIniciarCampeonato;
    private JLabel logo;
    private JLabel corridas_participandoinfoLabel;
    private JLabel corridas_participandoLabel;
    private JLabel se_e_piloto_admLabel;
    private JLabel convidar_pilotoLabel;
    private JComboBox<Object> comboBoxCampeonatosParticipando;
    private JComboBox<Object> convidarPilotoComboBox;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private JTable tableTodasAsCorridasMarcadas;
    private DefaultTableModel tabelamento;
    private JCheckBox tornarAdm;
    private InformacoesPiloto informacoesPiloto;

    private Piloto piloto;

    public VerificarCampeonatos(Piloto piloto) {

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

        fundo = new JPanel();
        drawer = new JPanel();
        btnDesinscrever = new JButton();
        btnVoltar = new JButton();
        btnConvidarPiloto = new JButton();
        btnEnviarAviso = new JButton();
        btnVerHistorico = new JButton();
        btnIniciarCampeonato = new JButton();
        logo = new JLabel();
        corridas_participandoinfoLabel = new JLabel();
        corridas_participandoLabel = new JLabel();
        se_e_piloto_admLabel = new JLabel();
        convidar_pilotoLabel = new JLabel();
        informacoesPiloto = new InformacoesPiloto();
        comboBoxCampeonatosParticipando = new JComboBox();
        convidarPilotoComboBox = new JComboBox();
        tornarAdm = new JCheckBox();
        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();

    }

    private void add() {

        add(tornarAdm);
        add(btnDesinscrever);
        add(btnVoltar);
        add(btnConvidarPiloto);
        add(informacoesPiloto);
        add(btnEnviarAviso);
        add(btnVerHistorico);
        add(btnIniciarCampeonato);
        add(logo);
        add(corridas_participandoinfoLabel);
        add(corridas_participandoLabel);
        add(se_e_piloto_admLabel);
        add(convidar_pilotoLabel);
        add(comboBoxCampeonatosParticipando);
        add(convidarPilotoComboBox);
        add(jScrollPaneCorridasMarcadas);
        add(drawer);
        add(fundo);

    }

    private void setTheme() {

        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            tornarAdm.setBackground(Colors.CINZAMEDB);
            tornarAdm.setForeground(Colors.CINZAMEDA);
            btnDesinscrever.setForeground(Colors.CINZADARKB);
            btnDesinscrever.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnConvidarPiloto.setForeground(Colors.CINZADARKB);
            btnConvidarPiloto.setBackground(Colors.VERDEDARK);
            btnEnviarAviso.setForeground(Colors.CINZADARKB);
            btnEnviarAviso.setBackground(Colors.VERDEDARK);
            btnVerHistorico.setForeground(Colors.CINZADARKB);
            btnVerHistorico.setBackground(Colors.VERDEDARK);
            btnIniciarCampeonato.setForeground(Colors.CINZADARKB);
            btnIniciarCampeonato.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            corridas_participandoinfoLabel.setForeground(Colors.CINZAMEDA);
            corridas_participandoLabel.setForeground(Colors.CINZAMEDA);
            se_e_piloto_admLabel.setForeground(Colors.CINZAMEDA);
            convidar_pilotoLabel.setForeground(Colors.CINZAMEDA);
            informacoesPiloto.setForeground(Colors.CINZAMEDB);
            comboBoxCampeonatosParticipando.setBackground(Colors.CINZALIGHTB);
            comboBoxCampeonatosParticipando.setForeground(Colors.BRANCO);
            convidarPilotoComboBox.setBackground(Colors.CINZALIGHTB);
            convidarPilotoComboBox.setForeground(Colors.BRANCO);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);

        } else {

            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            btnDesinscrever.setForeground(Colors.CINZADARKB);
            btnDesinscrever.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            informacoesPiloto.setForeground(Colors.BRANCO);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnConvidarPiloto.setForeground(Colors.CINZADARKB);
            btnConvidarPiloto.setBackground(Colors.VERDEDARK);
            btnEnviarAviso.setForeground(Colors.CINZADARKB);
            btnEnviarAviso.setBackground(Colors.VERDEDARK);
            btnVerHistorico.setForeground(Colors.CINZADARKB);
            btnVerHistorico.setBackground(Colors.VERDEDARK);
            btnIniciarCampeonato.setForeground(Colors.CINZADARKB);
            btnIniciarCampeonato.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            corridas_participandoinfoLabel.setForeground(Colors.CINZALIGHTB);
            corridas_participandoLabel.setForeground(Colors.CINZALIGHTB);
            se_e_piloto_admLabel.setForeground(Colors.CINZALIGHTB);
            convidar_pilotoLabel.setForeground(Colors.CINZALIGHTB);
            comboBoxCampeonatosParticipando.setForeground(Colors.CINZADARKA);
            comboBoxCampeonatosParticipando.setBackground(Colors.CINZALIGHTB);
            convidarPilotoComboBox.setForeground(Colors.CINZADARKA);
            convidarPilotoComboBox.setBackground(Colors.CINZALIGHTB);
            tornarAdm.setBackground(Colors.CINZALIGHTB);
            tornarAdm.setForeground(Colors.CINZADARKA);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDEDARK);
        }
    }

    private void limpaTabela() {
        tabelamento.setRowCount(0);
    }

    private void configs() {

        fundo.setSize(Info.MINSCREENSIZE);
        drawer.setBounds(0, 0, 800, 100);

        informacoesPiloto.setBounds(600, 3, 200, 100);
        informacoesPiloto.setPiloto(piloto);

        try {

            tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "CAMPEONATO", "DATA", "TOTAL DE PARTICIPANTES"
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

            PilotoParticipandoCampeonatoBO pilotoParticipandoCampeonatoBO = new PilotoParticipandoCampeonatoBO();

            try {
                List<PilotoParticipandoCampeonato> listaCampeonatoDoPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(piloto);
                if (listaCampeonatoDoPiloto.isEmpty()) {
                    tabelamento.addRow(new Object[]{
                            "Nem um campeonato na lista!"
                    });
                } else {
                    for (PilotoParticipandoCampeonato list : listaCampeonatoDoPiloto) {
                        comboBoxCampeonatosParticipando.addItem(list.getCampeonato().getNome());
                        List<PilotoParticipandoCampeonato> listaTotalPiloto = pilotoParticipandoCampeonatoBO.listarTodosPilotosQuePilotoParticipaNoCampeonato(list.getCampeonato());
                        tabelamento.addRow(new Object[]{
                                list.getCampeonato().getNome(),
                                Tempo.dateToPadraoBrasil(list.getCampeonato().getDataInicio()),
                                listaTotalPiloto.size()
                        });
                    }
                    mudarComboConvites();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(60, 150, 680, 200);

            btnDesinscrever.setBorderPainted(false);
            btnDesinscrever.setFocusPainted(false);
            btnDesinscrever.addActionListener(this);
            btnDesinscrever.setBounds(40, 500, 200, 35);
            btnDesinscrever.setText("Desinscrever");

            btnVoltar.setBorderPainted(false);
            btnVoltar.setFocusPainted(false);
            btnVoltar.addActionListener(this);
            btnVoltar.setBounds(40, 550, 200, 35);
            btnVoltar.setText("Voltar");

            btnVerHistorico.setBorderPainted(false);
            btnVerHistorico.setFocusPainted(false);
            btnVerHistorico.addActionListener(this);
            btnVerHistorico.setBounds(550, 550, 200, 35);
            btnVerHistorico.setText("Ver Histórico");

            btnEnviarAviso.setBorderPainted(false);
            btnEnviarAviso.setFocusPainted(false);
            btnEnviarAviso.addActionListener(this);
            btnEnviarAviso.setBounds(550, 500, 200, 35);
            btnEnviarAviso.setText("Enviar Aviso");

            tornarAdm.setBounds(340, 400, 140, 30);
            tornarAdm.setText("Ser Administrador");
            tornarAdm.setFocusPainted(false);
            tornarAdm.addActionListener(this);

            logo.setFont(Fonts.SANSSERIFMIN);
            logo.setBounds(20, 30, 500, 35);
            logo.setText("VERIFICAR CAMPEONATOS");

            corridas_participandoinfoLabel.setBounds(60, 120, 300, 30);
            corridas_participandoinfoLabel.setText("Corridas que você está participando:");

            corridas_participandoLabel.setBounds(60, 370, 300, 30);
            corridas_participandoLabel.setText("Campeonatos:");

            comboBoxCampeonatosParticipando.setBorder(BorderFactory.createEmptyBorder());
            comboBoxCampeonatosParticipando.setBounds(60, 400, 200, 35);

            convidarPilotoComboBox.setBorder(BorderFactory.createEmptyBorder());
            convidarPilotoComboBox.setBounds(540, 400, 200, 35);

            se_e_piloto_admLabel.setBounds(600, 120, 200, 30);
            se_e_piloto_admLabel.setText("Você é um piloto ADM");

            convidar_pilotoLabel.setBounds(540, 370, 200, 30);
            convidar_pilotoLabel.setText("Convidar Piloto:");

            btnConvidarPiloto.setBorderPainted(false);
            btnConvidarPiloto.setFocusPainted(false);
            btnConvidarPiloto.addActionListener(this);
            btnConvidarPiloto.setBounds(300, 550, 200, 35);
            btnConvidarPiloto.setText("Convidar Piloto");

            btnIniciarCampeonato.setBorderPainted(false);
            btnIniciarCampeonato.setFocusPainted(false);
            btnIniciarCampeonato.addActionListener(this);
            btnIniciarCampeonato.setBounds(300, 500, 200, 35);
            btnIniciarCampeonato.setText("Iniciar Campeonato");

            comboBoxCampeonatosParticipando.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        mudarComboConvites();
                    }
                }
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDesinscrever) {
            try {
                if (JOptionPane.showConfirmDialog(null,
                        "você tem certeza que deseja se desincrever?",
                        "Desincrever de Campeonato",
                        JOptionPane.YES_NO_OPTION) == 0) {

                    Campeonato campeonato = new CampeonatoBO().getByNome(comboBoxCampeonatosParticipando.getSelectedItem().toString());

                    for (PilotoParticipandoCampeonato pilotoqueparticipamcampeonatodesincrever : new PilotoParticipandoCampeonatoBO().Listar_o_piloto_do_campeonato(piloto, campeonato)) {
                        new PilotoParticipandoCampeonatoBO().deletar(pilotoqueparticipamcampeonatodesincrever);
                    }
                    comboBoxCampeonatosParticipando.removeItemAt(comboBoxCampeonatosParticipando.getSelectedIndex());
                }

                JOptionPane.showMessageDialog(null, "Desinscrição Realizada! você não participa mais dessa corrida!");

                dispose();
                new VerificarCampeonatos(piloto);

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Eita, não foi possível fazer a desinscrição!");
            }
        }

        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }

        if (e.getSource() == btnConvidarPiloto) {

            try {

                if (new CampeonatoBO().validaTelaVerificarCampeonatos(convidarPilotoComboBox.getSelectedItem().toString())) {
                    Piloto pilotoConvidado = new PilotoBO().listarPorApelido(convidarPilotoComboBox.getSelectedItem().toString());
                    ConviteCampeonato conviteCampeonato = new ConviteCampeonato();
                    conviteCampeonato.setCampeonato(new CampeonatoBO().getByNome(comboBoxCampeonatosParticipando.getSelectedItem().toString()));
                    conviteCampeonato.setPilotoQueConvidou(piloto);
                    conviteCampeonato.setPilotoConvidado(pilotoConvidado);
                    conviteCampeonato.setStatusConvite("Não respondido");

                    if (new ConviteCampeonatoBO().verificarConviteExistente(conviteCampeonato) == false) {
                        new ConviteCampeonatoBO().criar(conviteCampeonato);
                        convidarPilotoComboBox.removeItemAt(convidarPilotoComboBox.getSelectedIndex());
                    }

                    JOptionPane.showMessageDialog(null, "Convite enviado ao piloto: " + pilotoConvidado.getApelido());

                }

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, error.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            }

        }

        if (e.getSource() == btnEnviarAviso) {

            try {
                dispose();
                new EnviarAviso(piloto, new CampeonatoBO().getByNome(comboBoxCampeonatosParticipando.getSelectedItem().toString()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível entrar em enviar aviso");
            }

        }

        if (e.getSource() == btnVerHistorico) {
            dispose();
            new Historico(piloto);
        }

        if (e.getSource() == btnIniciarCampeonato) {
            if (!tableTodasAsCorridasMarcadas.getValueAt(0,0).equals("Nem um campeonato na lista!")) {
                try {
                    dispose();
                    new IniciarCampeonatoPt1(piloto);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma corrida!");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Nenhum campeonato está na lista, crie ou peça a um adminisitrador para criar um!");
            }
        }

        if (e.getSource() == tornarAdm) {
            try {
                if (tornarAdm.isSelected()) {
                    if (JOptionPane.showConfirmDialog(null,
                            "você tem certeza que deseja assumir a responsabilidade de ADM?",
                            "Termo de responsabilidade",
                            JOptionPane.YES_NO_OPTION) == 0) {
                        mudarStatusAdm();
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(null,

                            "você tem certeza que deseja remover seu ADM desse campeonato?",
                            "Remover status de ADM",
                            JOptionPane.YES_NO_OPTION) == 0) {
                        mudarStatusAdm();
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar status de ADM!");
            }
        }

    }

    private void mudarStatusAdm() throws Exception {
        Campeonato campeonato = new CampeonatoBO().getByNome(comboBoxCampeonatosParticipando.getSelectedItem().toString());

        List<PilotoParticipandoCampeonato> pilotoqueparticipamcampeonato = new PilotoParticipandoCampeonatoBO().Listar_o_piloto_do_campeonato(piloto, campeonato);

        PilotoParticipandoCampeonato pilotoatual = pilotoqueparticipamcampeonato.get(0);
        if (pilotoatual.isStatusAdm()) {
            pilotoatual.setStatusAdm(false);
        } else {
            pilotoatual.setStatusAdm(true);
        }

        new PilotoParticipandoCampeonatoBO().alterar(pilotoatual);

        verificarADM(campeonato);

        JOptionPane.showMessageDialog(null, "Status de ADM alterado!");
    }

    private void mudarComboConvites() {

        try {
            convidarPilotoComboBox.removeAllItems();
            Campeonato campeonato = new CampeonatoBO().getByNome(comboBoxCampeonatosParticipando.getSelectedItem().toString());
            for (Piloto pilotos : new PilotoBO().listarTodos()) {
                if (pilotos.getId() != piloto.getId()) {
                    //remove o proprio piloto
                    boolean pilotoparticipadocampeonato = false;
                    for (PilotoParticipandoCampeonato pilotoqueparticipamcampeonato : new PilotoParticipandoCampeonatoBO().listarTodosPilotosQuePilotoParticipaNoCampeonato(campeonato)) {
                        if (pilotoqueparticipamcampeonato.getPiloto().getId() == pilotos.getId()) {
                            pilotoparticipadocampeonato = true;
                            break;
                        }
                    }
                    ConviteCampeonato verificarsejafoiconvidado = new ConviteCampeonato();
                    verificarsejafoiconvidado.setCampeonato(campeonato);
                    verificarsejafoiconvidado.setPilotoConvidado(pilotos);
                    if (!pilotoparticipadocampeonato && !new ConviteCampeonatoBO().verificarConviteExistente(verificarsejafoiconvidado)) {
                        convidarPilotoComboBox.addItem(pilotos.getApelido());
                    } else {
                        convidarPilotoComboBox.removeAllItems();
                        convidarPilotoComboBox.addItem("Todos os pilotos responderam o convite");
                        break;
                    }
                }
            }

            verificarADM(campeonato);

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar os piloto para convidar");
        }

    }

    private void verificarADM(Campeonato campeonato) throws Exception {
        List<PilotoParticipandoCampeonato> lista = new PilotoParticipandoCampeonatoBO().Listar_o_piloto_do_campeonato(piloto, campeonato);
        PilotoParticipandoCampeonato pilotoparticipando = lista.get(0);
        if (pilotoparticipando.isStatusAdm()) {
            se_e_piloto_admLabel.setText("Você é um piloto ADM");
            convidar_pilotoLabel.setVisible(true);
            btnConvidarPiloto.setVisible(true);
            btnEnviarAviso.setVisible(true);
            btnIniciarCampeonato.setVisible(true);
            convidarPilotoComboBox.setVisible(true);
            tornarAdm.setSelected(true);
        } else {
            se_e_piloto_admLabel.setText("Você é não um piloto ADM");
            convidar_pilotoLabel.setVisible(false);
            btnConvidarPiloto.setVisible(false);
            btnEnviarAviso.setVisible(false);
            btnIniciarCampeonato.setVisible(false);
            convidarPilotoComboBox.setVisible(false);
            tornarAdm.setSelected(false);
        }
    }

}
