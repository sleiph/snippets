#include<stdio.h>
#include<math.h>

int main(int argc, char** argv)
{
    float a, b, c, x1, x2, delta;
    
    printf("Digite o valor de a:");
    scanf("%f", &a);
    printf("Digite o valor de b:");
    scanf("%f", &b);
    printf("Digite o valor de c:");
    scanf("%f", &c);
    
    if (a == 0) printf("Essa não é uma equação de segundo grau :(");
    else{
      delta = (b*b) - (4*a*c);
      if (delta < 0) printf("A equação não possui raízes reais.");
      else{
        x1 = (-b + sqrt(delta)) / (2*a);
        x2 = (-b - sqrt(delta)) / (2*a);
        if (x1==x2) printf("O valor de x é %.2f", x1);
        else{
          printf("O valor de x1 é %.2f\n", x1);
          printf("O valor de x2 é %.2f", x2);
        }
      }
    }
    
    return 0;
}