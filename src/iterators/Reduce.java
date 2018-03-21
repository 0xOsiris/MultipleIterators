package iterators;


import java.util.Iterator;

// Iterator that returns a single element that is the result of
// combining all the input elements
public class Reduce<InT,OutT> implements Iterator<OutT> {
		public Reduce(ReduceFunction<InT,OutT> f, Iterator<InT> input) {
		}

		@Override
		public boolean hasNext() {
                    return
		}

		@Override
		public OutT next() {
		}
}
