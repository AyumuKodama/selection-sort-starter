import java.util.*;

public class SelectionSorter {

	public static void selectionSort(ArrayList<String> wordList) {
		
		int numWords = wordList.size();
		for (int i = numWords - 1; i >= 0; i--) {
			int maxPos = 0;
			String ref = wordList.get(0);
			for (int j = 0; j <= i; j++) {
				if (wordList.get(j).compareTo(ref) > 0) {
					maxPos = j;
					ref = wordList.get(j);
				}
			}
			Collections.swap(wordList,  maxPos, i);
		}
	}
}
