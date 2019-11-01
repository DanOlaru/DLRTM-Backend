package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.TransactedProduct;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class TransactionDaoImpl implements TransactionDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TransactionDaoImpl() {
    }

    public TransactionDaoImpl(Client clientReference, ArrayList<TransactedProduct> productsList) {
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS transactions (transactionID varchar(45) NOT NULL, clientID varchar(255), " +
                "productUniqueIDs char(10), transactionStatus varchar(255), specialMentions varchar(255)," +
                "PRIMARY KEY (transactionID)); " +
                "FOREIGN KEY (clientID) REFERENCES clients(clientID));" +
                "FOREIGN KEY (productUniqueIDs) REFERENCES products(uniqueID));";
        this.jdbcTemplate.execute(sql);
    }

    public void clearTables() {
        createTable();

        String sql = "TRUNCATE TABLE transactions";
        this.jdbcTemplate.execute(sql);
    }

    public void dropTable() {

        String sql = "DROP TABLE transactions";

        this.jdbcTemplate.execute(sql);
    }

    /*
      private String transactionID;
      private Client clientReference;
      private ArrayList<TransactedProduct> productsList;
      private String transactionStatus;
      private String specialMentions;
       */
    @Override
    public void insertTransaction(Transaction transaction) {

        String sqlTransactions = "INSERT INTO transactions (clientID, productUniqueIDs, transactionStatus, transactionSpecialMentions) " +
                "VALUES (:transactionID, :clientID, :productUniqueIDs, :transactionStatus, :transactionSpecialMentions)";

        SqlParameterSource transactionNamedParameters =
                new MapSqlParameterSource("clientID", transaction.getClient().getClientID())
                .addValue("productUniqueIDs", transaction.getProductsList()
                    .stream().map(Product::getProductUniqueID).collect(Collectors.joining(","))) //TODO: does this give me string?
                .addValue("transactionStatus", transaction.getTransactionStatus())
                .addValue("transactionSpecialMentions", transaction.getSpecialMentions());

        createTable();
        namedParameterJdbcTemplate.update(sqlTransactions, transactionNamedParameters);

    }

    @Override
    public Collection<Transaction> getAllTransactions() {
        return null;
    }

    @Override
    public Collection<Transaction> getTransactionsByField(Object field) {
        return null;
    }

    @Override
    public Collection<Transaction> getAllTransactionsByDate(Date date) {
        return null;
    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        return null;
    }

    @Override
    public void removeTransactionById(String transactionId) {

    }

    @Override
    public void updateTransaction(Transaction transaction) {

    }
}
