package org.longmoneyoffshore.dlrtmweb.repository;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.*;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Data
public class ClientDaoImpl implements ClientDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private PaymentCardDaoImpl paymentCardDao;
    private TransactionDaoImpl transactionDao;

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


    public PaymentCardDaoImpl getPaymentCardDao() {
        return paymentCardDao;
    }

    public void setPaymentCardDao(PaymentCardDaoImpl paymentCardDao) {
        this.paymentCardDao = paymentCardDao;
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS clients (clientID varchar(45) NOT NULL, name varchar(255), homePhone varchar(45)," +
                "                businessPhone varchar(45), alternatePhone varchar(45), mobilePhone varchar(45)," +
                "                primaryContactPhone varchar(45), primaryEmail varchar(255), alternateEmail varchar(255)," +
                "                billingAddress varchar(255), shippingAddress varchar(255), alternateAddress varchar(255)," +
                "                deliveryAddress varchar(255), clientUrgency float, clientValue float, clientStatus varchar(255)," +
                "                clientSpecialMentions varchar(255)," +
                "                PRIMARY KEY (clientID));";
        this.jdbcTemplate.execute(sql);
    }

    @Override
    public void clearTables() {

        paymentCardDao.dropTable();
        transactionDao.dropTable();

        createTable();

        String sql = "TRUNCATE TABLE clients";

        this.jdbcTemplate.execute(sql);
    }

    public void dropTable() {

        String sql = "DROP TABLE clients";

        this.jdbcTemplate.execute(sql);
    }

    @Override
    public List<Client> getAllClients() {

        String sql = "SELECT * FROM clients";

        List<Client> clients = namedParameterJdbcTemplate.query(sql, new ClientMapper());

        clients.stream().forEach(c -> {
            c.setCards(paymentCardDao.getPaymentCardsByClientId(c.getClientID()));
        });

        return clients;
    }

    @Override
    public List<Client> getAllClientsByField(Object field) {
        return null;
    }

    @Override
    public Client getClientById(String clientId) {

        String sql = "SELECT * FROM clients WHERE clientID =" + clientId;

        return namedParameterJdbcTemplate.query(sql, new ClientMapper()).get(0);
    }

    @Override
    public void removeClientById(String clientId) {

        String sqlTransactionFK = "DELETE FROM transactions WHERE clientRef IN (?)";
        jdbcTemplate.update(sqlTransactionFK, new Object[] {clientId});


        String sqlCardsFK = "DELETE FROM paymentCards WHERE clientID IN (?)";
        jdbcTemplate.update(sqlCardsFK, new Object[] {clientId});

        String sql = "DELETE FROM clients WHERE clientID IN (?)";
        jdbcTemplate.update(sql, new Object[] {clientId});
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public void insertClient(Client client) {

        String sqlClients = "INSERT INTO clients (clientID, name, homePhone, businessPhone, alternatePhone, mobilePhone," +
                "primaryContactPhone, primaryEmail, alternateEmail, billingAddress, shippingAddress, alternateAddress," +
                "deliveryAddress, clientUrgency, clientValue, clientStatus, clientSpecialMentions) " +

                "VALUES (:clientID, :name, :homePhone, :businessPhone, :alternatePhone, :mobilePhone," +
                ":primaryContactPhone, :primaryEmail, :alternateEmail, :billingAddress, :shippingAddress, :alternateAddress," +
                ":deliveryAddress, :clientUrgency, :clientValue, :clientStatus, :clientSpecialMentions)";

        SqlParameterSource clientNamedParameters = new MapSqlParameterSource("clientID", client.getClientID())
                .addValue("name", client.getClientName().getSimpleName())
                .addValue("homePhone", client.getClientHomePhone().getClientPhoneNo())
                .addValue("businessPhone", client.getClientBusinessPhone().getClientPhoneNo())
                .addValue("alternatePhone", client.getClientAlternatePhone().getClientPhoneNo())
                .addValue("mobilePhone", client.getClientMobilePhone().getClientPhoneNo())
                .addValue("primaryContactPhone", client.getClientMobilePhone().getClientPhoneNo())
                .addValue("primaryEmail", client.getClientPrimaryEmailAddress())
                .addValue("alternateEmail", client.getClientAlternateEmailAddress())
                .addValue("billingAddress", client.getClientBillingAddress().getFullAddress())
                .addValue("shippingAddress", client.getClientShippingAddress().getFullAddress())
                .addValue("alternateAddress", client.getClientAlternateAddress().getFullAddress())
                .addValue("deliveryAddress", client.getClientShippingAddress().getFullAddress())
                .addValue("clientUrgency", client.getClientUrgency())
                .addValue("clientValue", client.getClientValue())
                .addValue("clientStatus", client.getClientStatus())
                .addValue("clientSpecialMentions", client.getClientSpecialMentions());

        createTable();
        namedParameterJdbcTemplate.update(sqlClients, clientNamedParameters);

        String sqlCards = "INSERT INTO paymentCards (cardNumber, nameOnCard, cardExpirationDate, CVC, clientID) " +
                        "VALUES (:cardNumber, :nameOnCard, :cardExpirationDate, :CVC, :clientID)";

        String sqlCreatePaymentCards = "CREATE TABLE IF NOT EXISTS paymentCards (cardID int NOT NULL AUTO_INCREMENT, cardNumber varchar(45), " +
                "nameOnCard varchar(255), cardExpirationDate varchar(45), CVC varchar(10), clientID varchar(45)," +
                "PRIMARY KEY (cardID), FOREIGN KEY (clientID) REFERENCES clients(clientID))";

        //this.jdbcTemplate.execute(sqlCreatePaymentCards);

        paymentCardDao.createTable();

        client.getCards().stream().forEach(c -> {
            SqlParameterSource cardNamedParameters = new MapSqlParameterSource("cardNumber", c.getCardNumber())
                    .addValue("nameOnCard", c.getNameOnCard())
                    .addValue("cardExpirationDate",c.getCardExpirationDate())
                    .addValue("CVC", c.getCVC())
                    .addValue("clientID",client.getClientID());

            namedParameterJdbcTemplate.update(sqlCards, cardNamedParameters);
        });

    }

    @Override
    public void insertClients (List<Client> clients) {
        clients.stream().forEach(c -> insertClient(c));
    }


    private static final class ClientMapper implements RowMapper<Client> {
        public ClientMapper() { }

        @Override
        public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Client client = new Client();

            client.setClientID(resultSet.getString("clientID"));

            String clientName = resultSet.getString("name");

            client.setClientName(new PersonName(clientName));
            client.setClientHomePhone(new PhoneNumber(clientName, resultSet.getString("homePhone")));
            client.setClientBusinessPhone(new PhoneNumber(clientName, resultSet.getString("businessPhone")));
            client.setClientAlternatePhone(new PhoneNumber(clientName, resultSet.getString("alternatePhone")));
            client.setClientMobilePhone(new PhoneNumber(clientName, resultSet.getString("mobilePhone")));
            client.setClientPrimaryEmailAddress(resultSet.getString("primaryEmail"));
            client.setClientAlternateEmailAddress(resultSet.getString("alternateEmail"));
            client.setClientBillingAddress(new Address(resultSet.getString("billingAddress")));
            client.setClientShippingAddress(new Address(resultSet.getString("shippingAddress")));
            client.setClientAlternateAddress(new Address(resultSet.getString("alternateAddress")));
            //client.setClientDeliveryAddress(new Address(resultSet.getString("deliveryAddress")));
            client.setClientUrgency(resultSet.getFloat("clientUrgency"));
            client.setClientValue(resultSet.getFloat("clientValue"));
            client.setClientStatus(resultSet.getString("clientStatus"));
            client.setClientSpecialMentions(resultSet.getString("clientSpecialMentions"));

            return client;
        }
    }
}