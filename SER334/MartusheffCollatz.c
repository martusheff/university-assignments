/**
* C style implementation of the Collatz Conjecture.
* Runs a user specified number against the conjecture and returns number of iterations & max value visited.
*
* Completion time: 0h 10m
*
* @author Andronick Martusheff
* @version v01.10.2022
*/

////////////////////////////////////////////////////////////////////////////////

#include <stdio.h>

//FORWARD DECLARATIONS
void termination(int n);

// GLOBAL VARIABLES
int iteration = 0;
int maxValueReached = 0;

int main() {
    // Variable for input user will test against collatz conjecture.
    int numToTest;

    printf("\nThink you can find a number that beats the Collatz Conjecture?\n");
    printf("Go ahead and try -> ");
    scanf("%d", &numToTest);

    // Testing user's input.
    termination(numToTest);

    printf("It was inevitable... it took %d iteration(s) to get back to 1.\n", iteration);
    printf("Don't feel too bad.. you reached a high value of %d!\n", maxValueReached);

    return 0;
}

void termination(int n) {
    while( n > 1) {
        if (n % 2 == 0) {
            n = n / 2;
        } else {
            n = (3 * n) + 1;
        }
        // Increment iteration on pass.
        iteration++;
        // Updated maxValueReached if new maxValue is found. Gives user some fun info.
        if( n > maxValueReached) {
            maxValueReached = n;
        }
    }
}