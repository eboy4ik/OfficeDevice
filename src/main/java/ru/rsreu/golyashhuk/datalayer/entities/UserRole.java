package ru.rsreu.golyashhuk.datalayer.entities;

/**
 * The UserRole class represents a role assigned to a user in the system.
 * It extends the AbstractEntity class, inheriting the ID property,
 * and includes an additional property for the name of the role.
 */
public class UserRole extends AbstractEntity {
    private String name;

    /**
     * Retrieves the name of the user role.
     *
     * @return the name of the user role
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user role.
     *
     * @param name the new name for the user role
     */
    public void setName(String name) {
        this.name = name;
    }
}
