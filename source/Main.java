package source;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        // Arquivo de entrada de dados (onde ficará o texto)
        File in = new File("./source/files/input.txt");
        // Arquivo de saida de dados
        File out = new File("./source/files/output.txt");
        // Arquivo de entrada de dados (onde ficara as palavras chaves)
        File keywords = new File("./source/files/keywords.txt");

        //instancia objeto para fazer a leitura de arquivos
        BufferedReader br = new BufferedReader(new FileReader(keywords));

        //reecria arquivo
        out.delete();
        out.createNewFile();

        // criando indice remissivo
        Index index = new Index(26);
        String line;

        //indexssando palavra chave
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
        
        //printa no arquivo out
        index.print(out);
    }
}