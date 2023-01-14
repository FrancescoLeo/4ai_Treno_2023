
public class Treno {

	private String nome,destinazione;
	private int vagoniMax;
	private Vagone[] vagoni;
	
	public Treno(String nome,int vM) {
		this.nome=nome;
		vagoniMax=vM;
		destinazione="";
		vagoni=new Vagone[vagoniMax];
	}
	public void setDestinazione(String d) {
		destinazione=d;
	}
	public void setPosti(int pos,int posti) {
		vagoni[pos-1].setPostiO(posti);
	}
	public boolean addVagone(int pos,Vagone v) {
		if((pos>0 && pos<=vagoniMax) && vagoni[pos-1]==null) {
			vagoni[pos-1]=v;
			return true;
		}
		return false;
	}
	public boolean deleteVagone(int pos) {
		if((pos>0 && pos<=vagoniMax) && vagoni[pos-1]==null) {
			vagoni[pos-1]=new Vagone(null, 0);
			return true;
		}
		return false;
	}
	public int getPostiLiberi(int pos) {
		if((pos>0 && pos<=vagoniMax) && vagoni[pos-1]!=null) {
			int x=vagoni[pos-1].pL();
			return x;
		}
		return -1;
	}
	public String stpPostiLiberi() {
		String s="";int tot=0,i=0;
		for(var v:vagoni) {
			++i;
			if(v!=null) {
				s+="\nVagone n°"+i+"\nPosti liberi nel vagone: "+v.pL();
				tot+=v.pL();
			}
		}
		s+="\nPosti totali: "+tot;
		return s;
	}
	public String toString() {
		String s="";int i=0;
		
		s+="Nome del treno: "+nome+"\nDestinazione: "+destinazione;
		s+="\nVagoni massimi: "+vagoniMax+"\n\nINFORMATIONI SUI VAGONI";
		for(var v:vagoni) {
			++i;
			if(v!=null)
				s+="\nVagone n°"+i+v;
		}
		
		return s;
	}
	public static void main(String[] args) {
		Treno t=new Treno("Alice", 3);
		t.setDestinazione("Londra");
		t.addVagone(1, new Vagone("prima", 69));
		t.addVagone(3, new Vagone("seconda", 55));
		t.setPosti(1, 30);
		System.out.println(t.stpPostiLiberi()+"\n\n"+t);
	}

}
