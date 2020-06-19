package com.company.jtatest.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;
import com.haulmont.cuba.core.global.DdlGeneration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.DISABLED)
@Table(name = "JTATEST_ARCHIVED_BOOK")
@Entity(name = "jtatest_ArchivedBook")
public class ArchivedBook extends StandardEntity {
    private static final long serialVersionUID = -5756228009473699826L;

    @SystemLevel
    @Column(name = "BOOK_ID")
    private UUID bookId;

    @NotNull
    @Transient
    @MetaProperty(related = "bookId", mandatory = true)
    private Book book;

    @NotNull
    @Column(name = "ARCHIVE_DATE", nullable = false)
    private LocalDateTime archiveDate;

    public LocalDateTime getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(LocalDateTime archiveDate) {
        this.archiveDate = archiveDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }
}