/*
package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class PaymentCardDaoImpl implements PaymentCardDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate()
    {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        //public void setDataSource(BasicDataSource dataSource) {

        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS paymentCards (cardID int NOT NULL AUTO_INCREMENT, cardNumber varchar(45), " +
                "nameOnCard varchar(255), cardExpirationDate varchar(45), CVC varchar(10), clientID varchar(45)," +
                "PRIMARY KEY (cardID), FOREIGN KEY (clientID) REFERENCES clients(clientID))";

        this.jdbcTemplate.execute(sql);
    }

    public void clearTable() {
        //String sql = "DROP TABLE IF EXISTS DLRTM_DB.paymentCards";
        //this.jdbcTemplate.execute(sql);

        createTable();

        String sql = "TRUNCATE TABLE paymentCards";
        this.jdbcTemplate.execute(sql);
    }

    public void dropTable() {

        createTable();

        String sql = "DROP TABLE paymentCards";

        this.jdbcTemplate.execute(sql);
    }


    public List<PaymentCard> getPaymentCardsByClientId(int clientID) {

        String cardsSql = "SELECT * FROM paymentCards WHERE clientID = ";
        return namedParameterJdbcTemplate.query(cardsSql + clientID, new PaymentCardMapper());
    }

    @Override
    public Collection<PaymentCard> getAllPaymentCards() {
        return null;
    }

    @Override
    public Collection<PaymentCard> getAllPaymentCardsByField(Object field) {
        return null;
    }

    public Collection<PaymentCard> getAllPaymentCardsByName(Object field) {
        return null;
    }
    public Collection<PaymentCard> getAllPaymentCardsByClientID(Object field) {
        return null;
    }


    @Override
    public PaymentCard getPaymentCardById(String paymentCardId) {

        return null;
    }

    @Override
    public void removePaymentCardById(String paymentCardId) {

    }

    @Override
    public void updatePaymentCard(PaymentCard paymentCard) {

    }

    @Override
    public void insertPaymentCard(PaymentCard paymentCard) {

    }

    private static final class PaymentCardMapper implements RowMapper<PaymentCard> {

        public PaymentCardMapper() {};

        @Override
        public PaymentCard mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            PaymentCard card = new PaymentCard();

            card.setCardNumber(resultSet.getString("cardNumber"));
            card.setNameOnCard(resultSet.getString("nameOnCard"));
            card.setCardExpirationDate(resultSet.getString("cardExpirationDate"));
            card.setCVC(resultSet.getString("CVC"));

            return card;
        }
    }
}
*/
