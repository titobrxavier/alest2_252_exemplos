import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CicloDirigido {

    private enum Status {
        WHITE, GRAY, BLACK
    }

    // Vértices já visitados
    private Map<String, Status> marked;
    private boolean hasCycle;

    public CicloDirigido(Digraph g)
    {
        marked = new HashMap<>();
        hasCycle = false;
        for(String v: g.getVerts()) {
            marked.put(v, Status.WHITE);
        }

        for(String v: g.getVerts())
        {
            if(marked.get(v) == Status.WHITE) {
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

    private boolean dfs(Digraph g, String v)
    {
        System.out.println("Estou em "+v);
        // Marca v como iniciado (GRAY)
        marked.put(v, Status.GRAY);
        for(String u: g.getAdj(v)) {
            // Se for GRAY, é um ciclo!
            if(marked.get(u) == Status.GRAY) {
                return true;
            }
            else if(marked.get(u) == Status.WHITE) {
                // Se encontrar o ciclo, retorna
                // true "em cascata" (para finalizar a recursão)
                if(dfs(g, u) == true)
                    return true;
            }
        }
        marked.put(v, Status.BLACK);
        return false;
    }

    public static void main(String[] args) {
        //Graph g = new Graph("exemplos/tinyG.txt");
        Digraph g = new Digraph();
        g.addEdge("1","2");
        g.addEdge("2","4");
        g.addEdge("4","3");
        // g.addEdge("3","1"); // retirando para não ter ciclo nesta parte
        g.addEdge("4","5");
        g.addEdge("6","7");
        g.addEdge("7","8");
        g.addEdge("8","6");
        CicloDirigido detciclo = new CicloDirigido(g);
        if(detciclo.hasCycle())
            System.out.println("Tem ciclo!");
        else
            System.out.println("Não tem ciclo...");
    }
}
