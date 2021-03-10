# snippets

Alguns pedaços de código em linguagens variadas que eu costumo usar nos estudos.

![Diferente](https://catracalivre.com.br/wp-content/uploads/2016/11/meme-10-450x487.jpg)

## Matemática

###### Cálculo de equações de segundo grau
Calcula equações de segundo grau, evitando divisão por zero e equações de primeiro grau.

###### Fibonacci Chamadas
Encontra o enésimo valor da sequência de Fibonacci por função recursiva e mostra quantas chamadas foram feitas à função. Feito enquanto tentava entender Haskell.

###### n Divisores
Uma função em C++17 que retorna da forma mais rápida a quantidade de divisores de um número inteiro, baseada no algoritmo do site [geeksforgeeks](https://www.geeksforgeeks.org/count-divisors-n-on13/), pra resolver um problema do [projeto Euler](https://projecteuler.net).

###### Primo Rápido
Mais um programa de primos, retorna verdadeiro se o número informado for primo. Criado pra resolver um problema do [Uri Online Judge](https://www.urionlinejudge.com.br).

## Grafos

###### Algoritmo de Kruskal
O algoritmo de Kruskal busca uma [árvore de extensão mínima](https://pt.wikipedia.org/wiki/%C3%81rvore_de_extens%C3%A3o_m%C3%ADnima) pra um grafo com pesos definindos, ele é útil pra encontrar o menor número de conexões necessário pra ligar todos os vértices de um grafo. Baseado fortemente no trabalho do [Xianshun Chen](https://github.com/chen0040/lua-graph/find/master).

###### Algoritmo de Heap
O algoritmo de Heap é usado pra gerar todas as permutações de uma sequência n de objetos, ou seja, todas as combinações possíveis dos elementos de uma lista, sem repetição. Eu encontrei esse algoritmo no [geeksforgeeks](https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/) e decidí adaptá-lo pra Lua, linguagem complicada que me enche de ódio e orgulho.

## Otimização

###### Pesquisa Binária
Algoritmo de Pesquisa Binária em C++, feito do modo recursivo, retorna a posição de um elemento x em um array ordenado, ou -1 se o elemento não estiver presente. Eu fiz uma interação com o console, pra pedir os elementos do array e o número buscado pro usuário, mas a parte mais importante é a função de busca. Original em [geeksforgeeks](https://www.geeksforgeeks.org/binary-search/).

###### Fila Circular (FIFO)
Classe personalizada do java, que funciona como uma fila, que armazena valores e retorna o primeiro item quando chamada, funciona de forma circular, então não vai usar muita memória.

###### Pilha (LIFO)
Classe personalizada do java, que funciona como uma pilha, que armazena valores e retorna o último item quando chamada, pode ser invertida, medida ou impressa, também funciona de forma circular pra melhorar a performance.

## Exploração de dados

###### Distribuicao de frequências
Cria uma tabela de distribuição de frequências com base em um array de dados, criado no notebook de python da Google pra aula de estatísticas.

###### Preços das ações B³
Notebook do Colab pra analisar diferentes fundos de investimento da BOVESPA, partindo dos dados do [Yahoo Finanças](https://finance.yahoo.com). Fortissimamente baseado no trabalho do [Matheus Coradini](https://medium.com/geleia/an%C3%A1lise-de-a%C3%A7%C3%B5es-com-python-7f6624939fb).

## Utilidades

###### Calculadora de Capacidade de Memória RAM
Pega pelo menos duas informações que você tenha (Capacidade da memória/Capacidade das células/Tamanho do endereço/Número de células) e calcula as outras.

###### Conversor Binário - Decimal - Hexadecimal
Solução menos eficiente que as normalmente encontradas na internet, eu tentei fazer com que o programa resolvesse o problema do jeito que um humano resolveria, ou seja, ineficientemente.
