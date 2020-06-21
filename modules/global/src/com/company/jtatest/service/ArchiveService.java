package com.company.jtatest.service;

import com.company.jtatest.entity.ArchivedBook;
import com.company.jtatest.entity.Book;

public interface ArchiveService {
    String NAME = "jtatest_ArchiveService";

    ArchivedBook createArchive(Book book);


}