package module2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class SpellChecker {

		ArrayList<String> fileArray = new ArrayList<>();
		ArrayList<String> dictionaryArray = new ArrayList<>();
		ArrayList<String> unknownWords = new ArrayList<>();
		
		

		
		public SpellChecker() throws FileNotFoundException {
			BufferedReader br = null;
			FileReader fr = null;
		
			 try {
				 fr = new FileReader("C:/Users/jada/Documents/states.txt");

					br = new BufferedReader(fr);
					String sCurrentLine;

					while ((sCurrentLine = br.readLine()) != null) {
						System.out.println(sCurrentLine);
					}
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			  
			
			 }finally {
				 
				 try {
					 if (br != null)
							br.close();

						if (fr != null)
							fr.close();
				 }catch (IOException ex) {
					 ex.printStackTrace();
				 }
			 }	
		}
		public void readDictionary() {
			BufferedReader br = null;
			FileReader fr = null;

			try {

				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader("C:/Users/jada/Documents/dictionary.txt");
				br = new BufferedReader(fr);

				String sCurrentLine;

				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
				}

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
		}
		
		public void spellCheck(String fileName) throws FileNotFoundException
		{
		System.out.println(" Spell checking " + fileName + " ");
		Scanner input = new Scanner(System.in);
		



		// Read in each line from "fileName"
		BufferedReader br = null;
		       FileReader fr = null;
		StringTokenizer st ;
		       try {

		           fr = new FileReader(fileName);
		           br = new BufferedReader(fr);
		           String line;
		String word;
		           while ((line = br.readLine()) != null) { 
		               st = new StringTokenizer(line, " \t,.;:-%'\"");
		while(st.hasMoreTokens())
		{
		//make each word a lower case
		word = st.nextToken().toLowerCase();

		// Skip over word 
		if(dictionaryArray.contains(word)||fileArray.contains(word)||(word.charAt(0)>64&&word.charAt(0)<91)||(word.charAt(0)>96&&word.charAt(0)<123)) {
		unknownWords.add(word);
		}
		// add word to unknownwords array 
		else {
				System.out.println(word + "added to arraylist"); 

		}
		  
		  
		}
		}
		           

		       } catch (IOException e) {

		           e.printStackTrace();

		       } finally {

		           try {

		               if (br != null)
		                   br.close();

		               if (fr != null)
		                   fr.close();

		           } catch (IOException ex) {

		               ex.printStackTrace();

		           }

		       }


		}
		  
		  
		public static void main(String[] args) {
		try {
		SpellChecker checkSpelling = new SpellChecker();
		  
		for (int i=0; i < args.length; i++)
		{
		checkSpelling.spellCheck(args[i]);	
		checkSpelling.unknownWords();
		}
		}
		catch (IOException ex)
		{
		System.out.println(ex);
		}
		  

		}
		private void unknownWords() {

			System.out.println(unknownWords);

		}

	}