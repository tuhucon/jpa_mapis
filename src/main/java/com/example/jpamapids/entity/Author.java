package com.example.jpamapids.entity;

import com.example.jpamapids.event.AuthorCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
//@NamedEntityGraph(
//        name = "author-book-graph",
//        attributeNodes = {
//                @NamedAttributeNode("books")
//        }
//)
public class Author extends AbstractAggregateRoot<Author> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<Phone> phones = new ArrayList<>();

    Integer age;

    @Basic(fetch = FetchType.LAZY)
    String name;

    @Version
    Integer version;

    public Author() {
        super();
//        registerEvent(new AuthorCreatedEvent(this));
    }
}
