/**
* Multi-threaded image filtering software.
*
* Completion time: 12hrs
*
* @author Martusheff, Acuna
* @version v02.05.2022
*/

////////////////////////////////////////////////////////////////////////////////
//INCLUDES
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <math.h>
#include <unistd.h>

//TODO: finish me

//UNCOMMENT BELOW LINE IF USING SER334 LIBRARY/OBJECT FOR BMP SUPPORT
#include "BmpProcessor.h"


////////////////////////////////////////////////////////////////////////////////
//MACRO DEFINITIONS

//problem assumptions
#define GLOBAL_THREAD_COUNT 8
#define MAX_CIRCLE_RADIUS 20
#define MIN_CIRCLE_RADIUS 5
#define NUM_CIRCLES 10
#define YELLOW_SHIFT 50

//TODO: finish me


////////////////////////////////////////////////////////////////////////////////
//DATA STRUCTURES

//TODO: finish me
struct Circle {
    int x;
    int y;
    int r;
};

struct DataInfo {
    int colStart;
    int colEnd;
};

struct BMP_Header *header;
struct DIB_Header *headerDIB;
struct Pixel **p_array;
struct Pixel ***dyn_data;
struct Circle circles[NUM_CIRCLES];
struct DataInfo chunks[GLOBAL_THREAD_COUNT];


int neighbors = 0;
int gSum = 0;
int rSum = 0;
int bSum = 0;
////////////////////////////////////////////////////////////////////////////////
//MAIN PROGRAM CODE

//TODO: finish me

//void yellow_color_shift(struct Pixel **p_array, int width, int height, int shift) {
//    struct Pixel temp;
//    for(int i = 0; i < height; i++) {
//        for (int j = 0; j < width; j++) {
//            temp = p_array[i][j];
//            p_array[i][j].green = (temp.green + shift) > 255 ? 255 : p_array[i][j].green + shift;
//            p_array[i][j].red = (temp.red + shift) > 255 ? 255 : p_array[i][j].red + shift;
//        }
//    }
//}

void yellow_color_shift(int colStart, int colEnd) {
    struct Pixel temp;
    for(int i = 0; i < headerDIB->height; i++) {
        for (int j = colStart; j < colEnd; j++) {
            temp = p_array[i][j];
            p_array[i][j].green = (temp.green + YELLOW_SHIFT) > 255 ? 255 : p_array[i][j].green + YELLOW_SHIFT;
            p_array[i][j].red = (temp.red + YELLOW_SHIFT) > 255 ? 255 : p_array[i][j].red + YELLOW_SHIFT;
        }
    }
}

void update_pixel_blur(struct Pixel **p_array, int i, int j, int rSum, int gSum, int bSum, int neighbors) {
    p_array[i][j].red = rSum / neighbors;
    p_array[i][j].green = gSum / neighbors;
    p_array[i][j].blue = bSum / neighbors;
}

