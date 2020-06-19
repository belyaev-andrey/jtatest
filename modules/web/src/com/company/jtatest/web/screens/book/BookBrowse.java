package com.company.jtatest.web.screens.book;

import com.company.jtatest.service.DocumentArchiverService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.jtatest.entity.Book;

import javax.inject.Inject;

@UiController("jtatest_Book.browse")
@UiDescriptor("book-browse.xml")
@LookupComponent("booksTable")
@LoadDataBeforeShow
public class BookBrowse extends StandardLookup<Book> {

    @Inject
    private CollectionContainer<Book> booksDc;

    @Inject
    private DocumentArchiverService documentArchiverService;

    @Subscribe("archiveDtn")
    public void onArchiveDtnClick(Button.ClickEvent event) {
            booksDc.replaceItem(documentArchiverService.archiveBook(booksDc.getItemOrNull()));
    }
}