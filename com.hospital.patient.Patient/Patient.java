package com.hospital.patient;

public class Patient {

    public int patientId;
    public String patientName;
    public int age;
    public String disease;

    public Patient(int id,String name,int a,String d)
    {
        patientId = id;
        patientName = name;
        age = a;
        disease = d;
    }

    public void displayPatient()
    {
        System.out.println("Id : "+patientId);
        System.out.println("Name : "+patientName);
        System.out.println("Age : "+age);
        System.out.println("Disease : "+disease);
        System.out.println();
    }

}