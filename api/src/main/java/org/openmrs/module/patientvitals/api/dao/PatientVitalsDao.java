package org.openmrs.module.patientvitals.api.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface PatientVitalsDao<item> {
	
	public List<item> getAllItems() throws DataAccessException;
	
	public void addItem(item fm) throws DataAccessException;
	
	public void updateItem(item fm) throws DataAccessException;
	
	public item getItemById(int id) throws DataAccessException;
	
	public item getItemByName(String itemName) throws DataAccessException;
	
	public void removeItem(int id) throws DataAccessException;
	
	public void removeItemByName(String Name) throws DataAccessException;
	
	public void removeAllItems() throws DataAccessException;
	
}
