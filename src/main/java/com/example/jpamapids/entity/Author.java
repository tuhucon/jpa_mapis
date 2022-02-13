package com.example.jpamapids.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Author {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "author_id")
    List<Book> books = new ArrayList<>();

    Integer age;

    String name;

    @Version
    Integer version;
}
