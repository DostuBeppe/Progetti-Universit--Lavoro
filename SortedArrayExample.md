# Esercizio di esempio

Implementare la struttura dati SortedArray. La struttura dati deve permettere inserimenti e cancellazioni di elementi di tipo generico e mantenere ordinata la collezione dei dati inseriti. L'ordine degli elementi deve potere essere specificato dall'utente.

# UnitTesting

Implementare gli unit-test degli algoritmi secondo le indicazioni suggerite nel documento [Unit Testing](UnitTesting.md).

# Uso della libreria

## Implementazione

Il file ordered_array_sample_file.csv, che potete trovare seguendo il path

    /usr/NFS/Linux/labalgoritmi/datasets/

(in laboratorio von Neumann, selezionare il disco Y) contiene 23 record del tipo <chiave,valore>, dove la chiave è una stringa e il valore è un intero.  Il formato è un CSV standard: i campi sono separati da virgole; i record sono separati dal carattere di fine riga (\n).

Implementare un'applicazione che, usando un SortedArray, carichi i record nella struttura dati una prima volta mantenendoli ordinati secondo l'ordinamento crescente del campo intero e una seconda volta secondo l'ordinamento lessicografico crescente del campo stringa.
