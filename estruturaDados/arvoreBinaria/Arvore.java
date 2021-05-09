public class Arvore {
	Node raiz;
	Arvore() {
		raiz = null;
	}
	public void adiciona(int e) {
		Node novo = new Node(e);
		if (raiz == null) { // Verifica se a árvore está vazia
			raiz = novo;    // inclui o Nó na raiz
			System.out.println("Árvore criada com raiz " + e);
		}
		else {
			Node aux1 = raiz, aux2 = raiz;
			while (aux1 != null) {
				aux2 = aux1;
				if (e == aux1.elemento)
					break;
				else if (e < aux1.elemento)					
					aux1 = aux1.esquerda;
				else 
					aux1 = aux1.direita;
			}
			if (e == aux2.elemento)     // se o elemento já existe na árvore, não adiciona
				System.out.println("Elemento " + e + " já existe!!!");
			else {                      // se não existe, cria um lugar na árvore pra ele
				if (e < aux2.elemento)  // à esquerda se for menor que o pai
					aux2.esquerda = novo;
				else                    // à direita se for maior
					aux2.direita = novo;
				System.out.println("Elemento " + e + " adicionado");
			}
		}
	}
	
	public void exibirPreOrdem(Node raiz) {
		if (raiz == null) 
			return;
		System.out.print(raiz.elemento + " ");
		exibirPreOrdem(raiz.esquerda);
		exibirPreOrdem(raiz.direita);
	}

	public void exibirEmOrdem(Node raiz) {
		if (raiz == null) 
			return;
		exibirEmOrdem(raiz.esquerda);
		System.out.print(raiz.elemento + " ");
		exibirEmOrdem(raiz.direita);
	}

	public void exibirPosOrdem(Node raiz) {
		if (raiz == null) 
			return;
		exibirPosOrdem(raiz.esquerda);
		exibirPosOrdem(raiz.direita);
		System.out.print(raiz.elemento + " ");
	}	
}
