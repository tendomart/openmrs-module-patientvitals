package org.openmrs.module.patientvitals.api.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface PatientVitalsService<patientvital> {
	
	public List<patientvital> getAllVitals() throws DataAccessException;
	
	public void addItem(patientvital pt) throws DataAccessException;
	
	public void updateItem(patientvital pt) throws DataAccessException;
	
	public patientvital getItemById(int id) throws DataAccessException;
	
	public patientvital getItemByName(String itemName) throws DataAccessException;
	
	public void removeItem(int id) throws DataAccessException;
	
	public void removeItemByName(String Name) throws DataAccessException;
	
	public void removeAllItems() throws DataAccessException;
}
