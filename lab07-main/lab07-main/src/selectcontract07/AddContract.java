/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package selectcontract07;

import java.awt.HeadlessException;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author c0345094
 */
public class AddContract extends javax.swing.JDialog {
    private ContractController controller;
    private ContractModel model;
    public static final String  FILE_PATH = "M:\\ICS2024\\ICS125\\lab07-main\\lab07-main\\src\\selectcontract07\\contracts.txt";
    public final String[] cityList = {
                                        "Select a City","Victoria", 
                                        "Vancouver", "Seattle", 
                                        "Nanaimo", "Prince George"};
    /**
     * Creates new form AddContract
     */
    public AddContract(JFrame f, boolean m, ContractModel model, ContractController controller) {
        super(f, m);
        initComponents();
        
        this.controller = controller;
        this.model = model;
        this.setOriginCityList(cityList);
        this.setDestinationCityList(cityList);        
        
    }
    
    void addcomboBoxListener(ItemListener listenForComboBox) {
        jComboBoxOriginCity.addItemListener(listenForComboBox);
        jComboBoxDestinationCity.addItemListener(listenForComboBox);
    }
    
    private void setOriginCityList(String[] cityList) {
        final DefaultComboBoxModel model = new DefaultComboBoxModel(cityList);
        this.jComboBoxOriginCity.setSelectedIndex(0);
        this.jComboBoxOriginCity.setModel(model);
    }
    
    private void setDestinationCityList(String[] cityList) {
        final DefaultComboBoxModel model = new DefaultComboBoxModel(cityList);
        this.jComboBoxDestinationCity.setSelectedIndex(0);
        this.jComboBoxDestinationCity.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabelContractID = new javax.swing.JLabel();
        jLabelOriginCity = new javax.swing.JLabel();
        jLabelDestinationCity = new javax.swing.JLabel();
        jLabelContents = new javax.swing.JLabel();
        jTextFieldContractID = new javax.swing.JTextField();
        jTextFieldContents = new javax.swing.JTextField();
        jComboBoxOriginCity = new javax.swing.JComboBox<>();
        jComboBoxDestinationCity = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add A New Contract");
        setBackground(new java.awt.Color(204, 255, 255));

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelContractID.setText("Contract ID:");

        jLabelOriginCity.setText("Origin City:");

        jLabelDestinationCity.setText("Destination City:");

        jLabelContents.setText("Contents:");

        jTextFieldContractID.setToolTipText("Must be a digit 1-9 followed by 3 letters");

        jTextFieldContents.setToolTipText("Must be letters and numbers or just letters, no commas");

        jComboBoxOriginCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxOriginCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOriginCityActionPerformed(evt);
            }
        });

        jComboBoxDestinationCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jButtonSave)
                .addGap(32, 32, 32)
                .addComponent(jButtonClear)
                .addGap(37, 37, 37)
                .addComponent(jButtonCancel)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelContractID)
                    .addComponent(jLabelOriginCity)
                    .addComponent(jLabelDestinationCity)
                    .addComponent(jLabelContents))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldContractID, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldContents, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxOriginCity, 0, 110, Short.MAX_VALUE)
                    .addComponent(jComboBoxDestinationCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContractID)
                    .addComponent(jTextFieldContractID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelContents)
                    .addComponent(jTextFieldContents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOriginCity)
                    .addComponent(jComboBoxOriginCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDestinationCity)
                    .addComponent(jComboBoxDestinationCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonCancel))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clearFields();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        saveContract();        
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jComboBoxOriginCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOriginCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOriginCityActionPerformed
    private boolean validContractID(String contractID) {
        return contractID.matches("^[1-9][a-zA-Z]{3}$");
    }
    private boolean validOrderItem(String contents) {
        return contents.matches("^(?!\\d+$)[^,\\s]+$");
    }
    
    public void saveContract() {
        String contractID = jTextFieldContractID.getText().trim().toUpperCase();
        String contents = jTextFieldContents.getText().trim();
        String originCity = (String) jComboBoxOriginCity.getSelectedItem();
        String destinationCity = (String) jComboBoxDestinationCity.getSelectedItem();
        
        try {
            if (!validContractID(contractID)) {
                JOptionPane.showMessageDialog(null, "Invalid Contract ID. Must be one digit followed by 3 letters.");
                return;
            }

            if (!validOrderItem(contents)) {
                JOptionPane.showMessageDialog(null, "Contents must contain at least on letter and NO commas.");
                return;
            }

            if (originCity.equals(destinationCity)) {
                JOptionPane.showMessageDialog(null, "Origin city and Destination city cannot be the same!");
                return;
            }
            
            if (model.contractIDFound(contractID)) {
                JOptionPane.showMessageDialog(null, "Contract with matching ID already exists!");
                return;
            }
            
            if (originCity.equals("Select a City") || destinationCity.equals("Select a City") || contractID.isEmpty() || contents.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled out.");
                return;
            }
        } catch (HeadlessException ex) {
            System.out.println(ex.getMessage());
        }
        
       
        try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(FILE_PATH, true))) { 
            writeFile.newLine();
            writeFile.write(contractID + "," + originCity + "," + destinationCity + "," + contents);   
            writeFile.close();            
            JOptionPane.showMessageDialog(null, "Contract successfully saved! Thank you!");           
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        model.refreshContract();
        controller.setUpDisplay();
        clearFields();
    }
    
    private void clearFields() {
        jTextFieldContractID.setText("");
        jTextFieldContents.setText(""); 
        jComboBoxOriginCity.setSelectedIndex(0);
        jComboBoxDestinationCity.setSelectedIndex(0);      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBoxDestinationCity;
    private javax.swing.JComboBox<String> jComboBoxOriginCity;
    private javax.swing.JLabel jLabelContents;
    private javax.swing.JLabel jLabelContractID;
    private javax.swing.JLabel jLabelDestinationCity;
    private javax.swing.JLabel jLabelOriginCity;
    private javax.swing.JTextField jTextFieldContents;
    private javax.swing.JTextField jTextFieldContractID;
    // End of variables declaration//GEN-END:variables
}