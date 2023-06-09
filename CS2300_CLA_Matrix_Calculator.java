import java.io.File;
import java.util.Scanner;
import java.io.IOException;


public class CS2300CLA_Project3 {

	public static void main(String[] args) throws IOException {
		
		//////////////////////////////  PART 1  ///////////////////////////////
		
		File file = new File("test_input_1 - Copy.txt");
		Scanner fileScanner = new Scanner (file);
		
		int i = 0;
		float[] fileValues = new float[6];
		while (fileScanner.hasNext()) {
			fileValues[i] = fileScanner.nextInt();
			i++;
		}
		float MatrixA [] =  {fileValues[0],fileValues[1],fileValues[3],fileValues[4]};
		float VectorB [] = {fileValues[2],fileValues[5]};
		
		if (((MatrixA[0]*MatrixA[3]) - (MatrixA[1]*MatrixA[2])) == 0) {
			System.out.println("System is Inconsistent");
		}
		else {
			float p = (MatrixA[0]*MatrixA[3]);
			float j = MatrixA[1]*MatrixA[2];
			float k = p-j;
			float x = 1 / k ;
			double InverseA [] = {MatrixA[3]*x, -MatrixA[1]*x, -MatrixA[2]*x, MatrixA[0]*x};
			double X1 = (InverseA[0]*VectorB[0]) + (InverseA[1]*VectorB[1]);
			double X2 = (InverseA[2]*VectorB[0]) + (InverseA[3]*VectorB[1]);

			double VectorX [] = {X1,X2};
			System.out.printf("%1.3f %1.3f",VectorX[0], VectorX[1]);
			
		}
		
		
		/////////////  PART 2 //////////////////////
		float a = 1;
		float b = -(MatrixA[0] + MatrixA[3]);
		float c = (MatrixA[0] * MatrixA[3]) - (MatrixA[1] * MatrixA[2]);
		
		float ev1 = (float) ((-b + Math.sqrt(b*b - 4*a*c)) / (2*a));
		float ev2 = (float) ((-b - Math.sqrt(b*b - 4*a*c)) / (2*a));
		
		System.out.printf("\nEigenValues:\n%1.3f  0\n0 %10.3f", ev1, ev2);   /////print out eigenvalues///////////
		float EigenValues [] = {ev2,0,0,ev1};
		
		/////////////////////   r1   /////////////////
		float r12 = 0;
		boolean pivot1 = false;

		float eVector1 [] = {MatrixA[0] - ev1, MatrixA[1], MatrixA[2], MatrixA[3] - ev1};
		System.out.printf("\n\n%1.3f %1.3f\n%1.3f %1.3f", eVector1[0], eVector1[1], eVector1[2], eVector1[3]);
		if ((eVector1[0] == eVector1[2]) && (eVector1[2] == 0)) {   //Pivoting if necessary
			float temp [] = eVector1;
			eVector1[0] = temp[1];
			eVector1[1] = temp[0];
			eVector1[2] = temp[3];
			eVector1[3] = temp[2];
			pivot1 = true;
		}
		
		float fElim1 [] = new float[4];
		
		if (eVector1[2] != 0) {   //forward elimination
			float temp = -eVector1[2] / eVector1[0];
			System.out.println("\n\ntemp: "+ temp);
			 fElim1[0] = eVector1[0] *temp;
			 fElim1[1] = eVector1[1] *temp;
			 fElim1[2] = eVector1[2] *temp;
			 fElim1[3] = eVector1[3] *temp;
			
		}
		else {
			fElim1[0] = eVector1[0] ;
			fElim1[1] = eVector1[1] ;
			fElim1[2] = eVector1[2] ;
			fElim1[3] = eVector1[3] ;		
		}
		
		if ((fElim1[2] == fElim1[3]) && (fElim1[2] == 0)) {   //if bottom two are both 0
			 r12 = 1;
		}
		else {
			 r12 = fElim1[3];
		}
		float r11 = -(fElim1[1]*r12) / (fElim1[0]);
		
		if (pivot1 == true){
			float temp2 = r12;
			r12 = r11;
			r11 = temp2;
		}
		///////////////////////////////////////////////////
		///////////////////////   r2   ////////////////////
		///////////////////////////////////////////////////
		float r22 = 0;
		boolean pivot2 = false;

		float eVector2 [] = {MatrixA[0] - ev2, MatrixA[1], MatrixA[2], MatrixA[3] - ev2};
		System.out.printf("\n\n%1.3f %1.3f\n%1.3f %1.3f", eVector2[0], eVector2[1], eVector2[2], eVector2[3]);
		if ((eVector2[0] == eVector2[2]) && (eVector2[2] == 0)) {   //Pivoting if necessary
			float temp [] = eVector2.clone();
			eVector2[0] = temp[1];
			eVector2[1] = temp[0];
			eVector2[2] = temp[3];
			eVector2[3] = temp[2];
			pivot2 = true;
		}
		
		float fElim2 [] = new float[4];
		
		if (eVector2[2] != 0) {   //forward elimination
			float temp = -eVector2[2] / eVector2[0];
			float FEMatrix [] = {1,0,temp,1};
			fElim2 = multiplyMatricies(FEMatrix, eVector2);
			
		}
		else {
			fElim2[0] = eVector2[0] ;
			fElim2[1] = eVector2[1] ;
			fElim2[2] = eVector2[2] ;
			fElim2[3] = eVector2[3] ;		}
		
		if ((fElim2[2] == fElim2[3]) && (fElim2[2] == 0)) {   //if bottom two are both 0
			 r22 = 1;
		}
		else {
			 r22 = fElim2[3];
		}
		float r21 = -(fElim2[1]*r22) / (fElim2[0]);
		
		if (pivot2 == true){
			float temp2 = r22;
			r22 = r21;
			r21 = temp2;
		}
		float norm1 = (float) Math.sqrt((r11*r11)+(r12*r12));
		float norm2 = (float) Math.sqrt((r22*r22)+(r21*r21));
		float R [] = {r21/norm2,r11/norm1,r22/norm2,r12/norm1};
		System.out.printf("\n\nR:\n%1.3f %1.3f\n%1.3f %1.3f", R[0],R[1],R[2],R[3]);
		
		
		float RTrans [] = {R[0], R[2], R[1], R[3]};
		System.out.printf("\n\nR:\n%1.3f %1.3f\n%1.3f %1.3f", RTrans[0],RTrans[1],RTrans[2],RTrans[3]);


		
		float tempp [] = multiplyMatricies(R,EigenValues);
		float Composition [] = multiplyMatricies(tempp, RTrans);
		
		System.out.printf("\n\nComposition:\n%1.3f %1.3f\n%1.3f %1.3f", Composition[0],Composition[1],Composition[2],Composition[3]);
		
		if (Composition[0] == R[0]) {
			if (Composition[1] == R[1]) {
				if (Composition[2] == R[2]) {
					if (Composition[3] == R[3]) {
						System.out.println("1");
					}
				}
			}
		}
		else {
			System.out.println("0");
		}
			
			
		////////////////    part 3 ///////////////////
		float area = area(fileValues);
		System.out.println("\n\n\n" + area);
	}//Main
	
	
	
	public static float [] multiplyMatricies(float [] M1, float [] M2) {
		float newMatrix [] = new float[4];
		newMatrix[0] = (M1[0]*M2[0]) + (M1[1]*M2[2]);
		newMatrix[1] = (M1[0]*M2[1]) + (M1[1]*M2[3]);
		newMatrix[2] = (M1[2]*M2[0]) + (M1[3]*M2[2]);
		newMatrix[3] = (M1[2]*M2[1]) + (M1[3]*M2[3]);
		
		
		return newMatrix;
		
	
	}
	
	public static float area(float[] matrix) { 
		
		
		    return (float) Math.abs((matrix[0] * (matrix[4] - matrix[5]) + matrix[1] * (matrix[5] - matrix[3]) + 
		      matrix[2] * (matrix[3] - matrix[4])) / 2.0);  
		 
			

}//Project 3
