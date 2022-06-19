package models.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime()-checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Erro: apenas atualizacoes futuras";
		}
		if(!checkOut.after(checkIn)) {
			return "Erro: checkin deve ser antes do checkout";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	@Override
	public String toString() {
		return "Room " +
				numQuarto +
				", Check-in: " +
				sdf.format(checkIn) +
				", Check-out: " +
				sdf.format(checkOut) +
				", " + 
				duration() + 
				" nights";
				
	}
	
}
