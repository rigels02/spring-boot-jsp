package springbootjsp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="t_tasks")
public class TTasks implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Size(max=45)
	private String name;
	@Size(max=45)
	private String descriptor;
	@Temporal(TemporalType.TIMESTAMP)
        @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date date_created;
	private Boolean finished;
	
	public TTasks() {
		
	}

	public TTasks(String name, String descriptor, Date date_created, Boolean finished) {
		super();
		this.name = name;
		this.descriptor = descriptor;
		this.date_created = date_created;
		this.finished = finished;
	}

	//getters/setters
	
	//--------------
	@Override
	public String toString() {
		return "TTasks [Id=" +id + ", name=" + name + ", descriptor=" + descriptor + ", date_created=" + date_created
				+ ", finished=" + finished + "]";
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
	
	
	
	

	
	
}
