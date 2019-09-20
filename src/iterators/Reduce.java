package iterators;


import java.util.Iterator;

// Iterator that returns a single element that is the result of
// combining all the input elements
public class Reduce<InT,OutT> implements Iterator<OutT> {
                private ReduceFunction<InT,OutT> f;
                private Iterator<InT> input;
                private int count;
                private int numCalls=0;
                
		public Reduce(ReduceFunction<InT,OutT> f, Iterator<InT> input) {
                    this.f =f;
                    this.input=input;
		}

		@Override
		public boolean hasNext() {
                    if(numCalls==0){
                        return true;
                    }
                    return input.hasNext();
		}

		@Override
		public OutT next() {
                    if (!hasNext()) throw new IllegalStateException();
                    
                    
                    numCalls+=1;
                    
                    OutT initialValue = f.initialValue();
                    if(!hasNext()){
                        return initialValue;
                    }
                    OutT soFar= f.combine(initialValue, input.next());
                    while(input.hasNext()){
                        soFar = f.combine(soFar, input.next());
                    }
                    
                    return soFar;
                    
		}
}
