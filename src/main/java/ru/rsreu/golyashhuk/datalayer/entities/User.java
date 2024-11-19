package ru.rsreu.golyashhuk.datalayer.entities;

import java.sql.Timestamp;

/**
 * The User class represents a user in the system. It extends the AbstractEntity class,
 * inheriting the ID property, and includes additional properties for user credentials,
 * role, registration details, and authorization status.
 */
public class User extends AbstractEntity {
    private String login;
    private String passwordHash;
    private UserRole role;
    private String name;
    private Timestamp dateRegistration;
    private boolean isBlocked;
    private boolean isAuthorized;

    /**
     * A constant representing a null user with default values.
     */
    public static final User NULL_USER = new User(-1, "NULL", "NULL");

    /**
     * Default constructor that initializes a new instance of User.
     */
    public User() {
    }

    /**
     * Constructs a new User instance with specified ID, login, and password hash.
     *
     * @param id the unique identifier for the user
     * @param login the login of the user
     * @param passwordHash the hashed password of the user
     */
    public User(int id, String login, String passwordHash) {
        super(id);
        this.setLogin(login);
        this.setPasswordHash(passwordHash);
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name for the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the registration date of the user.
     *
     * @param dateRegistration the new registration date for the user
     */
    public void setDateRegistration(Timestamp dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    /**
     * Sets the blocked status of the user.
     *
     * @param blocked the new blocked status for the user
     */
    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    /**
     * Sets the authorized status of the user.
     *
     * @param authorized the new authorized status for the user
     */
    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    /**
     * Sets the login of the user.
     *
     * @param login the new login for the user
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Sets the hashed password of the user.
     *
     * @param passwordHash the new password hash for the user
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the new role for the user
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Retrieves the login of the user.
     *
     * @return the login of the user
     */
    public String getLogin() {
        return login;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the registration date of the user.
     *
     * @return the registration date of the user
     */
    public Timestamp getDateRegistration() {
        return dateRegistration;
    }

    /**
     * Checks if the user is blocked.
     *
     * @return true if the user is blocked, false otherwise
     */
    public boolean getIsBlocked() {
        return isBlocked;
    }

    /**
     * Checks if the user is authorized.
     *
     * @return true if the user is authorized, false otherwise
     */
    public boolean getIsAuthorized() {
        return isAuthorized;
    }

    /**
     * Retrieves the hashed password of the user.
     *
     * @return the hashed password of the user
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Retrieves the role of the user.
     *
     * @return the role of the user
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Checks if the user is valid based on the ID.
     *
     * @return true if the user has a valid ID (greater than 0), false otherwise
     */
    public boolean isValid() {
        return (this.getId() > 0);
    }

}
