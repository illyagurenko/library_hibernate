package org.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity//этот класс будет связан с таблицей
@Table(name = "authors")//имя таблицы
//автоматическое создание геттеров сеттеров и конструктора по умолчанию
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//создание primary key с автоинкрементном
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
