/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientvitals.api.impl;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.patientvitals.PatientVitals;
import org.openmrs.module.patientvitals.api.PatientvitalsService;
import org.openmrs.module.patientvitals.api.dao.PatientvitalsDao;
import org.openmrs.module.patientvitals.api.dao.PatientvitalsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Qualifier("patientvitalsServiceImpl")
public class PatientvitalsServiceImpl extends BaseOpenmrsService implements PatientvitalsService, PatientVitalsService<PatientVitals> {
	
	PatientvitalsDao dao;
	
	UserService userService;
	
	@Autowired(required = true)
	@Qualifier(value = "patientvitalsDaoImpl")
	PatientvitalsDaoImpl ptdao;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(PatientvitalsDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//
	public PatientVitals getItemByUuid(String uuid) throws APIException {
		return dao.getItemByUuid(uuid);
	}
	
	@Override
	public PatientVitals saveItem(PatientVitals item) throws APIException {
		if (item.getOwner() == null) {
			item.setOwner(userService.getUser(1));
		}
		return dao.saveItem(item);
	}
	
	//get all patient vitals
	public List<PatientVitals> getAllVitals() throws DataAccessException {
		return ptdao.getAllItems();
	}
	
	//add patient
	public void addItem(PatientVitals pt) throws DataAccessException {
		ptdao.saveItem(pt);
	}
	
	//update item
	public void updateItem(PatientVitals pt) throws DataAccessException {
		ptdao.updateItem(pt);
	}
	
	//get item by ID
	public PatientVitals getItemById(int id) throws DataAccessException {
		return ptdao.getItemById(id);
	}
	
	//get item by name
	public PatientVitals getItemByName(String itemName) throws DataAccessException {
		return ptdao.getItemByName(itemName);
	}
	
	//remove item by id
	public void removeItem(int id) throws DataAccessException {
		ptdao.removeItem(id);
	}
	
	//remove item by name
	public void removeItemByName(String Name) throws DataAccessException {
		ptdao.removeItemByName(Name);
	}
	
	//remove all items
	public void removeAllItems() throws DataAccessException {
		ptdao.removeAllItems();
	}
}
