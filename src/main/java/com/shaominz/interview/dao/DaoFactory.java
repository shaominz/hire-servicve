package com.shaominz.interview.dao;

import com.shaominz.interview.db_service.DbService;
import com.shaominz.interview.model.Bike;
import com.shaominz.interview.model.Car;
import com.shaominz.interview.model.HireRecord;
import com.shaominz.interview.model.IHirable.HirableType;

@SuppressWarnings("rawtypes")
public class DaoFactory implements IDaoFactory {

	private static DbService dbService;
	private static String connectionDetails = "connectionDetails";
	
	private static IHireRecordDao<HireRecord> carHireRecordDao = new CarHireRecordDao(dbService, connectionDetails);
	private static IHireRecordDao<HireRecord> bikeHireRecordDao = new BikeHireRecordDao(dbService, connectionDetails);
	private static IDao<Car> carDao = new CarDao(dbService, connectionDetails);
	private static IDao<Bike> bikeDao = new BikeDao(dbService, connectionDetails);

	private static final IDaoFactory DAO_FACTORY = new DaoFactory();
	
	public static IDaoFactory getInstance() {
		return DAO_FACTORY;
	}
	
	private DaoFactory() {
	}
 
	public IHireRecordDao getHireRecordDao(HirableType type) {
		return (type == HirableType.CAR) ? carHireRecordDao : bikeHireRecordDao;
	}

	public IDao getDao(HirableType type) {
		return (type == HirableType.CAR) ? carDao : bikeDao;
	}

	/* for test purpose */
	static void setCarHireRecordDao(IHireRecordDao<HireRecord> carHireRecordDao) {
		DaoFactory.carHireRecordDao = carHireRecordDao;
	}

	static void setBikeHireRecordDao(IHireRecordDao<HireRecord> bikeHireRecordDao) {
		DaoFactory.bikeHireRecordDao = bikeHireRecordDao;
	}

	static void setCarDao(IDao<Car> carDao) {
		DaoFactory.carDao = carDao;
	}

	static void setBikeDao(IDao<Bike> bikeDao) {
		DaoFactory.bikeDao = bikeDao;
	}
	/* for test purpose */

}
