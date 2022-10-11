package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;

    }

    public DobbeltLenketListe(T[] a) {
        // sjekker tabellen
         if (a == null){
             throw new NullPointerException();
         }
         if (a.length > 0){
             int i = 0;
             for (; i < a.length; i++){
                 if (a [i] != null){
                     hode = new Node<>(a[i]);
                     antall ++;
                     break;
                 }
             }
             hale = hode;
             if (hode != null){
                 i++;
                 for (; i < a.length; i++){
                     if (a[i] != null){
                         hale.neste = new Node<>(a[i], hale, null);
                         hale = hale.neste;
                         antall ++;
                     }
                 }
             }
         }
    }

    public Liste<T> subliste(int fra, int til) {
        kontoll(antall, fra, til);
        Liste<T> subliste = new DobbeltLenketListe<>();
        int lengde = til - fra;
        if (lengde < 1){
            return subliste;
        }
        Node<T> hjelpeNode = finnNode(fra);
        while (lengde > 0){
            subliste.leggInn(hjelpeNode.verdi);
            hjelpeNode = hjelpeNode.neste;
            lengde --;
        }
        return subliste;
    }

    @Override
    public int antall() {
       return antall;
    }

    @Override
    public boolean tom() {
        if (hode == null){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi);
        Node<T> Nynode = new Node<>(verdi);
        if (hode == null && hale == null && antall == 0){
            hode = Nynode;
            hale = Nynode;
            antall ++;
            endringer ++;
            return true;
        }
        else {
            Nynode.forrige = hale;
            hale.neste = Nynode;
            hale = Nynode;
            antall ++ ;
            endringer ++;
            return  true;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }
    private Node<T> finnNode(int indeks){
        indeksKontroll(indeks, false);
        Node<T> foreløpig;
        if (indeks < antall / 2){
            foreløpig = hode;
            for (int i = 0; i < indeks; i++){
                foreløpig = foreløpig.neste;
            }
            return foreløpig;
        }else {
            foreløpig = hale;
            for (int i = antall-1; i > indeks; i--){
                foreløpig = foreløpig.forrige;
            }
            return foreløpig;
        }
    }
    private void kontoll (int tabellstørrelse, int fra, int til){
        if (fra < 0 || til > tabellstørrelse){
            throw new IndexOutOfBoundsException();
        }
        if (fra > til){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        Node<T> temp = hode;
        StringBuilder s1 = new StringBuilder();
        s1.append("[");

        if (tom()){
            s1.append("]");
            return s1.toString();
        }
        else {
            s1.append(temp.verdi);
            temp = temp.neste;
            while (temp != null){
                s1.append(", ");
                s1.append(temp.verdi);
                temp = temp.neste;
            }
        }
        s1.append("]");
        return s1.toString();
    }

    public String omvendtString() {
        Node<T> temp = hale;
        StringBuilder s1 = new StringBuilder();
        s1.append("[");
        if (tom()) {
            s1.append("]");
            return s1.toString();
        }
        else {
            s1.append(temp.verdi);
            temp = temp.forrige;
            while (temp != null){
                s1.append(", ");
                s1.append(temp.verdi);
                temp = temp.forrige;
            }
        }
        s1.append("]");
        return s1.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


