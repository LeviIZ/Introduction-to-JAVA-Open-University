/**
 * Matala MMN11 q.2 - performing a test by two triangular vertices if there are congruent or not
 * 
 * @author amaztia adler
 * @version 2020a
 */

import java.util.Scanner;

public class Congruent {

	public static void main(String[] args) {
		boolean check = false;
		Scanner scan = new Scanner(System.in);
		
		// first massage
		System.out.println("Please input twelve numbers for vertices (x and y) of the triangles by the correct order: ");
		
		// receive input
		double x1 = scan.nextDouble(), y1 = scan.nextDouble();
		double x2 = scan.nextDouble(), y2 = scan.nextDouble();
		double x3 = scan.nextDouble(), y3 = scan.nextDouble();
		double x10 = scan.nextDouble(), y10 = scan.nextDouble();
		double x20 = scan.nextDouble(), y20 = scan.nextDouble();
		double x30 = scan.nextDouble(), y30 = scan.nextDouble();
		scan.close(); // close input
		
		// calculate sides triangle 1
		double sideA1 = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
		double sideA2 = Math.sqrt(Math.pow((x2-x3), 2) + Math.pow((y2-y3), 2));
		double sideA3 = Math.sqrt(Math.pow((x3-x1), 2) + Math.pow((y3-y1), 2));
		
		// calculate sides triangle 2
		double sideB1 = Math.sqrt(Math.pow((x10-x20), 2) + Math.pow((y10-y20), 2));
		double sideB2 = Math.sqrt(Math.pow((x20-x30), 2) + Math.pow((y20-y30), 2));
		double sideB3 = Math.sqrt(Math.pow((x30-x10), 2) + Math.pow((y30-y10), 2));
		
		
		// checking if there is congruent by compare sides
		if (sideA1 == sideB1) {
			if (sideA2 == sideB2)
				if (sideA3 == sideB3)
					check = true;
			else if (sideA2 == sideB3)
				if (sideA3 == sideB2)
					check = true;
		}
		else if (sideA1 == sideB2) {
			if (sideA2 == sideB1)
				if (sideA3 == sideB3)
					check = true;
			else if (sideA2 == sideB3)
				if (sideA3 == sideB2)
					check = true;
		}
		else if (sideA1 == sideB3) {
			if (sideA2 == sideB1)
				if (sideA3 == sideB2)
					check = true;
			else if (sideA2 == sideB2)
				if (sideA3 == sideB1)
					check = true;
		}
		
		// output
		System.out.println("The first triangle is ("+x1+", "+y1+") ("+x2+", "+y2+") ("+x3+", "+y3+") .");
		System.out.println("Its lengths are "+sideA1+", "+sideA2+", "+sideA3+".");
		System.out.println("The second triangle is ("+x10+", "+y10+") ("+x20+", "+y20+") ("+x30+", "+y30+") .");
		System.out.println("Its lengths are "+sideB1+", "+sideB2+", "+sideB3+".");
		
		// make sure if there is congruent or not
		if (check == true)
			System.out.println("The triangle are congruent.");
		else
			System.out.println("The triangle are not congruent.");
		
	} // end of method main
} // end of class Congruent
