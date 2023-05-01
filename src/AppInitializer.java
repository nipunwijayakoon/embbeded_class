import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {

    public static void main(String[] args) {
        Address residentalAddress = new Address("SriLanka","Kurunrgala",60347);
        Address permenantAddress = new Address("USA","DA1",6045);
        Student student1 = new Student(1,"Sanath",residentalAddress,permenantAddress);
        saveStudent(student1);

    }


    private static void saveStudent(Student sanath) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            Transaction transaction = session.beginTransaction();
            long savedId = (long) session.save(sanath);
            transaction.commit();
            System.out.println("saved Student Primary Key :" + savedId);
        }
    }
}
