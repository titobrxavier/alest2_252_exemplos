import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrdTopologica {

    // Vértices já visitados
    private Set<String> marked;

    private List<String> ordemTopo;

    public OrdTopologica(Graph g)
    {
        ordemTopo = new LinkedList<>();
        marked = new HashSet<>();
        for(String v: g.getVerts()) {
            if(!marked.contains(v)) {
                dfs(g, v);
            }
        }
    }

    public Iterable<String> getOrdemTopologica()
    {
        return ordemTopo;
    }

    private void dfs(Graph g, String v)
    {
        // System.out.println("Estou em "+v);
        // Marca v como visitado
        marked.add(v);
        for(String w: g.getAdj(v)) {
            // Se não estiver marcado...
            if(!marked.contains(w)) {
                dfs(g, w);
            }
        }
        // Insere no início da lista para inverter
        // a ordem (pós-ordem invertida)
        ordemTopo.add(0, v);
//        System.out.println("Estou saindo de "+v);
    }

    public static void main(String[] args) {
        Digraph g = new Digraph("exemplos/tinyG.txt");
        System.out.println(g.toDot());
        OrdTopologica ot = new OrdTopologica(g);
        for(String v: ot.getOrdemTopologica())
            System.err.print(v+" ");
        System.out.println();
    }
}