void box_blur(int startCol, int endCol) {
    for(int i = 0; i < headerDIB->height; i++) {
        for(int j = startCol; j < endCol; j++) {
            if(i == 0) { // IN FIRST ROW
                if(j == 0) { // IN FIRST COLUMN
                    neighbors = 4;
                    rSum = p_array[i][j].red + p_array[i+1][j].red + p_array[i][i+1].red + p_array[i+1][j+1].red;
                    gSum = p_array[i][j].green + p_array[i+1][j].green + p_array[i][i+1].green + p_array[i+1][j+1].green;
                    bSum = p_array[i][j].blue + p_array[i+1][j].blue + p_array[i][i+1].blue + p_array[i+1][j+1].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                } else if (j == headerDIB->width - 1) { // IN LAST COLUMN
                    neighbors = 4;
                    rSum = p_array[i][j].red + p_array[i+1][j].red + p_array[i][j-1].red + p_array[i+1][j-1].red;
                    gSum = p_array[i][j].green + p_array[i+1][j].green + p_array[i][j-1].green + p_array[i+1][j-1].green;
                    bSum = p_array[i][j].blue + p_array[i+1][j].blue + p_array[i][j-1].blue + p_array[i+1][j-1].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                } else { // IN BETWEEN
                    neighbors = 6;
                    rSum = p_array[i][j].red + p_array[i][j-1].red + p_array[i][j+1].red + p_array[i+1][j-1].red + p_array[i+1][j].red + p_array[i+1][j+1].red;
                    gSum = p_array[i][j].green + p_array[i][j-1].green + p_array[i][j+1].green + p_array[i+1][j-1].green + p_array[i+1][j].green + p_array[i+1][j+1].green;
                    bSum = p_array[i][j].blue + p_array[i][j-1].blue + p_array[i][j+1].blue + p_array[i+1][j-1].blue + p_array[i+1][j].blue + p_array[i+1][j+1].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                }
            } else if(i == headerDIB->height - 1) { // IN LAST ROW
                if(j == 0) { // IN FIRST COLUMN
                    neighbors = 4;
                    rSum = p_array[i][j].red + p_array[i][j+1].red + p_array[i-1][j].red + p_array[i-1][j+1].red;
                    gSum = p_array[i][j].green + p_array[i][j+1].green + p_array[i-1][j].green + p_array[i-1][j+1].green;
                    bSum = p_array[i][j].blue + p_array[i][j+1].blue + p_array[i-1][j].blue + p_array[i-1][j+1].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                } else if (j == headerDIB->width - 1) { // IN LAST COLUMN
                    neighbors = 4;
                    rSum = p_array[i][j].red + p_array[i][j-1].red + p_array[i-1][j-1].red + p_array[i-1][j].red;
                    gSum = p_array[i][j].green + p_array[i][j-1].green + p_array[i-1][j-1].green + p_array[i-1][j].green;
                    bSum = p_array[i][j].blue + p_array[i][j-1].blue + p_array[i-1][j-1].blue + p_array[i-1][j].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                } else { // IN BETWEEN
                    neighbors = 6;
                    rSum = p_array[i][j].red + p_array[i][j-1].red + p_array[i][j+1].red + p_array[i-1][j-1].red + p_array[i-1][j].red + p_array[i-1][j+1].red;
                    gSum = p_array[i][j].green + p_array[i][j-1].green + p_array[i][j+1].green + p_array[i-1][j-1].green + p_array[i-1][j].green + p_array[i-1][j+1].green;
                    bSum = p_array[i][j].blue + p_array[i][j-1].blue + p_array[i][j+1].blue + p_array[i-1][j-1].blue + p_array[i-1][j].blue + p_array[i-1][j+1].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                }
            } else { // IN BETWEEN
                if(j == 0) { // IN FIRST COLUMN
                    neighbors = 6;
                    rSum = p_array[i][j].red + p_array[i][j+1].red + p_array[i-1][j].red + p_array[i-1][j+1].red + p_array[i+1][j].red + p_array[i+1][j+1].red;
                    gSum = p_array[i][j].green + p_array[i][j+1].green + p_array[i-1][j].green + p_array[i-1][j+1].green + p_array[i+1][j].green + p_array[i+1][j+1].green;
                    bSum = p_array[i][j].blue + p_array[i][j+1].blue + p_array[i-1][j].blue + p_array[i-1][j+1].blue + p_array[i+1][j].blue + p_array[i+1][j+1].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                } else if (j == headerDIB->width - 1) { // IN LAST COLUMN
                    neighbors = 6;
                    rSum = p_array[i][j].red + p_array[i][j-1].red + p_array[i-1][j-1].red + p_array[i-1][j].red + p_array[i+1][j-1].red + p_array[i+1][j].red;
                    gSum = p_array[i][j].green + p_array[i][j-1].green + p_array[i-1][j-1].green + p_array[i-1][j].green + p_array[i+1][j-1].green + p_array[i+1][j].green;
                    bSum = p_array[i][j].blue + p_array[i][j-1].blue + p_array[i-1][j-1].blue + p_array[i-1][j].blue + p_array[i+1][j-1].blue + p_array[i+1][j].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                } else { // IN BETWEEN
                    neighbors = 9;
                    rSum = p_array[i][j].red + p_array[i][j-1].red + p_array[i][j+1].red + p_array[i-1][j-1].red + p_array[i-1][j].red + p_array[i-1][j+1].red + p_array[i+1][j-1].red + p_array[i+1][j].red + p_array[i+1][j+1].red;
                    gSum = p_array[i][j].green + p_array[i][j-1].green + p_array[i][j+1].green + p_array[i-1][j-1].green + p_array[i-1][j].green + p_array[i-1][j+1].green + p_array[i+1][j-1].green + p_array[i+1][j].green + p_array[i+1][j+1].green;
                    bSum = p_array[i][j].blue + p_array[i][j-1].blue + p_array[i][j+1].blue + p_array[i-1][j-1].blue + p_array[i-1][j].blue + p_array[i-1][j+1].blue + p_array[i+1][j-1].blue + p_array[i+1][j].blue + p_array[i+1][j+1].blue;
                    update_pixel_blur(p_array,i,j,rSum,gSum,bSum,neighbors);
                }
            }
        }
    }

}

