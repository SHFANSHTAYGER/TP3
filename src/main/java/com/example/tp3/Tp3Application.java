package com.example.tp3;

import com.example.tp3.entities.Patient;
import com.example.tp3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class Tp3Application implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // Create Patient using no args constructor
        Patient patient = new Patient();
        patient.setId(null);
        patient.setSick(true);
        patient.setName("Wadii");
        patient.setBirthDate(new Date(2022, Calendar.NOVEMBER, 14));
        patient.setScore(123);

        // Create patient using all args constructor
        Patient patient1 = new Patient(null, "Yassine", new Date(122, Calendar.DECEMBER, 12), false, 22);

        // Create patient using the builder
        Patient patient2 = Patient.builder()
                .name("Salwa")
                .birthDate(new Date(2020, Calendar.APRIL, 28))
                .score(230)
                .sick(true)
                .build();

        // Add Patients to patientRepository
        patientRepository.save(patient);
        patientRepository.save(patient1);
        patientRepository.save(patient2);


    }
}