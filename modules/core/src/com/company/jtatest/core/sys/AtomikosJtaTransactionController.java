package com.company.jtatest.core.sys;

import com.haulmont.cuba.core.global.AppBeans;
import org.eclipse.persistence.transaction.JTATransactionController;

import javax.transaction.TransactionManager;

public class AtomikosJtaTransactionController extends JTATransactionController {

    protected TransactionManager acquireTransactionManager() throws Exception {
        TransactionManager transactionManager = AppBeans.get("atomikosTransactionManager");
        return transactionManager;
    }


}
