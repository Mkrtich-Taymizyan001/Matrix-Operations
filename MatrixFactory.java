package Project1;

public class MatrixFactory {
	public Matrix makeSequentialMatrix(int input) {
		return (Matrix) new SequentialMatrix(input, input);

	}

	public Matrix makeParallelMatrix(int input) {
		return (Matrix) new ParallelMatrix(input, input);

	}

}