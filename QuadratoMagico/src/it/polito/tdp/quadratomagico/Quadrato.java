package it.polito.tdp.quadratomagico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Quadrato {

	private int size;
	private List<Integer> mappa;
	private int size2;
	private int sommaMagica;
	
	public Quadrato(int size) {
		this.setSize(size);
		mappa = new LinkedList <Integer>();
		this.size2=size*size;
		this.sommaMagica = ( (size2*(size2+1))/2 ) / size ;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void add(Integer n) {
		mappa.add(n);
	}
	
	public void remove(int i) {
		this.mappa.remove(new Integer(i)) ;
	}

	public boolean contains(int i) {
		return this.mappa.contains(i);
	}

	public int getSize2() {
		return size2;
	}

	@Override
	protected Quadrato clone() {
		
		Quadrato q = new Quadrato(this.size) ;
		q.mappa = new ArrayList<>(this.mappa) ;
		return q ;
	}

	private int get(int riga, int col) {
		return mappa.get(riga*size+col) ;
	}


	public boolean isMagic() {
		
		// controlla righe
	    for(int riga=0; riga<size; riga++) {
			int somma = 0 ;
			for(int col=0; col<size; col++)
				somma += get(riga, col) ;
			if (somma!=sommaMagica)
				return false ;
		}
		
		// controlla colonne
		for(int col=0; col<size; col++) {
			int somma = 0 ;
			for(int riga=0; riga<size; riga++)
				somma += get(riga, col) ;
			if (somma!=sommaMagica)
				return false ;
		}
		
		// controlla D1 \
		int somma = 0 ;
		for(int riga=0; riga<size; riga++)
			somma+=get(riga, riga) ;
		if (somma!=sommaMagica)
			return false ;

		// controlla D2 /
		somma = 0 ;
		for(int riga=0; riga<size; riga++)
			somma+=get(riga, size-riga-1) ;
		if (somma!=sommaMagica)
			return false ;
		
		// se tutte le somme quadrano
		return true;
	}
	
	/*@Override
	public String toString() {
		String s ="";
		
		for(int i=0; i<size;i++) {
			for(int j=0; j<size; j++)
				s+=" "+this.get(i, j)+" ";
			s+="\n";
		}
		
		return s;
	}*/
	
	@Override
	public String toString() {
		return this.mappa.toString() ;
	}

	public boolean controllaRiga(Quadrato parziale) {
		
		
		
		for(int i=0; i<(parziale.mappa.size())/parziale.size; i++) {
			 
			int somma = 0;
			
			for(int j=0; j<parziale.size;j++)
			     somma += get(i, j);
			if (somma!=sommaMagica)
				return false;
		}
		
		return true;
	}
	
	
	
	
}

