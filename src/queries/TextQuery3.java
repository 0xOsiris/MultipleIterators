package queries;


import iterators.Apply;
import iterators.ApplyFunction;
import iterators.Filter;
import iterators.FlatApply;
import iterators.FlatApplyFunction;
import iterators.Predicate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import readers.TextFileReader;

// return all filenames that contain the word "Mars" 
public class TextQuery3 {
	public static void main(String[] args) {
		Iterator<Pair<String,String>> filenameAndContents = new TextFileReader("../sci.space");
		Iterator<String> filename = new Apply(new TextQuery3.TakeLeft<>(), filenameAndContents);
                Iterator<String> filter = new Filter(new checkMars(), filename);
		/* finish the query using a combination of Applys and Filters */
		
		while (filename.hasNext()) {
                    while(filter.hasNext()){
			System.out.println(filter.next());
                    }
		}
	}
        
        private static class TakeLeft<L,R> implements ApplyFunction<Pair<L,R>, L> {
            
		@Override
		public L apply(Pair<L, R> x) {
			return x.left;	
		}
	}
        
        public static class checkMars implements Predicate<String> {
                
				@Override
				public boolean check(String data) {
						return data=="Mars";
				}
				
		}


	

}
