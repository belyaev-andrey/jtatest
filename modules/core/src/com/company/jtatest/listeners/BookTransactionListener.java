package com.company.jtatest.listeners;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.listener.BeforeCommitTransactionListener;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component(BookTransactionListener.NAME)
public class BookTransactionListener implements BeforeCommitTransactionListener {
    public static final String NAME = "jtatest_BookTransactionListener";

    @Override
    public void beforeCommit(EntityManager entityManager, Collection<Entity> managedEntities) {

    }
}