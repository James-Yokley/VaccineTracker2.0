package cs3220.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patient {
	static int idSeed = 1; 
	private int id, vaccineId; 
	private String name; 
	private LocalDate date; 
	private LocalDate nextDate; 
	public boolean receivedSecond; 
	
	public Patient(String name, int vaccineId, boolean receivedSecond) {
		this.id = idSeed++; 
		this.name = name; 
		this.vaccineId = vaccineId; 
		this.date = LocalDate.now();
		this.receivedSecond = receivedSecond; 
	}
	public Patient(String name, int vaccineId, int year, int month, int dayOfMonth, boolean receivedSecond) {
		this.id = idSeed++; 
		this.name = name; 
		this.vaccineId = vaccineId; 
		this.date = LocalDate.of(year, month, dayOfMonth); 
		this.receivedSecond = receivedSecond; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDate() {
		return date; 
	}
	
	public void setDate(LocalDate date) {
		this.date = date; 
	}
	
	public LocalDate getNextDate() {
		return nextDate; 
	}
	
	public void setNextDate(long numberOfDays) {
		this.nextDate = date.plusDays(numberOfDays); 
	}
	public void setNextDate() {
		this.nextDate = LocalDate.now(); 
	}
	
	public String getFormattedDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		return formatter.format(date); 
	}
	
	public boolean getReceivedSecond() {
		return receivedSecond; 
	}
	
	public void setReceivedSecond(boolean received) {
		this.receivedSecond = received; 
	}
}
