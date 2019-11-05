package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.TransactedProduct;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class TransactionDaoImpl implements TransactionDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TransactionDaoImpl() { }

    public TransactionDaoImpl(Client client, ArrayList<TransactedProduct> productsList) { }

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

    /*
            String sql = "CREATE TABLE IF NOT EXISTS paymentCards (cardID int NOT NULL AUTO_INCREMENT, cardNumber varchar(45), " +
                "nameOnCard varchar(255), cardExpirationDate varchar(45), CVC varchar(10), clientID varchar(45)," +
                "PRIMARY KEY (cardID), FOREIGN KEY (clientID) REFERENCES clients(clientID))";

     */

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS transactions (transactionID int NOT NULL AUTO_INCREMENT, clientRef VARCHAR(255), " +
                "productIDs CHAR(255), transactionStatus VARCHAR(255), transactionSpecialMentions VARCHAR(255), transactionDate DATE," +
                "PRIMARY KEY (transactionID), FOREIGN KEY (clientRef) REFERENCES clients(clientID))";
                //"FOREIGN KEY (productUniqueIDs) REFERENCES products(uniqueID));";
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
    clientRef VARCHAR(255), productIDs CHAR(255), transactionStatus VARCHAR(255), specialMentions VARCHAR(255), transactionDate DATE
     */

    @Override
    public void insertTransaction(Transaction transaction) {

        String sqlTransactions = "INSERT INTO transactions (clientRef, productIDs, transactionStatus, transactionSpecialMentions, transactionDate) " +
                "VALUES (:clientRef, :productIDs, :transactionStatus, :transactionSpecialMentions, :transactionDate)";

        SqlParameterSource transactionNamedParameters =
                //new MapSqlParameterSource("transactionID",null)
                new MapSqlParameterSource("clientRef", transaction.getClientID())
                .addValue("clientRef", transaction.getClientID())
                .addValue("productIDs", transaction.getProductListAsString())
                .addValue("transactionStatus", transaction.getTransactionStatus())
                .addValue("transactionSpecialMentions", transaction.getSpecialMentions())
                .addValue("transactionDate", LocalDate.now().toString()); //TODO: might have to modify approach to date

        createTable();
        namedParameterJdbcTemplate.update(sqlTransactions, transactionNamedParameters);
    }

    @Override
    public Collection<Transaction> getAllTransactions() {
        String sql = "SELECT * FROM transactions";

        return namedParameterJdbcTemplate.query(sql, new TransactionMapper());
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
    public void removeTransactionById(String transactionId) { }

    @Override
    public void updateTransaction(Transaction transaction) { }


    private static final class TransactionMapper implements RowMapper<Transaction> {
        public TransactionMapper () {}


        @Override
        public Transaction mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Transaction transaction = new Transaction();

            transaction.setTransactionID(resultSet.getString("transactionID"));
            transaction.setClientID(resultSet.getString("clientRef"));
            transaction.setProductIDList(Arrays.asList(resultSet.getString("productIDs").split(", ")));
            transaction.setTransactionStatus(resultSet.getString("transactionStatus"));
            transaction.setSpecialMentions(resultSet.getString("transactionSpecialMentions"));
            transaction.setLocalDate(LocalDate.parse(resultSet.getString("transactionDate")));

            return transaction;
        }
    }

}
