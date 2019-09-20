package iterators;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.*;


// Iterator that uses a Predicate to filter out elements from the input
public class Filter<T> extends FlatApply<T,T> {
	public Filter(Predicate<T> p, Iterator<T> input) {
		// you DO NOT need to modify the constructor
		super(new FilteringFlatApplyFunction<>(p), input);
	}	

    // uses a Predicate to decide whether the input element is output or not
	private static class FilteringFlatApplyFunction<T> implements FlatApplyFunction<T, T> {
            Predicate<T> p;
            
            
            public FilteringFlatApplyFunction(Predicate<T> p){
                this.p=p;
                
            }
            
            @Override
            public List<T> apply(T x){
                List<T> l= new LinkedList<>();
                if(p.check(x)==true){
                    
                    return Arrays.asList(x);
                }else{
                    
                    return l;
                }
                
            }
            
            
            
            
	}

    // You DO NOT need to define hasNext() and next(). FlatApply provides them already.
}
