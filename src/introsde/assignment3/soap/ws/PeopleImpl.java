package introsde.assignment3.soap.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.persistence.*;

import introsde.assignment3.soap.dao.ActivityPreferenceDao;
import introsde.assignment3.soap.model.Activity;
import introsde.assignment3.soap.model.ActivityType;
import introsde.assignment3.soap.model.Person;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment3.soap.ws.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {

	//Method #0
    @Override
    public void init() {
    	try {
	    	EntityManager em = ActivityPreferenceDao.instance.createEntityManager();
	    	EntityTransaction tx = em.getTransaction();
			tx.begin();
	    	em.createQuery("DELETE FROM ActivityType at").executeUpdate();
	    	em.createQuery("DELETE FROM Activity a").executeUpdate();
	    	em.createQuery("DELETE FROM Person p").executeUpdate();
	    	tx.commit();
			ActivityPreferenceDao.instance.closeConnections(em);
    	}
    	catch(Exception ex) {System.out.println(ex);}
    	
    	//Insert ActivityType
    	ActivityType at1 = new ActivityType();
    	at1.setIdActivityType(1);
    	at1.setActivity_type("Social");
    	ActivityType.postActivityType(at1);
    	
    	ActivityType at2 = new ActivityType();
    	at2.setIdActivityType(2);
    	at2.setActivity_type("Sport");
    	ActivityType.postActivityType(at2);
    	
    	ActivityType at3 = new ActivityType();
    	at3.setIdActivityType(3);
    	at3.setActivity_type("Outdoor");
    	ActivityType.postActivityType(at3);
    	
    	//Insert Person 1
    	Person p1 = new Person();
    	p1.setFirstname("Massimo");
    	p1.setLastname("Rossi");
    	p1.setBirthdate("1991-01-15");
    	
    	Activity a1 = new Activity();
    	a1.setName("Running");
    	a1.setDescription("Running with friends");
    	a1.setPlace("City Centre Trento");
    	a1.setStartdate("2017-10-13T09:50:00.0");
    	a1.setRate(6);
    	
    	a1.setIdActivityType(at1.getIdActivityType());
    	a1.setActivityType(at1);
    	a1.setPerson(p1);
    	
    	List<Activity> tmp1 = new ArrayList<Activity>();
    	tmp1.add(a1);
    	p1.setActivities(tmp1);
    	Person.newPerson(p1);
    	
    	//Insert Person2
    	Person p2 = new Person();
    	p2.setFirstname("Luca");
    	p2.setLastname("Bianchi");
    	p2.setBirthdate("1999-02-10");
    	
    	Activity a2 = new Activity();
    	a2.setName("Dancing");
    	a2.setDescription("Dancing Group Dances");
    	a2.setPlace("Iris Club");
    	a2.setStartdate("2017-10-13T21:00:00.0");
    	a2.setRate(7);
    	
    	a2.setIdActivityType(at1.getIdActivityType());
    	a2.setActivityType(at1);
    	a2.setPerson(p2);
    	
    	List<Activity> tmp2 = new ArrayList<Activity>();
    	tmp2.add(a2);
    	p2.setActivities(tmp2);
    	Person.newPerson(p2);
    	
    	//Insert Person 3
    	Person p3 = new Person();
    	p3.setFirstname("Filippo");
    	p3.setLastname("Turri");
    	p3.setBirthdate("1999-10-23");
    	
    	Activity a3 = new Activity();
    	a3.setName("Boxing");
    	a3.setDescription("Boxing in the gym");
    	a3.setPlace("Santa Chiara Sport Gym");
    	a3.setStartdate("2017-10-14T18:00:00.0");
    	a3.setRate(7);
    	
    	a3.setIdActivityType(at2.getIdActivityType());
    	a3.setActivityType(at2);
    	a3.setPerson(p3);
    	
    	List<Activity> tmp3 = new ArrayList<Activity>();
    	tmp3.add(a3);
    	p3.setActivities(tmp3);
    	Person.newPerson(p3);
    	
    	//Insert Person 4
    	Person p4 = new Person();
    	p4.setFirstname("Piano");
    	p4.setLastname("Neri");
    	p4.setBirthdate("1993-05-15");
    	
    	Activity a4 = new Activity();
    	a4.setName("Skiing");
    	a4.setDescription("Skiing on the Bondone Mountain");
    	a4.setPlace("Bondone Mountain");
    	a4.setStartdate("2017-10-15T08:00:00.0");
    	a4.setRate(6);
    	
    	a4.setIdActivityType(at2.getIdActivityType());
    	a4.setActivityType(at2);
    	a4.setPerson(p4);
    	
    	List<Activity> tmp4 = new ArrayList<Activity>();
    	tmp4.add(a4);
    	p4.setActivities(tmp4);
    	Person.newPerson(p4);
    	
    	//Insert Person 5
    	Person p5 = new Person();
    	p5.setFirstname("Gianni");
    	p5.setLastname("Cassia");
    	p5.setBirthdate("1994-05-25");
    	
    	Activity a5 = new Activity();
    	a5.setName("Skateboarding");
    	a5.setDescription("Skateboarding with friends");
    	a5.setPlace("Rovereto Centre");
    	a5.setStartdate("2017-10-17T16:00:00.0");
    	a5.setRate(8);
    	
    	a5.setIdActivityType(at1.getIdActivityType());
    	a5.setActivityType(at1);
    	a5.setPerson(p5);
    	
    	List<Activity> tmp5 = new ArrayList<Activity>();
    	tmp5.add(a5);
    	p5.setActivities(tmp5);
    	Person.newPerson(p5);
    	
    	//File f = new File("database.sqlite");
    	//if(f.exists() && !f.isDirectory()) { 
    	//    f.delete();
    	//}
    	//copyFileUsingStream(new File("database_origin.sqlite"), new File("database.sqlite"));
    }
	
	// Method #1
    @Override
    public List<Person> readPersonList() {
        return Person.getAll();
    }
    
    // Method #2
    @Override
    public Person readPerson(Long id) {
        return Person.getPersonById(id.intValue());
    }

    // Method #3
    @Override
    public Person updatePerson(Person person) {
    	return Person.updatePerson(person);
    }

    // Method #4
    @Override
    public Person createPerson(Person person) {
        return Person.newPerson(person);
    }

    // Method #5
    @Override
    public int deletePerson(Long id) {
        Person p = Person.getPersonById(id.intValue());
        if (p!=null) {
            Person.removePerson(p);
            return 0;
        } else {
            return -1;
        }
    }

    // Method #6
    @Override
    public List<Activity> readPersonPreferences(Long id, String activity_type) {
    	return Activity.getActivityByIdPersonAndActivityType(id.intValue(), activity_type);
    }

    // Method #7
    @Override
    public List<Activity> readPreferences(){
		return Activity.getAll();
    	
    }
    
    // Method #8
    @Override
    public Activity readPersonPreferencesById(Long id, Long activity_id) {
    	return Activity.getActivityByIdPersonAndIdActivity(id.intValue(), activity_id.intValue());
    }
    
    // Method #9
    @Override
    public Activity savePersonPreferences(Long id, Activity activity) {
    	return Activity.postActivity(activity, id.intValue());
    }
    
    // Method #10
    @Override
    public Activity updatePersonPreferences(Long id, Activity activity){
    	activity.setIdPerson(id.intValue());
    	activity.setPerson(Person.getPersonById(id.intValue()));
		activity.setActivityType(ActivityType.getActivityTypeByActivityTypeId(activity.getIdActivityType()));
    	return Activity.updateActivity(activity);
    }
    
    // Method #11
    @Override
    public Activity evaluatePersonPreferences(Long id, Activity activity, int value) {
    	activity.setIdPerson(id.intValue());
    	activity.setPerson(Person.getPersonById(id.intValue()));
		activity.setActivityType(ActivityType.getActivityTypeByActivityTypeId(activity.getIdActivityType()));
    	activity.setRate(value);
    	return Activity.updateActivity(activity);
    }
    
    // Method #12
    @Override
    public List<Activity> getBestPersonPreference(Long id){
    	return Activity.getBestActivitiesByIdPerson(id.intValue());
    }
}