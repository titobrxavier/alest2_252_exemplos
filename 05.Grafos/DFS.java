import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {

    // Vértices já visitados
    private Set<String> marked;

    // Caminhos para chegar nos vértices
    private Map<String,String> edgeTo;

    // Vértice inicial do caminhamento
    private String start;

    public DFS(Graph g, String start)
    {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        dfs(g, start);
    }

    // Retorna true se houver caminho para v
    public boolean hasPathTo(String v)
    {
        return marked.contains(v);
        //if(marked.contains(v))
        //    return true;
        //return false;
    }

    public List<String> pathTo(String v)
    {
        List<String> path = new LinkedList<>();
        if(!hasPathTo(v))
            return path;
        while(v != null) 
        {
            //System.out.println("Adicionando "+v);
            // Adiciona no início da lista para inverter
            path.add(0, v);
            v = edgeTo.get(v);
        }
        return path;
    }

    private void dfs(Graph g, String v)
    {
        //System.out.println("Estou em "+v);
        // Marca v como visitado
        marked.add(v);
        for(String w: g.getAdj(v)) {
            // Se não estiver marcado...
            if(!marked.contains(w)) {
                // Para chegar em w, viemos de v
                //System.err.println("  Viemos de "+v+" indo para "+w);
                edgeTo.put(w, v);
                dfs(g, w);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        DFS dfs = new DFS(g, "0");
        for(String v: g.getVerts())
        {
            System.out.print(v+": ");
            for(String w: dfs.pathTo(v))
                System.out.print(w+" ");
            System.out.println();
        }
    }
}
