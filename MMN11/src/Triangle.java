/**
 * Matala MMN11 q.1 - calculate perimeter and area for any triangle
 * 
 * @author amaztia adler
 * @version 2020a
 */

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// first massage
		System.out.println("This program calculates the area and the perimeter of given triangle. ");
		System.out.println("Please enter the three lengths of the triangle's sides: ");

		int sideA = scan.nextInt(); // input side 1
		int sideB = scan.nextInt(); // input side 2
		int sideC = scan.nextInt(); // input side 3
		scan.close(); // close input
		
		if ((sideA <= 0) || (sideB <= 0) || (sideC <= 0)) {
			// error massage 1
			System.out.println(
					"This input is incorrect because one side or more is incorrect. \nthe input of the sides is: " + sideA
							+ ", " + sideB + ", " + sideC);
		}
		else if ((sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA)) {
			int perimeter = sideA + sideB + sideC; // calculates perimeter
			double halfPerimeter = perimeter / 2;
			double area = Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC)); // calculates area
			
			// last massage with results
			System.out.println("The perimeter of the triangle is: " + perimeter);
			System.out.println("And The area of the triangle is: " + area);
		} 
		else {
			// error massage 2
			System.out.println(
					"This input is incorrect because the sides together can not be a triangle. \nthe input of the sides is: " + sideA
							+ ", " + sideB + ", " + sideC);
		}

	} // end of method main
} // end of class Triangle
