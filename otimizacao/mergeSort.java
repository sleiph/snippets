package otimizacao;

import java.util.Random;
import java.util.Arrays;

public class mergeSort
{
    // divide o array até seu menor tamanho possível
    public static void Sort(int[] v, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            Sort(v, inicio, meio);
            Sort(v, meio+1, fim);
            merge(v, inicio, meio, meio+1, fim);
        }
    }
    
    // junta o array ordenando seus elementos
    public static void merge(int[] v, int iE, int fE, int iD, int fD) {
        int[] aux = new int[(fD-iE) + 1];
        int iAux = 0;
        int iV = iE;
        
        while (iE <= fE && iD <= fD) {
            if (v[iE] < v[iD]) {
                aux[iAux] = v[iE];
                iE++;
            }
            else {
                aux[iAux] = v[iD];
                iD++;
            }
            iAux++;
        }
        
        for (; iE <= fE; iE++) {
            aux[iAux] = v[iE];
            iAux++;
        }
        for (; iD <= fD; iD++) {
            aux[iAux] = v[iD];
            iAux++;
        }
        for (iAux = 0; iV <= fD; iAux++, iV++) {
            v[iV] = aux[iAux];
        }
    }
    
	public static void main(String[] args) {
	    Random rnd = new Random();
	    
		int[] arr = new int[10];
		for (int i=0; i < arr.length; i++) 
			arr[i] = rnd.nextInt(100);
		System.out.println(Arrays.toString(arr));
		
		Sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
