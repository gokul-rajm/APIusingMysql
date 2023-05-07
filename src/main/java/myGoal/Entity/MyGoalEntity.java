package myGoal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Entity")
public class MyGoalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private int number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private EntityClass entityClass1;
//	
//	public EntityClass getEntityClass1() {
//		return entityClass1;
//	}
//	public void setEntityClass1(EntityClass entityClass1) {
//		this.entityClass1 = entityClass1;
//	}
//
//	@OneToMany(targetEntity = EntityClass.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "id",referencedColumnName = "id")
//	public List<EntityClass>entityClass = new ArrayList<EntityClass>();
//	
//	public List<EntityClass> getEntityClass() {
//		return entityClass;
//	}
//	public void setEntityClass(List<EntityClass> entityClass) {
//		this.entityClass = entityClass;
//	}	
	
}