void read_input_file(char* input) {
    /* Load input file.
     *******************/

    // Allocate memory to headers.
    header = malloc(sizeof (struct BMP_Header));
    headerDIB = malloc(sizeof (struct DIB_Header));

    // Open input file.
    FILE *file = fopen (input, "rb");
    // Load input header data.
    readBMPHeader(file, header);
    readDIBHeader(file, headerDIB);

    // Allocate memory to pixel array.
    p_array = (struct Pixel **)calloc(headerDIB->width, sizeof (struct Pixel*));
    for(int i = 0; i < headerDIB->height; i++) {
        p_array[i] = (struct Pixel *)calloc(headerDIB->width, 3);
    }
    // Load pixel data.
    readPixelsBMP(file, (struct Pixel **) p_array, headerDIB->width, headerDIB->height);

    int colSize = headerDIB->width / GLOBAL_THREAD_COUNT;
    for(int i = 0; i < GLOBAL_THREAD_COUNT; i++) {
        chunks[i].colStart = i * colSize;
        chunks[i].colEnd = chunks[i].colStart + colSize;
    }

    // Close input file.
    fclose(file);
}


int compute_distance(int pointX, int pointY, int targetX, int targetY) {
    int a = abs(targetX - pointX);
    int b = abs(targetY - pointY);
    double squared = (a*a) + (b*b);
    double c = sqrt(squared);
    return (int) c;
}

int random_number(int min_num, int max_num) {
    int result = 0, low_num = 0, hi_num = 0;

    if (min_num < max_num)
    {
        low_num = min_num;
        hi_num = max_num + 1; // include max_num in output
    } else {
        low_num = max_num + 1; // include max_num in output
        hi_num = min_num;
    }

    srand(time(NULL));
    result = (rand() % (hi_num - low_num)) + low_num;
    return result;
}

void create_random_points() {
    for(int i = 0; i < NUM_CIRCLES; i++) {
        int radius = (rand() % MAX_CIRCLE_RADIUS) + MIN_CIRCLE_RADIUS;
        int randX = rand() % headerDIB->width;
        int randY = rand() % headerDIB->height;

        circles[i].x = randX;
        circles[i].y = randY;
        circles[i].r = radius;

        printf("Circle #%d | x = %d | y = %d | r = %d\n", i, circles[i].x, circles[i].y, circles[i].r);
    }
}

void swiss_cheese(int colStart, int colEnd) {
    for(int i = 0; i < headerDIB->height; i++) {
        for(int j = colStart; j < colEnd; j++) {
            for(int z = 0; z < NUM_CIRCLES; z++) {
                if(compute_distance(j,i,circles[z].x, circles[z].y) < circles[z].r) {
                    p_array[i][j].red = 0;
                    p_array[i][j].green = 0;
                    p_array[i][j].blue = 0;
                }
            }

        }
    }
    yellow_color_shift(colStart, colEnd);
}


void assignData() {
    int colSize = (headerDIB->width / GLOBAL_THREAD_COUNT);
    dyn_data = (struct Pixel ***)calloc(GLOBAL_THREAD_COUNT, sizeof (struct Pixel**));
    for(int i = 0; i < GLOBAL_THREAD_COUNT; i++) {
        dyn_data[i] = (struct Pixel**)calloc(headerDIB->height, sizeof (struct Pixel*));
        for(int j = 0; j < headerDIB->height; j++) {
            dyn_data[i][j] = (struct Pixel*)calloc(colSize, sizeof(struct Pixel));
        }
    }
}

void split() {
    /* go through each row */
    int colSize = (headerDIB->width / GLOBAL_THREAD_COUNT);

    for (int i = 0; i < headerDIB->height; i++) {
        for (int j = 0; j < headerDIB->width; j++) {
            dyn_data[j / colSize][i][j % colSize] = p_array[i][j];
        }
    }
}

