package myGoal.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "my_goal_entity2")
public class EntityClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id2;
	
	private String Email;

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id") 
	private MyGoalEntity myGoalEntity;

	public MyGoalEntity getMyGoalEntity() {
		return myGoalEntity;
	}

	public void setMyGoalEntity(MyGoalEntity myGoalEntity) {
		this.myGoalEntity = myGoalEntity;
	}
}
