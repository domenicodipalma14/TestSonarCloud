package pezzo;

public class Torre extends Pezzo {
	private int pos_a[] = new int [2];
	
	public Torre(String c, int r, int col) {
		super(c, r, col);
		pos_a = c_posizione();
	}
	
	public int[] sposta(int riga, int colonna) {
		//movimenti torre
		pos_a[0] = riga;
		pos_a[1] = colonna;
		return pos_a;
	}
	
	public boolean mangia(int r, int c, int p[]) {
		//p[] posizione del pezzo da spostare
		//r - riga del pezzo da mangiare
		//c - colonna del pezzo da mangiare
		if(r == p[0] && c != p[1]) return true; // mangia su riga
		else if(r!= p[0] && c == p[1]) return true; //mangia su colonna;
		else return false;
	}

	public boolean controlla_movimento(int r, int c, int p[], Pezzo mat[][]) {
		//r - riga dove si vuole spostare il pezzo
		//c - colonna dove si vuole spostare il pezzo
		//p - posizione attuale
		//mat - copia della scacchiera
		if((r>=0 && r <=7) || (c>=0 && c<=7)) {
			if(r == p[0] && c != p[1]) { //movimento sulla riga
				int partenza, arrivo;
				partenza = p[1]+1;
				arrivo = c;
				for(int i = partenza; i<=arrivo; i++) {
					if(mat[r][i] != null) return false;
				}
				return true;
			}
			else if( r !=p [0] && c == p[1]) { //movimento sulla colonna
				int partenza, arrivo;
				partenza = p[0]+1;
				arrivo = r;
				for(int i=partenza; i<=arrivo; i++) {
					if(mat[i][c] != null) return false;
				}
				return true;
			}
			else return false;
		}
		else return false;
	}
}
