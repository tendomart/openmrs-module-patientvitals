package org.openmrs.module.patientvitals.api.dao;

import java.util.List;

import org.openmrs.module.patientvitals.PatientVitals;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("patientvitalsDaoImpl")
public class PatientvitalsDaoImpl extends PatientvitalsDao implements PatientVitalsDao<PatientVitals> {
	
	//Get All Patient Vitals
	public List getAllItems() throws DataAccessException {
		return (List) new PatientvitalsDao().sessionFactory.getCurrentSession().createQuery("FROM PatientVitals").list();
	}
	
	//Add patient Vital
	public void addItem(PatientVitals patientvitals) throws DataAccessException {
		new PatientvitalsDao().sessionFactory.getCurrentSession().save(patientvitals);
	}
	
	//Update Patient Vitals
	public void updateItem(PatientVitals fm) throws DataAccessException {
		new PatientvitalsDao().sessionFactory.getCurrentSession().update(fm);
		
	}
	
	//Remove Patient Vitals by name
	public void removeItemByName(String Name) throws DataAccessException {
		new PatientvitalsDao().sessionFactory.getCurrentSession()
		        .createQuery("DELETE FROM PatientVitals WHERE name = :item_name").setParameter("item_name", Name);
	}
	
	//Remove Patient Vitals by Id
	public void removeItem(int id) throws DataAccessException {
		new PatientvitalsDao().sessionFactory.getCurrentSession()
		        .createQuery("DELETE FROM PatientVitals WHERE id = :item_id").setParameter("item_id", id);
	}
	
	//Remove all Patient Vitals
	public void removeAllItems() throws DataAccessException {
		new PatientvitalsDao().sessionFactory.getCurrentSession().createQuery("DELETE FROM PatientVitals");
	}
	
	//Get Patient Vital By Id
	public PatientVitals getItemById(int id) throws DataAccessException {
		return (PatientVitals) new PatientvitalsDao().sessionFactory.getCurrentSession().get(PatientVitals.class, id);
	}
	
	//Get Patient Vital by Name
	public PatientVitals getItemByName(String itemName) throws DataAccessException {
		return (PatientVitals) new PatientvitalsDao().sessionFactory.getCurrentSession()
		        .createQuery("SELECT FROM PatientVitals WHERE name = :item_name").setParameter("item_name", itemName);
	}
}//Close PatientvitalsDaoImpl
