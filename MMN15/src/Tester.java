
public class Tester {

	public static void main(String[] args) {
		
		// private Tester

		PolyNode a0 = new PolyNode(2, 2.8);
		PolyNode a1 = new PolyNode(2, 2.8);
		PolyNode a2 = new PolyNode(3, 4.9);
		PolyNode a3 = new PolyNode(2, -6.5);
		PolyNode a4 = new PolyNode(0, -12.0);
		
		PolyNode a5 = new PolyNode(2, 2.8);
		PolyNode a6 = new PolyNode(3, 4.9);
		PolyNode a7 = new PolyNode(2, -6.5);
		PolyNode a8 = new PolyNode(0, -12.0);
		/*
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		*/
		Polynom p2 = new Polynom(a8);
		Polynom p1 = new Polynom(a2);
		p1.addNode(a1);
		p1.addNode(a3);
		p1.addNode(a3);

		p2.addNode(a5);
		p2.addNode(a6);
		p2.addNode(a7);
		System.out.println(p1);
		System.out.println(p2);
		//p1.multByScalar(0);
		//p1.addPol(p2);
		//p1.multPol(p2);
		//p2.differential();
		System.out.println(p1.toString());
		//System.out.println(p2);
		
	}

}
