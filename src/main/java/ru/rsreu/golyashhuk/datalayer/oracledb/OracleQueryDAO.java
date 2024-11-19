package ru.rsreu.golyashhuk.datalayer.oracledb;

import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;
import ru.rsreu.golyashhuk.datalayer.entities.EntityReader;
import ru.rsreu.golyashhuk.datalayer.entities.Query;
import ru.rsreu.golyashhuk.datalayer.entities.QueryType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class OracleQueryDAO implements QueryDAO {
    private Connection connection;

    public OracleQueryDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Query> getUserQueries(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.query.getuserqueries");
        List<Query> queries = new LinkedList<>();
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
            rs = ps.executeQuery();
            while (rs.next()) {
                queries.add(EntityReader.readQuery(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error connection: " + e.getMessage());
            return queries;
        }

        return queries;
    }

    @Override
    public boolean deleteAllUserQueries(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.query.deleteuserqueries");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean closeQuery(int queryId, String response) {
        String query = ConfigurationManager.getProperty("query.oracle.query.closequery");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, response);
            ps.setInt(2, queryId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Query getQuery(int queryId) {
        String querySql = ConfigurationManager.getProperty("query.oracle.query.getquery");
        Query query = new Query();
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(querySql)) {
            ps.setInt(1, queryId);
            rs = ps.executeQuery();
            if (rs.next()) {
                query = EntityReader.readQuery(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return query;
        }
        return query;
    }

    @Override
    public boolean deleteAllQueriesWithDevice(int deviceId) {
        String query = ConfigurationManager.getProperty("query.oracle.query.deletequerieswithdevice");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceId);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Query> getAllQueries() {
        String query = ConfigurationManager.getProperty("query.oracle.query.getallqueries");
        List<Query> queries = new LinkedList<>();
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                queries.add(EntityReader.readQuery(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return queries;
        }

        return queries;
    }

    @Override
    public boolean createQuery(int userId, int deviceId, int queryType, String message) {
        String query = ConfigurationManager.getProperty("query.oracle.query.createquery");
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.setInt(2, deviceId);
            ps.setInt(3, queryType);
            ps.setString(4, message);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
