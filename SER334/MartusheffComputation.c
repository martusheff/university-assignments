/**
* Conveniently calculates a total sum of a user specified number of cylinders.
*
* Completion time: 0h 15m
*
* @author Andronick Martusheff, SER334 Provided Base File
* @version v01.10.2022
*/

#include <stdio.h>
#define PI 3.14159 // Defining PI for future use.

double calcCylinderVolume(double h, double r); // Helper function.

int main(void) {

    int numCylinders;
    double runningCylinderSum;

    printf("Enter number of cylinders you'd like to calculate the volume of!\n -> ");
    scanf("%d", &numCylinders);

    for(int i = 1; i <= numCylinders; i++) {
        double height, radius;
        printf("\nCylinder #%d", i);
        printf("\nHeight -> ");
        scanf("%lf", &height);
        printf("Radius -> ");
        scanf("%lf", &radius);

        runningCylinderSum += calcCylinderVolume(height, radius);
    }

    // Rounding to 2 decimal places with the '.2' trailing our 'lf' printf output.
    // Custom messages to improve perceived quality of output.
    if(numCylinders == 1) {
        printf("\nYour cylinder has a volume of %.2lf.\n", runningCylinderSum);
    } else {
        printf("\nThe total sum of your %d cylinders is %.2lf.\n", numCylinders, runningCylinderSum);
    }
}

double calcCylinderVolume(double h, double r) {
    return (PI * (r * r) * h);
}

