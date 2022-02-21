package com.jsfhibernate.dao;
 
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

 
//import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.jsfhibernate.pojo.Televisores;
import com.jsfhibernate.util.HibernateUtil;
 

public class DatabaseOperations {
 
    private static Transaction transObj;
    private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();
 
    // Method To Add New Student Details In Database
    public void addTelevisorInDb(Televisores televisorObj) {        
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.save(televisorObj);
            System.out.println("Televisor Record With Id: " + televisorObj.getId() + " Is Successfully Created In Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("createdStudentId",  televisorObj.getId());                        
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
    }
 
    // Method To Delete A Particular Student Record From The Database
    public void deleteTelevisorInDb(int delTelevisorId) {
        try {
            transObj = sessionObj.beginTransaction();
            Televisores televisorId = (Televisores)sessionObj.load(Televisores.class, delTelevisorId);
            sessionObj.delete(televisorId);
            System.out.println("Student Record With Id: " + delTelevisorId + " Is Successfully Deleted From Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("deletedStudentId",  delTelevisorId);  
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
    }
 
    // Method To Fetch Particular Student Details From The Database
    //@SuppressWarnings({ "unchecked", "unused" })
    @SuppressWarnings("rawtypes")
	public List getTelevisorById(int televisorId) { 
        Televisores particularTeleDObj = new Televisores();
        List particularTelevisoresList = new ArrayList();            
        try {
            transObj = sessionObj.beginTransaction();
            Query queryObj = sessionObj.createQuery("from Televisores where id= : "+ Integer.toString(televisorId));          
            particularTeleDObj = (Televisores)queryObj.uniqueResult();
            particularTelevisoresList = queryObj.list();            
            System.out.println("Televisores Record With Id: " + televisorId + " Is Fetched Successfully From Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("findStudentById",  televisorId);
        } catch(Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
        return particularTelevisoresList;
    }
 
    // Method To Update Particular Student Details In The Database  
    public void updateTelevisorRecord(Televisores updateTelevisorObj) {
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.update(updateTelevisorObj);        
            System.out.println("Student Record With Id: " + updateTelevisorObj.getId() + " Is Successfully Updated In Database"); 
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("updatedStudentRecord",  "Success");
        } catch(Exception exceptionObj){
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
    }
}