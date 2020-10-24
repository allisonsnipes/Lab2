import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class readMatrix {
    /**
     * This is the main method of the program. The program will take (2) run-
     * time arguments. Without the proper arguments the program will not
     * execute.
     * @param args provided from the user (names of the files to use)
     */
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
     * @param inputFile the data file provided to read the matrices
     * @param outputFile the file that will be created from read data
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
     * This block of code is responsible for determining all the paths between
     * each vertex. This is the method that utilizes the concept of recusion
     * as it will call another method that will search for a path between
     * vertices.
     *
     * @param matrices
     * @return
     */
    static String allThePaths(LinkedList<Integer> matrices[]) {
         int num = matrices.length;

        /**
         * The StringBuffer is a thread-safe, mutable sequence of characters. It
         * is like a String, but can be modified. It contains a sequence of
         * characters, and the length and content of the sequence can be
         * changed through method calls.
         */
         StringBuffer allThePaths = new StringBuffer();

        /**
         * This block of code is in charge of searching the actual matrix. It
         * will create an array of indices checked and save them there.
         */

        for (int i = 0; i < num; i++) {
             for (int j = 0; j < num; j++) {
                 boolean[] wasChecked = new boolean[num];
                 int[] prev = new int[num];
                 for(int k = 0; k < num; k++) {
                     prev[k] = -1;
                     if (i != j) {
                         wasChecked[i] = true;
                         allThePaths.append("\n" + "Path coming from" +
                                 (i + 1) + " is going to " + (j +1));
                     }

                     StringBuffer route = new StringBuffer();
                     wholePath(matrices, prev, wasChecked, i, j, k, 0, false, route);

                     if (route.toString().equals("")){
                         route.append("no path found." + "\n");
                     } else {
                         allThePaths.append(route);
                     }
                 }

             }
         }
        return allThePaths.toString();
    }

    /**
     * This block of code is responsible for reading the given input file,
     * output file, and throwing an exception should the file cannot be
     * read. This block of code is also responsible for creating the
     * Linklist that will hold the information contained in each graph/matrix.
     *
     * @param outputFile the file that will be created from read data
     * @param matrices
     * @param paths
     * @param writeData
     */
    static void writeOutput(String outputFile, LinkedList<Integer> matrices[], String paths, boolean writeData){

    }

    static void wholePath(){

    }

}
