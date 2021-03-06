package estruturaDados.arvoreBinaria;

public class Arvore {
	Node raiz;
	private int tamanho;
	Arvore() {
		raiz = null;
		tamanho = 0;
	}
	public void adiciona(String e) {
		Node novo = new Node(e);
		if (raiz == null) { // Verifica se a árvore está vazia
			raiz = novo;    // inclui o Nó na raiz
			System.out.println("Árvore criada com raiz " + e);
			tamanho = 1;
		}
		else {
			Node aux1 = raiz,
			     aux2 = raiz;
			while (aux1 != null) {
				aux2 = aux1;
				if (e.compareToIgnoreCase(aux1.elemento) == 0)
					break;
				else if (e.compareToIgnoreCase(aux1.elemento) < 0)					
					aux1 = aux1.esquerda;
				else
					aux1 = aux1.direita;
			}
			if (e.compareToIgnoreCase(aux2.elemento) == 0) {     // se o elemento já existe na árvore, aumenta a quantidade
				aux2.repetida();
				tamanho+=1;
				System.out.println("Outro " + e + " adicionado");
			}
			else {                      // se não existe, cria um lugar na árvore pra ele
				if (e.compareToIgnoreCase(aux2.elemento) < 0)  // à esquerda se for menor que o pai
					aux2.esquerda = novo;
				else                    // à direita se for maior
					aux2.direita = novo;
				System.out.println("Elemento " + e + " adicionado");
				tamanho+=1;
			}
		}
	}
	
	public int GetTamanho() {
	    return tamanho;
	}
	
	public Node busca(Node raiz, String e) {
	    if (raiz == null)
	        return null;
	    if (raiz.elemento.compareToIgnoreCase(e) == 0)
	        return raiz;
	    Node aux = busca(raiz.esquerda, e);
	    if (aux != null)
	        return aux;
	    return busca(raiz.direita, e);
	}
	
	public Node buscaPai(Node raiz, String e) {
	    Node atual = raiz;
	    Node pai = null;
	    boolean filhoEsquerda = true;
	    
	    while ((atual.elemento.compareToIgnoreCase(e) != 0) && (atual != null)) {
	        pai = atual;
	        if (e.compareToIgnoreCase(atual.elemento) < 0) {
	            atual = atual.esquerda;
	            filhoEsquerda = true;
	        }
	        else {
	            atual = atual.direita;
	            filhoEsquerda = false;
	        }
	    }
	    return pai;
	}
	
	public Node maiorEsquerda(Node node) {
	    Node anterior = node;
	    node = node.esquerda;
	    if (node != null) {
	        while (node.direita != null) {
	            anterior = node;
	            node = node.direita;
	        }
	    }
	    return node;
	}
	
	public Node menorDireita(Node node) {
	    Node anterior = node;
	    node = node.direita;
	    if (node != null) {
	        while (node.esquerda != null) {
	            anterior = node;
	            node = node.esquerda;
	        }
	    }
	    return node;
	}
	
	public boolean excluir (Node raiz, String e) {
	    Node atual,
	         nodePai,
	         substituto,
	         paiSubstituto;
	         
	    atual = busca(raiz, e);
	    nodePai = buscaPai(raiz, e);
	    if (atual == null)
	        return false;
	    if (atual.esquerda == null || atual.direita == null) {
	        if (atual.esquerda != null)
	            substituto = atual.esquerda;
	        else
	            substituto = atual.direita;
	        if (nodePai == null) {
	            this.raiz = substituto;
	        }
	        else {
	            if (nodePai.esquerda == atual)
	                nodePai.esquerda = substituto;
	            else
	                nodePai.direita = substituto;
	        }
	        System.out.println("Elemento " + e + " excluído");
	        tamanho-=atual.quantidade;
	        atual = null;
	    }
	    else {
	        //substituto = maiorEsquerda(atual);
	        substituto = menorDireita(atual);
	        paiSubstituto = buscaPai(this.raiz, substituto.elemento);
	        atual.elemento = substituto.elemento;
	        
	        if (paiSubstituto != null) {
	            if (paiSubstituto.esquerda ==substituto)
	                paiSubstituto.esquerda = substituto.esquerda;
	            else
	                paiSubstituto.direita = substituto.esquerda;
	        }
	        System.out.println("Elemento " + e + " excluído");
	        tamanho-=substituto.quantidade;
	        substituto = null;
	    }
	    return true;
	}
	
	public boolean altera(Node raiz, String antigo, String novo) {
	    if (excluir(raiz, antigo)) {
	        adiciona(novo);
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	
	public void exibirPreOrdem(Node raiz) {
		if (raiz == null) 
			return;
		if (raiz.quantidade == 1)
		    System.out.print(raiz.elemento + " " + raiz.quantidade + " vez; ");
		else
		    System.out.print(raiz.elemento + " " + raiz.quantidade + " vezes; ");
		exibirPreOrdem(raiz.esquerda);
		exibirPreOrdem(raiz.direita);
	}

	public void exibirEmOrdem(Node raiz) {
		if (raiz == null) 
			return;
		exibirEmOrdem(raiz.esquerda);
		if (raiz.quantidade == 1)
		    System.out.print(raiz.elemento + " " + raiz.quantidade + " vez; ");
		else
		    System.out.print(raiz.elemento + " " + raiz.quantidade + " vezes; ");
		exibirEmOrdem(raiz.direita);
	}

	public void exibirPosOrdem(Node raiz) {
		if (raiz == null) 
			return;
		exibirPosOrdem(raiz.esquerda);
		exibirPosOrdem(raiz.direita);
		if (raiz.quantidade == 1)
		    System.out.print(raiz.elemento + " " + raiz.quantidade + " vez; ");
		else
		    System.out.print(raiz.elemento + " " + raiz.quantidade + " vezes; ");
	}	
}
