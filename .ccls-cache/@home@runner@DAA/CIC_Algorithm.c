#include<stdio.h>
int main(){
  int m, n;
  scanf("%d%d", &m, &n);
  int min = m < n ? m : n;
  while(n != 0){
    if(m % min == 0){
      if(n % min == 0){
        break;
      }
    }
    min--;
  }
  printf("%d", min);
  return 0;
}