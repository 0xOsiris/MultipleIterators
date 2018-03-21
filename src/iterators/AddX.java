package iterators;


import java.util.Iterator;

public class AddX implements Iterator{
      
        private final Iterator<Integer> input;	
                private final int x;

		public AddX(int x, Iterator<Integer> input) {
				this.input = input;
                                this.x = x;
		}

		@Override
		public boolean hasNext() {
                    return input.hasNext();
		}

		@Override
		public Integer next() {
                    
                    if (!hasNext()) throw new IllegalStateException();
                    
                    Integer result = input.next();
                    
                    result+=x;
                    
                    return result;
                    
                    
		}
}
