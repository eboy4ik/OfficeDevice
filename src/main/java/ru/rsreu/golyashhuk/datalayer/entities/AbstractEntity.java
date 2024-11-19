package ru.rsreu.golyashhuk.datalayer.entities;

/**
 * The AbstractEntity class serves as a base class for all entities in the data layer.
 * It encapsulates a common identifier (ID) for all entities, providing methods to
 * get and set the ID value.
 */
public abstract class AbstractEntity {
	private int id;

	/**
	 * Default constructor that initializes a new instance of AbstractEntity.
	 */
	public AbstractEntity() {
	}

	/**
	 * Constructs a new instance of AbstractEntity with a specified ID.
	 *
	 * @param id the identifier for the entity
	 */
	public AbstractEntity(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the identifier (ID) of the entity.
	 *
	 * @return the ID of the entity
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the identifier (ID) for the entity.
	 *
	 * @param id the new ID to be assigned to the entity
	 */
	public void setId(int id) {
		this.id = id;
	}
}
