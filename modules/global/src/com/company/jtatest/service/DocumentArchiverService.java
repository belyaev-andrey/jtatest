package com.company.jtatest.service;

import com.company.jtatest.entity.Book;

public interface DocumentArchiverService {
    String NAME = "jtatest_DocumentArchiverService";

    Book archiveBook(Book book);

}