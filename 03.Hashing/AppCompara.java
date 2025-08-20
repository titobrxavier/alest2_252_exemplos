import java.util.HashMap;
import java.util.TreeMap;

public class AppCompara {

    public static void main(String[] args) {

        SeparateChainingHashST<String, Integer> ht = new SeparateChainingHashST<>();
        In arq = new In("DomCasmurro_utf8.txt");
        String[] words = arq.readAllStrings();
        arq.close();

        for (String word : words) {
            System.out.println(word);
        }
    }
}
