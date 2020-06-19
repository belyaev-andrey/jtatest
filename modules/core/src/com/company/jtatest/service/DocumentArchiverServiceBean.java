package com.company.jtatest.service;

import com.company.jtatest.entity.ArchivedBook;
import com.company.jtatest.entity.Book;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;

@Service(DocumentArchiverService.NAME)
public class DocumentArchiverServiceBean implements DocumentArchiverService {

    @Inject
    private DataManager dataManager;

    @Override
    public Book archiveBook(Book book) {
        if (book == null) {
            return null;
        }
        ArchivedBook archived = dataManager.create(ArchivedBook.class);
        archived.setBookId(book.getId());
        archived.setBook(book);
        archived.setArchiveDate(LocalDateTime.now());
        book.setArchived(true);
        dataManager.commit(archived);
        return dataManager.commit(book);
    }
}