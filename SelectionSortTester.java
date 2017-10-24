import java.io.*;
import java.util.*;

public class SelectionSortTester {

	public static void main(String[] args) {
		
		// ArrayList to hold the words in the file
		ArrayList<String> wordList = new ArrayList<String>();
		
        // The name of the file to open.
        String fileName = "./src/temp.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] split = line.trim().split("\\s+");
                for (String word : split) {
                	if (!word.equals("")) {
                		wordList.add(word);
                	}
                }
            }   

            // Always close files.
            bufferedReader.close();
            
            // Sort list of words and print out
            final long startTime = System.nanoTime();
            SelectionSorter.selectionSort(wordList);
            final long duration = System.nanoTime() - startTime;
            double secs = duration / 1e+9;
            for (String word : wordList) {
            	System.out.println(word);
            }
            
            System.out.println(wordList.size() + " words");
            System.out.println(secs + " seconds to sort");
            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
}
