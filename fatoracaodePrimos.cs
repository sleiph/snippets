using System;
using System.Collections.Generic;

class Program
{
    static void Main() {
        string entrada = System.Console.ReadLine();
        ulong caso = Convert.ToUInt64(entrada);
        int numero = 3, resposta = 0;
        List<long> primos = new List<long>();
        primos.Add(2);
        bool primo = true;
        while (numero <= Math.Sqrt(caso)){
            primo = true;
            for (int i = 0; i < primos.Count; i++){
                if (numero % primos[i] == 0) primo = false;
            }
            if (primo) primos.Add(numero);
            numero++;
        }
        foreach (ulong p in primos){
            if (caso % p == 0) resposta = Convert.ToInt32(p);
        }

        Console.Write(resposta);
    }
}