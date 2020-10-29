package pezzo;

public abstract class Pezzo {
	protected String colore;
	private int posizione[] = new int[2];
	
	public Pezzo(String c, int riga, int colonna) { //inizializzo il pezzo con colore e posizione di partenza
		//Costruttore
		colore = c;
		posizione[0] = riga; //indica la riga della scacchiera
		posizione[1] = colonna; //indica la colonna della scacchiera
	}
	
	public String check_colore() {
		return colore;
	}
	
	public int[] c_posizione() {
		return posizione;
	}
	
	public void aggiorna_posizione(int pos_nuova[]) {
		int r, c;
		r = pos_nuova[0];
		c = pos_nuova[1];
		this.posizione[0] = r;
		this.posizione[1] = c;
	}
	
	abstract public int[] sposta(int riga, int colonna);
	
	
	abstract public boolean mangia(int r, int c, int p[]) ;
		//p[] posizione del pezzo da spostare
		//r - riga del pezzo da mangiare
		//c - colonna del pezzo da mangiare
		
	abstract public boolean controlla_movimento(int r, int c, int p[], Pezzo mat[][]); 
	//r - riga dove si vuole spostare il pezzo
	//c - colonna dove si vuole spostare il pezzo
	//p - posizione attuale
	//mat - riga o colonna della scacchiera, serve solo a torre e alfiere
}
