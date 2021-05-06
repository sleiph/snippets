using System; 

class primos {
    static bool Primo(int caso) {
        // usa a raiz quadrada pra eliminar algumas checagens redundantes
        int raiz = (int)Math.Sqrt((double)caso);
        
        // elimina 0 e números negativos
        if (caso <= 1)
            return false;
            
        // 2 é o ponto cego do programa
        else if (caso == 2)
            return true;
            
        // elimina metade das checagens a ser feita
        // jah que o único par primo é 2
        else if (caso % 2 == 0)
            return false;
            
        // else força bruta mesmo
        else
            for (int i = 3; i <= raiz; i += 2)
                if (caso % i == 0)
                    return false;
        return true;
    }
    
    // funcao motriz
    static void Main(string[] args) {
        Console.WriteLine("Entre com o número a ser identificado: ");
        int entrada = Int32.Parse(System.Console.ReadLine());
        
        bool isPrimo = Primo(entrada);
        Console.WriteLine((isPrimo) ? (entrada + " é primo.") : (entrada + " não é primo."));
    }
}
