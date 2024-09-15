public class ShannonEntropy {

    public static double calculateEntropy(String sequence) {
        int[] counts = new int[4]; // Para las bases A, C, G, T
        int length = sequence.length();

        // Contar ocurrencias de cada base
        for (char base : sequence.toCharArray()) {
            switch (base) {
                case 'A':
                    counts[0]++;
                    break;
                case 'C':
                    counts[1]++;
                    break;
                case 'G':
                    counts[2]++;
                    break;
                case 'T':
                    counts[3]++;
                    break;
            }
        }

        double entropy = 0.0;
        for (int count : counts) {
            if (count > 0) {
                double p = (double) count / length;
                entropy -= p * (Math.log(p) / Math.log(2));
            }
        }

        return entropy;
    }
}