void* box_blur_runner(void* data) {
    int chunk = (int) data;
    for(int i = 0; i < headerDIB->height; i++) {
        for(int j = chunks[chunk].colStart; j < chunks[chunk].colEnd; j++) {
            if(i == 0) { // IN FIRST ROW
                if(j == 0) { // IN FIRST COLUMN
                    neighbors = 4;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i+1][j].red + dyn_data[chunk][i][i+1].red + dyn_data[chunk][i+1][j+1].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i+1][j].green + dyn_data[chunk][i][i+1].green + dyn_data[chunk][i+1][j+1].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i+1][j].blue + dyn_data[chunk][i][i+1].blue + dyn_data[chunk][i+1][j+1].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                } else if (j == chunks[chunk].colEnd - 1) { // IN LAST COLUMN
                    neighbors = 4;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i+1][j].red + dyn_data[chunk][i][j-1].red + dyn_data[chunk][i+1][j-1].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i+1][j].green + dyn_data[chunk][i][j-1].green + dyn_data[chunk][i+1][j-1].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i+1][j].blue + dyn_data[chunk][i][j-1].blue + dyn_data[chunk][i+1][j-1].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                } else { // IN BETWEEN
                    neighbors = 6;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i][j-1].red + dyn_data[chunk][i][j+1].red + dyn_data[chunk][i+1][j-1].red + dyn_data[chunk][i+1][j].red + dyn_data[chunk][i+1][j+1].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i][j-1].green + dyn_data[chunk][i][j+1].green + dyn_data[chunk][i+1][j-1].green + dyn_data[chunk][i+1][j].green + dyn_data[chunk][i+1][j+1].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i][j-1].blue + dyn_data[chunk][i][j+1].blue + dyn_data[chunk][i+1][j-1].blue + dyn_data[chunk][i+1][j].blue + dyn_data[chunk][i+1][j+1].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                }
            } else if(i == headerDIB->height - 1) { // IN LAST ROW
                if(j == 0) { // IN FIRST COLUMN
                    neighbors = 4;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i][j+1].red + dyn_data[chunk][i-1][j].red + dyn_data[chunk][i-1][j+1].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i][j+1].green + dyn_data[chunk][i-1][j].green + dyn_data[chunk][i-1][j+1].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i][j+1].blue + dyn_data[chunk][i-1][j].blue + dyn_data[chunk][i-1][j+1].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                } else if (j == chunks[chunk].colEnd - 1) { // IN LAST COLUMN
                    neighbors = 4;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i][j-1].red + dyn_data[chunk][i-1][j-1].red + dyn_data[chunk][i-1][j].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i][j-1].green + dyn_data[chunk][i-1][j-1].green + dyn_data[chunk][i-1][j].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i][j-1].blue + dyn_data[chunk][i-1][j-1].blue + dyn_data[chunk][i-1][j].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                } else { // IN BETWEEN
                    neighbors = 6;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i][j-1].red + dyn_data[chunk][i][j+1].red + dyn_data[chunk][i-1][j-1].red + dyn_data[chunk][i-1][j].red + dyn_data[chunk][i-1][j+1].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i][j-1].green + dyn_data[chunk][i][j+1].green + dyn_data[chunk][i-1][j-1].green + dyn_data[chunk][i-1][j].green + dyn_data[chunk][i-1][j+1].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i][j-1].blue + dyn_data[chunk][i][j+1].blue + dyn_data[chunk][i-1][j-1].blue + dyn_data[chunk][i-1][j].blue + dyn_data[chunk][i-1][j+1].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                }
            } else { // IN BETWEEN
                if(j == 0) { // IN FIRST COLUMN
                    neighbors = 6;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i][j+1].red + dyn_data[chunk][i-1][j].red + dyn_data[chunk][i-1][j+1].red + dyn_data[chunk][i+1][j].red + dyn_data[chunk][i+1][j+1].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i][j+1].green + dyn_data[chunk][i-1][j].green + dyn_data[chunk][i-1][j+1].green + dyn_data[chunk][i+1][j].green + dyn_data[chunk][i+1][j+1].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i][j+1].blue + dyn_data[chunk][i-1][j].blue + dyn_data[chunk][i-1][j+1].blue + dyn_data[chunk][i+1][j].blue + dyn_data[chunk][i+1][j+1].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                } else if (j == chunks[chunk].colEnd - 1) { // IN LAST COLUMN
                    neighbors = 6;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i][j-1].red + dyn_data[chunk][i-1][j-1].red + dyn_data[chunk][i-1][j].red + dyn_data[chunk][i+1][j-1].red + dyn_data[chunk][i+1][j].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i][j-1].green + dyn_data[chunk][i-1][j-1].green + dyn_data[chunk][i-1][j].green + dyn_data[chunk][i+1][j-1].green + dyn_data[chunk][i+1][j].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i][j-1].blue + dyn_data[chunk][i-1][j-1].blue + dyn_data[chunk][i-1][j].blue + dyn_data[chunk][i+1][j-1].blue + dyn_data[chunk][i+1][j].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                } else { // IN BETWEEN
                    neighbors = 9;
                    rSum = dyn_data[chunk][i][j].red + dyn_data[chunk][i][j-1].red + dyn_data[chunk][i][j+1].red + dyn_data[chunk][i-1][j-1].red + dyn_data[chunk][i-1][j].red + dyn_data[chunk][i-1][j+1].red + dyn_data[chunk][i+1][j-1].red + dyn_data[chunk][i+1][j].red + dyn_data[chunk][i+1][j+1].red;
                    gSum = dyn_data[chunk][i][j].green + dyn_data[chunk][i][j-1].green + dyn_data[chunk][i][j+1].green + dyn_data[chunk][i-1][j-1].green + dyn_data[chunk][i-1][j].green + dyn_data[chunk][i-1][j+1].green + dyn_data[chunk][i+1][j-1].green + dyn_data[chunk][i+1][j].green + dyn_data[chunk][i+1][j+1].green;
                    bSum = dyn_data[chunk][i][j].blue + dyn_data[chunk][i][j-1].blue + dyn_data[chunk][i][j+1].blue + dyn_data[chunk][i-1][j-1].blue + dyn_data[chunk][i-1][j].blue + dyn_data[chunk][i-1][j+1].blue + dyn_data[chunk][i+1][j-1].blue + dyn_data[chunk][i+1][j].blue + dyn_data[chunk][i+1][j+1].blue;
                    update_pixel_blur(dyn_data[chunk],i,j,rSum,gSum,bSum,neighbors);
                }
            }
        }
    }

    pthread_exit(0);
}

