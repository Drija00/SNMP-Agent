package com.snmp.simulator.tablemodel;

import com.snmp.simulator.domain.SnmpAgent;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class MyAgentModel extends AbstractTableModel {
    List<SnmpAgent> agents;
    String[] columnNames = {"id","ip adress"};

    public MyAgentModel() {
        agents = new ArrayList<>();
    }

    public MyAgentModel(List<SnmpAgent> agents) {
        this.agents = agents;
    }

    @Override
    public int getRowCount() {
        return agents.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SnmpAgent agent = agents.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return agent.getAgentId();
            case 1:
                return agent.getAddress();
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return  false;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
