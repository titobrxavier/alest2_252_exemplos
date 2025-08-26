
public class AppCompara {

    public static void main(String[] args) {

        SeparateChainingHashST<String, Integer> ht = new SeparateChainingHashST<>();
        //LinearProbingHashST<String, Integer> ht = new LinearProbingHashST<>();
        In arq = new In("DomCasmurro_utf8.txt");
        String[] words = arq.readAllStrings();
        arq.close();

        long start = System.nanoTime();
        for (String word : words) {
            //System.out.println(word);
            word = word.toLowerCase();
            if(!ht.containsKey(word))
                ht.put(word, 1);
            ht.put(word, ht.get(word)+1);
        }
        long end = System.nanoTime();
        double delta = (end-start)/(double)1e9;
        System.out.println("Total de chaves: "+ht.size());
        System.out.println("Tempo: "+delta);
    }
}
