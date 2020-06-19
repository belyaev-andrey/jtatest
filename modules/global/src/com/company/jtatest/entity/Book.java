package com.company.jtatest.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "JTATEST_BOOK")
@Entity(name = "jtatest_Book")
public class Book extends StandardEntity {
    private static final long serialVersionUID = 1980261774139944733L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ARCHIVED")
    private Boolean archived;

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}