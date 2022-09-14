package Project1;

import java.util.Arrays;

public class SequentialMatrix extends Matrix {

	public SequentialMatrix() {
		this(2, 2);
	}

	public SequentialMatrix(int rows, int columns) {

		this.rows = rows;
		this.cols = columns;
		matrix = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = (int) (Math.random() * 100);
			}
		}

	}

	public SequentialMatrix(int[][] matrixArray) {

		this.rows = matrixArray.length;
		this.cols = matrixArray[0].length;
		this.matrix = new int[this.rows][this.cols];
		for (int i = 0; i < rows; i++) {
			matrix[i] = Arrays.copyOf(matrixArray[i], matrixArray[i].length);
		}
	}

	@Override
	public Matrix add(Matrix otherMatrix) {

		if (this.rows != otherMatrix.rows || this.cols != otherMatrix.cols) {
			System.out.println(this.rows + " " + otherMatrix.rows + " " + this.cols + " " + otherMatrix.cols);
			return null;
		}

		int[][] answer = new int[this.rows][this.cols];
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				answer[i][j] = this.matrix[i][j] + otherMatrix.matrix[i][j];

			}
		}

		return new SequentialMatrix(answer);
	}

	@Override
	public Matrix subtract(Matrix otherMatrix) {
		if (this.rows != otherMatrix.rows || this.cols != otherMatrix.cols) {

			return null;
		}

		int[][] answer = new int[this.rows][this.cols];
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				answer[i][j] = this.matrix[i][j] - otherMatrix.matrix[i][j];

			}
		}
		return new SequentialMatrix(answer);

	}

	@Override
	public Matrix dotProduct(Matrix otherMatrix) {
		if (this.cols != otherMatrix.rows) {

			return null;
		}
		int[][] answer = new int[this.rows][otherMatrix.cols];
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < otherMatrix.cols; j++) {
				for (int k = 0; k < this.cols; k++)
					answer[i][j] += this.matrix[i][k] * otherMatrix.matrix[k][j];

			}
		}
		return new SequentialMatrix(answer);

	}

	@Override
	public Matrix HadamardProduct(Matrix otherMatrix) {
		if (this.rows != otherMatrix.rows || this.cols != otherMatrix.cols) {

			return null;
		}
		int[][] answer = new int[this.rows][this.cols];
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				answer[i][j] = this.matrix[i][j] * otherMatrix.matrix[i][j];

			}
		}
		return new SequentialMatrix(answer);

	}
}
