Using Atomikos and JTA transactions in CUBA - PoC

Uses docker image for mysql:
```
docker run --name mysql -P -e MYSQL_ROOT_PASSWORD=pw -d mysql:latest
```
PostgreSQL does not work with CUBA - it fails on anonymous login due to [Transaction interleaving not implemented](https://www.atomikos.com/Documentation/KnownProblems#PostgreSQL_HeuristicMixed_Exception) issue. 


Since there is no EclipseLink support in Atomikos for standalone applications, I had to create the utility classes:

`AtomikosServerPlatform` - used by session factory to and entity manager setup. The platform is used to get transaction manager.
`AtomikosJtaTransactionController` - used as a service to get transaction manager. See `JTATransactionController` for details.

`XaDataSourceProvider` - replaces CUBA provider and returns correct XADatasources wrapped into Atomikos datasource for compatibility
since "ordinal" Datasource cannot be replaced by XADatasource they are siblings, not parent-child. 

Note `spring.xml` - we had to override standard transaction manager and datasource factory to support JPA. `com.atomikos.icatch.serial_jta_transactions` is an important parameter to fix [XA issue in MySQL](https://www.atomikos.com/Documentation/KnownProblems#MySQL_XA_bug)

In `persistence.xml` you need to set `transaction-type="JTA"` for the persistence unit definition. Also, you need to define
EclipseLink specific property that will allow us to use JTA: `<property name="eclipselink.target-server" value="com.company.jtatest.core.sys.AtomikosServerPlatform"/>`.

   

 