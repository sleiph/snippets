#include <stdio.h>
#include <bits/stdc++.h> 

// funcao pra encontrar o numero de divisores de um inteiro
int nDivisores(int caso)
{ 
    int contagem = 0; 
    for (int i = 1; i <= sqrt(caso); i++) { 
        if (caso % i == 0) { 
            if (caso / i == i) 
                contagem += 1; 
            else
                contagem = contagem + 2; 
        } 
    } 
    return contagem; 
}

// funcao motriz
// entrar com um inteiro no console
int main()
{
    int n = 0;
    scanf("%d", &n);
    
    printf("%d\n", nDivisores(n));

    return 0;
}
