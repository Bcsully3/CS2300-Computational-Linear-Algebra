
#include <stdlib.h>
#include <stdio.h>

int main(void) {

	int Mat1[7][8];
	int Mat2[8][7];
	double Mat3[8][7];
	int Mat4[9][11];
	double Mat5[9][11];

	//MAT1
	int i = 0;
	int j = 0;
	double number = 1; 
	FILE* fptr;
	fptr = fopen("bsullivan_mat1.txt", "w");

	puts("Mat1:");
	for (i = 0; i < 7; i++) {
		puts("\n");
		fprintf(fptr, "\n");
		for (j = 0; j < 8; j++) {
			Mat1[i][j] = number;
			number++;
			printf("%d ", Mat1[i][j]);
			fprintf(fptr, "%d ", Mat1[i][j]); //write to file
		}
	}
	fclose(fptr);



	//MAT2
	number = 4;
	FILE* fptr2;
	fptr2 = fopen("bsullivan_mat2.txt", "w");

	puts("\n\n\n\n\nMat2:");
	for (i = 0; i < 8; i++) {
		puts("\n");
		fprintf(fptr2, "\n");
		for (j = 0; j < 7; j++) {
			Mat2[i][j] = number;
			number = number + 2;
			printf("%d ", Mat2[i][j]);
			fprintf(fptr2, "%d ", Mat2[i][j]); //write to file
		}
	}
	fclose(fptr2);


	//MAT3
	number = 0.3;
	FILE* fptr3;
	fptr3 = fopen("bsullivan_mat3.txt", "w");

	for (i = 0; i < 7; i++) {
		for (j = 0; j < 8; j++) {
			Mat3[i][j] = number;
			number = number + 0.1;
			
		}
	}
		//print MAT3
		puts("\n\n\n\n\nMat3:");
		for (j = 0; j < 8; j++) {
			puts("\n");
			fprintf(fptr3, "\n");
			for (i = 0; i < 7; i++) {
				printf("%.1lf ", Mat3[i][j]);
				fprintf(fptr3, "%.1lf ", Mat3[i][j]); //write to file

			}
		}
	fclose(fptr3);


	//MAT4
	number = 3;
	FILE* fptr4;
	fptr4 = fopen("bsullivan_mat4.txt", "w");

	puts("\n\n\n\n\nMat4:");
	for (i = 0; i < 9; i++) {
		puts("\n");
		fprintf(fptr4, "\n");
		for (j = 0; j < 11; j++) {
			Mat4[i][j] = number;
			number = number + 3;
			printf("%d ", Mat4[i][j]);
			fprintf(fptr4, "%d ", Mat4[i][j]); //write to file
		}
	}
	fclose(fptr4);



	//MAT5
	number = -5.0;
	FILE* fptr5;
	fptr5 = fopen("bsullivan_mat5.txt", "w");

	for (i = 0; i < 11; i++) {
		for (j = 0; j < 9; j++) {
			Mat5[j][i] = number;
			number = number + 1.5;

		}
	}
		//print MAT5
		puts("\n\n\n\n\nMat5:");
		for (j = 0; j < 9; j++) {
			puts("\n");
			fprintf(fptr5, "\n");
			for (i = 0; i < 11; i++) {
				printf("%.1lf ", Mat5[j][i]);
				fprintf(fptr5, "%.1lf ", Mat5[j][i]); //write to file

			}
		}
	fclose(fptr5);



}//main
