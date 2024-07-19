#include <stdio.h>
int main(){
  int m, n, rem;
  scanf("%d%d",&m, &n);
  while(n != 0){
    rem = m % n;
    m = n;
    n = rem;
  }
  printf("%d",m);
  return 0;
}