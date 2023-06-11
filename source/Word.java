package source;

import source.TAD.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// classe responsavel por conter a palavra e as linhas onde a palavra ocorre no texto

public class Word {
    public String word;
    public List lines;

    public Word(String word){
        this.word = word;
        this.lines = new List();
    }

    public Word(String word, int line){
        this.word = word;
        this.lines = new List();
    }

    public void addLine(int line){
        this.lines.add(line);
    }

    public void print(File file) throws IOException{
        FileWriter writer = new FileWriter(file, true);

        writer.write(word+" ");
        writer.flush();

        lines.print(file);

        writer.write("\n");

        writer.close();
    }
}
