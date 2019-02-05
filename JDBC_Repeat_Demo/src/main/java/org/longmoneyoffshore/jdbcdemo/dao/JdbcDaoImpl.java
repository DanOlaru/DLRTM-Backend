package org.longmoneyoffshore.jdbcdemo.dao;

import org.apache.commons.logging.Log;
import org.longmoneyoffshore.jdbcdemo.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

@Component
public class JdbcDaoImpl {

    //@Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();


    public Circle getCircle (int circleId) {

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
            ps.setInt(1, circleId);

            Circle circle = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                circle =  new Circle(circleId,rs.getString("name"));
            }

            rs.close();
            ps.close();

            return circle;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public int getCircleCount() {
        String sql = "SELECT COUNT(*) FROM circle";
        jdbcTemplate.setDataSource(getDataSource());

        int count = jdbcTemplate.queryForObject(sql,Integer.class);

        return count;

    }

    public String getCircleName(int circleId) {
        String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";

        //String circleName = jdbcTemplate.queryForObject(sql,String.class);
        String circleName = jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);

        return circleName;
    }


    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {

        //this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        //this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Circle> getAllCircles() {
        String sql = "SELECT * FROM CIRCLE";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    public Circle getCircleForId(int circleId) {

        String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());

    }


    private static final class CircleMapper implements RowMapper<Circle> {

        @Override
        public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt("ID"));
            circle.setName(resultSet.getString("NAME"));

            return circle;
        }
    }




    public void insertCircle (Circle circle) {

        String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
    }

    /*


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Circle getCircleXml(int circleId) {

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
            ps.setInt(1, circleId);

            Circle circle = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                circle =  new Circle(circleId,rs.getString("name"));
            }

            rs.close();
            ps.close();

            return circle;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;

    }


        /*


    public void insertCircle (Circle circle) {

        String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (:id, :name)";

        SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
                                                .addValue("name", circle.getName());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void deleteCircleById(int id) {

        String sql = "DELETE FROM CIRCLE WHERE ID IN (?)";
        jdbcTemplate.update(sql,new Object[] {id});

    }

    public void createTriangleTable () {
        String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
        jdbcTemplate.execute(sql);
    }

    }*/

}
