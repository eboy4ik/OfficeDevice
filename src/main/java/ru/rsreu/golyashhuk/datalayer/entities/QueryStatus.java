package ru.rsreu.golyashhuk.datalayer.entities;

/**
 * The QueryStatus class represents the status of a query in the system.
 * It extends the AbstractEntity class, inheriting the ID property,
 * and includes an additional property for the name of the status.
 */
public class QueryStatus extends AbstractEntity {
    private String name;

    /**
     * Default constructor that initializes a new instance of QueryStatus.
     */
    public QueryStatus() {
    }

    /**
     * Retrieves the name of the query status.
     *
     * @return the name of the query status
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the query status.
     *
     * @param name the new name for the query status
     */
    public void setName(String name) {
        this.name = name;
    }
}
