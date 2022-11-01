#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


int createBoard(const int size);

int main(void) {
	int NTemp = 0;
	int KTemp = 0;
	FILE* fptr = fopen("p2-1.txt", "r");

	fscanf(fptr, "%d", &NTemp);
	fscanf(fptr, "%d", &KTemp);

	const int N = 5;
	const int K = KTemp;
	double gradeArray[5] = { 0 };
	char board[N][N] = {0};



	createBoard(N);

	for (int i = 0; i < N; i++) {
		for (int i = 0; i < N; i++) {
			board[N][N] = '.';
		}
	}
	int slopes[K] = {0};

}   //main


int createBoard(const int size) {
	char board[size][size]
}






