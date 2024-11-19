package ru.rsreu.golyashhuk.datalayer.entities;

import java.sql.Timestamp;

/**
 * The Query class represents a request or inquiry related to an office device.
 * It extends the AbstractEntity class, inheriting the ID property, and includes
 * additional properties that define the details of the query, such as the device
 * involved, timestamps for sending and closing the query, the type and status
 * of the query, and messages exchanged between the user and the system.
 */
public class Query extends AbstractEntity {
    private OfficeDevice device;
    private Timestamp timeSending;
    private Timestamp timeClosing;
    private QueryType queryType;
    private QueryStatus queryStatus;
    private String userMessage;
    private String response;
    private User sender;

    /**
     * Default constructor that initializes a new instance of Query.
     */
    public Query() {
    }

    /**
     * Retrieves the office device associated with the query.
     *
     * @return the office device related to this query
     */
    public OfficeDevice getDevice() {
        return device;
    }

    /**
     * Sets the office device associated with the query.
     *
     * @param device the office device to be set for this query
     */
    public void setDevice(OfficeDevice device) {
        this.device = device;
    }

    /**
     * Retrieves the user who sent the query.
     *
     * @return the sender of the query
     */
    public User getSender() {
        return sender;
    }

    /**
     * Sets the user who sent the query.
     *
     * @param sender the user to be set as the sender of this query
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * Retrieves the timestamp of when the query was sent.
     *
     * @return the timestamp for sending the query
     */
    public Timestamp getTimeSending() {
        return timeSending;
    }

    /**
     * Sets the timestamp for when the query was sent.
     *
     * @param timeSending the new timestamp for sending the query
     */
    public void setTimeSending(Timestamp timeSending) {
        this.timeSending = timeSending;
    }

    /**
     * Retrieves the timestamp of when the query was closed.
     *
     * @return the timestamp for closing the query
     */
    public Timestamp getTimeClosing() {
        return timeClosing;
    }

    /**
     * Sets the timestamp for when the query was closed.
     *
     * @param timeClosing the new timestamp for closing the query
     */
    public void setTimeClosing(Timestamp timeClosing) {
        this.timeClosing = timeClosing;
    }

    /**
     * Retrieves the type of the query.
     *
     * @return the type of the query
     */
    public QueryType getQueryType() {
        return queryType;
    }

    /**
     * Sets the type of the query.
     *
     * @param queryType the new type for this query
     */
    public void setQueryType(QueryType queryType) {
        this.queryType = queryType;
    }

    /**
     * Retrieves the status of the query.
     *
     * @return the current status of the query
     */
    public QueryStatus getQueryStatus() {
        return queryStatus;
    }

    /**
     * Sets the status of the query.
     *
     * @param queryStatus the new status for this query
     */
    public void setQueryStatus(QueryStatus queryStatus) {
        this.queryStatus = queryStatus;
    }

    /**
     * Retrieves the message from the user related to the query.
     *
     * @return the user's message
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * Sets the message from the user related to the query.
     *
     * @param userMessage the new message from the user
     */
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    /**
     * Retrieves the response to the user's query.
     *
     * @return the response to the query
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets the response to the user's query.
     *
     * @param response the new response to the query
     */
    public void setResponse(String response) {
        this.response = response;
    }
}
