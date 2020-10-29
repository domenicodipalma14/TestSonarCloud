package pezzo;

public class Gioca {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scacchiera s;
		int position [] = new int[2];
		s = new Scacchiera();
		s.stampa();
		
		while(true) {
			position = s.seleziona_pezzo(); // posizione del pezzo selezionato
			if(position[0] != -1) { 
				s.sposta_pezzo(position); 
				s.stampa();
			}
		else System.out.print("\nCASELLA SELEZIONATA VUOTA!!\n");
		}
		
	}

}
