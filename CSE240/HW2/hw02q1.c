
/**
* CSE240 Homework 2 Question 1*
* Completion time : ~ 20 minutes. *
* @AndronickMartusheff
* @v03.13.2021
*/


#include <stdio.h>

// Macros
#define subm(a,b) (a-b) // subtraction
#define cubem(a) (a * a * a) // cube
#define minm(a,b) ((a < b) ? (a): (b)) // min
#define oddm(a) ((a % 2 == 1) ? 1 : 0) // odd
#define evenm(a) ((a % 2 == 0) ? 1 : 0) // even 

int a,b;

int subf(int a, int b) {
	return a - b;
}

int cubef(int a) {
	return a * a * a;
}

int minf(int a, int b) {
	if (a <= b) {
	    return a;
	} else {
		return b;
	}
}

int oddf(int a) {
	if (a % 2 == 1) {
	    return 1;
	} else {
		return 0;
	}
} 

int main() {

	a = 3; b = 6; // set a,b values
	printf("VALUES RESET. a = %d, b = %d\n", a, b);
	printf("subf(a,b) = %d\n",subf(a,b));
	printf("subm(a,b) = %d\n",subm(a,b));
	printf("subf(a++,b--) = %d\n",subf(a++,b--));
	printf("\n");

	
	a = 3; b = 6; // reset vals
	printf("VALUES RESET. a = %d, b = %d\n", a, b);
	printf("subm(a++,b--) = %d\n",subm(a++,b--)); 
	printf("\n");

	
	a = 3; b = 6; // reset vals
	printf("VALUES RESET. a = %d, b = %d\n", a, b);
	printf("cubef(a) = %d\n",cubef(a));
	printf("cubem(a) = %d\n",cubem(a));
	printf("cubef(--a) = %d\n",cubef(--a));
	printf("\n");

	
	a = 3; b = 6; // reset vals
	printf("VALUES RESET. a = %d, b = %d\n", a, b);
	printf("cubem(--a) = %d\n",cubem(--a));
	printf("\n");

	
	a = 3; b = 6; // reset vals
	printf("VALUES RESET. a = %d, b = %d\n", a, b);
	printf("minf(a,b) = %d\n",minf(a,b));
	printf("minm(a,b) = %d\n",minm(a,b));
	printf("minf(--a,--b) = %d\n",minf(--a,--b));
	printf("\n");

	
	a = 3; b = 6; // reset vals
	printf("VALUES RESET. a = %d, b = %d\n", a, b);
	printf("minm(--a,--b) = %d\n",minm(--a,--b));
	printf("\n");

	printf("1 indicates the call is true, 0 is false. (ie. evenm(2) returns 1)\n\n");


	a = 2; b =6; // reset vals
	printf("VALUES RESET. a = %d, b = %d\n", a, b);
	printf("oddf(a) = %d\n",oddf(a));
	printf("oddm(a) = %d\n",oddm(a));
	printf("oddf(a++) = %d\n",oddf(a++));
	printf("oddm(a++) = %d\n",oddm(a++));
	printf("\n");

	a = 2; b = 6; // reset vals
	printf("VALUES RESET. a = %d, b = %d\n", a, b);
	printf("evenm(a++) = %d\n",evenm(a++));
	printf("evenm(a) = %d\n",evenm(a));
	printf("\n");


}