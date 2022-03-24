/**
* SJF & SJF Live Scheduling Implementation
*
* Completion time: 5.5hrs
*
* @author Martusheff, Acuna
* @version v02.16.2022
*/

#include <stdio.h>
#include <stdlib.h>

int num_ticks;
int num_processes;
int** process;
int** completion_time;
int** process_copy;

void load_data(char* file_input) {
    FILE* file;
    file = fopen(file_input, "r");
    fscanf(file, "%d", &num_ticks);
    fscanf(file, "%d", &num_processes);
    // Dynamic Memory Allocation
    int *tau_list = malloc(num_processes * sizeof (int));
    float *alpha_list = malloc(num_processes * sizeof (float));
    process = malloc(num_processes * sizeof (int*));
    for(int i = 0; i < num_processes; i++) {
        process[i] = malloc(num_ticks * sizeof(int));
    }
    completion_time = malloc(num_processes * sizeof(int*));
    for(int i = 0; i < num_processes; i++) {
        completion_time[i] = malloc(num_ticks * sizeof (int));
    }
    int process_num = 0;
    for(int i = 0; i < num_processes; i++) {
        int tau;
        float alpha;
        fscanf(file, "%d", &process_num);
        fscanf(file, "%d", &tau);
        fscanf(file, "%f", &alpha);
        tau_list[i] = tau;
        alpha_list[i] = alpha;
        for(int j = 0; j < num_ticks; j++) {
            int process_time;
            fscanf(file, "%d", &process_time);
            process[i][j] = process_time;
            completion_time[i][j] = j == 0 ? tau : alpha * process[i][j-1] + ((1 - alpha) * completion_time[i][j-1]);
        }
    }
    fclose(file);
}

void populate_copy() {
    // Create Copy
    process_copy = malloc(num_processes * sizeof (int*));
    for(int i = 0; i < num_processes; i++) {
        process_copy[i] = malloc(num_ticks * sizeof(int));
    }
    for(int i = 0; i < num_processes; i++) {
        for(int j = 0; j < num_ticks; j++) {
            process_copy[i][j] = process[i][j];
        }
    }
}

void sjf() {
    int total_time = 0;
    int waiting_time = 0;
    int turnaround_time = 0;
    int* current_process = (int *) malloc(num_processes * sizeof(int));
    int* process_number = (int *) malloc(num_processes * sizeof(int));

    printf("==Shortest-Job-First==\n");
    for(int i = 0; i < num_ticks; i++) {
        int time = 0;
        printf("Simulating %dth tick of process @ time %d:\n", i, total_time);
        for(int j = 0; j < num_processes; j++) {
            int s = 12345678;
            int s_id = 0;
            for(int k = 0; k < num_processes; k++) {
                if (s > process[k][i]) {
                    s = process[k][i];
                    s_id = k;
                }
            }
            current_process[j] = s;
            process_number[j] = s_id;
            process[s_id][i] = 12345678;
        }
        for(int w = 0; w < num_processes; w++) {
            printf("   Process %d took %d.\n", process_number[w], current_process[w]);
            turnaround_time += time + current_process[w];
            total_time += current_process[w];
            waiting_time += time;
            time += current_process[w];
        }
    }
    printf("Turnaround time: %d\n", turnaround_time);
    printf("Waiting time: %d\n", waiting_time);
}

void sjf_live() {
    int total_time = 0;
    int waiting_time = 0;
    int turnaround_time = 0;
    int error_estimate = 0;
    int* current_process = (int *) malloc(num_processes * sizeof(int));
    int* process_number = (int *) malloc(num_processes * sizeof(int));
    for(int i = 0; i < num_ticks; i++) {
        int time = 0;
        printf("Simulating %dth tick of process @ time %d:\n", i, total_time);
        for(int j = 0; j < num_processes; j++) {
            int s = 12345678;
            int s_id = 0;
            for(int k = 0; k < num_processes; k++) {
                if(s > process_copy[k][i]) {
                    s = process_copy[k][i];
                    s_id = k;
                }
            }
            current_process[j] = s;
            process_number[j] = s_id;
            process_copy[s_id][i] = 12345678;
        }

        for(int w = 0; w < num_processes; w++) {
            int error = 0;
            printf("   Process %d was estimated for %d and took %d.\n", process_number[w], current_process[w], process_copy[process_number[w]][i]);
            error = process_copy[process_number[w]][i] > current_process[w] ? process[process_number[w]][i] - current_process[w] :
                    current_process[w] - process_copy[process_number[w]][i];
            turnaround_time += time + process_copy[process_number[w]][i];
            total_time += process_copy[process_number[w]][i];
            waiting_time += time;
            time += process_copy[process_number[w]][i];
            error_estimate += error;
        }


    }
    printf("Turnaround time: %d \n", turnaround_time);
    printf("Waiting time: %d \n", waiting_time);
    printf("Estimation Error: %d\n", error_estimate);
}

int main(int argc, char *argv[]) {

    load_data(argv[1]); // Load Date from Input
    sjf(); // Run Shortest Job First
    populate_copy(); // Create Copy
    sjf_live(); // Run on copy for Live

    return 0;
}