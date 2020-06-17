/**
 * Matala MMN13 q.2 - working with matrix of colors and build some options for it
 * 
 * @author amatzia adler
 * @version 2020a
 */

public class Matrix {
	private int [][] _matrix;
	private final int MAX_VALUE_COLOR = 255;
	
	// constructors
	/**
	 * constructor 1 - copy constructor
	 * @param array - to copy input array to the new matrix
	 */
	public Matrix(int [][] array) {
		_matrix = new int[array.length][array[0].length];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				_matrix[i][j] = array[i][j];
			}
		}
	}
	
	/**
	 * constructor 2 - build a matrix by lines and columns and give all the values 0
	 * @param size1 - present the lines
	 * @param size2 - present the columns
	 */
	public Matrix(int size1, int size2) {
		_matrix = new int[size1][size2];
	}
	
	/**
	 * method to string
	 * @param tempStr - temp helper to string
	 * @param i, j - counters
	 * @return string of the matrix
	 */
	public String toString() {
		String tempStr = "";
		int j;
		
		for(int i = 0; i < _matrix.length; i++) {
			for(j = 0; j < _matrix[0].length-1; j++) {
				tempStr += _matrix[i][j] + "\t"; // build the sting of the matrix
			}
			tempStr += _matrix[i][j] + "\n"; // avoid one more \t that don't needed
		}
		return tempStr;
	}
	
	/**
	 * replace all index in the old one with the exact opposite color
	 * @param tempMatrix - create temp matrix for the changes
	 * @return new anonymous matrix
	 */ 
	public Matrix makeNegative() {
		int[][] tempMatrix = new int[_matrix.length][_matrix[0].length];
		for(int i = 0; i < _matrix.length; i++) {
			for(int j = 0; j < _matrix[0].length; j++) {
				tempMatrix[i][j] = MAX_VALUE_COLOR - _matrix[i][j]; // replace the right color
			}
		}
		return new Matrix(tempMatrix);
	}
	
	/**
	 * make a new Matrix that get the average neighbors of the old one
	 * @param tempMatrix - create temp matrix for the changes
	 * @param sum - sum all the neighbors
	 * @param average - average of the sum
	 * @param neighbors - the neighbors of the current index
	 * @return new anonymous matrix
	 */
	public Matrix imageFilterAverage() {
		int[][] tempMatrix = new int[_matrix.length][_matrix[0].length];
		
		for(int i = 0; i < _matrix.length; i++) {
			for(int j = 0; j < _matrix[0].length; j++) {
				tempMatrix[i][j] = averageNeighbors(i, j);
			}
		}
		return new Matrix(tempMatrix);
	}
		
	/**
	 * rotate the matrix with the clockwise
	 * @param tempMatrix - create temp matrix for the changes
	 * @return new anonymous matrix
	 */
	public Matrix rotateClockwise() {
		int[][] tempMatrix = new int[_matrix[0].length][_matrix.length];
		
		for(int i = 0; i < _matrix.length; i++) {
			for(int j = 0; j < _matrix[0].length; j++) {
				tempMatrix[j][_matrix.length-1-i] = _matrix[i][j];
			}
		}
		return new Matrix(tempMatrix);
	}
	
	/**
	 * rotate the matrix against the clockwise
	 * @param tempMatrix - create temp matrix for the changes
	 * @return new anonymous matrix
	 */
	public Matrix rotateCounterClockwise() {
		int[][] tempMatrix = new int[_matrix[0].length][_matrix.length];
		
		for(int i = 0; i < _matrix.length; i++) {
			for(int j = 0; j < _matrix[0].length; j++) {
				tempMatrix[_matrix[0].length-1-j][i] = _matrix[i][j];
			}
		}
		return new Matrix(tempMatrix);
	}
	
	/*
	private int aaa(int n, int m, int neighbors, int i, int j) {
		int temp = 0;
		for(int t = 1; t < neighbors; t++) {
			temp += _matrix[i+m][j+n];
		}
		return temp;
	}
	*/
	
	/** private method that calculate the average of index with his neighbors.</br>
	 *  the method check all extreme cases included one row or column and corners. 
	 *  
	 *  ////////
	 *  
	 */  
	private int averageNeighbors(int i, int j) {
		int sum = 0, neighbors = 0;
		
		for(int n = (i == 0 ? 0 : i-1); n <= (i == _matrix.length-1 ? i : i+1); n++) {
			for(int m = (j == 0 ? 0 : j-1); m <= (j == _matrix[0].length-1 ? j : j+1); m++, neighbors++)
				sum += _matrix[n][m];
		}
		return sum / neighbors;
	
		/* option 2 ! 
		int sum = _matrix[0][0], neighbors = 1; // default values (_matrix[0][0], 1) for matrix that have 2 or less index
		final int upLeft = _matrix[0][0], upRight = _matrix[0][_matrix[0].length-1], downLeft = _matrix[_matrix.length-1][0];
		final int currentIndex = _matrix[i][j];
		
		int sum = 0, k = 1, currentIndex = _matrix[i][j];
		if(_matrix.length == 1 || _matrix[0].length == 1) {
			for(int m = 1; k < (currentIndex == _matrix[0][0] ? 2 : 3); m*=-1, k++) {
				if(_matrix.length == 1) {
					if(currentIndex == _matrix[0].length-1)
						//sum = aaa(0, -m, 2, i, j);
						sum += _matrix[i][j-1];
					else
						//sum = aaa(0, m, 3, i, j);
						sum += _matrix[i][j+m];}
				if(_matrix[0].length == 1) {
					if(currentIndex == _matrix.length-1)
						//sum = aaa(-m, 0, 2, i, j);
						sum += _matrix[i-1][j];
					else
						//sum = aaa(m, 0, 3, i, j);
						sum += _matrix[i+m][j]; }
			}
		}
		else if() {
			
		}
		else if() {
			
		}
		else {
			k = 9; // 8 neighbors + 1 currentIndex
			sum = _matrix[i+1][j] + _matrix[i+1][j-1] + _matrix[i][j-1] + _matrix[i-1][j-1]
					+ _matrix[i-1][j] + _matrix[i-1][j+1] + _matrix[i][j+1] + _matrix[i+1][j+1];
		}
		return (sum += currentIndex) / k;
		
		
		
		
		/* option 3 ! 
		// if the array is exact one row or column 
		if(_matrix.length == 1 || _matrix[0].length == 1) {
			neighbors = 2; // 1 neighbor + 1 currentIndex
			// if the array is one row
			if(_matrix.length == 1 && _matrix[0].length != 1) {
				if(currentIndex == upLeft) // corner left
					sum = currentIndex + _matrix[i][j+1];
				else if(currentIndex == upRight) // corner right
					sum = currentIndex + _matrix[i][j-1];
				else { // middle
					neighbors = 3; // override. 2 neighbor + 1 currentIndex
					sum = currentIndex + _matrix[i][j+1] + _matrix[i][j-1];
				}
			}
			// if the array is one column
			else if(_matrix[0].length == 1 && _matrix.length != 1) {
				if(currentIndex == upLeft) // corner up
					sum = currentIndex + _matrix[i+1][j];
				else if(currentIndex == downLeft) // corner down
					sum = currentIndex + _matrix[i-1][j];
				else { // middle
					neighbors = 3; // override. 2 neighbor + 1 currentIndex
					sum = currentIndex + _matrix[i+1][j] + _matrix[i-1][j];
				}
			}
		} // old one without 1 row or 1 column
		// if the index in one or more of the corners
		else if(currentIndex == upLeft || currentIndex == upRight 
				|| currentIndex == downLeft || currentIndex == _matrix[_matrix.length-1][_matrix[0].length-1]) {
			neighbors = 4; // 3 neighbors + 1 currentIndex
			if(currentIndex == upLeft)
				sum = currentIndex + _matrix[i+1][j] + _matrix[i+1][j+1] + _matrix[i][j+1];
			else if(currentIndex == upRight)
				sum = currentIndex + _matrix[i+1][j] + _matrix[i+1][j-1] + _matrix[i][j-1];
			else if(currentIndex == downLeft)
				sum = currentIndex + _matrix[i-1][j] + _matrix[i-1][j+1] + _matrix[i][j+1];
			else // down right corner
				sum = currentIndex + _matrix[i-1][j] + _matrix[i-1][j-1] + _matrix[i][j-1];
		}
		// if the index in one or more of the sides
		else if(i == 0 || i == _matrix.length-1 || j == 0 || j == _matrix[0].length-1) {
			neighbors = 6; // 5 neighbors + 1 currentIndex
			if(i == 0) // up side
				sum = currentIndex + _matrix[i][j-1] + _matrix[i+1][j-1] + _matrix[i+1][j]
						+ _matrix[i+1][j+1] + _matrix[i][j+1];
			else if(i == _matrix.length-1) // down side
				sum = currentIndex + _matrix[i][j-1] + _matrix[i-1][j-1] + _matrix[i-1][j]
						+ _matrix[i-1][j+1] + _matrix[i][j+1];
			else if(j == 0) // left side
				sum = currentIndex + _matrix[i-1][j] + _matrix[i-1][j+1] + _matrix[i][j+1]
						+ _matrix[i+1][j+1] + _matrix[i+1][j];
			else // right side
				sum = currentIndex + _matrix[i+1][j] + _matrix[i+1][j-1] + _matrix[i][j-1] 
						+ _matrix[i-1][j-1] + _matrix[i-1][j];
		}
		// else the index in the middle
		else {
			neighbors = 9; // 8 neighbors + 1 currentIndex
			sum = currentIndex + _matrix[i+1][j] + _matrix[i+1][j-1] 
					+ _matrix[i][j-1] + _matrix[i-1][j-1]
					+ _matrix[i-1][j] + _matrix[i-1][j+1] + _matrix[i][j+1] + _matrix[i+1][j+1];
		}
		return (sum / neighbors); // return the average*/
	}
} // end of class Matrix
