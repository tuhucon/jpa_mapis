package com.example.jpamapids;

import com.example.jpamapids.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends NaturalRepository<Book, Long> {
}
