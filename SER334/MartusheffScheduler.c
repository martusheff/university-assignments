/**
* Course Schedule Log/Tracker Implemented in C
* Supports storing & reading data.
*
* Completion time: about 10h 30m
*
* @author Andronick Martusheff, Acuna
* @version v01.13.2022
*/

////////////////////////////////////////////////////////////////////////////////
//INCLUDES
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

////////////////////////////////////////////////////////////////////////////////
//MACROS: CONSTANTS
#define MAX_LEN 1024

////////////////////////////////////////////////////////////////////////////////
//DATA STRUCTURES
typedef enum Subject {
    SER = 0, EGR = 1, CSE = 2, EEE = 3
} Subject;

typedef struct CourseNode {
    int credits;
    int number;
    Subject subject;
    char teacher[MAX_LEN];
    struct CourseNode* prev;
    struct CourseNode* next;
} CourseNode;

////////////////////////////////////////////////////////////////////////////////
//GLOBAL VARIABLES
CourseNode* course_collection;

////////////////////////////////////////////////////////////////////////////////
//FORWARD DECLARATIONS
void branching(char option);
void course_insert();
void schedule_print();
void schedule_save();
void schedule_load();
void course_drop();
void add_node(CourseNode *new);
void free_memory_on_quit();
void sorted_add(CourseNode* head, CourseNode* new);
void update_head();
int convert_subject_to_raw_value(char subject[MAX_LEN]);
int get_total_credits();
int already_enrolled(CourseNode *new);

void branching(char option) {
    switch (option) {
        case 'a':
            course_insert();
            break;
        case 'd':
            course_drop();
            break;
        case 's':
            schedule_print();
            break;
        case 'q':
            // main loop will take care of this.
            break;
        default:
            printf("\nError: Invalid Input.  Please try again...");
            break;
    }
}

void course_insert() {
    CourseNode *new;
    new = malloc(sizeof(CourseNode));
    printf("\nWhat is the subject (SER=0, EGR=1, CSE=2, EEE=3)?\n-----> ");
    scanf("%u", &new->subject);
    printf("\nWhat is the number (e.g. 334)?\n-----> ");
    scanf("%d", &new->number);
    printf("\nHow many credits is the class (e.g. 3)?\n-----> ");
    scanf("%d", &new->credits);
    printf("\nWhat is the name of the teacher (e.g. Acuna)?\n-----> ");
    scanf("%s", new->teacher);
    new->next = NULL;
    new->prev = NULL;
    sorted_add(course_collection, new);
}

void course_drop() {
    char *courseToDrop = malloc(MAX_LEN * sizeof(char));
    int numberToDrop, courseRawValue;
    printf("\nWhat is the subject?\n");
    scanf("%s", courseToDrop);
    printf("\nEnter number:\n");
    scanf("%d", &numberToDrop);
    courseRawValue = convert_subject_to_raw_value(courseToDrop);
    CourseNode *ptr = course_collection;
    int courseDropped = 0;
    while(ptr != NULL) {
        if(ptr->subject == courseRawValue && ptr->number == numberToDrop) {
            if(ptr->prev == NULL) { // If it is the first node...
                CourseNode *temp;
                temp = course_collection;
                course_collection = ptr->next;
                free(temp);
                courseDropped++;
                printf("\nCOURSE DROPPED\n");
            } else {
                CourseNode *temp;

                temp = ptr->prev->next;
                ptr->prev->next = ptr->next;
                free(temp);
                courseDropped ++;
                printf("\nCOURSE DROPPED\n");
            }
        }
        ptr = ptr->next;
    }
    if(courseDropped == 0) {
        printf("\nYou are not enrolled in that class.\n");
    }
    free(courseToDrop);
}

int convert_subject_to_raw_value(char subject[MAX_LEN]) {
    if (strcmp(subject, "SER") == 0) {
        return 0;
    } else if (strcmp(subject, "EGR") == 0) {
        return 1;
    } else if (strcmp(subject, "CSE") == 0) {
        return 2;
    } else if (strcmp(subject, "EEE") == 0) {
        return 3;
    } else {
        return -1;
    }
}

