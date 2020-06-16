package com.company.jtatest.web.screens.book;

import com.haulmont.cuba.gui.screen.*;
import com.company.jtatest.entity.Book;

@UiController("jtatest_Book.edit")
@UiDescriptor("book-edit.xml")
@EditedEntityContainer("bookDc")
@LoadDataBeforeShow
public class BookEdit extends StandardEditor<Book> {
}