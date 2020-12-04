package project.hospital.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Medicine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long medId;
	private String medicine; 
	private int dose;
	private String unit;
	private String route;
	private String frequency;
	
	@ManyToOne
    @JoinColumn(name="id")
	@JsonManagedReference
	private Patient patient;
	
	public Medicine() {
		super();
	}
	
	public Medicine(String medicine, int dose, String unit, String route, String frequency) {
		super();
		this.medicine = medicine;
		this.dose = dose;
		this.unit = unit;
		this.dose = dose;
		this.route = route;
		this.frequency = frequency;
	}
	
	public Medicine(String medicine, int dose, String unit, String route, String frequency, Patient patient) {
		super();
		this.medicine = medicine;
		this.dose = dose;
		this.unit = unit;
		this.dose = dose;
		this.route = route;
		this.frequency = frequency;
		this.patient = patient;
	}

	public long getMedId() {
		return medId;
	}

	public void setMedId(long medId) {
		this.medId = medId;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
