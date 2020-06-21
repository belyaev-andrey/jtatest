package com.company.jtatest.service;

import com.company.jtatest.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service(DocumentArchiverService.NAME)
public class DocumentArchiverServiceBean implements DocumentArchiverService {

    @Inject
    private ArchiveService archiveService;

    @Inject
    private BookService bookService;

    @Transactional
    @Override
    public Book archiveBook(Book book) {
        archiveService.createArchive(book);
        Book updateBook = bookService.updateBook(book);
        return updateBook;
    }
}