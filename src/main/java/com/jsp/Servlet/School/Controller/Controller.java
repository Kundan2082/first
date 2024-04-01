package com.jsp.Servlet.School.Controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.jsp.Servlet.School.Model.Admin;
import com.jsp.Servlet.School.Model.Student;

@WebServlet(loadOnStartup = 1)
public class Controller extends HttpServlet{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("psql_school");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();	
	
	//admin login check
	public Admin admin_login(String...arg) {
		String jpql = "SELECT a FROM Admin a";
		TypedQuery<Admin> typedQuery = entityManager.createQuery(jpql, Admin.class);
		List<Admin> list = typedQuery.getResultList();
		for (Admin admin : list) {
			if (admin.getAdmin_username().equals(arg[0]) && admin.getAdmin_password().equals(arg[1])) {
				System.out.println(admin.getAdmin_username());
				return admin;
			}
		}
		return null;
	}
	
	//student login check
	public Student student_login(String...arg) {
		String jpql = "SELECT s FROM Student s";
		TypedQuery<Student> typedQuery = entityManager.createQuery(jpql, Student.class);
		List<Student> list = typedQuery.getResultList();
		for (Student student : list) {
			if (student.getStudent_user().equals(arg[0]) && student.getStudent_pass().equals(arg[1])) {
				System.out.println(student.getStudent_user());
				return student;
			}
		}
		return null;
	}
	
	public boolean add_student(String...arg) {
		Student student = new Student();
		student.setStudent_name(arg[0]);
		int age = Integer.parseInt(arg[1]);
		student.setStudent_age(age);
		
		boolean gender;
		
		if (arg[2].equals("Male")) {
			gender = true;
		} else {
			gender = false;
		}
		
		student.setStudent_gender(gender);
		student.setStudent_gamil(arg[3]);
		student.setStudent_contact(arg[4]);
		student.setStudent_address(arg[5]);
		student.setStudent_user(arg[6]);
		student.setStudent_pass(arg[7]);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return true;
		
	}
	
	public Student find_student_by_id(int id) {
		Student student = entityManager.find(Student.class, id);
		
		if (student!=null) {
			return student;
		} else {
			return null;
		}
	}
	
	public boolean update_student(String...arg) {
		int id = Integer.parseInt(arg[0]);
		Student student = entityManager.find(Student.class, id);
		
		if (student!=null) {
			student.setStudent_name(arg[1]);
			int age = Integer.parseInt(arg[2]);
			student.setStudent_age(age);
			student.setStudent_gamil(arg[3]);
			student.setStudent_contact(arg[4]);
			student.setStudent_address(arg[5]);
			student.setStudent_user(arg[6]);
			student.setStudent_pass(arg[7]);
			
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	
	public boolean delete_student(String id) {
		int int_id = Integer.parseInt(id);
		Student student = entityManager.find(Student.class, int_id);
		
		if (student!=null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		
		return false;
	}

}
