package org.library.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.library.entity.Author;

public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try{
            //создание конфигурации на основе hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            //регистрация сущности
            configuration.addAnnotatedClass(Author.class);
            //добавление пароля из переменной окружения
            configuration.setProperty("hibernate.connection.password", System.getenv("PASSWORD"));
            return configuration.buildSessionFactory();
        }
        catch (Throwable e){
            System.err.println("init failed " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static void closeSession(){
        getSessionFactory().close();
    }
}
