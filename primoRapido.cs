using System; 

class primos {
    static bool Primo(int caso) {
        int raiz = (int)Math.Sqrt((double)caso);
        if (caso <= 1)
            return false;
        else {
            if (caso != 2 && caso % 2 == 0)
                return false;
            else
                for (int i = 3; i <= raiz; i += 2)
                    if (caso % i == 0)
                        return false;
        }
        return true;
    }
}
