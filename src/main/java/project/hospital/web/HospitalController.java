package project.hospital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.hospital.domain.Patient;
import project.hospital.domain.PatientRepository;

@Controller
public class HospitalController {
	
	@Autowired
	private PatientRepository repository;
	
	@RequestMapping(value={"/", "/home"})
	public String homepage() {
		return "homepage";
	} 
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	} 
	
    @RequestMapping(value="/patientlist")
    public String patientList(Model model) {	
        model.addAttribute("patients", repository.findAll());
        return "patientlist";
    }
    
    //@RequestMapping(value="/patients", method = RequestMethod.GET)
    //public @ResponseBody List<Patient> patientListRest() {	
    //    return (List<Patient>) repository.findAll();
   // }  
    
    //@RequestMapping(value="/patient/{id}", method = RequestMethod.GET)
    //public @ResponseBody Optional<Patient> findPatientRest(@PathVariable("id") int patientId) {	
    //	return repository.findById(patientId);
    //}       
   
    @RequestMapping(value = "/add")
    public String addPatient(Model model){
    	model.addAttribute("patient", new Patient());
        return "addPatient";
    }    
         
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Patient patient){
        repository.save(patient);
        return "redirect:patientlist";
    }    
    
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showPatient(@PathVariable("id") Long patientId, Model model) {
    	model.addAttribute("patient", repository.findById(patientId));
        return "homepage";
    } 
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePatient(@PathVariable("id") Long patientId, Model model) {
    	repository.deleteById(patientId);
        return "redirect:../patientlist";
    } 
    
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String editPatient(@PathVariable("id") Long patientId, Model model) {
    	model.addAttribute("patient", repository.findById(patientId));
    	repository.deleteById(patientId);
    	return "modifyPatient";
    }  
    
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public String PatientSubmit(@ModelAttribute Patient patient) {
		repository.save(patient);
		return "redirect:/patientlist";
	}
	
	@RequestMapping(value="/editVs")
	public String editVitals() {
		return "editVs";
	} 
}
