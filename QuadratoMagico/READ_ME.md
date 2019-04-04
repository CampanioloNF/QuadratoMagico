# Quadrato magico

Dato un numero intero N, costruire un quadrato
di NxN caselle. Ciascuna delle quali contiene un numero tra 1 a N^2.
I numeri devono essere tutti diversi tra di loro.

Il quadrato si dice *magico* se la somma dei numeri su ciascuna riga, la
somma dei numeri su ciascuna colonna e la sommma dei numeri su ciascuna diagonale,
sono uguali.

Nota: il valore delle somme sarà:
   
   N*(N^2+1)/2 
   
#Analisi del problema

    X X X 
    X X X
    X X X  
 
 Approccio 1: 
 Ad ogni livello L della ricorsione scelgo quale valore mettere all'interno della casella L
 
     L=0
 
     4 X X
     X X X
     X X X
  
    L=1
   
      4 8 X
      X X X
      X X X
    
 quando ho riempito un quadrato di numeri le somme tornano?
 
 Genero tutti i possibili quadrati di cui una parte avrà tale somma
 
    
 
 Approccio 2:
 
 Ad ogni livello L decido dove mettere il numero L+1
 
    L=0 --> Dove metto il numero 1?
 
     X X X
     X X 1
     X X X
  
  
    L=1 --> Dove metto il numero 2?
 
     X X X
     2 X 1
     X X X
  
    Al livello 9 avrò riempito la mappa 
  
  