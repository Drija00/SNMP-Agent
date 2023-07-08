package com.snmp.simulator.form;

import com.snmp.simulator.component.DeviceRunner;
import com.snmp.simulator.domain.SnmpAgent;
import com.snmp.simulator.tablemodel.MyAgentModel;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component
//@DependsOn("DeviceRunner")
public class AgentForm extends javax.swing.JFrame {

    private List<SnmpAgent> agents = new ArrayList<>();

    /**
     * Creates new form SetForm
     */

    public AgentForm(List<SnmpAgent> agents) {
        initComponents();
        //this.agents = DeviceRunner.getAgents();
        this.agents = agents;
        prepareForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgent = new javax.swing.JTable();
        btnTrap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAgent.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(tblAgent);

        btnTrap.setText("Send trap");
        btnTrap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnTrap)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTrap)
                                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnTrap;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAgent;
    // End of variables declaration
    private void btnTrapActionPerformed(java.awt.event.ActionEvent evt) {
        int[] rows = tblAgent.getSelectedRows();
        for(int x: rows){
            agents.get(x).sendTrap();
        }
    }
    private void prepareForm() {
        tblAgent.setModel(new MyAgentModel(agents));
    }

    public List<SnmpAgent> getAgents() {
        return agents;
    }

    public void setAgents(List<SnmpAgent> agents) {
        this.agents = agents;
    }
}
