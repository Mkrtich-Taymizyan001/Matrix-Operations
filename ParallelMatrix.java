package Project1;

import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Random;

public class ParallelMatrix extends Matrix {

	public ParallelMatrix() {
		this(2, 2);
	}

	public ParallelMatrix(int rows, int columns) {
		this.rows = rows;
		this.cols = columns;
		matrix = IntStream.range(0, rows).parallel().mapToObj(i -> new Random().ints(0, 100).limit(cols).toArray())
				.toArray(int[][]::new);
	}

	public ParallelMatrix(int[][] matrixArray) {
		this.rows = matrixArray.length;
		this.cols = matrixArray[0].length;
		matrix = IntStream.range(0, rows).parallel().mapToObj(i -> Arrays.copyOf(matrixArray[i], matrixArray[i].length))
				.toArray(int[][]::new);
	}

	@Override
	public Matrix add(Matrix otherMatrix) {
		int[][] answer = IntStream.range(0, rows).parallel().mapToObj(i -> IntStream.range(0, cols).parallel()
				.map(j -> this.matrix[i][j] + otherMatrix.matrix[i][j]).toArray()).toArray(int[][]::new);

		return new ParallelMatrix(answer);
	}

	@Override
	public Matrix subtract(Matrix otherMatrix) {
		int[][] answer = IntStream.range(0, rows).parallel().mapToObj(i -> IntStream.range(0, cols).parallel()
				.map(j -> this.matrix[i][j] - otherMatrix.matrix[i][j]).toArray()).toArray(int[][]::new);

		return new ParallelMatrix(answer);
	}

	@Override
	public Matrix dotProduct(Matrix otherMatrix) {
		int[][] answer = IntStream.range(0, rows).parallel()
				.mapToObj(i -> IntStream
						.range(0, otherMatrix.cols).parallel().map(j -> IntStream.range(0, cols).parallel()
								.map(k -> matrix[i][k] * otherMatrix.matrix[k][j]).reduce(0, (a, b) -> a + b))
						.toArray())
				.toArray(int[][]::new);

		return new ParallelMatrix(answer);
	}

	@Override
	public Matrix HadamardProduct(Matrix otherMatrix) {
		int[][] answer = IntStream.range(0, rows).parallel().mapToObj(i -> IntStream.range(0, cols).parallel()
				.map(j -> this.matrix[i][j] - otherMatrix.matrix[i][j]).toArray()).toArray(int[][]::new);

		return new ParallelMatrix(answer);
	}

}
