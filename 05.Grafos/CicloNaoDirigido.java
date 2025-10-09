import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CicloNaoDirigido {

    // Vértices já visitados
    private Set<String> marked;
    private Set<String> edgeSet;
    private boolean hasCycle;

    public CicloNaoDirigido(Graph g)
    {
        marked = new HashSet<>();
        edgeSet = new HashSet<>();
        hasCycle = false;
        for(String v: g.getVerts())
        {
            if(!marked.contains(v)) {
                System.out.println("Iniciando em "+v);
                if(dfs(g, v) == true) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    private boolean dfs(Graph g, String v)
    {
        System.out.println("Estou em "+v);
        // Marca v como visitado
        marked.add(v);
        for(String u: g.getAdj(v)) {
            // Se não estiver marcado...
            if(!marked.contains(u)) {
                // Para chegar em w, viemos de v
                //System.err.println("  Viemos de "+v+" indo para "+w);
                edgeSet.add(u+"-"+v);
                // Se encontrar ciclo na chamada recursiva, retorna
                // true "em cascata" (para finalizar a recursão)
                if(dfs(g, u) == true)
                    return true;
            }
            else {
                if(!edgeSet.contains(v+"-"+u)) {
                    System.out.println("Ciclo detectado em "+v+"-"+u);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Graph g = new Graph("exemplos/tinyG.txt");
        Graph g = new Graph();
        g.addEdge("1","2");
        g.addEdge("2","4");
        g.addEdge("4","3");
        // g.addEdge("1","3");
        g.addEdge("4","5");
        g.addEdge("6","7");
        g.addEdge("7","8");
        g.addEdge("6","8");
        CicloNaoDirigido detciclo = new CicloNaoDirigido(g);
        if(detciclo.hasCycle())
            System.out.println("Tem ciclo!");
        else
            System.out.println("Não tem ciclo...");
    }
}
