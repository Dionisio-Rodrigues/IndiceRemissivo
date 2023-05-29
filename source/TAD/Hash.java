package source.TAD;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;

public class Hash {
    Abb[] array;

    public Hash(int size){
        this.array  = new Abb[size];
    }

    private int hash(String key){
        int charAsc = normalize(key).charAt(0);
        return charAsc - 97;
    }

    public Abb get(String key){
        try{
            return this.array[hash(key)];
        }catch(Exception e){
            System.out.println(key);
        }

        return null;
    }
    public Abb set(Abb abb, String key){
        this.array[hash(key)] = abb;
        return abb;
    }

    public void print(File file) throws IOException{
        for(Abb a : this.array){
            if(a == null)
                continue;
            a.print(file);
        }
    }

    private String normalize(String string){
        string = string.toLowerCase();
        string = Normalizer.normalize(string, Normalizer.Form.NFKD);
        string = string.replaceAll("[^\\p{ASCII}]", "");
        string = string.replaceAll("^\\(|\\)$", "");
        string = string.replaceAll("[']", "");

        return string;
    }
}