void* box_blur_ultra_runner(void* data) {
    int chunk = (int) data;
    printf("Chunk #%d\n", chunk);

    box_blur(chunks[chunk].colStart, chunks[chunk].colEnd);
    pthread_exit(0);
}

void* swiss_cheese_ultra_runner(void* data) {
    int chunk = (int) data;
    swiss_cheese(chunks[chunk].colStart, chunks[chunk].colEnd);
    pthread_exit(0);
}

void write_output_file(char* output) {
    FILE *copy = fopen(output, "wb");
    writeBMPHeader(copy, header);
    writeDIBHeader(copy, headerDIB);
    writePixelsBMP(copy, (struct Pixel**)p_array, headerDIB->width, headerDIB->height);
    fclose(copy);
}

void blur_opt() {
    pthread_t *tids = (pthread_t *) malloc(sizeof(pthread_t) * GLOBAL_THREAD_COUNT);
    for (int i = 0; i < GLOBAL_THREAD_COUNT; i++) {
        pthread_create(&tids[i], NULL, box_blur_ultra_runner, i);
    }
    for (int i = 0; i < GLOBAL_THREAD_COUNT; i++) {
        pthread_join(tids[i], NULL);
    }
}

void cheese_opt() {
    pthread_t *tiCheese = (pthread_t *) malloc(sizeof(pthread_t) * GLOBAL_THREAD_COUNT);
    for (int i = 0; i < GLOBAL_THREAD_COUNT; i++) {
        pthread_create(&tiCheese[i], NULL, swiss_cheese_ultra_runner, i);
    }

    for (int i = 0; i < GLOBAL_THREAD_COUNT; i++) {
        pthread_join(tiCheese[i], NULL);
    }
}

void main(int argc, char* argv[]) {
    int option;
    char *input;
    char *output;
    char *filter;
    while( (option = getopt(argc, argv, ":i:o:f:")) != -1) {
        switch(option) {
            case 'i':
                input = optarg;
                break;
            case 'o':
                output = optarg;
                break;
            case 'f':
                filter = optarg;
                break;
            case '?':
                fprintf(stderr, "Unknown option -%c.\n", optopt);
                break;
            default:
                printf(stderr, "getopt");
        }
    }

    read_input_file(input);
    create_random_points();
    assignData();
    split();

    printf("%s", filter);

    if(filter[0] == 'b') {
        blur_opt();
    } else if (filter[0] == 'c') {
        cheese_opt();
    }

    write_output_file(output);

}