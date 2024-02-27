/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author c0345094
 */
class ContractController {
    
    private ContractView theView;
    private ContractModel theModel;
    
    ContractController(ContractView theView, ContractModel theModel) {
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
    }
    
    private void setUpDisplay() {
        
        try {
            theView.setContractID("???");
            theView.setDestCity("???");
            theView.setOriginCity("???");
            theView.setOrderItem("???");
        } catch (Error ex) {
            System.out.println("ex");
            theView.displayErrorMessage(
          "Error: There was a problem setting the contract.\n");
        }
    }
    
    class PrevButtonListener implements ActionListener {
        
        @Override
        public void actionPreformed(ActionEvent e) {
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
        public void actionPreformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == 0) {
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
        
    }
    
    
}
