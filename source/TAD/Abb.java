package source.TAD;

import source.Word;
import java.io.File;
import java.io.IOException;

public class Abb {
    public class Nodo {
        public Nodo dir;
        public Nodo esq;
        public Word word;

        public Nodo(Word word){
            this.dir = null;
            this.esq = null;
            this.word = word;
        }
    }

    private Nodo root;

    public Abb(){
        this.root = null;
    }

    public void add(Word word){
        if(this.root == null){
            this.root = new Nodo(word);
            return;
        }

        setElement(this.root, word);
    }

    public Word fetchWord(Word word){
        return fetch(this.root, word);
    }

    private Nodo setElement(Nodo nodo, Word word){

        int compare = word.word.compareTo(nodo.word.word);

        if(compare<0){
            if(nodo.esq == null){
                nodo.esq = new Nodo(word);
                return nodo.esq;
            }

            nodo = nodo.esq;
        }else if(compare>0){
            if(nodo.dir == null){
                nodo.dir = new Nodo(word);
                return nodo.dir;
            }

            nodo = nodo.dir;
        }else{
            return null;
        }

        return setElement(nodo, word);
    }

    private Word fetch(Nodo nodo, Word word){

        int compare = word.word.compareTo(nodo.word.word);

        if(compare<0){
            if(nodo.esq == null)
                return null;
            
            nodo = nodo.esq;
        }else if(compare>0){
            if(nodo.dir == null)
                return null;
            
            nodo = nodo.dir;
        }else{
            return nodo.word;
        }

        return fetch(nodo, word);
    }

    public void print(File file) throws IOException{
        printInOrder(this.root, file);
    }

    public void printInOrder(Nodo nodo, File file) throws IOException{
        if (nodo == null)
            return;

        this.printInOrder(nodo.esq, file);
        nodo.word.print(file);
        this.printInOrder(nodo.dir, file);
    }
}