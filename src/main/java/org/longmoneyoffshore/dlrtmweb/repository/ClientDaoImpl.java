package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.*;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private PaymentCardDaoImpl payment;

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

    //@Autowired
    public void setDataSource(DataSource dataSource) {
        //public void setDataSource(BasicDataSource dataSource) {

        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    public PaymentCardDaoImpl getPayment() {
        return payment;
    }

    public void setPayment(PaymentCardDaoImpl payment) {
        this.payment = payment;
    }

    public void createTable() {
        String sql = "CREATE TABLE clients (clientID varchar(45) NOT NULL, name varchar(255), homePhone varchar(45)," +
                "                businessPhone varchar(45), alternatePhone varchar(45), mobilePhone varchar(45)," +
                "                primaryContactPhone varchar(45), primaryEmail varchar(255), alternateEmail varchar(255)," +
                "                billingAddress varchar(255), shippingAddress varchar(255), alternateAddress varchar(255)," +
                "                deliveryAddress varchar(255), clientUrgency float, clientValue float, clientStatus varchar(255)," +
                "                clientSpecialMentions varchar(255)," +
                "                PRIMARY KEY (clientID));";
        this.jdbcTemplate.execute(sql);
    }

    public void dropTable() {

        String sql = "DROP TABLE clients";

        this.jdbcTemplate.execute(sql);
    }

    @Override
    public List<Client> getAllClients() {
        //TODO: need to join tables clients with paymentCards???

        System.out.println("INSIDE DAO: DAN: GETTING ALL CLIENTS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        String sql = "SELECT * FROM clients";

        List<Client> clients = namedParameterJdbcTemplate.query(sql, new ClientMapper());

        clients.stream().forEach(c -> {
            c.setCards(payment.getPaymentCardsByClientId(c.getClientID()));
        });

        return clients;
    }


    @Override
    public Collection<Client> getAllClientsByField(Object field) {
        return null;
    }

    @Override
    public Client getClientById(String clientId) {
        return null;
    }

    @Override
    public void removeClientById(String clientId) {

    }

    @Override
    public void updateClient(Client client) {

    }

    /*

     */

    @Override
    public void insertClient(Client client) {

        System.out.println("INSIDE CLIENT DAO: INSERTING FAKE CLIENTS SET");
        System.out.println("CLIENT IS:" + client.smallToString());

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
                .addValue("primaryContactPhone", client.getClientPrimaryContactPhone().getClientPhoneNo())
                .addValue("primaryEmail", client.getClientPrimaryEmailAddress())
                .addValue("alternateEmail", client.getClientAlternateEmailAddress())
                .addValue("billingAddress", client.getClientBillingAddress().getStandardAddress())
                .addValue("shippingAddress", client.getClientShippingAddress().getStandardAddress())
                .addValue("alternateAddress", client.getClientAlternateAddress().getStandardAddress())
                .addValue("deliveryAddress", client.getClientDeliveryAddress().getStandardAddress())
                .addValue("clientUrgency", client.getClientUrgency())
                .addValue("clientValue", client.getClientValue())
                .addValue("clientStatus", client.getClientStatus())
                .addValue("clientSpecialMentions", client.getClientSpecialMentions());

        namedParameterJdbcTemplate.update(sqlClients, clientNamedParameters);

        String sqlCards = "INSERT INTO paymentCards (cardNumber, nameOnCard, cardExpirationDate, CVC, clientID) " +
                        "VALUES (:cardNumber, :nameOnCard, :cardExpirationDate, :CVC, :clientID)";

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
            client.setClientName(new PersonName(resultSet.getString("name")));
            client.setClientHomePhone(new PhoneNumber(client.getClientName().getSimpleName(), resultSet.getString("homePhone")));
            client.setClientBusinessPhone(new PhoneNumber(client.getClientName().getSimpleName(), resultSet.getString("businessPhone")));
            client.setClientAlternatePhone(new PhoneNumber(client.getClientName().getSimpleName(), resultSet.getString("alternatePhone")));
            client.setClientMobilePhone(new PhoneNumber(client.getClientName().getSimpleName(), resultSet.getString("mobilePhone")));
            client.setClientPrimaryContactPhone(new PhoneNumber(client.getClientName().getSimpleName(), resultSet.getString("primaryContactPhone")));
            client.setClientPrimaryEmailAddress(resultSet.getString("primaryEmail"));
            client.setClientAlternateEmailAddress(resultSet.getString("alternateEmail"));
            client.setClientBillingAddress(new Address(resultSet.getString("billingAddress")));
            client.setClientShippingAddress(new Address(resultSet.getString("shippingAddress")));
            client.setClientAlternateAddress(new Address(resultSet.getString("alternateAddress")));
            client.setClientDeliveryAddress(new Address(resultSet.getString("deliveryAddress")));
            client.setClientUrgency(resultSet.getFloat("clientUrgency"));
            client.setClientValue(resultSet.getFloat("clientValue"));
            client.setClientStatus(resultSet.getString("clientStatus"));
            client.setClientSpecialMentions(resultSet.getString("clientSpecialMentions"));

            return client;
        }
    }
}

