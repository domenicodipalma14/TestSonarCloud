package pezzo;

public class Regina extends Pezzo {
	private int pos_a[] =new int [2];
	
	public Regina(String c, int r, int col) {
		super(c, r, col);
	}
	
	public int[] sposta(int riga, int colonna) {
		//riga - riga dove si vuole spostare
		//colonna dove si vuole spostare
		pos_a[0] = riga;
		pos_a[1] = colonna;
		return pos_a;
	}

	public boolean mangia(int r, int c, int p[]) {
		return true;
	}

	public boolean controlla_movimento(int r, int c, int p[], Pezzo m[][]) {
		//r - riga dove si vuole spostare il pezzo
		//c - colonna dove si vuole spostare il pezzo
		//p - posizione attuale
		
		if(c != p[1]) return false;
		else return true;
	}
}
