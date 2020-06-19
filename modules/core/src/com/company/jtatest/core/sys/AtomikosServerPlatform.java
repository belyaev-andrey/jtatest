package com.company.jtatest.core.sys;

import org.eclipse.persistence.platform.server.ServerPlatformBase;
import org.eclipse.persistence.sessions.DatabaseSession;

public class AtomikosServerPlatform extends ServerPlatformBase {

    public AtomikosServerPlatform(DatabaseSession newDatabaseSession) {
        super(newDatabaseSession);
    }

    @Override
    public Class getExternalTransactionControllerClass() {
        return AtomikosJtaTransactionController.class;
    }

    @Override
    protected void externalTransactionControllerNotNullWarning() {
        super.externalTransactionControllerNotNullWarning();
    }

    @Override
    public boolean isJTAEnabled() {
        return super.isJTAEnabled();
    }
}
