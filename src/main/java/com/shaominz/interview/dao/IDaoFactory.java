package com.shaominz.interview.dao;

import com.shaominz.interview.model.IHirable.HirableType;

@SuppressWarnings("rawtypes")
public interface IDaoFactory {
	IHireRecordDao getHireRecordDao(HirableType type);
	IDao getDao(HirableType type);
}
