package com.documents;

import com.documents.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class DocumentsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentsBackendApplication.class, args);

        Student student = new Student();
        student.setAddress("none");
        student.setId(1l);
        student.setBirthDate(new Date(1996, 10, 1));
        student.setCnp(22223l);
        student.setFatherInitial("V");
        student.setFirstName("Ion");
        student.setLastName("ion");
        student.setWebmail("ion@info.uaic.ro");
        student.setIdentityCardId("none");

        // Creating a new session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Opening a session.
        Session session = sessionFactory.openSession();

        // Beginning a transaction
        session.beginTransaction();

        // Saving the student created above
        session.save(student);

        // Comiting the current transation
        session.getTransaction().commit();

        session.close();
    }
}
