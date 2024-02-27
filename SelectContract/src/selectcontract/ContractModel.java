/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Matthew Golshani
 */
class ContractModel {
    
    private ArrayList<Contract> theContracts;
    private int contractCounter;
    
    ContractModel() {
        contractCounter = 0;
        theContracts = new ArrayList<>();
        String filename = "M:\\ICS2024\\ICS125\\SelectContract\\src\\selectcontract\\contracts.txt";
        
        
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            
            while((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",", 4);
                
                String contractID = tokens[0];
                String originCity = tokens[1];
                String destCity = tokens[2];
                String orderItem = tokens[3];
                
                Contract dataContract = new Contract(contractID
                                                   , originCity
                                                   , destCity
                                                   , orderItem);
                theContracts.add(dataContract);
            }
            fileReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
