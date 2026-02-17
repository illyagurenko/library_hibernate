# Hibernate Library Management

Учебный проект с использованием ORM Hibernate.

## Что реализовано:
* **Entity Mapping:** Маппинг Java-классов на таблицы БД с использованием аннотаций JPA/Hibernate.
* **Relationships:** Реализована связь **One-to-Many** (Один автор — много книг) и **Many-to-One**.
* **Cascade Operations:** Автоматическое сохранение и удаление связанных сущностей (`CascadeType.ALL`).
* **HQL (Hibernate Query Language):** Написание запросов к объектам, поиск по параметрам.
* **Lombok:** Использование библиотек для уменьшения шаблонного кода (геттеры, сеттеры, конструкторы).

## Стек технологий:
* Java 21
* PostgreSQL
* Hibernate 6.4.4.Final
* Lombok
* Maven

## Как запустить:
1. Создайте базу данных `library_db` в PostgreSQL.
2. Склонируйте репозиторий.
3. Установите переменную окружения `PASSWORD` (пароль от БД).
4. В файле `hibernate.cfg.xml` проверьте настройки подключения.
5. Запустите `Main.main()`. Таблицы будут созданы автоматически (`hbm2ddl.auto=update`).