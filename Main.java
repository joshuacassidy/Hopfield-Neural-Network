import java.util.Random;

public class Main {

    public static void main(String[] args) {
        HopfieldNetwork hopfieldNetwork = new HopfieldNetwork(4);
        hopfieldNetwork.train(new double[] {1,0,1,0});
        hopfieldNetwork.train(new double[] {1,1,1,1});
        hopfieldNetwork.train(new double[] {0,0,0,0});


        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            hopfieldNetwork.recall(new double[] {random.nextInt(2),random.nextInt(2),random.nextInt(2),random.nextInt(2)});
            System.out.println();
        }
        hopfieldNetwork.printMatrix();



    }



}
