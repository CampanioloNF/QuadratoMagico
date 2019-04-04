package it.polito.tdp.quadratomagico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CercaQuadrato {

	//lavora in un livello L ed ha un quadrato parzialmente riempito

	List<Quadrato> soluzioni = new LinkedList<Quadrato>();
	
	public void genera(int size) {
		
		long prima = System.currentTimeMillis();
		
		Quadrato parziale = new Quadrato(size) ;
		this.soluzioni= new ArrayList<Quadrato>() ;
		this.cerca(parziale, 0);
		
		System.out.println(this.soluzioni.toString());
	
		System.out.println(""+(System.currentTimeMillis()-prima));
	}

	
	
	private void cerca(Quadrato parziale, int L) {
		
		/*le L caselle da 0 a L-1 sono piene e devo 
	    trovare la casella in posizione L
	    A meno che il quadrato non sia pieno!
	      */
		
		if(L==parziale.getSize2() ) {
			/*
			 * r
			 * il quadrato è pieno e devo verificare se è magico
			 */
			
		
			
			if(parziale.isMagic()) {
				soluzioni.add(parziale.clone());
				
			}
			return;
		}
		
		/*
		 * Caso generico
		 */
		
		for(int i=1; i<=parziale.getSize2();i++) {
			//provo a mettere il valore 'i' nella casella 'L'
			

			//condizioni
			                                                        //se tolgo isEmpty mi da tutte le soluzioni
			if(!parziale.contains(i) && parziale.controllaRiga(parziale) && soluzioni.isEmpty()) {
			parziale.add(i);
			
			cerca(parziale, L+1);
			
			parziale.remove(i);
			
		    }
		}
	}


	
}
