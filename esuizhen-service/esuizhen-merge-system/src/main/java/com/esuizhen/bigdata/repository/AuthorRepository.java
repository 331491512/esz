package com.esuizhen.bigdata.repository;

import com.esuizhen.bigdata.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fqc on 16/11/14.
 */
//@RepositoryRestResource
//@EnableTransactionManagement
//@Transactional
@Repository
public interface AuthorRepository extends //RevisionRepository<Author, Long, Integer>,
        JpaRepository<Author, Long> {

    List<Author> findByLastName(String name);
    //JpaRepository<Author, Long>, PagingAndSortingRepository<Author, Long> {
}
