/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author c0345094
 */
class ContractController {
    
    private ContractView theView;
    private ContractModel theModel;
    
    private static final String DEFAULT_CONTRACT_ID = "???";
    private static final String DEFAULT_DEST_CITY = "???";
    private static final String DEFAULT_ORIGIN_CITY = "???";
    private static final String DEFAULT_ORDER_ITEM = "???";
    
    ContractController(ContractView theView, ContractModel theModel) {
        this.theView = theView;
        this.theModel = theModel;        
        
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
        this.theView.addcomboBoxListener(new ComboListener());
        this.theView.setOriginCityList(theModel.getOriginCityList());
        this.theView.addContractListener(new AddContractListener());
        
        setUpDisplay();
    }
    
    private void setUpDisplay() {
        
        try {
            if (theModel.foundContract()) {
                Contract c = theModel.getTheContract();
                theView.setContractID(c.getContractID());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
                theView.updateContractViewPanel(theModel.getCurrentContractNum(), theModel.getContractCount());
            } else {
                theView.setContractID(DEFAULT_CONTRACT_ID);
                theView.setDestCity(DEFAULT_DEST_CITY);
                theView.setOriginCity(DEFAULT_ORIGIN_CITY);
                theView.setOrderItem(DEFAULT_ORDER_ITEM);
            }
            
            theView.setPrevButtonEnabled(theModel.getCurrentContractNum() > 0);
            theView.setNextButtonEnabled(theModel.getCurrentContractNum() < theModel.getContractCount() - 1);
            
        } catch (Error ex) {
            System.out.println("ex");
            theView.displayErrorMessage(
            """
            Error: There was a problem setting the contract.
            Contract Number """ + theModel.getCurrentContractNum());
        }
    }
    
    class PrevButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == 0) {
                return;
            }            
            try {
                theModel.prevContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage(
                        "Error: There is a problem setting a previous contract.");
            }            
            setUpDisplay();
        }
    }
    
    class NextButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == theModel.getContractCount() - 1) {
                return;
            }      
            try {
                theModel.nextContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage(
                        "Error: There is a problem setting the next contract.");
            }            
            setUpDisplay();
        }
    }
    
    class BidButtonListener implements ActionListener {
            
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ConfirmBid cb;
                cb = new ConfirmBid(theView, true, theModel.getTheContract());
                cb.setLocationRelativeTo(null);
                cb.setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage(
                        "Error: the numbers entered must be integers.");
            }
        }   
    }
    
    class ComboListener implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println(e.getItem().toString());
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedCity = e.getItem().toString();
                System.out.println(selectedCity);
                theModel.updateContractList(selectedCity);
                setUpDisplay();
            }
        }
    }
    
    class AddContractListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AddContract ac;
                ac = new AddContract(theView, true);
                ac.setLocationRelativeTo(null);
                ac.setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: failed to display");
            }
        }
    }
}