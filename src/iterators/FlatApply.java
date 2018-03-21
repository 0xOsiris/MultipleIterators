package iterators;


import java.util.Iterator;

// Iterator that may produce 0 or more output elements for every input element
public class FlatApply<InT,OutT> implements Iterator<OutT> {
    
                private final Iterator<InT> input;
                
                private final FlatApplyFunction<InT,OutT> f;
                
		public FlatApply(FlatApplyFunction<InT,OutT> f, Iterator<InT> input) {
                    this.input= input;
                    this.f = f;
		}

		@Override
		public boolean hasNext() {
                    return input.hasNext();
		}

		@Override
		public OutT next() {
                    if (!hasNext()) throw new IllegalStateException();
                    
                    
                    
                    return f.apply(input.next());
		}

        // feel free to create private methods if helpful
}
