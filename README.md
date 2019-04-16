# Relazione progetto Algoritmi 2017/2018
##### Alicino Andrea, Dostuni Giuseppe

### Esercizio 1: Algoritmi di Sorting 
Gli algoritimi da implementare erano:
 
  - InsertionSort
  - MergeSort

abbiamo deciso di svilupparne due per tipo per vedere le differenze.

| Nome | Complessità | Interger.csv | Interger1M.csv |
| ---- | ----------- | ------------ | -------------- | 
| Insertion Sort – Basic | O(n^2) | >10 minuti * | >10 minuti *|
| Inserton Sort – Bin | O(n^2) | >10 minuti *  | >10 minuti *  |
| Merge Sort – Basic | O(n logn) |10,30 secondi | 0,41 secondi | 
| Merge Sort – No Garbage | O(n logn) | 1,38 secondi | 0,26 secondi |

  *test fallito

**Note**: 
Con i test di JUnit tutti i metodi erano performanti, aumentando il numero di elementi abbiamo confermato le nostre supposizioni, il MergeSort è decisamente più veloce, dei metodo di InsertionSort. Siamo rimasti particolarmente colpiti dalla versione NoGarbage che utilizza un ArrayList ausiliario e non alloca un ArrayList ad ogni chiamata ricorsiva.


#### Esercizio 1 : SumPair 
Abbiamo caricato Integer.csv e sums.txt in due ArrayList, ordinato il primo e iniziato la ricerca delle coppie.   
*hasPair* è il metodo per la ricerca di due interi all'interno di un array la cui somma sia il numero passato in input.
La precondizione necessaria per utilizzare il metodo e' che l'array passato sia gia' ordinato.


### Esercizio 2: Edit Distance 
 *edit_distance_dyn* impiega 14,58 secondi a formattare la frase corretta, utilizzando un metodo iterativo.
Questo algoritmo calcola la edit distance con una complessità O(n^2) dove n è il numero di lettere che compongono la parola.
Un for passa all’interno dell’*edit_distance_dyn*, viene richiamato un metodo chiamato *getEditDistDP*, dove al suo interno istanzia una matrice, salva la distanza di tutte le stringhe passate in precedenza.

All’interno di un for:
-	Se la prima stringa è vuota, allora inserisco tutti i caratteri della seconda;
-	Se la seconda stringa è vuota, allora inserisco tutti i caratteri della prima;
-	Se gli ultimi caratteri sono uguali, scorro oltre
-	Se i caratteri sono differenti, scelgo il minimo

Alla fine di queste operazioni ritorna il numero di operazioni necessarie per trasformare la prima stringa nella seconda.

Questo metodo è risultato inaffidabile in quanto alcune parole non vengono corrette con quelle desiderate perchè l'algoritmo si basa, solo, sulla distanza prediligendo soluzioni in cui basta eliminare un carattere o aggiungerlo rispetto a fare un replace (elimino+inserisco che sarebbe a distanza 2).

Inoltre abbiamo dovuto ignorare tutte le maiuscole, poiché all’interno del dizionario non erano presenti e quindi le avrebbe riconosciute come parole diverse da quelle prese all’interno del dizionario.