package project.hospital.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	public int id;
	private String firstName;
	private String lastName;
	private int age;
	private String sex;
	private String diagnosis;
	private String modeOfTransmission;
	
    @ManyToOne
	@JoinColumn(name = "vitalId")
	@JsonManagedReference
	 
	    private Vitals vitals;
	
	public Patient() {
		this.id=0;
		this.firstName= null;
		this.lastName= null;
		this.age= 0;
		this.sex= null;
		this.diagnosis= null;
		this.modeOfTransmission= null;
	}


	public Patient(int id, String firstName, String lastName, int age, String sex, String diagnosis, String modeOfTransmission) {
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.sex=sex;
		this.diagnosis=diagnosis;
		this.modeOfTransmission=modeOfTransmission;
	}
	
	public Patient(String firstName, String lastName, int age, String sex, String diagnosis, String modeOfTransmission) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.sex=sex;
		this.diagnosis=diagnosis;
		this.modeOfTransmission=modeOfTransmission;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getModeOfTransmission() {
		return modeOfTransmission;
	}

	public void setModeOfTransmission(String modeOfTransmission) {
		this.modeOfTransmission = modeOfTransmission;
	}
	
	@Override
	public String toString() {
		return "Patient [id =" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", sex=" + sex + ", diagnosis=" + diagnosis + ", modeOfTransmission=" + modeOfTransmission + "]";
	}
}