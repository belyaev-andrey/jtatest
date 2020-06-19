package com.company.jtatest.web.screens.archivedbook;

import com.haulmont.cuba.gui.screen.*;
import com.company.jtatest.entity.ArchivedBook;

@UiController("jtatest_ArchivedBook.browse")
@UiDescriptor("archived-book-browse.xml")
@LookupComponent("archivedBooksTable")
@LoadDataBeforeShow
public class ArchivedBookBrowse extends StandardLookup<ArchivedBook> {
}