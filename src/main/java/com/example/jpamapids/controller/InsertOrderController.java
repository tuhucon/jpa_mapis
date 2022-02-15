package com.example.jpamapids.controller;

import com.example.jpamapids.AuthorRepository;
import com.example.jpamapids.ParentRepository;
import com.example.jpamapids.entity.Author;
import com.example.jpamapids.entity.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequiredArgsConstructor
public class InsertOrderController {

    private final AuthorRepository authorRepository;

    private final ParentRepository parentRepository;

    @GetMapping("/insertOrder")
    @Transactional
    public void insertOrder() {
        Author author = new Author();
        author.setAge(12);
        author.setName("tu hu con");

        Parent parent = new Parent();
        parent.setTitle(" chich choe");

        Author author3 = authorRepository.findById(3L).get();
        Author author4 = authorRepository.findById(4L).get();

        Parent parent3 = parentRepository.findById(3L).get();
        Parent parent4 = parentRepository.findById(4L).get();

        int ran = ThreadLocalRandom.current().nextInt(0, 100_00);
        author4.setName("ha ha ha" + ran);
        author3.setName("hi hi hi" + ran);
        parent4.setTitle("ha ha ha" + ran);
        parent3.setTitle("hi hi hi" + ran);

        parentRepository.save(parent4);
        parentRepository.save(parent3);

        authorRepository.save(author4);
        authorRepository.save(author3);

        parentRepository.save(parent);
        authorRepository.save(author);
        authorRepository.save(Author.builder().name("abasdf").build());
        parentRepository.save(Parent.builder().title("abc").build());

    }
}
