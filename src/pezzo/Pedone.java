package pezzo;

public class Pedone extends Pezzo {
	private int pos_a[] = new int [2];
	public Pedone(String c, int r, int col) {
		super(c, r , col);
		pos_a = c_posizione();
		//set_colore(c);
	}
	
	public int[] sposta(int riga, int colonna) {
		pos_a[0] = riga;
		pos_a[1] = colonna;
		return pos_a;
	}
	
	public boolean mangia(int r, int c, int p[]) {
		//p[] posizione del pezzo da spostare
		//r - riga del pezzo da mangiare
		//c - colonna del pezzo da mangiare
		int r_p, c_p;
		r_p = p[0];
		c_p = p[1];
		if(colore == "bianco") {
			if( (r == (r_p+1)) && ( (c == (c_p-1)) || (c == (c_p+1)) ) ) return true;
			else return false;
		}
		else {
			if( (r == (r_p-1)) && ( (c == (c_p-1)) || (c == (c_p+1)) ) ) return true;
			else return false;
		}
	}
	
	public boolean controlla_movimento(int r, int c, int p[], Pezzo m[][]) {
		//r - riga dove si vuole spostare il pezzo
		//c - colonna dove si vuole spostare il pezzo
		//p - posizione attuale
		
		/*
		 * prima controllo se il pedone si trova nella posizione di partenza
		 * oppure se non è in posizione di partenza la riga deve essere aumentata al massimo di 1
		 * altrimenti la mossa non è valida
		 */
		//pos_a = p;
		if(colore == "bianco") {
			if((p[0] == 1 && r<=3 && r>1)  && c == p[1]) return true;
			else if (p[0] != 1 && r == (p[0]+1) && c == p[1]) return true;
			else return false;
		}
		else {
			if( (p[0] == 6 && r>=4 && r<6) && (c == p[1])) return true;
			else if (p[0] != 6 && r == (p[0]-1) && c == p[1]) return true;
			else return false;
		}
	}
}
