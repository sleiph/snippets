public class Pilha {
    // Atributos
    int[] dados;
    int tamanho;
    int capacidade;
    /// inverter Pilha
    int topo;
    int fundo;
    Boolean isInvertida;
    
    // Construtor
    Pilha(int c) {
        this.capacidade = c;
        dados = new int[capacidade];
        tamanho = 0;
        topo = -1;
        fundo = 0;
        isInvertida = false;
    }
    
    // Checks de capacidade
    public boolean cheia() {
        return (capacidade == tamanho);
    }
    public boolean vazia() {
        return (tamanho == 0);
    }
    public int tamanho() {
        return tamanho;
    }
    
    // Métodos
    public void empilha(int e) {
        if (!cheia()) {
            tamanho++;
            if (!isInvertida) {
                topo++;
                if (topo == capacidade)
                    topo = 0;
            }
            else {
                topo--;
                if (topo == -1)
                    topo = capacidade-1;
            }
            dados[topo] = e;
        }
        else {
            System.out.println("Pilha cheia, impossível adicionar o elemento '" + e + "'");
        }
    }
    
    public int desempilha() {
        if (!vazia()) {
            tamanho--;
            int aux = dados[topo];

            if (!isInvertida) {
                topo--;
                if (topo == 0)
                    topo = capacidade-1;
            }
            else {
                topo++;
                if (topo == capacidade)
                    topo = 0;
            }
            return aux;
        }
        else {
            return -1;
        }
    }
    
    public void inverte() {
        int aux = topo;
        topo = fundo;
        fundo = aux;
        isInvertida = isInvertida ? false : true;
    }
    
    public String toString() {
        String aux = "[";
        if (!isInvertida) {
            if (fundo < topo) {
                for(int i=fundo; i<=topo; i++){
                    aux = aux + dados[i];
                    if (i < topo) {
                        aux = aux + ", ";
                    }
                }
            }
            else { // se fundo >= topo
                if (!vazia()) {
                    for(int i=fundo; i<capacidade; i++){
                        aux = aux + dados[i] + ", ";
                    }
                    for(int i=0; i<=topo; i++){
                        aux = aux + dados[i];
                        if (i < topo) {
                            aux = aux + ", ";
                        }
                    }
                }
            }
        }
        else { // se a pilha está invertida
            if (fundo > topo) {
                for(int i=fundo; i>=topo; i--){
                    aux = aux + dados[i];
                    if (i > topo) {
                        aux = aux + ", ";
                    }
                }
            }
            else { // se fundo <= topo
                if (!vazia()) {
                    for(int i=fundo; i>-1; i--){
                        aux = aux + dados[i] + ", ";
                    }
                    for(int i=capacidade-1; i>=topo; i--){
                        aux = aux + dados[i];
                        if (i > topo) {
                            aux = aux + ", ";
                        }
                    }
                }
            }
        }
        aux = aux + "]";
        return aux;
    }
}
