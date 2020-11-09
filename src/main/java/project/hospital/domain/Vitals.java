package project.hospital.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Vitals {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long vitalId;
	private String firstName;
	private String lastName;
	private Double temp;
	private Integer respiratoryRate;
	private Integer pulseRate;
	private Integer systolic;
	private Integer diastolic;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vitals")
	private List<Patient> patients;
	
	public Vitals() {
		
	}
	
	public Vitals(String firstName, String lastName, Double temp, Integer respiratoryRate, Integer pulseRate, Integer systolic, Integer diastolic ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.temp = temp;
		this.respiratoryRate = respiratoryRate;
		this.pulseRate = pulseRate;
		this.systolic = systolic;
		this.diastolic = diastolic;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Integer getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Integer respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public Integer getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Integer getSystolic() {
		return systolic;
	}

	public void setSystolic(Integer systolic) {
		this.systolic = systolic;
	}

	public Integer getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(Integer diastolic) {
		this.diastolic = diastolic;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
}