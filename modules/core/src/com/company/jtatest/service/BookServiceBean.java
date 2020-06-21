package com.company.jtatest.service;

import com.company.jtatest.entity.Book;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service(BookService.NAME)
public class BookServiceBean implements BookService {

    @Inject
    private Persistence persistence;

    @Transactional()
    @Override
    public Book updateBook(Book book) {
        EntityManager emMain = persistence.getEntityManager();
        book.setArchived(true);
        Book updated = emMain.merge(book);
        /*
                if (updated.getArchived()) {
                    throw new IllegalStateException("Test exception!");
                }
        */
        return updated;
    }
}