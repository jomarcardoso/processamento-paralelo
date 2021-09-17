import java.util.ArrayList;

public class SecretariaDoNoel {
  ArrayList<Elfo> filaElfos = new ArrayList<Elfo>();
  ArrayList<Rena> filaRenas = new ArrayList<Rena>();

  public void adicionarElfoAFila(Elfo elfo) {
    this.filaElfos.add(elfo);
  }

  public void adicionarRenaAFila(Rena rena) {
    this.filaRenas.add(rena);
  }
}
