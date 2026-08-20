#include <stdio.h>

void print_math(int *a, int *b){
    int sum;
    int product;

    sum = *a + *b;
    product = *a * *b;

    *a = sum;
    *b = product;
}

int main(){

    int number1;
    int number2;

    printf("Please enter a number\n");
    scanf("%d", &number1);


    printf("Now enter a second number\n");
    scanf("%d", &number2);

    //pass by pointer
    print_math(&number1, &number2);


    printf("Sum: %d, Product: %d", number1, number2);

    return 0;
}