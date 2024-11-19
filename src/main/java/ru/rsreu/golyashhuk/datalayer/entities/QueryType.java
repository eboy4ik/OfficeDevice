package ru.rsreu.golyashhuk.datalayer.entities;

/**
 * The QueryType class represents the type of a query in the system.
 * It extends the AbstractEntity class, inheriting the ID property,
 * and includes an additional property for the name of the query type.
 */
public class QueryType extends AbstractEntity {
    private String name;

    /**
     * Default constructor that initializes a new instance of QueryType.
     */
    public QueryType() {
    }

    /**
     * Retrieves the name of the query type.
     *
     * @return the name of the query type
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the query type.
     *
     * @param name the new name for the query type
     */
    public void setName(String name) {
        this.name = name;
    }
}
