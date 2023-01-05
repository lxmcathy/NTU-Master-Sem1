

package TestIndex;

import org.apache.lucene.search.ScoreDoc;
import java.util.Scanner;

public class LuceneTester {

	/** Define the paths for the data file and the lucene index */
	public static final String DATA_FILE="./data/processed_dataCell.json";
	public static final String INDEX_PATH="./data/luceneIndex";
	
	
	public static void main (String[] arg) throws Exception{
		System.out.println("If you want to have not do indexing, input 1 to do index, otherwise input 0:");
		Scanner in = new Scanner(System.in);
		String s0 = in.nextLine();

		if(s0.equals("1")){
			QAIndexer indexer = new QAIndexer(LuceneTester.INDEX_PATH);
			indexer.indexQAs(LuceneTester.DATA_FILE);
		}
		
				
		//search index
		QASearcher searcher=new QASearcher(LuceneTester.INDEX_PATH);

		//command line control
		System.out.println("What field you want to search? input 0 for reviewText; 1 for reviewerID; and 2 for asin:");
		String s1 = in.nextLine();
		System.out.println("Please input query:");
		String s2 = in.nextLine();
		System.out.println("Please input the number of results you want to display:");
		int n0 = in.nextInt();

		if(s1.equals("0")){
			ScoreDoc[] hits = searcher.search("reviewText", s2, n0);
			System.out.println("\n=================Results for reviewText search=============\n");
			searcher.printResult(hits);
		}
		if(s1.equals("1")) {
			ScoreDoc[] hits_id=searcher.search("reviewerID", s2, n0);
			System.out.println("\n=================Results for id search=============\n");
			searcher.printResult(hits_id);
		}
		if(s1.equals("2")) {
			ScoreDoc[] hits_asin = searcher.search("asin", s2, n0);
			System.out.println("\n=================Results for asin search=============\n");
			searcher.printResult(hits_asin);
		}
	}
	
}
