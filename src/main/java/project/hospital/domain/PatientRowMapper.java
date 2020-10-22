package project.hospital.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PatientRowMapper implements RowMapper<Patient> {

	@Override
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patient patient = new Patient(); 
		patient.setFirstName(rs.getString("firstName"));
		patient.setLastName(rs.getString("lastName"));
		patient.setAge(rs.getInt("age"));
		patient.setSex(rs.getString("sex"));
		patient.setDiagnosis(rs.getString("diagnosis"));
		patient.setModeOfTransmission(rs.getString("modeOfTransmission"));
		
		return patient;
	}
}