package ru.rsreu.golyashhuk.datalayer;

public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract UserDataDAO getUserPasswordDAO();
	public abstract OfficeDeviceDAO getOfficeDeviceDAO();
	public abstract QueryDAO getQueryDAO();

}
