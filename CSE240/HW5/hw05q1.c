/**
* CSE240 Homework 5 Question 1*
* Completion time : 2 Hours *
* @AndronickMartusheff
* @v03.24.2021
*/

// CSE240 
// Be sure to add the standard header above.
// Write the compiler used: Visual Studio

// READ BEFORE YOU START:
// You are given a partially completed program that creates a linked list of patient records.
// Each record(struct) has this information: student's name, major, school year of student, ID number.
// The struct 'studentRecord' holds information of one student. School year is enum type.
// A linked list called 'list' is made to hold the list of students.
// To begin, you should trace through the given code and understand how it works.
// Please read the instructions above each required function and follow the directions carefully.
// You should not modify any of the given code, the return types, or the parameters, you risk getting compile error.
// You are not allowed to modify main ().
// You can use string library functions.
// ***** WRITE COMMENTS FOR IMPORANT STEPS OF YOUR CODE. *****
// ***** GIVE MEANINGFUL NAMES TO VARIABLES. *****


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#pragma warning(disable: 4996) // for Visual Studio Only

#define MAX_NAME_LENGTH 25

typedef enum { freshman = 0, sophomore, junior, senior } schoolYearType; // enum type 

struct studentRecord {
	char studentName[MAX_NAME_LENGTH];
	char major[MAX_NAME_LENGTH];
	schoolYearType schoolYear;
	unsigned int IDNumber;
	struct studentRecord* next;	// pointer to next node
} *list = NULL;					// Declare linked list 'list'

// forward declaration of functions (already implmented)
void flushStdIn();
void executeAction(char);

// functions that need implementation:
int addSort(char* studentName_input, char* major_input, char* schoolYear_input, unsigned int IDNumber_input); // 20 points
void displayList();						// 10 points
int countNodes();						// 5 points
int deleteNode(char* studentName_input);	// 10 points
void swapNodes(struct studentRecord* node1, struct studentRecord* node2);	// 5 points
						


int main()
{	
	char selection = 'i';		// initialized to a dummy value
	printf("\nCSE240 HW6\n");
	do
	{
		printf("\nCurrently %d student(s) on the list.", countNodes());	// NOTE: countNodes() called here
		printf("\nEnter your selection:\n");
		printf("\t a: add a new student\n");
		printf("\t d: display student list\n");
		printf("\t r: remove a student from the list\n");
		printf("\t q: quit\n");
		selection = getchar();
		flushStdIn();
		executeAction(selection);
	} while (selection != 'q');

	return 0;
}

// flush out leftover '\n' characters
void flushStdIn()
{
	char c;
	do c = getchar(); 
	while (c != '\n' && c != EOF);
}

// Ask for details from user for the given selection and perform that action
// Read the code in the function, case by case
void executeAction(char c)
{
	char studentName_input[MAX_NAME_LENGTH], major_input[MAX_NAME_LENGTH];
	unsigned int IDNumber_input, result = 0;
	char schoolYear_input[20];
	switch (c)
	{
	case 'a':	// add student
		// input student details from user
		printf("\nEnter student name: ");
		fgets(studentName_input, sizeof(studentName_input), stdin);
		studentName_input[strlen(studentName_input) - 1] = '\0';	// discard the trailing '\n' char
		printf("Enter major: ");
		fgets(major_input, sizeof(major_input), stdin);
		major_input[strlen(major_input) - 1] = '\0';	// discard the trailing '\n' char

		printf("Enter whether student is 'freshman' or 'sophomore' or 'junior' or 'senior': ");
		fgets(schoolYear_input, sizeof(schoolYear_input), stdin);
		schoolYear_input[strlen(schoolYear_input) - 1] = '\0';	// discard the trailing '\n' char
		printf("Please enter ID number: ");
		scanf("%d", &IDNumber_input);
		flushStdIn();

		// add the student to the list
		result = addSort(studentName_input, major_input, schoolYear_input, IDNumber_input);
		if (result == 0)
			printf("\nStudent is already on the list! \n\n");
		else if (result == 1)
			printf("\nStudent successfully added to the list! \n\n");
		
		break;

	case 'd':		// display the list
		displayList();
		break;

	case 'r':		// remove a student
		printf("\nPlease enter student name: ");
		fgets(studentName_input, sizeof(studentName_input), stdin);
		studentName_input[strlen(studentName_input) - 1] = '\0';	// discard the trailing '\n' char

		// delete the node
		result = deleteNode(studentName_input);
		if (result == 0)
			printf("\nStudent does not exist! \n\n");
		else if (result == 1)
			printf("\nStudent successfully removed from the list. \n\n");
		else
			printf("\nList is empty! \n\n");
		break;

	case 'q':		// quit
		break;
	default: printf("%c is invalid input!\n",c);
	}
}

// Q1 : addSort 
// This function is used to insert a new student into the list. You can insert the new student to the end of the linked list.
// Do not allow the student to be added to the list if that student already exists in the list. You can do that by checking the names of the students already in the list.
// If the student already exists then return 0 without adding student to the list. If the student does not exist in the list then go on to add the student at the end of the list and return 1.
// NOTE: You must convert the string 'schoolYear_input' to an enum type and store it in the list because the struct has enum type for school year.
// Sorting should happen within the list. That is, you should not create a new linked list of students having sorted students.
// Hint: One of the string library function can be useful to implement this function because the sorting needs to happen by student name which is a string.
//       Use swapNodes() to swap the nodes in the sorting logic

