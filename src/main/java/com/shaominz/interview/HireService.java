package com.shaominz.interview;

import java.sql.SQLException;
import java.util.Date;

import com.shaominz.interview.dao.DaoFactory;
import com.shaominz.interview.dao.IHireRecordDao;
import com.shaominz.interview.model.HireRecord;
import com.shaominz.interview.model.HireRecord.HireState;
import com.shaominz.interview.model.IHirable.HirableType;
import com.shaominz.interview.utils.IdGenerator;


/*
 * Main hire service class
 */
@SuppressWarnings("rawtypes")
public class HireService {
	
	//called by rest servlet to make booking
	public long hire(HirableType type, int itemId, int clientId, Date startDate, int days, double rate) {
		if (itemId <= 0) throw new IllegalArgumentException(String.format("%s id must be greater than 0: %d", type, itemId));
		if (clientId <= 0) throw new IllegalArgumentException(String.format("client id must be greater than 0: %d", clientId));
		if (startDate == null) throw new IllegalArgumentException(String.format("startDate can't be null"));
		if (rate <= 0.0) throw new IllegalArgumentException(String.format("rate must be greater than 0: %s", rate));
		
		try {
			return hireItem(type, itemId, clientId, startDate, days, rate);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HireException(e.getMessage(), e);
		}
	}
	
	public void markReturned(HirableType type, int itemId) {
		if (itemId <= 0) throw new IllegalArgumentException(String.format("%s id must be greater than 0: %d", type, itemId));

		try {
			returnItem(type, itemId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HireException(e.getMessage(), e);
		}
	}
	
	int hireItem(HirableType type, int itemId, int clientId, Date startDate, int days, double rate) throws SQLException {
		IHireRecordDao hireRecordDao = DaoFactory.getInstance().getHireRecordDao(type);
		HireRecord hireRecord = hireRecordDao.getLatestRecordByCarId(itemId);

		if (isItemAvailable(hireRecord)) {
			int hireId = IdGenerator.hireIdGenerator.getNextId(); 
			HireRecord newHireRecord = new HireRecord(hireId, itemId, clientId, startDate, null, rate);
			hireRecordDao.save(newHireRecord);
			return newHireRecord.getId();
		} else {
			throw new HireException(String.format("%s %d is not available for hire", type, itemId));
		}
	}
	
	void returnItem(HirableType type, int itemId) throws SQLException {
		IHireRecordDao hireRecordDao = DaoFactory.getInstance().getHireRecordDao(type);
		HireRecord hireRecord = hireRecordDao.getLatestRecordByCarId(itemId);

		if (!isItemAvailable(hireRecord)) {
			hireRecord.setEndDate(new Date());
			hireRecordDao.save(hireRecord);
		} else if (hireRecord == null){
			throw new HireException(String.format("can't find hire record for: %s %d", type, itemId));
		} else {
			throw new HireException(String.format("%s %d is already returned", type, itemId));
		}
	}
	
	boolean isItemAvailable(HireRecord hireRecord) {
		if (hireRecord == null) {
			// no hire record for the item, it is available for hire
			return true; 
		} else if (hireRecord.getState() == HireState.RETURNED) {
			return true; 
		}
		
		return false;
	}
}
