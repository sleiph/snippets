package grafos.conexoes;

import java.util.ArrayList;

class Grafo {
    int V;
    ArrayList< ArrayList<Integer> > adjListArray;
 
    // construtor
    Grafo(int V)
    {
        this.V = V;
        adjListArray = new ArrayList<>();
 
        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }
 
    void addAresta(int src, int dest)
    {
        adjListArray.get(src).add(dest);
        adjListArray.get(dest).add(src);
    }
 
    void DFSUtil(int v, boolean[] visitado, ArrayList<Integer> comps)
    {
        visitado[v] = true;
        comps.add(v);
        
        for (int x : adjListArray.get(v)) {
            if (!visitado[x])
                DFSUtil(x, visitado, comps);
        }
    }
    ArrayList< ArrayList<Integer> > conexoesComponentes()
    {
        ArrayList< ArrayList<Integer> > conexoes = new ArrayList< ArrayList<Integer> >();
        boolean[] visitado = new boolean[V];
        for (int v=0; v < V; ++v) {
            if (!visitado[v]) {
                ArrayList<Integer> componentes = new ArrayList<Integer>();
                DFSUtil(v, visitado, componentes);
                conexoes.add(componentes);
            }
        }
        return conexoes;
    }
}
