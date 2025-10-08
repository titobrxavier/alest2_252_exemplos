import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS {

    // Vértices já visitados
    private Set<String> marked;

    // Caminhos para chegar nos vértices
    private Map<String,String> edgeTo;

    // Distâncias (em número de arestas) do vértice inicial
    private Map<String,Integer> distTo;

    // Vértice inicial do caminhamento
    private String start;

    public BFS(Graph g, String start)
    {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        bfs(g, start);
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

    public int distTo(String v) {
        if(!hasPathTo(v))
            throw new UnsupportedOperationException("Não há caminho para "+v);
        return distTo.get(v);
    }

    private void bfs(Graph g, String v)
    {
        LinkedList<String> fila = new LinkedList<>();
        fila.add(v); // adiciona vértice inicial na fila
        // Marca v como visitado
        marked.add(v);
        edgeTo.put(v, null); // indica que não tem ninguém antes dele
        distTo.put(v, 0); // distância do inicial para ele mesmo é zero!
        while(!fila.isEmpty())
        {
            v = fila.removeFirst();
            for(String w: g.getAdj(v)) {
                // Se não estiver marcado...
                if(!marked.contains(w)) {
                    // Para chegar em w, viemos de v
                    //System.err.println("  Viemos de "+v+" indo para "+w);
                    marked.add(w);
                    edgeTo.put(w, v);
                    // Distância até w é a distância até v + 1
                    distTo.put(w, distTo.get(v)+1);
                    fila.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        BFS bfs = new BFS(g, "0");
        for(String v: g.getVerts())
        {
            System.out.print(v+": ");
            if(bfs.hasPathTo(v)) {
                for(String w: bfs.pathTo(v))
                    System.out.print(w+" ");
                System.out.print("("+bfs.distTo(v)+")");
            }
            System.out.println();
        }
    }
}
