package myGoal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myGoal.Entity.EntityClass;
import myGoal.Response.ResponseClass;
import myGoal.Service.ServiceClass;

@RestController
@RequestMapping("/entity2")
public class ControllerClass {
	
	@Autowired
	private ServiceClass serviceClass;
	
	@PostMapping("/post")
	public ResponseClass save(@RequestBody EntityClass entityClass) {
		return serviceClass.saveDetail(entityClass);
	}
	
	@GetMapping("/get/{id}")
	public ResponseClass getElement(@PathVariable int id) {
		return serviceClass.getElementById(id);
	}
	
	@GetMapping("/get-all")
	public  ResponseClass getAllElement() {
		return serviceClass.getAllElement();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		serviceClass.deleteById(id); 
	}
	
	@DeleteMapping("/delete-all")
	public void deleteAll(@RequestBody EntityClass entityClass) {
		serviceClass.DeleteAll();		
	}
}
