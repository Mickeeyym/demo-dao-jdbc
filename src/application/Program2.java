package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: findById =====");
		
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("==== TEST 2: findAll =====");
		List<Department> list = departmentDao.findAll();
		
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("==== TEST 3: insert =====");
		
		Department newDep = new Department(null, "Music");
		
		departmentDao.insert(newDep);
		
		System.out.println("Inserted! New id: " + newDep.getId());
		
		System.out.println("==== TEST 4: update =====");
		
		Department dep2 = departmentDao.findById(9);
		
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Updated Completed!");
		
		System.out.println("==== TEST 5: delete =====");
		System.out.println("Enter the Id you want to delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");
		
		sc.close();
		
		
		
	}

}
