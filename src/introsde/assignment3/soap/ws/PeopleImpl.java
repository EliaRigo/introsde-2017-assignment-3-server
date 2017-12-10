package introsde.assignment3.soap.ws;

import java.util.List;

import javax.jws.WebService;

import introsde.assignment3.soap.model.Activity;
import introsde.assignment3.soap.model.Person;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment3.soap.ws.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {

	// Method #1
    @Override
    public List<Person> readPersonList() {
    	System.out.println("arrivo qui");
    	System.out.println(Person.getAll().toString());
        return Person.getAll();
    }
    /*
    // Method #2
    @Override
    public Person readPerson(Long id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id.intValue());
        return p;
    }

    // Method #3
    @Override
    public Person updatePerson(Person person) {
    	return Person.updatePerson(person);
    }

    // Method #4
    @Override
    public Person createPerson(Person person) {
        Person.newPerson(person);
        return person;
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
    	return Activity.postActivity(activity, id.intValue(), activity.getActivityType());
    }
    
    // Method #10
    @Override
    public Activity updatePersonPreferences(Long id, Activity activity){
    	activity.setIdPerson(id.intValue());
    	activity.setPerson(Person.getPersonById(id.intValue()));
    	return Activity.updateActivity(activity);
    }
    
    // Method #11
    @Override
    public Activity evaluatePersonPreferences(Long id, Activity activity, int value) {
    	activity.setIdPerson(id.intValue());
    	activity.setPerson(Person.getPersonById(id.intValue()));
    	activity.setRate(value);
    	return Activity.updateActivity(activity);
    }
    
    // Method #12
    @Override
    public List<Activity> getBestPersonPreference(Long id){
    	return Activity.getBestActivitiesByIdPerson(id.intValue());
    }*/
}