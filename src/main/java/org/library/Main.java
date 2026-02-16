package org.library;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.library.entity.Author;
import org.library.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        //достаем сессию из фабрики
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            //объект для записи
            Transaction transaction = session.beginTransaction();

            //создание объекта сущности
            Author author = new Author();
            author.setFirstName("Александр");
            author.setLastName("Пушкин");

            //сохранение объекта в БД
            session.persist(author);

            //подтверждение
            transaction.commit();

            System.out.println("автор сохранен с id: " + author.getId());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            HibernateUtil.closeSession();
        }
    }
}