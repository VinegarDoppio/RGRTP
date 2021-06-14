import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Object[]> list = null;

        try {
            session.beginTransaction();

            Query<Object[]> query = session.createSQLQuery("select pa.fullname, s.name, pa.house, pa.flat, p.cost, p.date\n" +
                    "from personal_accounts as pa\n" +
                    "         inner join payment p on p.id_personal_account = pa.id\n" +
                    "         inner join street s on pa.id_street = s.id where s.name = 'Пр-т Московский' and p.cost > 30");

            list = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
            sessionFactory.close();
        }
        list.forEach(s -> System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4] + " " + s[5]));
    }
}
