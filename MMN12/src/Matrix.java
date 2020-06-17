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
				tempMatrix[i][j] = averageNeighbors(i, j); // private method
			}
		}
		return new Matrix(tempMatrix);
	}
		
		
	/** 
	 * private method that calculate the average of an index with his neighbors.
	 * the method check all extreme cases included one row or column and corners. explanation : <br>
	 * n = row, m = column, neighbors = number of currentIndex + neighbors.
	 * if i = 0 than the row = 1, else = 2 | if i = length-1 than n <= i, else <= i+1. same goth for the columns.
	 * basically it's creating unique iteration for any index in the matrix.
	 */
	private int averageNeighbors(int i, int j) {
		int sum = 0, neighbors = 0; // number of neighbors = currentIndex + neighbors
		
		for(int n = (i == 0 ? 0 : i-1); n <= (i == _matrix.length-1 ? i : i+1); n++) {
			for(int m = (j == 0 ? 0 : j-1); m <= (j == _matrix[0].length-1 ? j : j+1); m++, neighbors++)
				sum += _matrix[n][m]; // sum of the currentIndex + neighbors
		}
		return sum / neighbors; // make and return the average
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
	
} // end of class Matrix
