using System; 

class primos {
    static void Main(string[] args) { 
        Console.Write("Digite o número que você quer saber se é primo: \n");
        int caso = Int32.Parse(System.Console.ReadLine()), raiz = (int)Math.Sqrt((double)caso);;
        bool primo = true;
        if (caso != 2 && caso % 2 == 0) primo = false;
        else{
            for (int i = 3; i <= raiz; i += 2){
                if (caso % i == 0){
                    primo = false;
                    break;
                }
            }
        }
        if (primo) Console.Write("{0} é primo.\n", caso);
        else Console.Write("{0} não é primo.\n", caso);
    }
}