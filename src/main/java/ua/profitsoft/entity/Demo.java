package ua.profitsoft.entity;

import data.Client;
import data.InsuredPerson;
import dict.Type;
import service.Contract;
import service.ContractBuilder;
import service.Director;

import java.util.*;
import java.time.LocalDate;

/**
 * This class is used to show the initialization and filling the object Contract, with the display on the console
 * of the main attributes of contract and total insurance cost
 *
 * @author Daryna
 */
public class Demo {

    public static void main(String[] args){
       System.out.print("Contains in storage:");

        Client first = new Client(Type.LEGAL, "CyberLife", "Detroit", "Sumska","14-F", 1);
        ArrayList<InsuredPerson> firstList = new ArrayList<>();

        try {
            InsuredPerson a=new InsuredPerson(1, "Pavlik", "Viktor", "Nazarovich",
                    LocalDate.of(1995, 12, 1), 123.50);
            firstList.add(a);
            firstList.add(new InsuredPerson(2, "Chelentttano", "Adriana", "Petrovich",
                    LocalDate.of(1971, 7, 20), 1150));
            firstList.add(new InsuredPerson(3, "Chaplin", "Adriano", "Petrovich",
                    LocalDate.of(1971, 8, 20), 1150));
            firstList.add(new InsuredPerson(4, "Gosling", "Rayan", "Reinolds",
                    LocalDate.of(1971, 8, 20), 1150));
            firstList.add(new InsuredPerson(5, "Sanchez", "Rick", "Richard",
                    LocalDate.of(1974, 8, 20), 1150));
        }catch(NullPointerException n){
            n.printStackTrace();

        }

        Director director = new Director();
        ContractBuilder contractBuilder=new ContractBuilder();
        director.constructContract(contractBuilder);
        contractBuilder.setId(41);
        contractBuilder.setAcceptDate(LocalDate.of(2018, 9, 1));
        contractBuilder.setStartDate(LocalDate.of(2018, 10, 1));
        contractBuilder.setEndDate(LocalDate.of(2020, 10, 1));
        contractBuilder.setClient(first);
        contractBuilder.setPersons(firstList);


        Contract contractId41 = contractBuilder.getResult();
        System.out.print(contractId41.toString());
        System.out.println(contractId41.getTotalCost());

        Client second = new Client(Type.NATURAL, "Petrichenko", "Anthon", "Victorovich", "Kharkyv",
                "Klochkovskaya", "111-A", 2);
        ArrayList<InsuredPerson> secListInsuredPers = new ArrayList<>();
        secListInsuredPers.add(new InsuredPerson(1, "Ivashenko", "Inokentiy", "Nikolovich",
                LocalDate.of(1982, 10, 3), 220.55));
        secListInsuredPers.add(new InsuredPerson(2, "Danylchenko", "Dmythriy", "Horithonovich",
                LocalDate.of(1997, 12, 14), 49.99));
        secListInsuredPers.add(new InsuredPerson(3, "Prof","IT", "Soft ",
                LocalDate.of(2002, 8, 7), 0.0));



        contractBuilder.setId(48);
        contractBuilder.setAcceptDate(LocalDate.of(2015, 8, 17));
        contractBuilder.setStartDate(LocalDate.of(2002, 9, 17));
        contractBuilder.setEndDate(LocalDate.of(2019, 9, 17));
        contractBuilder.setClient(second);
        contractBuilder.setPersons(secListInsuredPers);

        Contract contractId42 = contractBuilder.getResult();
        System.out.print(contractId42.toString());
        System.out.println(contractId42.getTotalCost());

        contractId42.saveCSV();

            System.out.println(contractId42.uploadCSV().toString());

    }

}

