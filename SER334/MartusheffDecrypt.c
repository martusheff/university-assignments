/**
* A simple C program to decrypt a 2D array of ASCII adjusted chars.
*
* Completion time: 1h 15m
*
* @author Andronick Martusheff, Acuna (SER334 Base File)
* @version v01.10.22
*/

////////////////////////////////////////////////////////////////////////////////

//INCLUDES
#include <stdio.h>
#include <string.h>

//CONSTANTS
#define CHUNK_LENGTH (20+1)  //each chunk has twenty characters, we add 1 so
                           //there is space for the null terminator.
#define NUMBER_OF_CHUNKS 4 //the message is spread across 4 chunks.
#define DECRYPTION_SHIFT 5 //this is the ASCII table shift used for decryption.

//FORWARD DECLARATIONS
void sort_chunks();
void decrypt_chunks();
void display_chunks();

char chunks[NUMBER_OF_CHUNKS][CHUNK_LENGTH];

int main() {
	//copy message into memory.
	strcpy(chunks[0], "2i1%fsi%fs%jstwrtzx%");
	strcpy(chunks[1], "1'H%nx%vznwp~1%kqf|j");
	strcpy(chunks[2], "4R3%Wnyhmnj%%%%%%%%%");
	strcpy(chunks[3], "3xzhhjxx3'%2%Ijssnx%");

	sort_chunks();
    decrypt_chunks();
	display_chunks();

	return 0; 
}

// Given swap strings helper method for selection sort.
void swap_strings(char* x, char* y) {
	// Temporary variable so as to not lose our data.
	char temp[CHUNK_LENGTH];

	strcpy(temp, x);
	strcpy(x, y);
	strcpy(y, temp);
}

// Sorting 2D array w/ Selection Sort (using provided 'swap_strings' method)
void sort_chunks() {
    for(int i = 0; i < NUMBER_OF_CHUNKS - 1; i++) {
        int min_pos = i;
        for(int j = i + 1; j < NUMBER_OF_CHUNKS; j++) {
            if(chunks[j][0] < chunks[min_pos][0]) {
                min_pos = j;
            }
        }
        if( min_pos != i) {
            swap_strings(chunks[i], chunks[min_pos]);
        }
    }
}

// Decryption method simply shifts every ASCII value in 'chunks' with a given offset.
void decrypt_chunks() {
    for(int i = 0; i < NUMBER_OF_CHUNKS; i++) {
        for(int j = 0; j < CHUNK_LENGTH; j++) {
            chunks[i][j] -= DECRYPTION_SHIFT; // Subtracting decryption shift here.
        }
    }
}

// Iteratively displays the contents 'chunks' to show our decrypted message.
void display_chunks() {
    for(int i = 0; i < NUMBER_OF_CHUNKS - 1; i++) {
        for(int j = 0; j < CHUNK_LENGTH - 1; j++) {
            // Ignoring 0th index (used for positioning, sorting)
            if(j != 0) {
                printf("%c", chunks[i][j]);
            }
        }
    }
    printf("\n");
}
