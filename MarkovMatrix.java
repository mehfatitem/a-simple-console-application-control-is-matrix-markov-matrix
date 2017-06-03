package markov_matrix;

public class MarkovMatrix implements InterfaceMarkovMatrix {
	
	public MarkovMatrix() {
		
		double[][] matrix = new double[][] { { 0.0, 0.5, 0.2 }, { 0.3, 0.1, 0.7 }, {0.7, 0.4, 0.1 } };

		if (this.validMatrix(matrix))
			this.print("Markov matrisidir.");
		else
			this.print("Markov matrisi degildir.");
	}
	
	private void print(Object text) {
		System.out.println(text);
	}
	
	@Override
	public boolean numberControl(double matrix[][]) {

		int row = matrix.length;
		int column = matrix[0].length;

		boolean result = true;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < column; j++) {

				if (matrix[i][j] < 0)
					result = false;
			}
		}
		
		return result;
	}

	@Override
	public boolean valControl(double matrix[][]) {

		int row = matrix.length;
		int column = matrix[0].length;

		boolean result = false;
		int counter = 0;
		double total = 0.0;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < column; j++) {
				total += matrix[j][i];
				total = Math.round(total * 1e4) / 1e4;
			}
			
			if (total == 1.0)
				counter++;

			if (counter == column)
				result = true;

			total = 0.0;
		}
		

		return result;
	}

	@Override
	public boolean validMatrix(double matrix[][]) {
		
		return this.numberControl(matrix) && this.valControl(matrix);
	}
}
