import java.text.Normalizer;

public class test {
    public static void main(String args[]){
        String s = "(tubarao)";
        s = Normalizer.normalize(s, Normalizer.Form.NFKD);
        s = s.replaceAll("[^\\p{ASCII}]", "");
        s = s.replaceAll("[']", "");
        s = s.replaceAll("^\\(|\\)$", "");
        
        System.out.println(s);
    }
}
