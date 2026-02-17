package org.library;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.library.entity.Author;
import org.library.entity.Book;
import org.library.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Book> dostoevskyBooks = new ArrayList<>();
        Author fodor = new Author();
        fodor.setFirstName("Федор");
        fodor.setLastName("Достоевский");

        Book b1 = new Book("Преступление и наказание", 1866, fodor);
        Book b2 = new Book("Идиот", 1869, fodor);
        dostoevskyBooks.add(b1);
        dostoevskyBooks.add(b2);
        fodor.setBooks(dostoevskyBooks);

        saveAuthor(fodor);

        System.out.println("list books after 1860");
        foundBooksAfterYear(1860);

        HibernateUtil.closeSession();
    }

    //сохранение автора
    public static void saveAuthor(Author author){
        //достаем сессию из фабрики
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            //объект для записи
            Transaction transaction = session.beginTransaction();

            //сохранение объекта в БД
            session.persist(author);

            //подтверждение
            transaction.commit();
            System.out.println("Author save: " + author.getLastName());
        }
        catch (Exception e){
            System.out.println("error saved");
            e.printStackTrace();
        }
    }

    //поиск с помощью HQL все книги после заданного года
    public static void foundBooksAfterYear(int year){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Book> books = session.createQuery(
                    "FROM Book b WHERE b.publishingYear > :year", Book.class)
                    .setParameter("year", year)
                    .getResultList();

            books.forEach(b -> System.out.println(b.getTitle() + " " + b.getAuthor().getLastName()));

        }
    }

    //удаление автора
    public static void deleteAuthor(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Author author = session.get(Author.class, id);
            if(author != null){
                session.remove(author);
                System.out.println("author with id " + id + " deleted");

            }
            transaction.commit();
        }
    }

}