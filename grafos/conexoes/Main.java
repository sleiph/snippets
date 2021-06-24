package grafos.conexoes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int qnt = sc.nextInt();
        
        for (int i=0; i<qnt; i++) {
            int v = sc.nextInt(),
                e = sc.nextInt();
            int contador = 0;
                
            Grafo g = new Grafo( v );
                
            while (e-- > 0) {
                char n1 = sc.next().charAt(0),
                     n2 = sc.next().charAt(0);
                    
                g.addAresta((int)n1-97, (int)n2-97);
            }

            sc.close();
            
            System.out.println("Case #" + (i+1) + ":");
            
            for (ArrayList<Integer> conexoes : g.conexoesComponentes()) {
                Collections.sort(conexoes);
                for (int j=0; j<conexoes.size(); j++) {
                    System.out.print((char)(conexoes.get(j)+97)+",");
                }
                contador++;
                System.out.println();
            }
            
            System.out.println(contador + " connected components");
            System.out.println();
        }

    }
}
