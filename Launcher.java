import java.io.*;
import java.util.*;

public class Launcher {

    public static void main(String[] args) throws IOException {
        int[] sequenceSizes = {10000, 50000};
        double[][] baseProbabilities = {
                {0.4, 0.3, 0.2, 0.1},
                {0.25, 0.25, 0.25, 0.25}
        }; //These are the probabilities of the databases
        int[] motifSizes = {5, 6}; //Size of the motif to be searched
        double entropyThreshold = 1.5; //Entropy threshold for filtering sequences

        String outputFile = "nucleotide_data.txt";

        for (int seqSize : sequenceSizes) {
            for (double[] probabilities : baseProbabilities) {
                //Generate the data sets
                DataGenerator generator = new DataGenerator(seqSize, 50, probabilities, outputFile);
                generator.generateData(); 

                System.out.println("\nResultados sin filtro de entropía:");
                runMotifFinder(outputFile, motifSizes);//Searching for motifs without entropy filter

                List<String> filteredSequences = EntropyFilter.filterSequencesByEntropy(outputFile, entropyThreshold);
                //Filter sequences by entropy

                String filteredFile = "filtered_nucleotide_data.txt";
                saveFilteredSequences(filteredSequences, filteredFile);//Filtered sequences are saved in a txt file

            //Searching for motifs with entropy filter
                System.out.println("\nResults with entropy filter:");
                runMotifFinder(filteredFile, motifSizes);
            }
        }
    }

    // This function runs the motif finder and records the time spent searching for the motif.
    private static void runMotifFinder(String inputFile, int[] motifSizes) throws IOException {
        for (int motifSize : motifSizes) {
            long startTime = System.currentTimeMillis();
            MotifFinder finder = new MotifFinder(motifSize, inputFile);
            finder.findMotifs();
            long endTime = System.currentTimeMillis();
            System.out.println("time for the size of motif " + motifSize + ": " + (endTime - startTime) );
        }
    }

    // Function to save filtered sequences to a file
    private static void saveFilteredSequences(List<String> sequences, String outputFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (String sequence : sequences) {
            writer.write(sequence);
            writer.newLine();
        }
        writer.close();
    }
}
