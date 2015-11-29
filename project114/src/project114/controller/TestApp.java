package project114.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import project114.model.Department;
import project114.model.Memo;
import project114.model.Memo_Person;
import project114.model.Person;
import project114.model.Position;
import project114.model.Role;
import project114.utility.SQLOperations;

public class TestApp {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = 
				new Configuration().configure().buildSessionFactory();
				
		
		Session session = sessionFactory.openSession();
        session.beginTransaction();
		/*
		Department it = new Department("IT");
		
		Person seno = new Person("Jose","Seno",new Department("CS"));
		
		Set<Person> persons = new HashSet<Person>();
		persons.add(seno);
         
        it.setPersons(persons);
         
        session.save(it);
         */
        
        /* counting
        List<Long> cs = session.createQuery("from Department where department = 'IS'").list();
        
    	System.out.println(cs.size());
        */
        
        
        /* specific dept
        List<Department> cs = session.createQuery("from Department where department = 'CS'").list();
        
        for (Department d : cs) {
        	System.out.print("" + d.getDepartment_id() + ","
        			+ d.getDepartment()+",[");
        	for (Person p : d.getPersons()) {
        		System.out.print("" + p.getFirstname() + " " + p.getLastname() + ",");
        	}
    		System.out.print("]\n");
        }*/
        
        /* list depts
        List<Department> departments = session.createQuery("from Department").list();
        
        for (Department d : departments) {
        	System.out.print("" + d.getDepartment_id() + ","
        			+ d.getDepartment()+",[");
        	for (Person p : d.getPersons()) {
        		System.out.print("" + p.getFirstname() + " " + p.getLastname() + ",");
        	}
    		System.out.print("]\n");
        }
        */
        
        /* list persons
        List<Person> persons = session.createQuery("from Person").list();
        
        for (Person p : persons) {
        	System.out.println("" + p.getPerson_id() + " - " + p.getFirstname() + " "
        			+ p.getLastname() + ", " + p.getDepartment().getDepartment());
        	
        }
        */
        
        //SQLOperations.printShit(sessionFactory);
        Person p1 = new Person("Alex", "Santos", new Department("IT"), new Position("Director"), new Role("admin"));
        Person p2 = new Person("Jose", "Seno", new Department("CS"), new Position("Chairman"), new Role("user"));
        SQLOperations.addPerson(sessionFactory, "Lawrence", "Decamora", "IS", "Professor", "user");

        session.save(p1);
        session.save(p2);
        
        
        Memo memo1 = new Memo("Memo 1","C:\\memos","a short description");
        
        Memo_Person memoPerson = new Memo_Person();
        
        memoPerson.setMemo(memo1);
        memoPerson.setPerson(p1);
        memoPerson.setSigned(true);
        memoPerson.setSignDate(new Date());

        session.save(memoPerson);
        
        Memo memo2 = new Memo("Memo 3","C:\\memos","a short description");
        
        Memo_Person memoPerson2 = new Memo_Person();
        
        memoPerson2.setMemo(memo1);
        memoPerson2.setPerson(p2);
        memoPerson2.setSigned(false);
        memoPerson2.setSignDate(new Date());

        session.save(memoPerson2); 
        
        SQLOperations.addMemo(sessionFactory, "Memo 2", "C:\\memos2", "a short descriptions");
        
        SQLOperations.getMemosOfPerson(sessionFactory, 1);
        
        //List<Memo> memos = SQLOperations.getAllMemos(sessionFactory);
        
        /*for (Memo m : memos) {
        	System.out.println("" + m.getMemo_id() + " - " + m.getTitle() + " "
        			+ m.getDescription() + ", " + m.getUrl());
        	
        }*/
        /*Set<Person> persons = new HashSet<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(SQLOperations.getPerson(sessionFactory, 1));
 
        //memo1.setPersons(persons);*/
 		
        
        /*
        for (Person p : SQLOperations.getAllPersons(sessionFactory)) {
        	System.out.println("" + p.getPerson_id() + " - " + p.getFirstname() + " "
        			+ p.getLastname() + ", " + p.getDepartment().getDepartment()
        			+ ", " + p.getPosition().getPosition() + ", " + p.getRole().getRole());
        	
        }*/
        
        //SQLOperations.updatePerson(sessionFactory, 2, "Jose", "Seno", "IS");
        
        
        
        
        session.getTransaction().commit();
        session.close(); 
		
		
	}
	
	
}
