package source;

import source.TAD.Hash;
import source.TAD.Abb;
import java.io.File;
import java.io.IOException;

public class Index {
    private Hash hashMap;

    public Index(int size){
        this.hashMap = new Hash(size);
    }

    public void add(Word word){
        Abb abb = this.hashMap.get(word.word);

        if (abb == null)
            abb = this.hashMap.set(new Abb(), word.word);
        
        abb.add(word);
    }

    public Word fetch(Word word){
        Abb abb = this.hashMap.get(word.word);

        if (abb == null)
            return null;
        
        return abb.fetchWord(word);
    }

    public void print(File file) throws IOException{
        hashMap.print(file);
    }
}
