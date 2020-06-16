package com.company.jtatest.web.screens.book;

import com.haulmont.cuba.gui.screen.*;
import com.company.jtatest.entity.Book;

@UiController("jtatest_Book.browse")
@UiDescriptor("book-browse.xml")
@LookupComponent("booksTable")
@LoadDataBeforeShow
public class BookBrowse extends StandardLookup<Book> {
}