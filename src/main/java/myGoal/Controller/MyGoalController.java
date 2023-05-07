package myGoal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import myGoal.Entity.MyGoalEntity;
import myGoal.Response.ResponseClass;
import myGoal.Service.MyGoalService;

@RestController
@RequestMapping("/myGoal")
public class MyGoalController {

	@Autowired
	MyGoalService myGoalService;
		
//	Logger logger = LoggerFactory.getLogger(ControllerClass.class);
	
	@PostMapping("/post")
	public ResponseClass save(@RequestBody MyGoalEntity myGoalEntity) {
	//	logger.info("this is a info message");
	//	logger.error("this is a error message");
		return myGoalService.save(myGoalEntity);
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseClass getElement(@PathVariable int id) {
	//	logger.warn("this is a warn message");
		return myGoalService.getElementById(id);
	}
	
	@GetMapping("/get-all")
	public ResponseClass getAllElement() {
		return myGoalService.getAllElement();
	}
	
	@PutMapping("/updatebyid/{id}")
	public MyGoalEntity updateById(@PathVariable("id") int id, @RequestBody MyGoalEntity myGoalEntity) {
		return myGoalService.updateById(myGoalEntity);
		
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	public ResponseClass delete(@PathVariable("id") int id) {
		return myGoalService.deleteById(id); 
	}
	
//	@DeleteMapping("/delete-all")
//	public void deleteAll(@RequestBody MyGoalEntity myGoalEntity) {
//		myGoalService.DeleteAll();		
//	}
	
	@GetMapping("/MySql/get/{number}")
	public ResponseClass getByNum(@PathVariable("number") int number) {
		return myGoalService.getByNum(number);
	}
	
	@DeleteMapping("/MySql/delete/{name}")
	public void deleteByNum(@PathVariable("name") String name) {
		myGoalService.deleteByName(name);
	}
	
	@PutMapping("/update")
	public ResponseClass updateNumberByName(@RequestParam("name") String name, @RequestParam("number") int number) {
		return myGoalService.updateNumberByName(name, number);
	}
}



