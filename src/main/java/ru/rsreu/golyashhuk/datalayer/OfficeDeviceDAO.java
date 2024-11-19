package ru.rsreu.golyashhuk.datalayer;

import ru.rsreu.golyashhuk.datalayer.entities.OfficeDevice;

import java.util.List;

/**
 * Interface representing a Data Access Object (DAO)
 * for handling OfficeDevice entities.
 */
public interface OfficeDeviceDAO {

    /**
     * Retrieves a list of all office devices that are currently free
     *
     * @return a list of free OfficeDevice objects
     */
    List<OfficeDevice> getFreeOfficeDevices();

    /**
     * Retrieves a list of all office devices.
     *
     * @return a list of all OfficeDevice objects
     */
    List<OfficeDevice> getAllOfficeDevices();

    /**
     * Retrieves a list of office devices currently assigned to a specific user.
     *
     * @param userId the ID of the user whose devices are to be retrieved
     * @return a list of OfficeDevice objects assigned to the user
     */
    List<OfficeDevice> getUserOfficeDevices(int userId);

    /**
     * Creates a new office device with the specified name.
     *
     * @param name the name of the device to create
     * @return true if the device was created successfully,
     * false otherwise
     */
    boolean createDevice(String name);

    /**
     * Deletes an office device by its ID.
     *
     * @param deviceId the ID of the device to delete
     * @return true if the device was deleted successfully,
     * false otherwise
     */
    boolean deleteDevice(int deviceId);

    /**
     * Returns all office devices that are currently assigned to a specific user.
     *
     * @param userId the ID of the user whose devices are to be returned
     * @return true if all devices were returned successfully,
     * false otherwise
     */
    boolean backAllUserDevices(int userId);

    /**
     * Returns a specific office device by its ID.
     *
     * @param deviceId the ID of the device to return
     * @return true if the device was returned successfully,
     * false otherwise
     */
    boolean backDevice(int deviceId);

    /**
     * Assigns a specific office device to a user.
     *
     * @param userId   the ID of the user to whom the device is assigned
     * @param deviceId the ID of the device to assign
     * @return true if the device was assigned successfully,
     * false otherwise
     */
    boolean giveDevice(int userId, int deviceId);

    /**
     * Retrieves the ID of the user to whom a specific device is currently assigned.
     *
     * @param deviceId the ID of the device
     * @return the user ID if the device is assigned, or -1 if the device is free
     */
    int getDeviceUser(int deviceId);
}
