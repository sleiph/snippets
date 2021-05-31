import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Arvore minhaArvore = new Arvore();
		while (sc.hasNext()) {
			minhaArvore.adiciona(sc.next());
		}
		
		sc.close();
		
		System.out.println("\nNúmero de alunos: " + minhaArvore.GetTamanho());
		System.out.print("\nPre ordem: ");
		minhaArvore.exibirPreOrdem(minhaArvore.raiz);
		System.out.print("\nEm ordem: ");
		minhaArvore.exibirEmOrdem(minhaArvore.raiz);
		System.out.print("\nPos ordem: ");
		minhaArvore.exibirPosOrdem(minhaArvore.raiz);
		
		// excluir
		System.out.println("\n");
		minhaArvore.excluir(minhaArvore.raiz, "Alecio");
		// prints
		System.out.println("\nNúmero de alunos: " + minhaArvore.GetTamanho());
		System.out.print("\nPre ordem: ");
		minhaArvore.exibirPreOrdem(minhaArvore.raiz);
		System.out.print("\nEm ordem: ");
		minhaArvore.exibirEmOrdem(minhaArvore.raiz);
		System.out.print("\nPos ordem: ");
		minhaArvore.exibirPosOrdem(minhaArvore.raiz);
		
		// pesquisas
		System.out.println("\n");
		String nome = "Alexandre";
		Node temp = minhaArvore.busca(minhaArvore.raiz, nome);
		System.out.println(
		    (temp != null) ?
		    temp.elemento + " existe na árvore" :
		    nome + " não encontrado"
		);
		
		nome = "Alberto";
		temp = minhaArvore.busca(minhaArvore.raiz, nome);
		System.out.println(
		    (temp != null) ?
		    temp.elemento + " existe na árvore"  :
		    nome + " não encontrado"
		);
		
		// alterar
		System.out.println();
		minhaArvore.altera(minhaArvore.raiz, "Tailan", "Taylan");
		// prints
		System.out.println("\nNúmero de alunos: " + minhaArvore.GetTamanho());
		System.out.print("\nPre ordem: ");
		minhaArvore.exibirPreOrdem(minhaArvore.raiz);
		System.out.print("\nEm ordem: ");
		minhaArvore.exibirEmOrdem(minhaArvore.raiz);
		System.out.print("\nPos ordem: ");
		minhaArvore.exibirPosOrdem(minhaArvore.raiz);
	}

}
