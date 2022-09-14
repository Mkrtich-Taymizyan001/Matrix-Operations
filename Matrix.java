package Project1;

import java.util.Arrays;

public abstract class Matrix {

	protected int[][] matrix;
	int rows;
	int cols;

	public abstract Matrix add(Matrix otherMatrix);

	public abstract Matrix subtract(Matrix otherMatrix);

	public abstract Matrix dotProduct(Matrix otherMatrix);

	public abstract Matrix HadamardProduct(Matrix otherMatrix);

	@Override
	public String toString() {
		return Arrays.stream(matrix)
				.map(x -> Arrays.stream(x).mapToObj(i -> String.format(" % 6d", i)).reduce("", (a, b) -> a + b))
				.reduce("", (a, b) -> a + b + '\n');
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Matrix)) {
			return false;
		}
		Matrix m = (Matrix) obj;
		for (int i = 0; i < this.rows; i += 1)
			for (int j = 0; j < this.cols; j += 1) {
				if (this.matrix[i][j] != m.matrix[i][j]) {
					return false;
				}
			}
		return true;
	}

	static boolean validOperation(Matrix A, Matrix B) {
		return (A.cols == B.cols && A.rows == B.rows);
	}

	static boolean vaildDot(Matrix A, Matrix B) {
		return (A.cols == B.rows);
	}

}
