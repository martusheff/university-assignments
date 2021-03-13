/**
* CSE240 Homework 1 Question 3*
* Completion time : ~ 60 minutes. *
* @AndronickMartusheff
* @v03.13.2021
*/

#include <stdio.h>

main() {

  char ch;
  int a = 10, b = 20;
  double f;
  ch = '+';
  printf("ch = %c\n", ch);
  switch (ch) {
    case '+':
      f = a + b;
      printf("f = %f\n", f);
      break;
    case '-':
      f = a - b;
      printf("f = %f\n", f);
      break;
    case '*':
      f = a * b;
      printf("f = %f\n", f);
      break;
    case '/':
      f = a / b;
      printf("f = %f\n", f);
      break;
    default: printf("invalid operator\n");
  }

  ch = '-';
  printf("ch = %c\n", ch);
  switch (ch) {
    case '+':
      f = a + b;
      printf("f = %f\n", f);
      break;
    case '-':
      f = a - b;
      printf("f = %f\n", f);
      break;
    case '*':
      f = a * b;
      printf("f = %f\n", f);
      break;
    case '/':
      f = a / b;
      printf("f = %f\n", f);
      break;
    default: printf("invalid operator\n");
  }

  ch = '*';
  printf("ch = %c\n", ch);
  switch (ch) {
    case '+':
      f = a + b;
      printf("f = %f\n", f);
      break;
    case '-':
      f = a - b;
      printf("f = %f\n", f);
      break;
    case '*':
      f = a * b;
      printf("f = %f\n", f);
      break;
    case '/':
      f = a / b;
      printf("f = %f\n", f);
      break;
    default: printf("invalid operator\n");
  }

  ch = '/';
  printf("ch = %c\n", ch);
  switch (ch) {
    case '+':
      f = a + b;
      printf("f = %f\n", f);
      break;
    case '-':
      f = a - b;
      printf("f = %f\n", f);
      break;
    case '*':
      f = a * b;
      printf("f = %f\n", f);
      break;
    case '/':
      f = (float)a / (float)b;
      printf("f = %f\n", f);
      break;
    default: printf("invalid operator\n");
  }

  ch = '%';
  printf("ch = %c\n", ch);
  switch (ch) {
      case '+':
        f = a + b;
        printf("f = %f\n", f);
        break;
      case '-':
        f = a - b;
        printf("f = %f\n", f);
        break;
      case '*':
        f = a * b;
        printf("f = %f\n", f);
        break;
      case '/':
        f = a / b;
        printf("f = %f\n", f);
        break;
      default: printf("invalid operator\n");
  }
  return 0;
}