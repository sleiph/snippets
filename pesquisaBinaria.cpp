// Algoritmo original em https://www.geeksforgeeks.org/binary-search/

// Pesquisa Binária em C++
// Método recursivo
#include <bits/stdc++.h>

using namespace std;

// Pesquisa Binária retorna a posição de um elemento x em um array ordenado
// ou -1 se o elemento não estiver presente
int pesquisaBinaria(int arr[], int alfa, int omega, int x)
{ 
    if (omega >= alfa) {
        int meio = alfa + (omega - alfa) / 2;
        // Se o elemento estiver no meio
        if (arr[meio] == x)
            return meio;
        // Se o elemento for menor que o meio
        // chama a funcao denovo só do lado esquerdo
        if (arr[meio] > x) 
            return pesquisaBinaria(arr, alfa, meio-1, x);
        // Se o elemento for maior que o meio
        // chama a funcao denovo só do lado direito
        return pesquisaBinaria(arr, meio+1, omega, x);
    } 
    // Só chega até aqui se o elemento não estiver presente no array
    return -1;
}
  
int main(void) 
{
    int qnt, temp, i=0, n = 0, x;
    
    printf("Digite a quantidade de elementos do array: ");
    scanf( "%d", &qnt);
    
    int arr[qnt];
    
    printf("Digite os valores do array ordenado, separados por espaço: ");
    while( qnt > 0 ) {
        scanf( "%d", &temp);
        arr[i] = temp;
        n++;
        i++;
        qnt--;
    }
    sort(arr, arr + (sizeof(arr) / sizeof(arr[0])));
    
    printf("Digite o valor a ser buscado no array: \n");
    scanf( "%d", &x);
    
    int resultado = pesquisaBinaria(arr, 0, n-1, x); 
    
    (resultado == -1) ? cout << "Elemento não faz parte do array dado" 
                    : cout << "Elemento presente no índice " << resultado;
    
    return 0;
}
