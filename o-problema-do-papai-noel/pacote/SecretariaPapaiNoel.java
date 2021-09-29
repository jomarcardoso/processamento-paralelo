package pacote;

import java.util.ArrayList;

public class SecretariaPapaiNoel extends Thread {
  private ArrayList<Rena> filaRenas = new ArrayList<Rena>();
  private ArrayList<Elfo> filaElfos = new ArrayList<Elfo>();
  private EstadoPapaiNoel estado;

  private void entregar() throws InterruptedException {
    if(this.filaRenas.size() >= 8) {
      this.filaRenas.clear();
      System.out.println("partiu entregar presentes");
      this.estado = EstadoPapaiNoel.DISTRIBUINDO_PRESENTES;
      Thread.sleep((int)(500));
      this.estado = EstadoPapaiNoel.DORMINDO;
    }
  }

  private void discutir() throws InterruptedException {
    if(this.filaElfos.size() >= 3) {
      this.filaElfos.clear();
      System.out.println("partiu discutir com os elfos");
      this.estado = EstadoPapaiNoel.DISCUTINDO_PROJETOS;
      Thread.sleep((int)(500));
      this.estado = EstadoPapaiNoel.DORMINDO;
    }
  }

  public void adicionarElfoAFila(Elfo elfo) throws InterruptedException {
    this.filaElfos.add(elfo);

    while(estado != EstadoPapaiNoel.DISCUTINDO_PROJETOS) {
      Thread.sleep((int)(100));
    }
  }

  public void adicionarRenaAFila(Rena rena) throws InterruptedException {
    this.filaRenas.add(rena);

    while(estado != EstadoPapaiNoel.DISTRIBUINDO_PRESENTES) {
      Thread.sleep((int)(100));
    }
  }

  public void run() {
    while(true) {
      try {
        Thread.sleep((int)(5000 + Math.random() * 10000));
        System.out.println("Papai Noel acordou");
        this.entregar();
        this.discutir();
        System.out.println("Papai Noel voltou a dormir");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
