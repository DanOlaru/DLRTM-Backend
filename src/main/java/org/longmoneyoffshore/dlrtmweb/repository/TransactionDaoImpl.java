package org.longmoneyoffshore.dlrtmweb.repository;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@Data
public class TransactionDaoImpl implements TransactionDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TransactionDaoImpl() { }

    public TransactionDaoImpl(Client client, ArrayList<Product> productsList) { }


    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS transactions (transactionID int NOT NULL AUTO_INCREMENT, clientRef VARCHAR(255), " +
                "productIDs CHAR(255), transactionStatus VARCHAR(255), transactionSpecialMentions VARCHAR(255), transactionDate DATE," +
                "PRIMARY KEY (transactionID), FOREIGN KEY (clientRef) REFERENCES clients(clientID))";
        this.jdbcTemplate.execute(sql);
    }

    public void clearTable() {
        createTable();

        String sql = "TRUNCATE TABLE transactions";
        this.jdbcTemplate.execute(sql);
    }

    public void dropTable() {

        createTable();

        String sql = "DROP TABLE transactions";

        this.jdbcTemplate.execute(sql);
    }

    @Override
    public void insertTransaction(Transaction transaction) {

        String sqlTransactions = "INSERT INTO transactions (clientRef, productIDs, transactionStatus, transactionSpecialMentions, transactionDate) " +
                "VALUES (:clientRef, :productIDs, :transactionStatus, :transactionSpecialMentions, :transactionDate)";

        SqlParameterSource transactionNamedParameters =
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
    public List<Transaction> getAllTransactions() {

        createTable();

        String sql = "SELECT * FROM transactions";
        return namedParameterJdbcTemplate.query(sql, new TransactionMapper());
    }

    @Override
    public List<Transaction> getTransactionsByField(Object field) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsByDate(Date date) {
        return null;
    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        return null;
    }

    @Override
    public void removeTransactionById(String transactionId) {
        String sql = "DELETE FROM transactions WHERE transactionID = (?)";
        jdbcTemplate.update(sql, transactionId);
    }

    @Override
    public void removeAllTransactions () {
        String sql = "TRUNCATE TABLE transactions";
        jdbcTemplate.update(sql);
    }

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
