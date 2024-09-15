import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    private static final char[] NUCLEOTIDES = {'A', 'C', 'G', 'T'};
    private double[] probabilities;
    private int n; // number of sequances
    private int m; // Length of each sequence
    private String outputFile;

    public DataGenerator(int n, int m, double[] probabilities, String outputFile) {
        this.n = n;
        this.m = m;
        this.probabilities = probabilities;
        this.outputFile = outputFile;
    }

    public void generateData() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            writer.write(generateSequence(random));
            writer.newLine();
    }
        writer.close();
    }

    private String generateSequence(Random random) {
        StringBuilder sequence = new StringBuilder(m);
        for (int i = 0; i < m; i++) {
            sequence.append(selectNucleotide(random));
        }
        return sequence.toString();
    }

    private char selectNucleotide(Random random) {
        double rand = random.nextDouble();
        double cumulativeProbability = 0.0;
        for (int i = 0; i < NUCLEOTIDES.length; i++) {
            cumulativeProbability += probabilities[i];
            if (rand <= cumulativeProbability) {
                return NUCLEOTIDES[i];
            }
        }
        return NUCLEOTIDES[NUCLEOTIDES.length - 1];
    }
}
