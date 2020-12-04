package project.hospital.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vitals {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long vitalsId;
	private double temp; 
	private int pulse;
	private int resp;
	private int sys;
	private int dia;
	
	@ManyToOne
    @JoinColumn(name="id")
	@JsonManagedReference
	private Patient patient;
	
	public Vitals() {
		super();
	}
	
	public Vitals(double temp, int pulse, int resp, int sys, int dia) {
		super();
		this.temp = temp;
		this.pulse = pulse;
		this.resp = resp;
		this.sys = sys;
		this.dia = dia;
	}
	
	public Vitals(double temp, int pulse, int resp, int sys, int dia, Patient patient) {
		super();
		this.temp = temp;
		this.pulse = pulse;
		this.resp = resp;
		this.sys = sys;
		this.dia = dia;
		this.patient = patient;
	}

	public long getVitalsId() {
		return vitalsId;
	}

	public void setVitalsId(long vitalsId) {
		this.vitalsId = vitalsId;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public int getResp() {
		return resp;
	}

	public void setResp(int resp) {
		this.resp = resp;
	}

	public int getSys() {
		return sys;
	}

	public void setSys(int sys) {
		this.sys = sys;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}

