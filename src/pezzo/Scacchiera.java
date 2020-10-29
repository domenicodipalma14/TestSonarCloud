package pezzo;
import java.util.Scanner;

public class Scacchiera {
	private Pezzo mat[][] = new Pezzo [8][8];
	private Pezzo pezzi_b [] = new Pezzo[16];
	private Pezzo pezzi_n[] = new Pezzo[16];
	
	/*
	 * L'array di pezzi è formato in questo modo:
	 * 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
	 * P  P  P  P  P  P  P  P  Re R  T   T   C   C   A   A
	 * 
	 * P - pedone
	 * Re - re
	 * R - regine
	 * T - torre
	 * C - cavallo
	 * A - alfiere
	 */

	public Scacchiera() {
		//inizializzazione della scacchiera	
		
		//creo pedoni
		crea_pedoni();
		crea_re();
		crea_regina();
		crea_cavallo();
		crea_torre();
		crea_alfiere();
		
		//inserisco le torri nella scacchiera
		mat[0][0] = pezzi_b[10];
		//pezzi_b[10].
		mat[0][7] = pezzi_b[11];
		
		mat[7][0] = pezzi_n[10];
		mat[7][7] = pezzi_n[11];
		
		//inserisco alfieri nella scacchiera
		mat[0][2] = pezzi_b[14];
		mat[0][5] = pezzi_b[15];
		
		mat[7][2] = pezzi_n[14];
		mat[7][5] = pezzi_n[15];
		
		//inserisco i cavalli nella scacchiera
		mat[0][1] = pezzi_b[12];
		mat[0][6] = pezzi_b[13];
		
		mat[7][1] = pezzi_n[12];
		mat[7][6] = pezzi_n[13];
	
		
		//inserisco regine nella scacchiera
		mat[0][3] = pezzi_b[9];
		mat[7][3] = pezzi_n[9];

		//inserisco i re nella scacchiera
		mat[0][4] = pezzi_b[8];
		mat[7][4] = pezzi_n[8];
		
		//inserisco pedoni nella scacchiera
		for(int i=0; i<8; i++) mat[1][i] = pezzi_b[i];
		for(int i=0; i<8; i++) mat[6][i] = pezzi_n[i];
	}
	
	//metodi privati per creare i pezzi
	private void crea_alfiere() {
		pezzi_b[14] = new Alfiere("bianco", 0, 2);
		pezzi_b[15] = new Alfiere("bianco", 0, 5);
		
		pezzi_n[14] = new Alfiere("nero", 7, 2);
		pezzi_n[15] = new Alfiere("nero", 7, 5);
	}
	
	private void crea_torre() {
		pezzi_b[10] = new Torre("bianco", 0, 0);
		pezzi_b[11] = new Torre("bianco", 0, 7);
		
		pezzi_n[10] = new Torre("nero", 7, 0);
		pezzi_n[11] = new Torre("nero", 7, 7);
	}
	
	private void crea_cavallo() {
		pezzi_b[12] = new Cavallo("bianco", 0, 1);
		pezzi_b[13] = new Cavallo("bianco", 0, 6);
		
		pezzi_n[12] = new Cavallo("nero", 7, 1);
		pezzi_n[13] = new Cavallo("nero", 7, 6);
	}
	
	private void crea_regina() {
		pezzi_b[9] = new Regina("bianco", 0, 3);
		pezzi_n[9] = new Regina("nero", 7, 3);
	}
	private void crea_re() {
		pezzi_b[8] = new Re("bianco", 0, 4);
		pezzi_n[8] = new Re("nero", 7, 4);
	}
	private void crea_pedoni() {
		for(int i=0; i<8; i++) {
			pezzi_b[i] = new Pedone("bianco", 1, i);
			pezzi_n[i] = new Pedone("nero", 6, i);
		}
	}
	
	public void stampa() {
		for(int i=0; i<9; i++) {
			System.out.print("\n");
			for(int j=0; j<9; j++) {
				if(i == 0) {
					if(j == 0) System.out.print("   ");
					else System.out.print(" " + (j-1) + " ");
				}
				else if(j == 0) {
					
					System.out.print(" " + (i-1) + " ");
				}
				else if(mat[i-1][j-1] instanceof Pedone) System.out.print(" P " /*+ mat[i][j].check_colore() +" "*/);
				else if(mat[i-1][j-1] instanceof Re) System.out.print(" Z " /*+ mat[i][j].check_colore() +" "*/);
				else if(mat[i-1][j-1] instanceof Regina) System.out.print(" R "/* + mat[i][j].check_colore() +" "*/);
				else if(mat[i-1][j-1] instanceof Cavallo) System.out.print(" C " /*+ mat[i][j].check_colore() +" "*/);
				else if(mat[i-1][j-1] instanceof Torre) System.out.print(" T " /*+ mat[i][j].check_colore() +" "*/);
				else if(mat[i-1][j-1] instanceof Alfiere) System.out.print(" A " /*+ mat[i][j].check_colore() +" "*/);
				else System.out.print(" V ");
			}
		}
	}
	
	private boolean controlla_scacchiera(int riga, int colonna, int pos[]) {
		Pezzo matrix[][] = new Pezzo[8][8];
		if(mat[pos[0]][pos[1]] instanceof Torre || mat[pos[0]][pos[1]] instanceof Alfiere) {
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(mat[i][j] != null ) matrix[i][j] = mat[i][j];
				}
			}
		}
		if((mat[riga][colonna] == null) && (mat[pos[0]][pos[1]].controlla_movimento(riga, colonna, pos, matrix) == true)) return true;
		else {
			//p[] posizione del pezzo da spostare
			//r - riga del pezzo da mangiare
			//c - colonna del pezzo da mangiare
			if(((mat[pos[0]][pos[1]].mangia(riga, colonna, pos)) == true) && (mat[riga][colonna] != null) && (mat[riga][colonna].check_colore()!= mat[pos[0]][pos[1]].check_colore())) return true;
			return false;
		}
	}
	
	public int[] seleziona_pezzo() {
		Scanner sc = new Scanner(System.in);
		int r, c;
		int pos [] = new int[2];
		System.out.print("\n\nInserire posizione del pezzo da selezionare(R/C): ");
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(mat[r][c] != null) {
			pos[0] = r;
			pos[1] = c;
			return pos; //posizione del pezzo selezionato
		}
		else {
			int app[] = new int[1];
			app[0] = -1;
			return app;
		}
	}
	
	public void sposta_pezzo(int pos[]) { //pos - posizione del pezzo selezionato
		int r, c, riga, colonna;
		int pos_n[] = new int[2];
		//pos[] contiene la posizione passata come parametro che corrisponde alla posizione del pezzo da spostare
		r = pos[0];
		c = pos[1];
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire riga: ");
		riga = sc.nextInt();
		System.out.print("Inserire colonna: ");
		colonna = sc.nextInt();
		//controllare scacchiera
		if(controlla_scacchiera(riga, colonna, pos)) {
			pos_n = mat[r][c].sposta(riga, colonna);
			mat[r][c].aggiorna_posizione(pos_n);
			mat[pos_n[0]][pos_n[1]] = mat[r][c];
			mat[r][c] = null;
		}
		else System.out.print("\nMOSSA NON VALIDA");
	}
	
}
