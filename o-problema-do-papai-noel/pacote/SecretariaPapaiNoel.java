package pacote;

import java.util.ArrayList;

public class SecretariaPapaiNoel {
  private ArrayList<Servical> fila = new ArrayList<Servical>();

  public void adicionarElfoAFila(Servical servical) throws InterruptedException {
    this.fila.add(servical);
    servical.wait();
  }
}
