/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Matthew Golshani
 */
class ContractModel {
    
    private ArrayList<Contract> theContracts;
    private ArrayList<Contract> theContractsAll;
    private int contractCounter;
    private SortedSet<String> originCityList;
    
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;
    
    public static final String ALL_COMBO_OPTION = "All";    
    public static final String FILE_PATH = "M:\\ICS2024\\ICS125\\SelectContract07\\src\\selectcontract07\\contracts.txt";

            
    
    ContractModel() {
        contractCounter = 0;
        theContracts = new ArrayList<>();   
        originCityList = new TreeSet<>();
        
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
                originCityList.add(originCity);
            }
            theContractsAll = theContracts;
            fileReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        originCityList.add(ALL_COMBO_OPTION);
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
    public String[] getOriginCityList() {
        String[] a;
        a = originCityList.toArray(new String[originCityList.size()]);
        return a;
    }
    public void updateContractList(String city) {
        theContracts = new ArrayList<>(theContractsAll);
        if (!"All".equals(city)) {
            theContracts.removeIf(s -> !s.contains(city));
        }
        contractCounter = 0;
    }
}