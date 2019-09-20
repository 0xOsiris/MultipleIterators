package iterators;


import java.util.Iterator;
import java.util.*;
import java.util.LinkedList;

// Iterator that may produce 0 or more output elements for every input element
public class FlatApply<InT,OutT> implements Iterator<OutT> {
                private final Iterator<InT> input;
                
                
                private boolean end0 =false;
                
                          
                private int count;
                //Alternate List used as a queue
                private List<OutT> queueList = new LinkedList<OutT>();
                
                private int secondCount=0;
                
                //Iterator iterating over queue
                public Iterator<OutT> queue;
                
                //FlatApplyFunction initialization
                private final FlatApplyFunction<InT,OutT> f;
                
                //Keep track of the size of the list
                private int listIndex=0;
                
		public FlatApply(FlatApplyFunction<InT,OutT> f, Iterator<InT> input) {
                    //initialize input iterator
                    this.input= input;
                    
                    //initialize FlatApplyFunction
                    this.f = f;
                                   
                  
		}
                
               

		@Override
		public boolean hasNext() {
                    
                    if(queueList.size()>0){
                        return true;
                    }
                    
                    while(input.hasNext()){
                        queueList.addAll(f.apply(input.next()));
                        if(queueList.size()>0){
                            return true;
                        }
                    }
                    
                    return false;
                    
		}

		@Override
		public OutT next() {
                    //if (!hasNext()) throw new IllegalStateException();
                    
                    //check if queue is empty
                    if(queueList.size()==0){
                        
                        //Make Queud list into the output List                        
                        queueList.addAll(f.apply(input.next()));                        
                        
                        //Set the int listSize to the size of the list
                        if(queueList.size()>0){                            
                            
                            return queueList.remove(queueList.size()-1);                            
                            
                        }else while(queueList.size()==0 && input.hasNext()){
                            
                            queueList.addAll(f.apply(input.next()));
                        }
                                             
                    }
                    return queueList.remove(queueList.size()-1);
                                         
		}  
                
  
                
                

        // feel free to create private methods if helpful
}
