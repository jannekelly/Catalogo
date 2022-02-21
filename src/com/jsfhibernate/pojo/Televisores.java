package com.jsfhibernate.pojo;
 
import java.util.List;
 
import javax.faces.bean.ManagedBean;
 
import com.jsfhibernate.dao.DatabaseOperations;
 
@ManagedBean
public class Televisores implements java.io.Serializable {
 
    private int id;
    private String tipo;
    private String so;
    private float preco;
    private int tamanho;
    private List televisoresList;  
    public static DatabaseOperations dbObj;
    private static final long serialVersionUID = 1L;
 
    public Televisores() { }
 
    public Televisores(int id) {
        this.id = id;
    }
 
    public Televisores(int id, String tipo, String so,float preco,int tamanho) {
        this.id = id;
        this.tipo= tipo;
        this.so = so;
        this.preco=preco;
        this.tamanho=tamanho;
    }
 
    public int getId() {
        return this.id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getTipo() {
        return this.tipo;
    }
 
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getSo() {
        return this.so;
    }
 
    public void setSo(String so) {
        this.so = so;
    }
 
    public List getTelevisoresList() {
        return televisoresList;
    }
 
    public void setStudentList(List televisoresList) {
        this.televisoresList = televisoresList;
    }
 
    // Method To Add New Student Details In Database
    public void saveTelevisorRecord() {
        System.out.println("Calling saveStudentRecord() Method To Save Student Record");
        dbObj = new DatabaseOperations();
        dbObj.addTelevisorInDb(this);
    }
 
    // Method To Delete A Particular Student Record From The Database
    public void deleteStudentRecord() {
        System.out.println("Calling deleteStudentRecord() Method To Delete Student Record");
        dbObj = new DatabaseOperations();
        dbObj.deleteTelevisorInDb(id);
    }
 
    // Method To Fetch Particular Student Details From The Database
    @SuppressWarnings("rawtypes")
	public List getTelevisorDetailsById() {
        System.out.println("Calling getStudentDetailsById() Method Details For Student Id?= " + id);
        dbObj = new DatabaseOperations();       
        televisoresList = dbObj.getTelevisorById(id);
        for(Object selectedTelevisor : televisoresList) {
        	Televisores tv = (Televisores) selectedTelevisor;
            tipo = tv.getTipo();
            so = tv.getSo();
        }
        System.out.println("Fetched Id? " + id + " Details Are: Tipo=" + tipo + ", So=" + so);
        return televisoresList;
    }
 
    // Method To Update Particular Student Details In Database
    public void updateStudentDetails() {
        System.out.println("Calling updateStudentDetails() Method To Update Student Record");
        dbObj = new DatabaseOperations();       
        dbObj.updateTelevisorRecord(this);
    }
}