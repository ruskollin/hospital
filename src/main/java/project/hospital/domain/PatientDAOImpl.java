package project.hospital.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAOImpl implements PatientDAO {  

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate jdbcTemplate() {
	    return new JdbcTemplate();
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(Patient patient) {
		String sql = "INSERT INTO patient(first_name, last_name, age, sex, diagnosis, mode_of_transmission) VALUES (?,?,?,?,?,?,?)";
		Object[] parameters = new Object[] { patient.getFirstName(),
				patient.getLastName(), patient.getAge(), patient.getSex(), patient.getDiagnosis(), patient.getModeOfTransmission()};

		jdbcTemplate.update(sql, parameters);

	}

	@Override
	public Patient findOne(int id) {
		String sql = "SELECT id, first_name, last_name from patient WHERE id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Patient> mapper = new PatientRowMapper();

		Patient patient = jdbcTemplate.queryForObject(sql, parameters, mapper);
		return patient;

	}

	@Override
	public List<Patient> findAll() {

		String sql = "SELECT id, first_name, last_name, age, sex, diagnosis, mode_of_transmission from patient";
		RowMapper<Patient> mapper = new PatientRowMapper();
		List<Patient> patients = jdbcTemplate.query(sql, mapper);

		return patients;
	}
}
