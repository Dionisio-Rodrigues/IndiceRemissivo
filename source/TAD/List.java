package source.TAD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class List{
    private int[] array;
    private int size;

    public List(){
        this.array = new int[100];
        this.size = 0;
    }

    public void add(int n){
        if(isFull()){
            extendSizeArray();
        }

        this.array[size] = n;
        size++;
    }

    public int get(int index){
        return this.array[index];
    }

    private void extendSizeArray(){
        int newSize = (this.array.length*25/100) + this.array.length;
        int[] newArray = clone(new int[newSize]);
        this.array = newArray;
    }

    private int[] clone(int[] newArray){
        for(int i = 0 ; i < size; i++){
            newArray[i] = this.array[i];
        }
        return newArray;
    }

    private boolean isFull(){
        return this.size == this.array.length;
    }

    public void print(File file) throws IOException {
        FileWriter writer = new FileWriter(file, true);

        for(int i = 0; i < this.size; i++)
            writer.write(this.array[i]+ " ");
        
        writer.close();
    }
}   