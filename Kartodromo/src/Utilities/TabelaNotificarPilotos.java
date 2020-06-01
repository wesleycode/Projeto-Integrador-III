package Utilities;

import Model.Corrida;
import Model.Piloto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TabelaNotificarPilotos extends AbstractTableModel {

    private List<Piloto> listPiloto;
    private String[] colunas = {"NOME DO PILOTO"};

    public TabelaNotificarPilotos() {
        listPiloto = new ArrayList<>();
    }

    public void addRow(Piloto c) {
        listPiloto.add(c);
        this.fireTableDataChanged();
    }

    public void removeRow(int x) {
        listPiloto.remove(x);
        this.fireTableRowsDeleted(x,x);
    }

    public List<Piloto> getListPiloto() {
        return listPiloto;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return listPiloto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 : return listPiloto.get(linha).getNomePiloto();
        }
        return null;
    }

}
