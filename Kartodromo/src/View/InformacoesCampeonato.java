package View;

import Bo.CampeonatoBO;
import Bo.CorridaBO;
import Bo.PilotoParticipandoCampeonatoBO;
import Model.Campeonato;
import Model.Corrida;
import Model.Piloto;
import Model.PilotoParticipandoCampeonato;
import Utilities.*;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class InformacoesCampeonato extends JFrame implements ActionListener {

    private JPanel fundo;
    private JPanel drawer;
    private JButton btnVoltar;
    private JButton btnOrdenarNome;
    private JButton btnOrdenarData;
    private JButton btnInfos;
    private JLabel logo;
    private JLabel ordenarporLabel;
    private JLabel corridaLabel;
    private JComboBox<String> CorridasjComboBox;
    private JScrollPane jScrollPaneCorridasMarcadas;
    private InformacoesPiloto informacoesPiloto;
    private JTable tableTodasAsCorridasMarcadas;
    private DefaultTableModel tabelamento;
    private JPanel painelOrdenar;

    private Piloto piloto;

    public InformacoesCampeonato(Piloto piloto) {

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
        btnVoltar = new JButton();
        btnInfos = new JButton();
        informacoesPiloto = new InformacoesPiloto();
        btnOrdenarNome = new JButton();
        btnOrdenarData = new JButton();
        logo = new JLabel();
        ordenarporLabel = new JLabel();
        corridaLabel = new JLabel();
        jScrollPaneCorridasMarcadas = new JScrollPane();
        tableTodasAsCorridasMarcadas = new JTable();
        CorridasjComboBox = new JComboBox<>();
        painelOrdenar = new JPanel();
    }

    private void add() {
        add(btnVoltar);
        add(logo);
        add(ordenarporLabel);
        add(corridaLabel);
        add(btnInfos);
        add(CorridasjComboBox);
        add(informacoesPiloto);
        add(jScrollPaneCorridasMarcadas);
        add(painelOrdenar);
        add(drawer);
        add(fundo);
    }

    private void setTheme() {
        if (SplashScreen.getConfiguracao().isTema()) {
            // Se o tema for escuro, os itens ficam assim //
            fundo.setBackground(Colors.CINZAMEDB);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            ordenarporLabel.setForeground(Colors.CINZAMEDA);
            corridaLabel.setForeground(Colors.CINZAMEDA);
            btnVoltar.setForeground(Colors.CINZADARKB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnInfos.setForeground(Colors.CINZADARKB);
            btnInfos.setBackground(Colors.VERDEDARK);
            informacoesPiloto.setForeground(Colors.CINZALIGHTB);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            btnOrdenarNome.setBackground(Colors.VERDEDARK);
            btnOrdenarNome.setForeground(Colors.CINZADARKB);
            btnOrdenarData.setBackground(Colors.VERDEDARK);
            btnOrdenarData.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDELIGHT);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
        } else {
            fundo.setBackground(Colors.CINZAMEDA);
            drawer.setBackground(Colors.VERDEDARK);
            logo.setForeground(Colors.CINZAMEDB);
            ordenarporLabel.setForeground(Colors.CINZALIGHTB);
            corridaLabel.setForeground(Colors.CINZALIGHTB);
            btnVoltar.setBackground(Colors.VERDEDARK);
            btnInfos.setForeground(Colors.CINZADARKB);
            informacoesPiloto.setForeground(Colors.BRANCO);
            btnInfos.setBackground(Colors.VERDEDARK);
            btnVoltar.setForeground(Colors.CINZADARKB);
            CorridasjComboBox.setForeground(Colors.CINZADARKB);
            CorridasjComboBox.setBackground(Colors.VERDEDARK);
            btnOrdenarNome.setForeground(Colors.CINZADARKB);
            btnOrdenarNome.setBackground(Colors.VERDEDARK);
            btnOrdenarData.setForeground(Colors.CINZADARKB);
            btnOrdenarData.setBackground(Colors.VERDEDARK);
            tableTodasAsCorridasMarcadas.setForeground(Colors.CINZADARKB);
            tableTodasAsCorridasMarcadas.setBackground(Colors.VERDELIGHT);
        }
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
                            "CAMPEONATO", "DATA", "TIPO"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                        false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }

            });

            tableTodasAsCorridasMarcadas.getColumnModel().getColumn(0).setPreferredWidth(260);
            tableTodasAsCorridasMarcadas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableTodasAsCorridasMarcadas.getColumnModel().getColumn(2).setPreferredWidth(300);
            
            tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();

            PilotoParticipandoCampeonatoBO pilotoParticipandoCampeonatoBo = new PilotoParticipandoCampeonatoBO();
            for (Campeonato campeonato : new CampeonatoBO().listarTodos()) {
                if (!pilotoParticipandoCampeonatoBo.Listar_o_piloto_do_campeonato(piloto, campeonato).isEmpty()) {

                        CorridasjComboBox.addItem(campeonato.getNome());
                        tabelamento.addRow(new Object[]{
                                campeonato.getNome(),
                                Tempo.dateToPadraoBrasil(campeonato.getDataInicio()),
                                campeonato.getTipoCorrida()
                        });

                }
            }

            jScrollPaneCorridasMarcadas.setViewportView(tableTodasAsCorridasMarcadas);
            jScrollPaneCorridasMarcadas.setBounds(60, 150, 680, 220);
            CorridasjComboBox.setBorder(BorderFactory.createEmptyBorder());
            CorridasjComboBox.setBounds(60, 480, 300, 35);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        painelOrdenar.setLayout(new GridLayout());
        painelOrdenar.setBounds(60, 400, 300, 40);
        painelOrdenar.add(this.btnOrdenarNome);
        painelOrdenar.add(this.btnOrdenarData);
        btnOrdenarNome.setText("NOME");
        btnOrdenarNome.addActionListener(this);
        btnOrdenarData.setText("DATA");
        btnOrdenarData.addActionListener(this);

        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(this);
        btnVoltar.setBounds(60, 550, 100, 35);
        btnVoltar.setText("Voltar");
        
        btnInfos.setBorderPainted(false);
        btnInfos.setFocusPainted(false);
        btnInfos.addActionListener(this);
        btnInfos.setBounds(520, 400, 230, 35);
        btnInfos.setText("Ver informações do campeonato");

        logo.setBounds(20, 30, 760, 35);
        logo.setText("INFORMAÇÕES DO CAMPEONATO");
        logo.setFont(Fonts.SANSSERIFMIN);

        // Mudar para valores reais aqui //

        ordenarporLabel.setBounds(60, 370, 200, 30);
        ordenarporLabel.setText("ORDENAR TABELA POR:");

        corridaLabel.setBounds(60, 450, 200, 35);
        corridaLabel.setText("ESCOLHER UM CAMPEONATO:");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            dispose();
            new PerfilPiloto(piloto);
        }
        if (e.getSource() == btnInfos) {
            try {
                Campeonato campeonato = new CampeonatoBO().getByNome(CorridasjComboBox.getSelectedItem().toString());
                dispose();
                new InfosGeraisCorridas(piloto,campeonato);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível verificar informações de campeonato");
            }
        
        }
        
        if (e.getSource() == btnOrdenarNome) {
            PilotoParticipandoCampeonatoBO pilotoparticipandocampeonatobo = new PilotoParticipandoCampeonatoBO();
            try {
                tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "CAMPEONATO", "DATA", "TIPO"
                    }
                ) {
                    boolean[] canEdit = new boolean[]{
                            false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }

                });
                tableTodasAsCorridasMarcadas.getColumnModel().getColumn(0).setPreferredWidth(260);
                tableTodasAsCorridasMarcadas.getColumnModel().getColumn(1).setPreferredWidth(100);
                tableTodasAsCorridasMarcadas.getColumnModel().getColumn(2).setPreferredWidth(300);
            

                tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();

                Tabelas.alinharCelulasNoCentro(tableTodasAsCorridasMarcadas);

                for (Campeonato campeonato : new CampeonatoBO().listarPorNome()) {
                    List<PilotoParticipandoCampeonato> campeonatos = pilotoparticipandocampeonatobo.Listar_o_piloto_do_campeonato(piloto, campeonato);
                    if (!campeonatos.isEmpty()) {                   
                            tabelamento.addRow(new Object[]{
                                    campeonato.getNome(),
                                    campeonato.getDataInicio(),
                                    campeonato.getTipoCorrida()
                            });
                        
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        if (e.getSource() == btnOrdenarData) {

            PilotoParticipandoCampeonatoBO pilotoparticipandocampeonatobo = new PilotoParticipandoCampeonatoBO();

            try {
                tableTodasAsCorridasMarcadas.setModel(new DefaultTableModel(
                    new Object[][]{

                    },
                    new String[]{
                            "CAMPEONATO", "DATA", "TIPO"
                    }
                ) {
                    boolean[] canEdit = new boolean[]{
                            false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }

                });
                tableTodasAsCorridasMarcadas.getColumnModel().getColumn(0).setPreferredWidth(260);
                tableTodasAsCorridasMarcadas.getColumnModel().getColumn(1).setPreferredWidth(100);
                tableTodasAsCorridasMarcadas.getColumnModel().getColumn(2).setPreferredWidth(300);
            

                tabelamento = (DefaultTableModel) tableTodasAsCorridasMarcadas.getModel();


                for (Campeonato campeonato : new CampeonatoBO().listarPorData()) {
                    List<PilotoParticipandoCampeonato> campeonatos = pilotoparticipandocampeonatobo.Listar_o_piloto_do_campeonato(piloto, campeonato);
                    if (!campeonatos.isEmpty()) {                   
                            tabelamento.addRow(new Object[]{
                                    campeonato.getNome(),
                                    campeonato.getDataInicio(),
                                    campeonato.getTipoCorrida()
                            });
                        
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

} 
