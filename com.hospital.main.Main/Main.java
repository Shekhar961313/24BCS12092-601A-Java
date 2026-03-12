package com.hospital.main;

import java.util.Scanner;
import com.hospital.patient.Patient;
import com.hospital.service.HospitalService;

public class Main {

    public static void main(String args[])
    {

        Scanner sc = new  Scanner(System.in);

        HospitalService hs = new HospitalService();

        try{

            System.out.println("enter the id of the patient");

            int id = sc.nextInt();
            sc.nextLine();


            System.out.println("enter the name of the patient");
            String name = sc.nextLine();

            

            System.out.println("enter the age of the patient");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("enter the diesease");
            String dis = sc.nextLine();

            Patient p = new Patient(id,name,age,dis);

            hs.addPatient(p);

            System.out.println();

            hs.displayPatients();

            System.out.println(); 

            System.out.println("Enter id to search");

            int sid = sc.nextInt();

            hs.searchPatient(sid);

        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
        }

    }

}