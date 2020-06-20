package com.company.jtatest.core.sys;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.google.common.base.Preconditions;
import com.haulmont.cuba.core.global.Stores;
import com.haulmont.cuba.core.sys.DataSourceProvider;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import java.sql.SQLException;
import java.util.Map;

public class XaDataSourceProvider extends DataSourceProvider {
    //TODO Implement fetching XA from JNDI
    @Override
    protected DataSource getJndiDataSource(String jndiName) {
        Preconditions.checkNotNull(jndiName, "Jndi name is null");
        DataSourceLookup lookup = new JndiDataSourceLookup();
        XADataSource dataSource = (XADataSource) lookup.getDataSource(jndiName);
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(dataSource);
        return atomikosDataSourceBean;
    }

    @Override
    protected DataSource getApplicationDataSource(String storeName) {
        String actualStoreName = storeName == null ? Stores.MAIN : storeName;

        Map<String, String> dsParameters = getDataSourceParameters(actualStoreName);

        XADataSource ds = getXADataSource(dsParameters);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("cubaXADs/"+storeName);
        atomikosDataSourceBean.setXaDataSource(ds);
        atomikosDataSourceBean.setMaxPoolSize(100);
        return atomikosDataSourceBean;
    }

    //TODO Implement proper datasource generation
    private XADataSource getXADataSource(Map<String, String> dsParameters) {
        return getMySqlXaDataSource(dsParameters);
    }

/*
    private XADataSource getPgSqlXaDataSource(Map<String, String> dsParameters) {
        PGXADataSource ds = new PGXADataSource();
        ds.setServerNames(new String[]{dsParameters.get(HOST)});
        ds.setPortNumbers(new int[]{Integer.parseInt(dsParameters.getOrDefault(PORT, "5432"))});
        ds.setDatabaseName(dsParameters.get(DB_NAME));
        ds.setUser(dsParameters.get(USER_NAME));
        ds.setPassword(dsParameters.get(PASSWORD));
        return ds;
    }
*/

    private XADataSource getMySqlXaDataSource(Map<String, String> dsParameters) {
        MysqlXADataSource ds = new MysqlXADataSource();
        //PGXADataSource ds = new PGXADataSource();
        ds.setServerName(dsParameters.get(HOST));
        ds.setPort(Integer.parseInt(dsParameters.getOrDefault(PORT, "5432")));
        ds.setDatabaseName(dsParameters.get(DB_NAME));
        ds.setUser(dsParameters.get(USER_NAME));
        ds.setPassword(dsParameters.get(PASSWORD));
        try {
            ds.setPinGlobalTxToPhysicalConnection(true);
            ds.setServerTimezone("UTC");
            ds.setRequireSSL(false);
            ds.setUseSSL(false);
            ds.setAllowMultiQueries(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ds;
    }


}
