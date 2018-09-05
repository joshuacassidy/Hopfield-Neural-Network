import java.util.Arrays;

public class HopfieldNetwork {

    private double[][] weightMatrix;

    public HopfieldNetwork(int dimesion) {
        this.weightMatrix = new double[dimesion][dimesion];
    }

    public void train(double[] pattern) {

        double[] patternBipolar = Utils.transform(pattern);
        double[][] patternMatrix = Matrix.createMatrix(patternBipolar.length, patternBipolar.length);
        patternMatrix = Matrix.outerProduct(patternBipolar);
        patternMatrix = Matrix.clearDiagnols(patternMatrix);
        this.weightMatrix = Matrix.addMatrix(weightMatrix, patternMatrix);

    }


    public  void recall(double[] pattern ) {
        double[] patternBipolar = Utils.transform(pattern);
        double[] result = Matrix.matrixVectorMulitplication(weightMatrix, patternBipolar);
        for (int i = 0; i < patternBipolar.length; i++) {
            result[i] = ActivationFunction.stepFunction(result[i]);
        }

        for (int i = 0; i < pattern.length; i++) {
            if(patternBipolar[i] != result[i]) {
                System.out.println("Pattern " + Arrays.toString(result) + " not recognised...");
                return;
            }
        }
        System.out.println("Pattern " + Arrays.toString(result) + " recognised!");
    }

    public void printMatrix() {
        for (int i = 0; i < weightMatrix.length; i++) {
            for (int j = 0; j < weightMatrix[i].length; j++) {
                System.out.print(weightMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
