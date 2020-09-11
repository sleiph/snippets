#include <bits/stdc++.h> 

using namespace std;

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