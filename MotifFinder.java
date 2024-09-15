import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MotifFinder {

    private int s; // Motif size
    private String fileName; // file with the sequences
    private Map<String, Integer> motifCountMap; //To count occurrences of motives

    public MotifFinder(int s, String fileName) {
        this.s = s;
        this.fileName = fileName;
        this.motifCountMap = new HashMap<>();
    }//Constructor of MotifFinder class

    public void findMotifs() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i <= line.length() - s; i++) {
                String motif = line.substring(i, i + s);
                motifCountMap.put(motif, motifCountMap.getOrDefault(motif, 0) + 1);
            }
        }
        reader.close();

        String bestMotif = null;
        int maxCount = 0;
        int maxRepetition = 0;

        for (Map.Entry<String, Integer> entry : motifCountMap.entrySet()) {
            String motif = entry.getKey();
            int count = entry.getValue();
            int repetition = getMaxConsecutiveBases(motif);

            if (count > maxCount || (count == maxCount && repetition > maxRepetition)) {
                bestMotif = motif;
                maxCount = count;
                maxRepetition = repetition;
            }
        }

        System.out.println("Best motif: " + bestMotif + " with " + maxCount + " ocurrences and " + maxRepetition + " consecutive repetitions.");
    } //findMotifs method to find motifs of size 's' in the file sequences, then stores them in a HashMap with their frequency of appearance.

    private int getMaxConsecutiveBases(String motif) {
        int maxRepetition = 1;
        int currentRepetition = 1;

        for (int i = 1; i < motif.length(); i++) {
            if (motif.charAt(i) == motif.charAt(i - 1)) {
                currentRepetition++;
            } else {
                currentRepetition = 1;
            }
            maxRepetition = Math.max(maxRepetition, currentRepetition);
        }
        return maxRepetition;//Returns the maximum number of consecutive occurrences found.
    }//Method for obtaining the maximum number of consecutive repeated bases in a motif
}

