package com.company.jtatest.service;

import com.company.jtatest.entity.Book;

public interface BookService {
    String NAME = "jtatest_BookService";

    Book updateBook(Book book);

}