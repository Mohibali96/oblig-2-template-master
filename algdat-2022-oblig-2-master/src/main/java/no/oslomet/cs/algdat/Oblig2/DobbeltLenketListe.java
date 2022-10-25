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
        Objects.requireNonNull(verdi,"Null");

        if (indeks > antall){
            throw new IndexOutOfBoundsException("Indeks er for stor");
        }
        else if (indeks < 0){
            throw new IndexOutOfBoundsException("Negativ indeks");
        }
        if (antall == 0 && indeks == 0){
            hode = new Node<T>(verdi, null, null);
            hale = hode;
        }
        else if (indeks == antall){
            hale = new Node<T>(verdi, hale, null);
            hale.forrige.neste = hale;

           }
        else if (indeks == 0){
            hode = new Node<T>(verdi,null,hode);
            hode.neste.forrige = hode;
        }else {
            Node<T> temp = hode;
            for (int i = 0; i < indeks; i++) temp= temp.neste;{
                temp = new Node<T>(verdi,temp.forrige,temp);
            }
            temp.neste.forrige = temp.forrige.neste = temp;
        }
        antall++;
        endringer++;
     }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }
    private Node<T> finnNode(int indeks){
        indeksKontroll(indeks, false);
        Node<T> temp;
        if (indeks < antall / 2){
            temp = hode;
            for (int i = 0; i < indeks; i++){
                temp = temp.neste;
            }
            return temp;
        }else {
            temp = hale;
            for (int i = antall-1; i > indeks; i--){
                temp = temp.forrige;
            }
            return temp;
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
        Node<T> temp = finnNode(indeks);
        return temp.verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        if (verdi == null){
            return -1;
        }
        Node<T> temp = hode;
        for (int i = 0; i < antall; i++, temp = temp.neste){
            if (temp.verdi.equals(verdi)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi);
        Node<T> temp = finnNode(indeks);

        T tidligereverdi = temp.verdi;
        endringer++;
        temp.verdi = nyverdi;
        return tidligereverdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null){
            return false;
        }
        Node<T> temp = hode;
        if (verdi.equals(temp.verdi)){
            if (temp.neste !=null){
                hode = temp.neste;
                hode.forrige = null;
            } else{
                hode = null;
                hale = null;
            }
            antall --;
            endringer ++;
            return true;
        }
        temp = hale;
        if (verdi.equals(temp.verdi)){
            hale = temp.forrige;
            hale.neste = null;
            antall--;
            endringer++;
            return true;
        }
        temp = hode.neste;
        for (; temp != null; temp = temp.neste){
            if (verdi.equals(temp.verdi)){
                temp.forrige.neste=temp.neste;
                temp.neste.forrige=temp.forrige;
                antall--;
                endringer++;
                return true;
            }
        }
        return false;
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks,false);
        Node<T> temp = hode;

        T verdi;

        if (indeks == 0){
            verdi = temp.verdi;
            if (temp.neste != null){
                hode = temp.neste;
                hode.forrige = null;
            }
            else{
                hode = null;
                hale = null;
            }
        }
        else if (indeks == antall-1){
            temp = hale;
            verdi = hale.verdi;
            hale = temp.forrige;
            hale.neste = null;
        } else {
            for (int i = 0; i < indeks; i++){
                temp = temp.neste;
            }
            verdi = temp.verdi;
            temp.forrige.neste = temp.neste;
            temp.neste.forrige = temp.forrige;
        }
        antall--;
        endringer++;
        return verdi;

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