int addSort(char* studentName_input, char* major_input, char* schoolYear_input, unsigned int IDNumber_input) {// 20 points

	struct studentRecord* tempList = list;	// work on a copy of 'list'
	struct studentRecord* prevNode = NULL; // student node previous to student

	// enter code here
	while(tempList != NULL) { // until tempList points to NULL (no node)...
		if(strcmp(tempList->studentName, studentName_input) == 0) //if cur. nodes "studentName" value is == to inputted name then..
			return 0; // return 0 to main call (indicating that student is already in the list)
		else if(strcmp(tempList->studentName, studentName_input) > 0) // else if diff between strings > 0, student is to be inserted before
			break; 
		prevNode = tempList; // positions one node back
		tempList = tempList->next; // temp list is set to the next node in temp list 
	}

	// creating new student record with struct and storing it to node
	struct studentRecord* node = (struct studentRecord*)malloc(sizeof(struct studentRecord)); //allocates memory
	strcpy(node->studentName,studentName_input); // sets name of current student in node
	strcpy(node->major, major_input); // sets major

	if(strcmp(schoolYear_input, "freshman") == 0) // converts string to value to fit assignment (school year)
		node->schoolYear = freshman;
	else if(strcmp(schoolYear_input, "sophomore") == 0)
		node->schoolYear = sophomore;
	else if(strcmp(schoolYear_input, "junior") == 0)
		node->schoolYear = junior;
	else
		node->schoolYear = senior;

	node->IDNumber = IDNumber_input; // id number is set to user inputted id number for student

	node->next = NULL; // sets curr node next to null to indicate an end point

	if(prevNode == NULL) { // if the previous node is null, put student is first node position
		node->next = list; // set the rest of list to come after node
		list = node; // where the new list begins with node
	} else {
		node->next = tempList; // or, set the next node to the tempList
		prevNode->next = node; // and assign the prev node next to the current node
	}

	return 1;	// return 1 to indicate student has been added to list
}
// Q2 : displayList (10 points)
// This function displays the linked list of students, with all details (struct elements). 
// Parse through the linked list and print the student details one after the other. See expected output screenshots in homework question file.
// NOTE: School year is stored in the struct as enum type. You need to display a string for school year.
void displayList()
{
	struct studentRecord* tempList = list;				// work on a copy of 'list'

	if(tempList == NULL) //if temp list has no value assigned (and only consists of a NULL value)
		printf("\nThe list is Empty.\n"); // tell the user that the list is empty.
	// enter code here

	while(tempList != NULL) { // while tempList != NULL (while the current node has data)
		printf("\nStudent Name: %s",tempList->studentName); //similar to previous HW, print name
		printf("\nStudent Major: %s\n",tempList->major); // major

		if(tempList->schoolYear == freshman) // convert struct assignment to string
			printf("School Year: Freshman");
		else if(tempList->schoolYear == sophomore)
			printf("School Year: Sophomore");
		else if(tempList->schoolYear == junior)
			printf("School Year: Junior");
		else if(tempList->schoolYear == senior)
			printf("School Year: Senior");
		else
			printf("Invalid school year was entered."); // if the case where an invalid school year is entered, inform the user
		printf("\nID Number : %d\n",tempList->IDNumber);

		tempList = tempList->next; // while (curr) is the loop, he we iterate through tempList of nodes by setting curr node to next node
	}


}

// Q3: countNodes (5 points)
// This function counts the number of students on the linked list and returns the number.
// You may use this function in other functions like deleteNode(), sortList(), addNode(), if needed. 
// It can helpful to call this function in other functions, but not necessary.
// This function is called in main() to display number of students along with the user menu.
int countNodes()
{
	struct studentRecord *tempList = list; // list to count from
	int i = 0; // iterable

	while(tempList != NULL) { // while tempList has "data"... (an empty list will close out and return i where i = 0)
		i++; // increment i (update node count)
		tempList = tempList->next; // continue to next node to check again
	}
	return i;	// return counted nodes
}

// Q4 : deleteNode (10 points)
// This function deletes the node specified by the student name.
// Parse through the linked list and remove the node containing this student name.
// NOTE: After you remove the node, make sure that your linked list is not broken.
// (Hint: Visualize the list as: list......-> node1 -> node_to_remove -> node2 -> ...end. 
//        After removing "node_to_remove", the list is broken into "list ....node1" and "node2.... end". Stitch these lists.)

int deleteNode(char* studentName_input)
{	
	struct studentRecord* tempList = list->next;				// work on a copy of 'list'
	struct studentRecord* prevNode = NULL; 

	while(tempList != NULL) { // while temp list has "data"
		if(strcmp(tempList->studentName,studentName_input) == 0) { // if studentName_input has a match
			if(prevNode == NULL) // if curr node is first node (because previous node contains no data)
				list = list->next; 
			else // if node isnt the first node
				prevNode->next = tempList->next;
				free(tempList); // delete node

			return 1;
		}
		prevNode = tempList; // set previous node to tempList
		tempList = tempList->next; //set tempList to next value for next check
	}

	
	return 0;			// student is not in list
}


// Q5 : swapNodes (5 points)
// This function swaps the elements of parameters 'node1' and 'node2' (Here node1 does NOT mean 1st node of the list. 'node1' is just the name of the node)
// This function should not alter the 'next' element of the nodes. Only then will the nodes be swapped.
// Hint: The swap logic is similar to swapping two simple integer/string variables.
// NOTE: This function can be used in the sorting logic in addSort()

void swapNodes(struct studentRecord* node1, struct studentRecord* node2)
{
	 struct studentRecord *temp = node1->next; // node swap method
	 node1->next = node2->next; //node1s next pointer points to node2s next
	 node2->next = temp; //node2s next points to temp
}


