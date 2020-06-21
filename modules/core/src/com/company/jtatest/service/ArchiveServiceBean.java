package com.company.jtatest.service;

import com.company.jtatest.entity.ArchivedBook;
import com.company.jtatest.entity.Book;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;

@Service(ArchiveService.NAME)
public class ArchiveServiceBean implements ArchiveService {

    @Inject
    private Persistence persistence;

    @Inject
    private Metadata metadata;

    @Transactional("Archive")
    @Override
    public ArchivedBook createArchive(Book book) {
        EntityManager emArc = persistence.getEntityManager("Archive");
        ArchivedBook archived = metadata.create(ArchivedBook.class);
        archived.setBookId(book.getId());
        archived.setBook(book);
        archived.setArchiveDate(LocalDateTime.now());
        emArc.persist(archived);
        return emArc.reload(archived);
    }
}