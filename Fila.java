public class Fila {
    // Atributos
    int[] dados;
    int tamanho;
    int capacidade;
    /// fila circular
    int cabeca;
    int pes;
    /// inverter Fila
    Boolean isInvertida;
    
    // Construtor
    Fila(int c) {
        this.capacidade = c;
        dados = new int[capacidade];
        tamanho = 0;
        cabeca = -1;
        pes = 0;
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
    public void adiciona(int e) {
        if (!cheia()) {
            tamanho++;
            if (!isInvertida) {
                cabeca++;
                if (cabeca == capacidade)
                    cabeca = 0;
            }
            else {
                cabeca--;
                if (cabeca == -1)
                    cabeca = capacidade-1;
            }
            dados[cabeca] = e;

        }
        else {
            System.out.println("Fila Cheia, impossível adicionar o elemento '" + e + "'");
        }
    }
    
    public int remove() {
        if (!vazia()) {
            tamanho--;
            int aux = dados[pes];

            if (!isInvertida) {
                pes++;
                if (pes == capacidade)
                    pes = 0;
            }
            else {
                pes--;
                if (pes == -1)
                    pes = capacidade-1;
            }
            return aux;
        }
        else {
            return -1;
        }
    }
    
    public void inverte() {
        int aux = cabeca;
        cabeca = pes;
        pes = aux;
        isInvertida = isInvertida ? false : true;
    }
    
    // imprime a fila no console
    /// bem vindo ao inferno dos ifs
    //// deve ter um jeito de fazer tudo isso em uma linha
    public String toString() {
        String aux = "[";
        if (!isInvertida) {
            if (pes < cabeca) {
                for(int i=pes; i<=cabeca; i++){
                    aux = aux + dados[i];
                    if (i < cabeca) {
                        aux = aux + ", ";
                    }
                }
            }
            else { // se pes >= cabeca
                if (!vazia()) {
                    for(int i=pes; i<capacidade; i++){
                        aux = aux + dados[i] + ", ";
                    }
                    for(int i=0; i<=cabeca; i++){
                        aux = aux + dados[i];
                        if (i < cabeca) {
                            aux = aux + ", ";
                        }
                    }
                }
            }
        }
        else { // se a fila está invertida
            if (pes > cabeca) {
                for(int i=pes; i>=cabeca; i--){
                    aux = aux + dados[i];
                    if (i > cabeca) {
                        aux = aux + ", ";
                    }
                }
            }
            else { // se pes <= cabeca
                if (!vazia()) {
                    for(int i=pes; i>-1; i--){
                        aux = aux + dados[i] + ", ";
                    }
                    for(int i=capacidade-1; i>=cabeca; i--){
                        aux = aux + dados[i];
                        if (i > cabeca) {
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
