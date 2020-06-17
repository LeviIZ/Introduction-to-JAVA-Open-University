
public class MatrixTester {

	public static void main(String[] args) {
		
		// official tester
		
		
        System.out.println("\n*********************** START OF MATRIX TESTER**************************************");
        
        // MATRIX
        System.out.println("\nTest Matrix:\n");
        System.out.println("for Matrix m2 = new Matrix(3, 3); the toString of m2 is:");
        Matrix m2 = new Matrix(3, 3);
        System.out.println(m2);

        System.out.println("\nfor a = { { 10, 30, 50 }, { 100, 150, 200 } };");
        int[][] t = { { 10, 30, 50 }, {100 ,150 ,200 } };
        Matrix m1 = new Matrix(t);
        System.out.println("\nfor Matrix m1 = new Matrix(a); the toString of m1 is:");
        System.out.println(m1);
        Matrix temp;
        
        temp = m1.makeNegative();
        System.out.println("resuls of m1.makeNegative(); \n" + temp);

        temp = m1.imageFilterAverage();
        System.out.println("resuls of m1.imageFilterAverage(); \n" + temp);

        temp = m1.rotateClockwise();
        System.out.println("resuls of m1.rotateClockwise(); \n" + temp);

        temp = m1.rotateCounterClockwise();
        System.out.println("resuls of m1.rotateCounterClockwise(); \n" + temp);
        System.out.println("\n*********************** END OF MATRIX TESTER**************************************");
		
		
		
		int[][] a = {{13,8,72},{4,6,60},{253,2,1}};
	    Matrix photo = new Matrix(a);
	    Matrix emptyPhoto = new Matrix(2,2);
	    System.out.println(photo.toString() + "\t This checks the first constructor and the toString method");
	    System.out.println(emptyPhoto.toString() + "\t This checks the second constructor and the toString method");
	    
	    for(int i = 0; i < 4; i++) //Spaces so the output is more easibly readble.
	        System.out.println();
	    
	    System.out.println("Checks the makeNegative method");    
	    int[][] b = {{19,124,28,35,38},{115,22,25,230,31},{9,21,21,249,230},{0,6,9,232,255},{2,5,10,116,129}};
	    Matrix photo2 = new Matrix(b);
	    int[][] c = {{236,131,227,220,217},{140,233,230,25,224},{246,234,233,6,25},{255,249,246,23,0},{253,250,245,139,126}};
	    Matrix photoCheck = new Matrix(c);
	    System.out.println(photo2.makeNegative().toString());
	    
	    System.out.println("The output should be equal to this:");
	    System.out.println(photoCheck.toString());
	    
	    for(int i = 0; i < 4; i++) //Spaces so the output is more easibly readble.
	        System.out.println();
	    
	    System.out.println("Checks the imageFilterAverage method"); 
	    int[][] d = {{19,124,28,35,38},{115,22,25,230,31},{9,21,22,249,230},{0,6,9,232,255},{2,5,10,116,129}};
	    Matrix photo3 = new Matrix(d);
	    int[][] e = {{70,55,77,64,83},{51,42,84,98,135},{28,25,90,142,204},{7,9,74,139,201},{3,5,63,125,183}};
	    Matrix photoCheck2 = new Matrix(e);
	    
	    System.out.println(photo3.imageFilterAverage().toString());
	    
	    System.out.println("The output should be equal to this:");
	    System.out.println(photoCheck2.toString());
	    
	    for(int i = 0; i < 4; i++) //Spaces so the output is more easibly readble.
	        System.out.println();
	    
	    System.out.println("Checks the rotateClockwise method");     
	    int[][] f = {{19,124,28,35},{115,22,25,230},{19,21,22,249},{0,16,9,232},{62,35,10,116}};
	    Matrix photo4 = new Matrix(f);
	    int[][] g = {{62,0,19,115,19},{35,16,21,22,124},{10,9,22,25,28},{116,232,249,230,35}};
	    Matrix photoCheck3 = new Matrix(g);
	    
	    System.out.println(photo4.rotateClockwise().toString());
	    
	    System.out.println("The output should be equal to this:");
	    System.out.println(photoCheck3.toString());
	    
	    for(int i = 0; i < 4; i++) //Spaces so the output is more easibly readble.
	        System.out.println();
	    System.out.println("Checks the rotateCounterClockwise method"); 
	        
	    System.out.println(photoCheck3.rotateCounterClockwise().toString());
	    
	    System.out.println("The output should be equal to this:");
	    System.out.println(photo4.toString());
	    
	    for(int i = 0; i < 4; i++) //Spaces so the output is more easibly readble.
	        System.out.println();
		
	    System.out.println("\n*********************** END OF MATRIX TESTER**************************************");
	}

}
