package com.donnu.oop_laba_4;

import com.donnu.oop_laba_4.Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class OopLaba4Application {

    public static void main(String[] args) {
        SpringApplication.run(OopLaba4Application.class, args);
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pet.class)
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(History.class)
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            Owner owner1 = new Owner("Крыжевич Артём Александрович", "0711234567", "Донецк, улица Островского 58");
            Owner owner2 = new Owner("Иванов Иван Иванович", "0717654321", "Донецк, улица Петровского 58");
            Pet pet1 = new Pet("Персик", 2, "Женский", "Кошка");
            Pet pet2 = new Pet("Мона", 6, "Женский", "Кошка");
            Doctor doctor1 = new Doctor("Петров Сергей Андреевич", "Ветеринар", 10);
            Doctor doctor2 = new Doctor("Петрова Маргарита Васильевна", "Мед.сестра", 8);
            History history1 = new History(new Date(), "Лишай", 1000, "Мазь антибактериальная");
            History history2 = new History(new Date(), "Микоз", 1000, "Антибиотики");
            owner1.setPets(pet1);
            owner2.setPets(pet2);
            history1.setDoctor(doctor1);
            history2.setDoctor(doctor2);
            history1.setPet(pet1);
            history2.setPet(pet2);

            session.beginTransaction();

            session.save(owner1);
            session.save(owner2);
            session.save(pet1);
            session.save(pet2);
            session.save(history1);
            session.save(history2);

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\n\n\n------------------------------------------------");
            System.out.println("--- Получение животного по ID = 1 ---");
            Pet db_pet1 = session.get(Pet.class, 1);
            System.out.println(db_pet1.toString());
            System.out.println("------------------------------------------------");

            System.out.println("--- Получение животного по ID = 2 ---");
            Pet db_pet2 = session.get(Pet.class, 2);
            System.out.println(db_pet2.toString());
            System.out.println("------------------------------------------------");

            System.out.println("--- Получение доктора по ID = 1 ---");
            Doctor db_doctor1 = session.get(Doctor.class, 1);
            System.out.println(db_doctor1.toString());
            System.out.println("------------------------------------------------");

            System.out.println("--- Получение владельца по ID = 1 ---");
            Owner db_owner1 = session.get(Owner.class, 1);
            System.out.println(db_owner1.toString());
            System.out.println("------------------------------------------------");

            System.out.println("--- Получение владельца по ID = 2 ---");
            Owner db_owner2 = session.get(Owner.class, 2);
            System.out.println(db_owner2.toString());
            System.out.println("------------------------------------------------");

            System.out.println("--- Получение истории болезни по ID = 1 ---");
            History db_history1 = session.get(History.class, 1);
            System.out.println(db_history1.toString());
            System.out.println("------------------------------------------------");

            System.out.println("--- Получение истории болезни по ID = 2 ---");
            History db_history2 = session.get(History.class, 2);
            System.out.println(db_history2.toString());
            System.out.println("------------------------------------------------");

            System.out.println("--- Получение доктора по ID = 2 ---");
            Doctor doctor_eager = session.get(Doctor.class, 2);
            System.out.println("------------------------------------------------");

            System.out.println("--- Показать доктора ---");
            System.out.println(doctor_eager);
            System.out.println("------------------------------------------------");

            System.out.println("--- Показать истории болезни животных выписанных доктором ---");
            System.out.println(doctor_eager.getHistory());
            System.out.println("------------------------------------------------");

            session.getTransaction().commit();
        }
        catch(Exception e){
            if(session !=null){
                session.close();
            }
            factory.close();
        }
    }

}
