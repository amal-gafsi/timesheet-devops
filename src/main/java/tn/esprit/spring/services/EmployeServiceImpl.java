package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger L = LogManager.getLogger(EmployeServiceImpl.class);  
	
	@Override
	public List<Employe> retrieveAllEmployes() { 
		List<Employe> employes = null; 
		try {
	
			L.info("In method retrieveAllEmployes : "); 
			employes = (List<Employe>) employeRepository.findAll();  
			for (Employe employe : employes) {
				L.debug("employe : " + employe.getNom());   
			} 
			L.info("Out of method retrieveAllEmployes with success" +employes.size()); 
		}catch (Exception e) {
			L.error("Out of method retrieveAllEmployes : " + e);
		}

		return employes;
	}


	@Override
	public Employe addEmploye(Employe emp) {
		L.info("In method addEmploye : "); 
		Employe emp_saved = employeRepository.save(emp); 
		L.info("Out of method addEmploye with success"); 
		return emp_saved; 
	}

	@Override 
	public Employe updateEmploye(Employe emp) { 
		L.info("In method updateEmploye : ");
		Employe emp_saved = employeRepository.save(emp); 
		L.info("Out of method updateEmploye with success : "); 
		return emp_saved; 
	}

	@Override
	public void deleteEmploye(String id) {
		L.info("In method deleteEmploye : ");
		employeRepository.deleteById(Long.parseLong(id)); 
		L.info("Out of method deleteEmploye with success : "); 
	}

	@Override
	public Employe retrieveEmploye(String id) {
		L.info("In method retrieveEmploye : "); 
		//Employe emp =  employeRepository.findById(Long.parseLong(id)).orElse(null);
		Employe emp =  employeRepository.findById(Long.parseLong(id)).get(); 
		L.info("Out of method retrieveEmploye with success : "); 
		return emp; 
	}

}
