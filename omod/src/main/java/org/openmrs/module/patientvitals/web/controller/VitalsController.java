package org.openmrs.module.patientvitals.web.controller;

import java.util.List;

import org.openmrs.module.patientvitals.PatientVitals;
import org.openmrs.module.patientvitals.api.impl.PatientvitalsServiceImpl;
import org.openmrs.ui.framework.annotation.InjectBeans;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VitalsController {
	
	//@Autowired
	//@Qualifier("patientvitalsServiceImpl")
	PatientvitalsServiceImpl ptservc;
	
	//Save  patient Vitals
	
	public void save() {
		
	}
	
	public String getPage(@RequestParam(value = "patientId", required = false) @InjectBeans PageModel model) {
		model.addAttribute("name", ptservc.getItemById(0));
		return "capturevitals";
		
	}
	
	public PatientVitals getPatientVital() {
		return null;
		
	}
	
	public void UpDateVital() {
		
	}
	
	public void deleteVital() {
		
	}
	
	public List<PatientVitals> fetchAllVitals() {
		return null;
		
	}
	
}
