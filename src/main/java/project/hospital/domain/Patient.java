package project.hospital.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	public Long id;
	private String firstName;
	private String lastName;
	private int age;
	private String sex;
	private String diagnosis;
	private String modeOfTransmission;
	
    @ManyToOne
	@JoinColumn(name = "categoryId")
	@JsonManagedReference
	private Category category;
    
    @JsonBackReference
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "patient", orphanRemoval = true)
	private List<Medicine> medicines;
	
	public Patient() {
		super();
		this.medicines = new ArrayList<Medicine>();
	}
	
	public Patient(String firstName, String lastName, int age, String sex, String diagnosis, String modeOfTransmission, Category category) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.sex=sex;
		this.diagnosis=diagnosis;
		this.modeOfTransmission=modeOfTransmission;
		this.category=category;
		this.medicines = new ArrayList<Medicine>();
	}
	
	public Patient(String firstName, String lastName, int age, String sex, String diagnosis, String modeOfTransmission, Category category, List<Medicine> medicines) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.sex=sex;
		this.diagnosis=diagnosis;
		this.modeOfTransmission=modeOfTransmission;
		this.category=category;
		this.medicines = medicines;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	public void addMedicine(Medicine medicine) {
		medicines.add(medicine);
        medicine.setPatient(this);
    }
 
    public void removeMedicine(Medicine medicine) {
    	medicine.setPatient(null);
        this.medicines.remove(medicine);
    }
    
	@Override
	public String toString() {
		return "Patient [id =" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", sex=" + sex + ", diagnosis=" + diagnosis + ", modeOfTransmission=" + modeOfTransmission + "]";
	}
}