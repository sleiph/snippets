import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Arvore minhaArvore = new Arvore();
		while (sc.hasNext()) {
			minhaArvore.adiciona(sc.nextInt());
		}
		
		System.out.print("\nPre ordem: ");
		minhaArvore.exibirPreOrdem(minhaArvore.raiz);

		System.out.print("\nEm ordem: ");
		minhaArvore.exibirEmOrdem(minhaArvore.raiz);
		
		System.out.print("\nPos ordem: ");
		minhaArvore.exibirPosOrdem(minhaArvore.raiz);
	}

}
