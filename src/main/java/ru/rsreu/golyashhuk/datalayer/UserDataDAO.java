package ru.rsreu.golyashhuk.datalayer;

import ru.rsreu.golyashhuk.datalayer.entities.User;
import ru.rsreu.golyashhuk.datalayer.entities.UserRole;

import java.util.List;

/**
 * Interface representing a Data Access Object (DAO)
 * for handling User entities.
 */
public interface UserDataDAO {

    /**
     * Retrieves a user based on their login and password credentials.
     *
     * @param login the login of the user
     * @param password the password of the user
     * @return the User object if the credentials match,
     * or NULL User if no matching user is found
     */
    User getUser(String login, String password);

    /**
     * Retrieves a list of all users in the system.
     *
     * @return a list of User objects representing all users
     */
    List<User> getUsers();

    /**
     * Checks if a user with the specified login exists in the system.
     *
     * @param login the login to check
     * @return true if the user exists, false otherwise
     */
    boolean isExistUser(String login);

    /**
     * Creates a new user with the specified login, password, name, and role ID.
     *
     * @param login    the login of the new user
     * @param password the password of the new user
     * @param name     the name of the new user
     * @param roleId   the role ID of the new user
     * @return true if the user was created successfully,
     * false otherwise
     */
    boolean createUser(String login, String password, String name, int roleId);

    /**
     * Deletes a user by their ID.
     *
     * @param userId the ID of the user to delete
     * @return true if the user was deleted successfully,
     * false otherwise
     */
    boolean deleteUser(int userId);

    /**
     * Sets a user's status to offline.
     *
     * @param userId the ID of the user whose status is to be set
     * @return true if the status was updated successfully,
     * false otherwise
     */
    boolean setOfflineStatus(int userId);

    /**
     * Sets a user's status to online.
     *
     * @param userId the ID of the user whose status is to be set
     * @return true if the status was updated successfully,
     * false otherwise
     */
    boolean setOnlineStatus(int userId);

    /**
     * Retrieves the role ID of a user by their ID.
     *
     * @param userId the ID of the user whose role is to be retrieved
     * @return the role ID of the user
     */
    int getUserRoleById(int userId);

    /**
     * Edits a user's data by updating their name and role.
     *
     * @param userId    the ID of the user to edit
     * @param newName   the new name for the user
     * @param newRoleId the new role ID for the user
     * @return true if the data was updated successfully,
     * false otherwise
     */
    boolean editUserData(int userId, String newName, int newRoleId);

    /**
     * Blocks a user, preventing them from accessing the system.
     *
     * @param userId the ID of the user to block
     * @return {@code true} if the user was blocked successfully,
     *         {@code false} otherwise
     */
    boolean blockUser(int userId);

    /**
     * Unblocks a user, allowing them to access the system again.
     *
     * @param userId the ID of the user to unblock
     * @return true if the user was unblocked successfully,
     * false otherwise
     */
    boolean unblockUser(int userId);

    /**
     * Checks if a user is currently blocked.
     *
     * @param id the ID of the user to check
     * @return true if the user is blocked, false otherwise
     */
    boolean isBlockedUser(int id);
}
