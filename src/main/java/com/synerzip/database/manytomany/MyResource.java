package com.synerzip.database.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MyResource {

	public static void main(String[] args) {
		Project p1=new Project();
		p1.setProjectId(101);
		p1.setProjectTitle("online tour travel");
		p1.setProjectDescription("tour and travel");
		p1.setProjectFeature("helps travelers");
		p1.setTechnologyUsed("java angular");
		
		Project p2=new Project();
		p2.setProjectId(102);
		p2.setProjectTitle("live score");
		p2.setProjectDescription("get ipl match score");
		p2.setProjectFeature("cricket");
		p2.setTechnologyUsed("java angular php");
		
		Project p3=new Project();
		p3.setProjectId(103);
		p3.setProjectTitle("live movies");
		p3.setProjectDescription("watch movies live");
		p3.setProjectFeature("entertainment");
		p3.setTechnologyUsed("angular bootstrap");
		
		Project p4=new Project();
		p4.setProjectId(104);
		p4.setProjectTitle("calculator");
		p4.setProjectDescription("add sub mul div");
		p4.setProjectFeature("mathematics");
		p4.setTechnologyUsed("angular javascript");
		
		Set<Project> projectList=new HashSet<Project>();
		projectList.add(p1);
		projectList.add(p2);
		projectList.add(p3);
		
		Employee e1=new Employee();
		e1.setEmpId(1001);
		e1.setEmpName("ashok");
		e1.setEmpDepartment("cse");
		e1.setEmpSubjects("java c c#");
	
		Employee e2=new Employee();
		e2.setEmpId(1002);
		e2.setEmpName("vinod");
		e2.setEmpDepartment("ec");
		e2.setEmpSubjects("php c++ css");
		
		Employee e3=new Employee();
		e3.setEmpId(1003);
		e3.setEmpName("manish");
		e3.setEmpDepartment("it");
		e3.setEmpSubjects("java angular");
		
		Employee e4=new Employee();
		e4.setEmpId(1004);
		e4.setEmpName("sunil");
		e4.setEmpDepartment("me");
		e4.setEmpSubjects("production");
		
		
		
		Set<Employee> employeeList=new HashSet<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		
		p1.setEmployee(employeeList);
		p2.setEmployee(employeeList);
		
		Configuration con=new Configuration().configure();
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		tx.commit();
		
		session.close();
	}
}
