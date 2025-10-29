package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
public class Blogg {

	//objektvariable
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell=new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		int antall=0;
		for(int i =0; i<innleggtabell.length;i++){
			if(innleggtabell[i]!= null){
				antall +=1;
			}
		}
		return antall;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
			for (int i = 0; i < innleggtabell.length; i++) {
				if (innleggtabell[i] != null && innleggtabell[i].erLik(innlegg)) {
					return true;
				}
			}
				return false;
	}

	public boolean ledigPlass() {
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(ledigPlass() && !finnes(innlegg)){
			for(int i=0;i<innleggtabell.length;i++){
				if(innleggtabell[i] == null){
					innleggtabell[i] = innlegg;
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		int count = 0;
		for(int i =0;i<innleggtabell.length;i++){
			if(innleggtabell[i] !=null){
				count ++;
			}
		}
		return count+Innlegg.Tekst.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}