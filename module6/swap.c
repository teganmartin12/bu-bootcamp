#include <stdio.h> 
 
void swap(int *a, int *b) { 
    // temp saves val at a 
    int temp = *a;
    
    // b val goes to a location
    *a = *b;

    //temp val goes to b location
    *b = temp;
} 

void broken_swap(int a, int b){

    int temp2 = a;

    a = b;

    b = temp2;
}
 
int main() { 

    int x = 54321; 
    int y = 5678; 
 
    printf("Before swap: x = %d, y = %d\n", x, y); 
 
    swap(&x, &y); 
 
    printf("After swap:  x = %d, y = %d\n", x, y);
    printf("\n"); 


    int c = 0;
    int d = 1;

    printf("Before broken swap: x = %d, y = %d\n", c, d); 
 
    broken_swap(c, d); 
 
    printf("After broken swap:  x = %d, y = %d\n", c, d);
    
    //broken swap returns the values unswapped because not using pointers 
    // means that you are only passing in a copy of the variable
    // you are also not returning the copy anywhere so the og vars 
    // remain unchanged

    return 0;
} 