package jwd.wafepa.model;

import java.util.Comparator;
	
public class Sortiraj implements Comparator<Ucesnik> {


	

	

		int direction = 1;
		
		public Sortiraj(int direction) {
			if(direction!=1 && direction!=-1){
				direction = 1;
			}
			this.direction = direction;
		}
	

		@Override
		public int compare(Ucesnik ob1, Ucesnik ob2) {
			// TODO Auto-generated method stub
			int retVal = 0;
			if(ob1!= null && ob2!=null){
				retVal = ob1.getBrojBodova().compareTo(ob2.getBrojBodova());
			}
			return retVal * direction;

		}
	
}
