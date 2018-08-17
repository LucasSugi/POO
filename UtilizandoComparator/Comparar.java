import java.util.*;

//Implementando a interface Comparator
public class Comparar implements Comparator<Integer>{
	
	//Implementando a função compare	
	@Override
	public int compare(Integer a, Integer b){
	
		if(a > b){
			return -1;
		}
		if(a == b){
			return 0;
		}	
		return 1;	
	}
}
