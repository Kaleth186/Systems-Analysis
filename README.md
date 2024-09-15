## Workshop-No.-1-Entrophy-and-Divide-Conquer
### Abstract
This code allows us to create DNA sequences by generating random sequences, using Shannon's entropy to filter and discard low-entropy sequences, which could make the work of searching for and working with the sequences left over from the filter a little more efficient and meaningful.

### Project Structure

##### Classes

- `<DataGenerator.java>`: The DataGenerator class is responsible for generating artificial DNA sequences and saving them into a file. 
- `<EntropyFilter.java>`: The EntropyFilter class is designed to filter DNA sequences based on their Shannon entropy, a measure of randomness or diversity.
-  `<Launcher.java>`:The Launcher class is the main entry point for running the program. It coordinates the various components of the project, including sequence generation, entropy filtering, and motif searching.
-  `<MotifFinder.java>`: The MotifFinder class is responsible for searching and identifying motifs (subsequences) of a specified length in a set of DNA sequences.
-  `<ShannonEntropy.java>`: The ShannonEntropy class is responsible for calculating the Shannon entropy of a given DNA sequence.

##### Principal Methods
- `<filterSequencesByEntropy:>`
Filters sequences based on Shannon entropy, removing sequences that lack diversity.

- `<findMotifs:>`
Finds and counts motifs of a given size in the input sequences

- `<getMaxConsecutiveBases:>`
Returns the maximum number of consecutive identical nucleotides in a motif, used to identify repetitive motifs.

### Results and Output

The program outputs a list of motifs with their occurrences after filtering the sequences and searching for motifs.

## End
