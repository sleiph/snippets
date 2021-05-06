#include<stdio.h>
#include<math.h>

int main(int argc, char** argv) {
  double a, b, c, delta, x1, x2;
    
  while (1) {
    printf("Digite o valor de a: ");
    scanf("%lf", &a);
    if (a != 0.0) break;
    printf("O valor de a precisa ser diferente de zero\n");
  }
  printf("Digite o valor de b: ");
  scanf("%lf", &b);
  printf("Digite o valor de c: ");
  scanf("%lf", &c);
    
  delta = (b * b) - (4 * a * c);
    
  if (delta < 0.0)
    printf("A equação não possui raízes reais.");
  else {
    x1 = (-b + sqrt(delta)) / (2*a);
    x2 = (-b - sqrt(delta)) / (2*a);
    if (x1 == x2)
      printf("O valor de x é %.3lf", x1);
    else {
      printf("O valor de x1 é %.3lf\n", x1);
      printf("O valor de x2 é %.3lf", x2);
    }
  }
  return 0;
}