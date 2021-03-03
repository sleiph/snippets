public class Pilha {
    // Atributos
    int[] dados;
    int topo;
    
    // Construtor
    Pilha(int capacidade) {
        dados = new int[capacidade];
        topo = -1;
    }
    
    public boolean cheia() {
        return (topo == dados.length-1);
    }
    
    public boolean vazia() {
        return (topo == -1);
    }
    
    public void empilha(int e) {
        if(!cheia()){
            topo++;
            dados[topo] = e;
        } else {
            // throw erro em vez de systemprint
            System.out.println("Erro! Pilha Cheia!");
        }
    }
    
    public int desempilha() {
        if(!vazia())  {
            int aux = dados[topo];
            dados[topo] = 0;
            topo--;
            return aux;
        } else {
            // throw erro em vez de systemprint
            System.out.println("Erro! Pilha Vazia!");
            return -1;
        }
    }
    
    // funcao de inverso
    //public void inverte() {}
    
    public String toString() {
        String aux="[";
        for(int i=topo; i > -1; i--) {
            aux = aux + dados[i];
            if (i > 0) {
                aux = aux + ", ";
            }
        }
        aux = aux + "]";
        return aux;
    }
}
