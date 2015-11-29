package project114.utility;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import project114.model.Department;
import project114.model.Memo;
import project114.model.Memo_Person;
import project114.model.Person;
import project114.model.Position;
import project114.model.Role;

public class SQLOperations {

	// *** Person ***

	public static Person addPerson(SessionFactory sessionFactory,
			String firstname, String lastname, String department,
			String position, String role) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person p = new Person();

		p.setFirstname(firstname);
		p.setLastname(lastname);

		List<Department> dList = session.createQuery(
				"from Department where department = '" + department + "'")
				.list();

		if (dList.size() > 0) {
			p.setDepartment(dList.get(0));
		} else {
			p.setDepartment(new Department(department));
		}

		List<Position> pList = session.createQuery(
				"from Position where position = '" + position + "'").list();

		if (pList.size() > 0) {
			p.setPosition(pList.get(0));
		} else {
			p.setPosition(new Position(position));
		}

		List<Role> rList = session.createQuery(
				"from Role where role = '" + role + "'").list();

		if (rList.size() > 0) {
			p.setRole(rList.get(0));
		} else {
			p.setRole(new Role(role));
		}

		long pId = (Long) session.save(p);

		session.getTransaction().commit();
		session.close();

		return p;

	}

	public static void updatePerson(SessionFactory sessionFactory, long id,
			String firstname, String lastname, String department,
			String position, String role) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person p = (Person) session.load(Person.class, id);
		p.setFirstname(firstname);
		p.setLastname(lastname);

		List<Department> dList = session.createQuery(
				"from Department where department = '" + department + "'")
				.list();

		if (dList.size() > 0) {
			p.setDepartment(dList.get(0));
		} else {
			p.setDepartment(new Department(department));
		}

		List<Position> pList = session.createQuery(
				"from Position where position = '" + position + "'").list();

		if (pList.size() > 0) {
			p.setPosition(pList.get(0));
		} else {
			p.setPosition(new Position(position));
		}

		List<Role> rList = session.createQuery(
				"from Role where role = '" + role + "'").list();

		if (rList.size() > 0) {
			p.setRole(rList.get(0));
		} else {
			p.setRole(new Role(role));
		}

		session.getTransaction().commit();
		session.close();

	}

	public static Person getPerson(SessionFactory sessionFactory, long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person p = (Person) session.get(Person.class, id);

		session.getTransaction().commit();
		session.close();

		return p;

	}

	public static List<Person> getAllPersons(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Person> persons = session.createQuery("from Person").list();

		session.getTransaction().commit();
		session.close();

		return persons;
	}

	public static void deletePerson(SessionFactory sessionFactory, long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person p = (Person) session.load(Person.class, id);
		session.delete(p);

		session.getTransaction().commit();
		session.close();

	}

	// *** Memo ***

	public static void addMemo(SessionFactory sessionFactory, String title,
			String url, String description) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Memo m = new Memo(title, url, description);

		session.save(m);

		session.getTransaction().commit();
		session.close();

	}

	public static void updateMemo(SessionFactory sessionFactory, long id,
			String title, String url, String description) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Memo m = (Memo) session.load(Person.class, id);

		m.setTitle(title);
		m.setUrl(url);
		m.setDescription(description);

		session.save(m);

		session.getTransaction().commit();
		session.close();

	}

	public static Memo getMemo(SessionFactory sessionFactory, long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Memo m = (Memo) session.load(Memo.class, id);

		session.getTransaction().commit();
		session.close();

		return m;

	}

	public static Memo deleteMemo(SessionFactory sessionFactory, long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Memo m = (Memo) session.load(Memo.class, id);
		session.delete(m);

		session.getTransaction().commit();
		session.close();

		return m;

	}

	public static List<Memo> getAllMemos(SessionFactory sessionFactory) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Memo> memos = session.createQuery("from Memo").list();

		session.getTransaction().commit();
		session.close();

		return memos;
	}

	// *** Memo_Person ***

	public static void addMemo_Person(SessionFactory sessionFactory, Memo memo,
			Person person) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Memo_Person mp = new Memo_Person();

		mp.setMemo(memo);
		mp.setPerson(person);
		mp.setSigned(false);
		mp.setSignDate(new Date());

		session.save(mp);

		session.getTransaction().commit();
		session.close();

	}

	public static void signMemo_Person(SessionFactory sessionFactory, long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Memo_Person mp = (Memo_Person) session.load(Memo_Person.class, id);

		mp.setSigned(true);
		mp.setSignDate(new Date());

		session.save(mp);

		session.getTransaction().commit();
		session.close();

	}
	
	public static void deleteMemo_Person(SessionFactory sessionFactory, long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Memo_Person mp = (Memo_Person) session.load(Memo_Person.class, id);

		session.delete(mp);

		session.getTransaction().commit();
		session.close();

	}
	
	//*** Joined Query ***
	
	public static void getMemosOfPerson(SessionFactory sessionFactory, long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Object[]> allmemopersons = session.createQuery("from Memo_Person mp inner join mp.memo where person = " + id).list();
		
		session.getTransaction().commit();
		session.close();

		//return allmemopersons;
	}

}
