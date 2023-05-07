package myGoal.Repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import myGoal.Entity.MyGoalEntity;

public interface MyGoalRepository extends JpaRepository<MyGoalEntity, Integer> {

	
	@Query("SELECT u FROM MyGoalEntity u WHERE u.number = ?1")
	List<MyGoalEntity> findByNumber(Integer number);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM MyGoalEntity WHERE name = ?1")
	void deleteByName(String name);

	
	@Modifying
	@Transactional
	@Query("UPDATE MyGoalEntity u SET u.name = :name WHERE u.number = :number")
	void updateNumberByName(String name,int number);
	
	
	//Native Query
//		@Query(value="SELECT * FROM entity u WHERE u.number = ?1",nativeQuery=true)
//		List<EntityClass> findUserByStatus(Integer number);
}