void schedule_print() {
    printf("\nClass Schedule:\n");
    CourseNode *temp = course_collection;
    if (course_collection == NULL) {
        printf("You are not enrolled in any courses.\n");
    } else {

        while (temp != NULL) {
            switch (temp->subject) {
                case SER:
                    printf("SER");
                    break;
                case EGR:
                    printf("EGR");
                    break;
                case CSE:
                    printf("CSE");
                    break;
                case EEE:
                    printf("EEE");
                    break;
                default:
                    printf("ERROR: Something went wrong reading your course subject.");
                    break;
            }
            printf("%d ", temp->number);
            printf("%d ", temp->credits);
            printf("%s", temp->teacher);
            temp = temp->next;
        }
    }
}

void schedule_load() {
    if( access( "schedule.txt", F_OK) == 0) {
        char *line = malloc(MAX_LEN * sizeof (char));
        FILE *fp;
        fp = fopen("schedule.txt", "r");
        while (fgets(line, MAX_LEN, fp) != NULL) {
            if (strcmp(line, "\n") == 0 || strcmp(line, "\r\n") == 0) {
                // DO NOTHING
            } else {
                CourseNode *new = malloc(sizeof(CourseNode));
                new->subject = atoi((strtok(line, " ")));
                new->number = atoi((strtok(NULL, " ")));
                new->credits = atoi((strtok(NULL, " ")));
                strcpy(new->teacher, strtok(NULL, " "));
                sorted_add(course_collection, new);
                //add_node(new);
            }
        }
        free(line);
        fclose(fp);
    } else {
        printf("Creating data file 'schedule.txt'...");
    }
}

void schedule_save() {
    if(course_collection == NULL) {
        FILE *fp;
        fp = fopen("schedule.txt", "w");
        fprintf(fp, "\n");
        fclose(fp);
    } else {
        FILE *fp;
        fp = fopen("schedule.txt", "w");
        CourseNode *ptr = course_collection;
        while (ptr != NULL) {
            fprintf(fp, "%d %d %d %s\n", ptr->subject, ptr->number, ptr->credits, ptr->teacher);
            ptr = ptr->next;
        }
        fclose(fp);
    }
}

int get_total_credits() {
    CourseNode *temp = course_collection;
    int sum = 0;

    while(temp != NULL) {
        sum += temp->credits;
        temp = temp->next;
    }
    if(sum < 0 || sum > 1000) {
        printf("\nREMINDER: Maximum Credits Allowed PER TERM is 24!");
        return 0;
    }
    return sum;
}

void update_head() {
    CourseNode *ptr = course_collection;
    while(ptr != NULL && ptr->prev != NULL) {
        ptr = ptr->prev;
    }
    course_collection = ptr;
}

void sorted_add(CourseNode* head, CourseNode* new)
{
    // Assumes List is Already Sorted.
    // List should always be sorted since it's created by program that sorts it by default.

    update_head();
    if(already_enrolled(new) == 0) {
        if (course_collection == NULL) {
            course_collection = new;
            return;
        }
        if (head == NULL || head->number >= new->number) {
            new->next = head;
            head->prev = new;
            new->prev = NULL;
            update_head();
            return;
        }
        // locate the node before the point of insertion
        CourseNode *ptr = course_collection;
        while (ptr->next != NULL && ptr->next->number < new->number) {
            ptr = ptr->next;
        }
        new->next = ptr->next;
        new->prev = ptr;
        ptr->next = new;
        update_head();
    } else {
        printf("You are already enrolled in this course!");
    }
}

int already_enrolled(CourseNode *new) {
    CourseNode *temp = course_collection;
    while(temp != NULL) {
        if(new->subject == temp->subject && new->number == temp->number) {
            free(new);
            return 1;
        }
        temp = temp->next;
    }
    return 0;
}

void free_memory_on_quit() {
    CourseNode *ptr;
    while(course_collection != NULL) {
        ptr = course_collection;
        course_collection = course_collection->next;
        free(ptr);
    }
}

int main() {
    char input_buffer;
    printf("\n\nWelcome to ASU Class Schedule\n");

    // Load Data ('schedule.txt')
    schedule_load();

    do {
        printf("\n\nMenu Options\n");
        printf("------------------------------------------------------\n");
        printf("a: Add a class\n");
        printf("d: Drop a class\n");
        printf("s: Show your classes\n");
        printf("q: Quit\n");
        printf("\nTotal Credits: %d\n\n", get_total_credits());
        printf("Please enter a choice ---> ");
        scanf(" %c", &input_buffer);
        branching(input_buffer);
    } while (input_buffer != 'q');

    // Save Data ('schedule.txt')
    schedule_save();
    // Free memory on quit.
    free_memory_on_quit();

    return 0;
}
