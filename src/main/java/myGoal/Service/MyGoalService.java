 package myGoal.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import myGoal.Entity.MyGoalEntity;
import myGoal.ExceptionHandler.DBisEmptyException;
import myGoal.ExceptionHandler.IdAlreadyExistsException;
import myGoal.ExceptionHandler.IdNotFoundException;
import myGoal.ExceptionHandler.NumberNotFoundException;
import myGoal.Repository.MyGoalRepository;
import myGoal.Response.ResponseClass;

@Service
public class MyGoalService {

	@Autowired
	MyGoalRepository myGoalRepository;
	
	Logger logger = LoggerFactory.getLogger(MyGoalService.class);
	
	public ResponseClass save(MyGoalEntity myGoalEntity) {
		logger.debug("Debugging....");
        if (myGoalRepository.existsById(myGoalEntity.getId())) {
        	logger.warn("Checking Id");
        	logger.error("User id already exist");
            throw new IdAlreadyExistsException();
        }
        logger.warn("Checking Id");
        logger.info("created successfully");
        return new ResponseClass(HttpStatus.CREATED,myGoalRepository.save(myGoalEntity),"Created SuccessFully");
    }
	
	public ResponseClass getElementById(int id) throws IdNotFoundException {
		logger.debug("Debugging....");
        if (myGoalRepository.findById(id).isEmpty()) {
        	logger.warn("Checking Id");
        	logger.error("User id not exist ");
            throw new IdNotFoundException();
        } else {
        	myGoalRepository.findById(id).get();
        }
        logger.warn("Checking Id");
        logger.info("Information retrieved successfully");
        return new ResponseClass(HttpStatus.OK,myGoalRepository.findById(id),"Retrived Successfully");
    }
	
	public ResponseClass getAllElement() throws DBisEmptyException {
		logger.debug("Debugging....");
        if (myGoalRepository.findAll().isEmpty()) {
        	logger.warn("Checking DB");
        	logger.error("Table is Empty");
            throw new DBisEmptyException();
        } else {
        	myGoalRepository.findAll();
        }
        logger.warn("Checking Id");
        logger.info("Information retrieved successfully");
        return new ResponseClass(HttpStatus.OK,myGoalRepository.findAll(),"All Informations Retrived Successfully");
    }
	

	public ResponseClass deleteById(int id) throws IdNotFoundException {
        if (myGoalRepository.findById(id).isEmpty()) {
        	logger.warn("Checking Id");
        	logger.error("User id not exist ");
            throw new IdNotFoundException();
        } else {
        	Optional<MyGoalEntity> res = myGoalRepository.findById(id);
        	myGoalRepository.deleteById(id);
        	logger.warn("Checking Id");
            logger.info("Information retrieved successfully");
            return new ResponseClass(HttpStatus.OK,res,"Deleted Successfully");
        }
    }
	
	
	public ResponseClass getByNum(int number) throws NumberNotFoundException {
		if(myGoalRepository.findByNumber(number).isEmpty()) {
			logger.warn("Checking Id");
        	logger.error("Number not exist ");
			 throw new NumberNotFoundException();
		}else 
			logger.warn("Checking Id");
        	logger.info("Information retrieved successfully");
        	return new ResponseClass(HttpStatus.OK,myGoalRepository.findByNumber(number),"Retrived Successfully");
	}

	public void deleteByName(String name) {
		myGoalRepository.deleteByName(name);
	}

	public ResponseClass updateNumberByName(String name, int number) {
		
		if(myGoalRepository.findByNumber(number).isEmpty()) {
			logger.warn("Checking Id");
        	logger.error("Number not exist ");
			 throw new NumberNotFoundException();
		}else
			myGoalRepository.updateNumberByName(name,number);
		return new ResponseClass(HttpStatus.OK,"Updated Successfully");
	}

	public MyGoalEntity updateById(MyGoalEntity myGoalEntity) {
		return myGoalRepository.save(myGoalEntity);
	}
}