/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientvitals;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the PatientVitals class persistable, see also PatientvitalsDaoTest and liquibase.xml
@Entity(name = "patientvitals.PatientVitals")
@Table(name = "patientvitals_item")
public class PatientVitals extends BaseOpenmrsData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "patientvitals_item_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	@Basic
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "height")
	private float height;
	
	@Column(name = "bmi")
	private float bmi;
	
	@Column(name = "pulse_rate")
	private int pulse_rate;
	
	@Column(name = "temperature")
	private int temperature;
	
	@Column(name = "blood_pressure")
	private String blood_pressure;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getBmi() {
		return bmi;
	}
	
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
	
	public int getPulse_rate() {
		return pulse_rate;
	}
	
	public void setPulse_rate(int pulse_rate) {
		this.pulse_rate = pulse_rate;
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	public String getBlood_pressure() {
		return blood_pressure;
	}
	
	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	
}
