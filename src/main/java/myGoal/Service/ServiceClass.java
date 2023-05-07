package myGoal.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import myGoal.Entity.EntityClass;
import myGoal.ExceptionHandler.DBisEmptyException;
import myGoal.ExceptionHandler.IdAlreadyExistsException;
import myGoal.ExceptionHandler.IdNotFoundException;
import myGoal.Repository.RepositoryClass;
import myGoal.Response.ResponseClass;

@Service
public class ServiceClass {

	@Autowired
	private RepositoryClass repositoryClass;
	
	Logger logger = LoggerFactory.getLogger(ServiceClass.class);
	
	public ResponseClass saveDetail(EntityClass entityClass) {
		logger.debug("Debugging....");
        if (repositoryClass.existsById(entityClass.getId2())) {
        	logger.warn("Checking Id");
        	logger.error("User id already exist");
            throw new IdAlreadyExistsException();
        }
        logger.warn("Checking Id");
        logger.info("created successfully");
        return new ResponseClass(HttpStatus.CREATED,repositoryClass.save(entityClass),"Created SuccessFully");
    }
	
	public ResponseClass getElementById(int id) throws IdNotFoundException {
		logger.debug("Debugging....");
        if (repositoryClass.findById(id).isEmpty()) {
        	logger.warn("Checking Id");
        	logger.error("User id not exist ");
            throw new IdNotFoundException();
        } else {
        	repositoryClass.findById(id).get();
        }
        logger.warn("Checking Id");
        logger.info("Information retrieved successfully");
        return new ResponseClass(HttpStatus.OK,repositoryClass.findById(id),"Retrived Successfully");
    }
	
	public ResponseClass getAllElement() throws DBisEmptyException {
		logger.debug("Debugging....");
        if (repositoryClass.findAll().isEmpty()) {
        	logger.warn("Checking DB");
        	logger.error("Table is Empty");
            throw new DBisEmptyException();
        } else {
        	repositoryClass.findAll();
        }
        logger.warn("Checking Id");
        logger.info("Information retrieved successfully");
        return new ResponseClass(HttpStatus.OK,repositoryClass.findAll(),"All Informations Retrived Successfully");
    }
	

	public void deleteById(int id) throws IdNotFoundException {
        if (repositoryClass.findById(id).isEmpty()) {
            throw new IdNotFoundException();
        } else {
        	repositoryClass.deleteById(id);
        }
    }

	public void DeleteAll() {
		repositoryClass.deleteAll();
	}

}
