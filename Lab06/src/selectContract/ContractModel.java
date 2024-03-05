/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectContract;

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
    
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;
    
    public static final String FILE_PATH = "M:\\ICS2024\\ICS125\\SelectContract\\src\\selectcontract\\contracts.txt";

            
    
    ContractModel() {
        contractCounter = 0;
        theContracts = new ArrayList<>();        
        
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            
            while((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",", NUMBER_OF_CONTRACT_ATTRIBUTES);
                
                String contractID = tokens[INDEX_OF_CONTRACT_ID];
                String originCity = tokens[INDEX_OF_ORIGIN_CITY];
                String destCity = tokens[INDEX_OF_DEST_CITY];
                String orderItem = tokens[INDEX_OF_ORDER_ITEM];
                
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
    
    boolean foundContract() {
        return !theContracts.isEmpty();
    }
    public Contract getTheContract() {
        return theContracts.get(contractCounter);
    }
    public int getContractCount() {
        return theContracts.size();
    }
    public int getCurrentContractNum() {
        return contractCounter;
    }
    public void nextContract() {
        if (contractCounter < theContracts.size() -1) {
            contractCounter++;
        }
    }
    public void prevContract() {
        if (contractCounter > 0) {
            contractCounter--;
        }
    }
}