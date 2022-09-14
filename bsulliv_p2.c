#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main(void) {
	char filename1[30];
	char filename2[30];
	char filename3[30];
	puts("enter the first input filename:");
	scanf("%s", filename1);
	puts("\n\nenter the second input filename:");
	scanf("%s", filename2);
	puts("\n\nenter the output filename:");
	scanf("%s", filename3);

	FILE* fptr1;
	fptr1 = fopen(filename1, "r");

	FILE* fptr2;
	fptr2 = fopen(filename2, "r");

	int rows1 = 0;
	int rows2 = 0;
	int columns1 = 0;
	int columns2 = 0;
	bool hasNext = true;
	int next = 0;

	while (hasNext == true) {
		scanf("%d", &next);
		//see if it is a newline character
		if (next == 10) {

		}
	}



}