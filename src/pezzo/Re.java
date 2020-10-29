package pezzo;

public class Re extends Pezzo{
	private int pos_a[] =new int [2];
	
	public Re(String c, int r, int col) {
		super(c, r, col);
		pos_a = c_posizione();
	}
	
	public int[] sposta(int riga, int colonna) {
		//riga - riga dove si vuole spostare
		//colonna dove si vuole spostare
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
		if( (r == r_p) && ( (c == (c_p-1) ) || (c == (c_p+1)))) return true;
		else if ( ( (r == (r_p+1)) || (r == (r_p-1) ) ) && ( (c == (c_p+1)) || (c == (c_p -1)) || (c == c_p) ) ) return true;
		else return false;
	}

	public boolean controlla_movimento(int r, int c, int p[], Pezzo m[][]) {
		//r - riga dove si vuole spostare il pezzo
		//c - colonna dove si vuole spostare il pezzo
		//p - posizione attuale
		if(colore == "bianco") {
			if(((p[0]+1)<=7) && ((p[0]-1)>=0) && ((p[1]+1)<=7) && ((p[1]-1)>=0)) { 
				if((c == (p[1]+1)) || (c == p[1]) || (c == (p[1]-1))) {
					if((r == p[0]+1) || (r == p[0]) || (r == p[0]-1) ) return true;
					else return false;
				} else return false;
			}
			else return false; 
		}
		else {
			if(((p[0]-1)>=0) && ((p[0]+1)<=7) && ((p[1]-1)>=0) && ((p[1]+1)<=7)){
				if(( c == (p[1]+1)) || (c == p[1]) || (c == (p[1]-1))) {
					if((r == p[0]-1) || (r == p[0]) || (r == p[0]+1) ) return true;
					else return false;
				}else return false;
			}
			else return false;
		}
	}
}
