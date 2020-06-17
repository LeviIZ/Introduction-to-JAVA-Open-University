/**
 * Matala MMN14
 * @author amatzia adler
 * @version 2020a
 * 
 * four methods that work with strings and array.
 * more details before any method.
 */
public class Ex14 {
	
	
	/**
	 * Q.1 S.1
	 * check how many substring there is in s that start and end with c <br>
	 * efficiency: <br> O(n) Time, O(1) Place.
	 * @param s - input any string
	 * @param c - input char for checking
	 * @return - number of string between c with only one c inside 
	 */
	public static int subStrC (String s, char c) {
		int counter = 0;
		
		for(int i = 0; i < s.length(); i++) { // O(n)
			if(s.charAt(i) == c)
				counter++;
		}
		if(counter <= 2)
			return 0;
		return (counter - 2);
	}
	
	
	
	/**
	 * Q.1 S.2
	 * check how many substring there is in s that start and end with c and there is inside of them k number of c <br>
	 * efficiency: <br> O(n) Time, O(1) Place.
	 * @param s - input any string
	 * @param c - input char for checking
	 * @param k - input integer for number of c
	 * @return number of string between c with at most k times of c in the input string
	 */
	public static int subStrMaxC (String s, char c, int k) {
		int counter = 0, numOfsubstring = 0;
		
		for(int i = 0; i < s.length(); i++) { // O(n) - number of c in s
			if(s.charAt(i) == c)
				counter++;
		}
		while(k >= 0) { // O(k) - sum of substring for each k
			if(counter > k)
				numOfsubstring += counter - (k + 1);
			k--;
		}
		return numOfsubstring;
	}
	
	
	
	/**
	 * Q.2
	 * method that get an array and change every index that not 0 to the distance of his from the near 0.
	 * efficiency: <br> O(n) Time, O(1) Place.
	 * @param a - input any array
	 */
	public static void zeroDistance(int[] a) {
		int firstZ = -1, currentZ = -1;
		
		for(int i = 0; i < a.length; i++) { // O(n) - run from start to end
			if(a[i] == 0) {
				currentZ = i; // set current zero
				if(firstZ == -1)
					firstZ = currentZ; // set first zero
			}
			else if (currentZ != -1)
				a[i] = i - currentZ;
		}
		currentZ = -1;
		
		for(int i = a.length - 1; i >= 0; i--) { // O(n) - run from end to start
			if(a[i] == 0)
				currentZ = i; // set current zero
			else if (currentZ == firstZ)
				a[i] = currentZ - i;
			else if ((currentZ != -1) && (a[i] > currentZ - i))
				a[i] = currentZ - i;
		}
	}
	
	
	
	/**
	 * Q.3
	 * method that check if string t has undergone transformation from string s. <br>
	 * @param s - original string
	 * @param t - string unknown if related to the original or not
	 * @return true if t has undergone transformation from s and false otherwise
	 */
	public static boolean isTrans (String s, String t) {
		if(s.length() > t.length()) // transformation can't be if s is bigger than t
			return false;
		if(t.length() == 0) // if s isn't bigger than t and t = 0 than the transformation must be right
			return true;
		if(s.length() == 0) // if s = 0 and t != 0
			return false;
		/* if chat(0) for s & t is equals and one of the option in the end is true - return true
		else return false */
		return s.charAt(0) == t.charAt(0) && isTrans(s.substring(1), t.substring(1)) || isTrans(s, t.substring(1));
	}
	
	
	
	/**
	 * Q.4
	 * method that calculate in any input matrix of integers how many paths can be in that case:
	 * from the number in a certain index we adding the first or the second digit to i and the other one to j <br>
	 * and continue by the new index of mat[new i][new j].
	 * if the path end in the last index of mat then its 1 path correct. <br>
	 * @param mat - input array
	 * @return number of paths
	 */
	public static int countPaths (int[][] mat) {
		return countPaths(mat, 0, 0); // overload private method
	}
	
	/**
	 * overload Q.4
	 * @param mat - input array
	 * @param i - index row of mat
	 * @param j - index column of mat
	 * @param counter - number of paths
	 * @return counter
	 */
	private static int countPaths (int[][] mat, int i, int j) {
		if(i > mat.length-1 || j > mat[0].length-1) // if the index is after the bounds 
			return 0;
		if(i == mat.length-1 && j == mat[0].length-1) // if the index is in the last index - the path is right
			return 1;
		if(mat[i][j] == 0) // if the value equals 0 than the path can not go on
			return 0;
		if(mat[i][j] / 10 == mat[i][j] % 10) // prevent value with same two numbers from double paths
			return countPaths(mat, i + (mat[i][j] / 10), j + (mat[i][j] % 10));
		return countPaths(mat, i + (mat[i][j] / 10), j + (mat[i][j] % 10)) +
				countPaths(mat, i + (mat[i][j] % 10), j + (mat[i][j] / 10));
	}
	
}
