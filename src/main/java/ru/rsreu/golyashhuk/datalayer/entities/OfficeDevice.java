package ru.rsreu.golyashhuk.datalayer.entities;

import java.sql.Timestamp;

/**
 * The OfficeDevice class represents a device in an office environment.
 * It extends the AbstractEntity class, inheriting the ID property,
 * and includes additional properties specific to office devices,
 * such as the device's name, the user associated with the device,
 * and timestamps for when the device was received and removed.
 */
public class OfficeDevice extends AbstractEntity {
    private String name;
    private User user;
    private Timestamp timeReceiving;
    private Timestamp timeRemoving;

    /**
     * Default constructor that initializes a new instance of OfficeDevice.
     */
    public OfficeDevice() {
    }

    /**
     * Retrieves the name of the office device.
     *
     * @return the name of the device
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the office device.
     *
     * @param name the new name for the device
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the timestamp of when the device was received.
     *
     * @return the timestamp of receiving the device
     */
    public Timestamp getTimeReceiving() {
        return timeReceiving;
    }

    /**
     * Sets the timestamp for when the device was received.
     *
     * @param timeReceiving the new timestamp for receiving the device
     */
    public void setTimeReceiving(Timestamp timeReceiving) {
        this.timeReceiving = timeReceiving;
    }

    /**
     * Retrieves the user associated with the office device.
     *
     * @return the user of the device
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the office device.
     *
     * @param user the new user for the device
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Retrieves the timestamp of when the device was removed.
     *
     * @return the timestamp of removing the device
     */
    public Timestamp getTimeRemoving() {
        return timeRemoving;
    }

    /**
     * Sets the timestamp for when the device was removed.
     *
     * @param timeRemoving the new timestamp for removing the device
     */
    public void setTimeRemoving(Timestamp timeRemoving) {
        this.timeRemoving = timeRemoving;
    }
}
