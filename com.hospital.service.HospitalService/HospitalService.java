package com.hospital.service;

import java.io.*;
import com.hospital.patient.Patient;
import com.hospital.exception.*;

public class HospitalService {

    String file = "patients.txt";

    public void addPatient(Patient p) throws Exception
    {

        if(p.age < 0 || p.age > 120)
        {
            throw new InvalidAgeException("wrong age");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while(true)
        {
            line = br.readLine();

            if(line == null) break;

            String data[] = line.split(",");

            int id = Integer.parseInt(data[0]);

            if(id == p.patientId)
            {
                br.close();
                throw new DuplicatePatientException("patient already exists");
            }
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));

        bw.write(p.patientId + "," + p.patientName + "," + p.age + "," + p.disease);
        bw.newLine();

        bw.close();

        if(p.age > 60 && p.disease.equals("Heart Problem"))
        {
            System.out.println("Priority Patient – Immediate Attention Required");
        }

        System.out.println("Patient added");

    }



    public void displayPatients() throws Exception
    {

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while(true)
        {
            line = br.readLine();

            if(line == null) break;

            System.out.println(line);
        }

        br.close();

    }



    public void searchPatient(int id) throws Exception
    {

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while(true)
        {
            line = br.readLine();

            if(line == null)
            {
                br.close();
                throw new PatientNotFoundException("Patient not found");
            }

            String data[] = line.split(",");

            int pid = Integer.parseInt(data[0]);

            if(pid == id)
            {
                System.out.println("Patient Found");
                System.out.println(line);
                br.close();
                return;
            }

        }

    }

}