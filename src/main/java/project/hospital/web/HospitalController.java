package project.hospital.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.hospital.domain.Category;
import project.hospital.domain.CategoryRepository;
import project.hospital.domain.Patient;
import project.hospital.domain.PatientRepository;
import project.hospital.domain.UserClass;
import project.hospital.domain.UserRepository;

@Controller
public class HospitalController {
	
	@Autowired
	private PatientRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;
	
	@RequestMapping(value={"/login", "/", "/home"})
	public String login() {
		return "login";
	} 
	
    @RequestMapping(value="/patientlist", method=RequestMethod.GET)
    public String patientList(Model model) {	
    	model.addAttribute("category", new Category());
        model.addAttribute("patients", repository.findAll());
        model.addAttribute("categories", crepository.findAll());
        return "patientlist";
    }
    
	@RequestMapping(value="/patientlist", method=RequestMethod.POST)
	public String patientSearch(Category category, Model model) {
		List<Patient> patients = repository.findByCategory(crepository.findById(category.getCategoryId()).get());
		
		model.addAttribute("patients", patients);
		model.addAttribute("category", new Category());
		model.addAttribute("categories", crepository.findAll());
		return "patientlist";
	}
    
    @RequestMapping(value="/patients", method = RequestMethod.GET)
    public @ResponseBody List<Patient> patientListRest() {	
       return (List<Patient>) repository.findAll();
    }  
    
    @RequestMapping(value="/patient/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Patient> findPatientRest(@PathVariable("id") Long patientId) {	
    	return repository.findById(patientId);
    }       
   
    @RequestMapping(value = "/add")
    public String addPatient(Model model){
    	model.addAttribute("patient", new Patient());
    	model.addAttribute("categories", crepository.findAll());
        return "addPatient";
    }    
         
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Patient patient, Category category){
        repository.save(patient);
        crepository.save(category);
        return "redirect:patientlist";
    }    
    
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showPatient(@PathVariable("id") Long patientId, Model model) {
    	Optional<Patient> optionalPatient = repository.findById(patientId);
    	Patient patient = optionalPatient.get();
    	model.addAttribute("patient", patient);
    	model.addAttribute("categories", crepository.findAll());
        return "second";
    } 
        
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePatient(@PathVariable("id") Long patientId, Model model) {
    	repository.deleteById(patientId);
        return "redirect:../patientlist";
    } 
    
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String editPatient(@PathVariable("id") Long patientId, Model model) {
    	model.addAttribute("patient", repository.findById(patientId));
    	model.addAttribute("categories", crepository.findAll());
    	return "modifyPatient";
    }  
    
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public String PatientSubmit(@ModelAttribute Patient patient, Category category) {
		repository.save(patient);
		crepository.save(category);
		return "redirect:/patientlist";
	}
	
	@RequestMapping(value="/editVs")
	public String editVitals() {
		return "editVs";
	} 
	
	@RequestMapping(value="/addMeds")
	public String addMedications() {
		return "addMeds";
	} 
	
	@RequestMapping(value="/addOrders")
	public String addOrders() {
		return "addOrders";
	} 
	
	@RequestMapping(value="/dischargeForm")
	public String dischargeForm() {
		return "dischargeForm";
	} 
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "logout";
	} 
	
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(UserClass userClass){
        urepository.save(userClass);
        return "redirect:userlist";
    }  

    @RequestMapping(value="/userlist")
    public String userList(Model model) {	
        model.addAttribute("userClasses", urepository.findAll());
        return "userlist";
    }
    
    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") Long userId, Model model) {
    	urepository.deleteById(userId);
        return "redirect:../userlist";
    } 
    
	@RequestMapping(value={"/forgotPassword"})
	public String forgot() {
		return "forgotPassword";
	} 
	
	@RequestMapping(value="/profile")
	public String profile() {
		return "profile";
	} 
	
	@RequestMapping("/register")
	public String submitForm() {
	    return "success";
	}
	
}
