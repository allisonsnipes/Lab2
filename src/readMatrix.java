import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class readMatrix {
    public static void main(String[] args) {
        if (args.length == 2) {
            String inputFile = args[0];
            String outputFile = args[1];


        }
    }

    /**
     * This block of code is responsible for reading the given input file,
     * output file, and throwing an exception should the file cannot be
     * read. This block of code is also responsible for creating the
     * Linklist that will hold the information contained in each graph/matrix.
     *
     * @param inputFile
     * @param outputFile
     * @throws FileNotFoundException
     */
    static void graphInput(String inputFile, String outputFile) throws FileNotFoundException {
        Scanner inputGraphs = new Scanner(new File(inputFile));
        boolean hasData = true;

        int num;
        LinkedList<Integer> matrices[];

        /**
         * While there is input to be read in each row, then the input should
         * be saved into a variable to be placed into a matrix that will be
         * written to the output file. Once we have the data read from the
         * matrix we will check to see if the output file has data already.
         * If it has data we will not write to the file, if it does not we
         * will write to the output file.
         */
        while (inputGraphs.hasNextLine()){
            num = inputGraphs.nextInt();
            matrices = new LinkedList[num];
            for( int i = 0; i < num; i++){
                matrices[i] = new LinkedList<Integer>();
                    for(int j = 0; j < num; j++){
                        int indices = inputGraphs.nextInt();
                        if (indices != 0) {
                            matrices[i].addLast(j);
                        }
                    }
            }
            String paths = allThePaths(matrices);

            if(hasData) {
               writeOutput(outputFile, matrices, paths, false);
               hasData = false;
            } else {
                writeOutput(outputFile, matrices, paths, true);
            }
            inputGraphs.close();
        }
    }

    /**
     *
     * @param matrices
     * @return
     */
    static String allThePaths(LinkedList<Integer> matrices[]) {
         int num = matrices.length;
         StringBuffer allThePaths = new StringBuffer();

    }

    static void writeOutput(String outputFile, LinkedList<Integer> matrices[], String paths, boolean writeData){

    }

}
