package service;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Employee;

public class EmployeeService {
	
	//创建一个实体管理器工厂
	 public static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa_test");
	//通过实体管理器工厂船建一个实体管理器
	 public static EntityManager entityManager = emfactory.createEntityManager();
	 
	 
	public static void main(String[] args) {
		//insertEmployee(88, "baidu", 2, 50000);
		
//		Employee fingEmp = fingEmp(2);
//		System.out.println(fingEmp);
		
		Employee updateEmp = updateEmp(66, "taiji", 2, 66666);
		System.out.println(updateEmp);
		
		//deleteEmp(3);
		
	}
	
	//增加
	public static void insertEmployee(long id,String name,int did,double sal) {
		//开启实体管理器
		entityManager.getTransaction().begin();
		
		Employee employee = new Employee(); 
		employee.setEmpId(id);
		employee.setName(name);
		employee.setSalary(sal);
		employee.setDeptId(did);
		//提交
		System.out.println(employee);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		//关闭
		entityManager.close();
		emfactory.close();
		
	}
     //查找
	public static Employee fingEmp(long id) {
		//开启实体管理器
		entityManager.getTransaction().begin();
		Employee find = entityManager.find(Employee.class,id);
		
		//关闭
		entityManager.close();
		emfactory.close();
		
		return find; 
	}
	
	
	//更新
	public static Employee updateEmp(long id,String name,int did,double sal) {
		//开启实体管理器
		entityManager.getTransaction().begin();
		
		Employee find = entityManager.find(Employee.class,id);
		find.setDeptId(did);
		find.setName(name);
		find.setSalary(sal);
		//提交
		System.out.println(find);
		entityManager.getTransaction().commit();
		
		//关闭
		entityManager.close();
		emfactory.close();
		return find;
	}
	//删除
	public static void deleteEmp(long id) {
		//开启实体管理器
		entityManager.getTransaction().begin();
		//执行Sql
		Employee find = entityManager.find(Employee.class,id);
		entityManager.remove(find);
		//提交
		System.out.println(find);
		entityManager.getTransaction().commit();
		
		//关闭
		entityManager.close();
		emfactory.close();
		
		
	}
}

