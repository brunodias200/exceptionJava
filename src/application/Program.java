package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import models.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("num do quarto: ");
		int number = sc.nextInt();
		
		System.out.println("checkin: ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.println("checkout: ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkIn)) {
			System.out.println("Erro: checkout antes do checkin");
		}
		else {
			Reserva reserva = new Reserva(number, checkIn, checkout);
			System.out.println(reserva);
			
			System.out.println("Entre com as datas para atualizar a reserva");

			System.out.println("checkin: ");
			checkIn = sdf.parse(sc.next());
			
			System.out.println("checkout: ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkout.before(now)) {
				System.out.println("Erro: alteracao deve ser futura");
			}
			else if(!checkout.after(checkIn)) {
				System.out.println("Erro: checkout antes do checkin");
			}
			else {
				reserva.updateDates(checkIn, checkout);
				System.out.println(reserva);
			}
		}
		
		sc.close();
	}

}
