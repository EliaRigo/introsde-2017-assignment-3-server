package introsde.assignment3.soap.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import introsde.assignment3.soap.model.Activity;
import introsde.assignment3.soap.model.Person;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
	
	//Method #1
    @WebMethod(operationName="readPersonList")
    @WebResult(name="people") 
    public List<Person> readPersonList();

    //Method #2
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="personId") Long id);
 
    //Method #3
    @WebMethod(operationName="updatePerson")
    @WebResult(name="person") 
    public Person updatePerson(@WebParam(name="person") Person person);
 
    //Method #4
    @WebMethod(operationName="createPerson")
    @WebResult(name="person") 
    public Person createPerson(@WebParam(name="person") Person person);
    
    //Method #5
    @WebMethod(operationName="deletePerson")
    @WebResult(name="delete") 
    public int deletePerson(@WebParam(name="personId") Long id);
    
    //Method #6
    @WebMethod(operationName="readPersonPreferences")
    @WebResult(name="activity") 
    public List<Activity> readPersonPreferences(@WebParam(name="personId") Long id, 
    									   		@WebParam(name="activityType") String activity_type);

    //Method #7
    @WebMethod(operationName="readPreferences")
    @WebResult(name="activity") 
    public List<Activity> readPreferences();
    
    //Method #8
    @WebMethod(operationName="readPersonPreferencesById")
    @WebResult(name="activity") 
    public Activity readPersonPreferencesById(@WebParam(name="personId") Long id, 
    								 	  	  @WebParam(name="activityId") Long activity_id);
    
    //Method #9
    @WebMethod(operationName="savePersonPreferences")
    @WebResult(name="activity")
    public Activity savePersonPreferences(@WebParam(name="personId") Long id,  
    								  	  @WebParam(name="activity") Activity activity);
   
    //Method #10
    @WebMethod(operationName="updatePersonPreferences")
    @WebResult(name="activity") 
    public Activity updatePersonPreferences(@WebParam(name="personId") Long id, 
    										@WebParam(name="activity") Activity activity);
    
    //Method #11
    @WebMethod(operationName="evaluatePersonPreferences")
    @WebResult(name="activity") 
    public Activity evaluatePersonPreferences(@WebParam(name="personId") Long id, 
    										  @WebParam(name="activity") Activity activity,
    										  @WebParam(name="value") int value);
    
    //Method #12
    @WebMethod(operationName="getBestPersonPreference")
    @WebResult(name="activity") 
    public List<Activity> getBestPersonPreference(@WebParam(name="personId") Long id);
}