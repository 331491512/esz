package com.esuizhen.bigdata.service;

import com.esuizhen.bigdata.domain.Author;
import com.esuizhen.bigdata.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;

/**
 * Created by fqc on 16/11/9.
 */
@Transactional(readOnly = true)
@Service
public class AuthorService {

    private static final String HISTORY_ENTRY_TEMPLATE = "No: %s, at: %s, TVSet UDID: %s<br />";

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Author addAuthor(Author author) {
        Author author2 = authorRepository.save(author);
        //int a = 1 / 0;
        return author2;
    }

    public void updateAuthor(Author ar) {
        Author author = authorRepository.findOne(ar.getAuthorId());
        authorRepository.save(author);
    }

   /* public String getHistory(long id) {

        Revisions<Integer, Author> revisions = authorRepository.findRevisions(id);
        StringBuilder historyText = new StringBuilder();

        for (Revision<Integer, Author> entry : revisions.getContent()) {
            historyText.append(format(HISTORY_ENTRY_TEMPLATE, entry.getRevisionNumber(), entry.getRevisionDate(), entry
                    .getEntity().getFirstName()));
        }

        return historyText.toString();
    }*/
}