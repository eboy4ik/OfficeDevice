package ru.rsreu.golyashhuk.datalayer;

import ru.rsreu.golyashhuk.datalayer.entities.Query;

import java.util.List;

/**
 * Interface representing a Data Access Object (DAO)
 * for handling Query entities.
 */
public interface QueryDAO {

    /**
     * Retrieves a list of all queries created by a specific user.
     *
     * @param id the ID of the user whose queries are to be retrieved
     * @return a list of Query objects created by the user
     */
    List<Query> getUserQueries(int id);

    /**
     * Retrieves a list of all queries.
     *
     * @return a list of all Query objects
     */
    List<Query> getAllQueries();

    /**
     * Creates a new query with the specified user, device, query type, and message.
     *
     * @param userId    the ID of the user creating the query
     * @param deviceId  the ID of the device related to the query
     * @param queryType the type of query (get, repair, return)
     * @param message   the message or description of the query
     * @return true if the query was created successfully,
     * false otherwise
     */
    boolean createQuery(int userId, int deviceId, int queryType, String message);

    /**
     * Deletes all queries made by a specific user.
     *
     * @param userId the ID of the user whose queries are to be deleted
     * @return true if all queries were deleted successfully,
     * false otherwise
     */
    boolean deleteAllUserQueries(int userId);

    /**
     * Closes a specific query and records a response.
     *
     * @param queryId  the ID of the query to close
     * @param response the response to be recorded for the query
     * @return true if the query was closed successfully,
     * false otherwise
     */
    boolean closeQuery(int queryId, String response);

    /**
     * Retrieves a specific query by its ID.
     *
     * @param queryId the ID of the query to retrieve
     * @return the Query object corresponding to the given ID
     */
    Query getQuery(int queryId);

    /**
     * Deletes all queries related to a specific device.
     *
     * @param deviceId the ID of the device whose related queries are to be deleted
     * @return true if all related queries were deleted successfully,
     * false otherwise
     */
    boolean deleteAllQueriesWithDevice(int deviceId);
}
