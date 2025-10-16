import java.util.ArrayList;
import java.util.Collections; 
public class KruskalMST {

    private ArrayList<Edge> mst;
    public KruskalMST(EdgeWeightedGraph g) {
        mst = new ArrayList<>();
        UnionFind uf = new UnionFind(g); 
        ArrayList<Edge> edges = new ArrayList<>();
        for(Edge e : g.getEdges()){
            edges.add(e); 
        } 

    }

    Collections.sort(edges); 
    for(Edge e: edges){
        String v = e.getV();
        String w = e.getW(); 
        if(!uf.find(v).equals(uf.find(w))){
            mst.add(e);
            uf.union(v, w); 
        }
    }

    Iterable<Edge> getMST() {
        return mst; 
    }

    public static void main(String[] args){
        EdgeWeightedGraph g = new EdgeWeightedGraph("exemplos/tinyEWG.txt");
        KruskalMST k = new KruskalMST(g); 
        for(Edge e: k.getMST())
            System.out.println(e); 
    }
    
}
