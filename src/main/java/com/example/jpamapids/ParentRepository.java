package com.example.jpamapids;

import com.example.jpamapids.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    @Query("select p from Parent p where p.id < :id")
    List<Parent> findParentWithIdLessThan(Long id);

}
