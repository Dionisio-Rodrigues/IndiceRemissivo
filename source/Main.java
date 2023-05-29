package source;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        File in = new File("./source/files/input.txt");
        File out = new File("./source/files/output.txt");
        File keywords = new File("./source/files/keywords.txt");

        BufferedReader br = new BufferedReader(new FileReader(keywords));

        out.delete();
        out.createNewFile();

        // criando indice remissivo
        Index index = new Index(26);
        String line;

        while((line = br.readLine()) != null){
            String[] words = line.split("[,. ]+");

            for(String w : words){
                index.add(new Word(w));
            }
        }

        br.close();

        //encontrado palavras chaves
        br = new BufferedReader(new FileReader(in));
        int i = 1;
        
        while((line = br.readLine()) != null){
            String[] words = line.split("[,.!? ]+");

            for(String w : words){
                Word word = index.fetch(new Word(w));
                if(word != null)
                    word.addLine(i);
            }

            ++i;
        }
        

        index.print(out);
    }
}