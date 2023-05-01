import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;

public class AppInitializer {

    public static void main(String[] args) {
//        Address address1 = new Address("SriLanka", "Kurunrgala", 60347);
//        Address address2 = new Address("USA", "DA1", 6045);
//        Address address3 = new Address("UK", "OA1", 345);
//        Student student1 = new Student();
//
//        student1.setName("Nimal");
//        student1.setAddressList(Arrays.asList(address1, address2, address3));
//        saveStudent(student1);
        findStudent(1);

    }

    private static void findStudent(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student selectedStudent = session.find(Student.class,id);
            System.out.println(selectedStudent);

        }
    }


    private static void saveStudent(Student sanath) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            long savedId = (long) session.save(sanath);
            transaction.commit();
            System.out.println("saved Student Primary Key :" + savedId);
        }
    }
}
