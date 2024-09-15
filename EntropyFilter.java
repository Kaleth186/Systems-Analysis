import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EntropyFilter {

    public static List<String> filterSequencesByEntropy(String inputFile, double entropyThreshold) throws IOException {
        List<String> filteredSequences = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        while ((line = reader.readLine()) != null) {
            double entropy = ShannonEntropy.calculateEntropy(line); //Calculates the entropy of the current sequence using the calculateEntropy method of the ShannonEntropy class.
            if (entropy >= entropyThreshold) {
                filteredSequences.add(line);
            }
        }

        reader.close();
        return filteredSequences;//Returns the list of sequences that passed the entropy filter.
    }
}
