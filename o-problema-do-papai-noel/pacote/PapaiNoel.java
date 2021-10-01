package pacote;

import java.util.ArrayList;

public class PapaiNoel extends Thread {
  private ArrayList<Rena> filaRenas = new ArrayList<Rena>();
  private ArrayList<Elfo> filaElfos = new ArrayList<Elfo>();
  private EstadoPapaiNoel estado = EstadoPapaiNoel.DORMINDO;

  synchronized private void entregar() throws InterruptedException {
    if(this.filaRenas.size() >= 8) {
      this.filaRenas.clear();

      System.out.println("partiu entregar presentes");

      this.estado = EstadoPapaiNoel.DISTRIBUINDO_PRESENTES;
      notifyAll();
      Thread.sleep((int)(8000));
      this.estado = EstadoPapaiNoel.ACORDADO;
      notifyAll();

      System.out.println("acabou o natal nao precisa mais fazer entregas");
    }
  }

  synchronized private void discutir() throws InterruptedException {
    if(this.filaElfos.size() >= 3) {
      this.filaElfos.remove(0);
      this.filaElfos.remove(0);
      this.filaElfos.remove(0);

      System.out.println("partiu discutir com os elfos");

      this.estado = EstadoPapaiNoel.DISCUTINDO_PROJETOS;
      notifyAll();
      Thread.sleep((int)(4000));
      System.out.println("acabou de ajudar os elfos");
      this.estado = EstadoPapaiNoel.ACORDADO;

      notifyAll();
    }
  }

  synchronized public void adicionarElfoAFila(Elfo elfo) throws InterruptedException {
    this.filaElfos.add(elfo);

    while(this.filaElfos.contains(elfo)) {
      System.out.println(elfo.name + " na fila");
      wait();
    }

    while(this.estado == EstadoPapaiNoel.DISCUTINDO_PROJETOS) {
      System.out.println(elfo.name + " sendo atendido");
      wait();
    }

    System.out.println(elfo.name + " foi atendido");
  }

  synchronized public void adicionarRenaAFila(Rena rena) throws InterruptedException {
    this.filaRenas.add(rena);

    while(estado != EstadoPapaiNoel.DISTRIBUINDO_PRESENTES) {
      wait();
    }

    while(estado == EstadoPapaiNoel.DISTRIBUINDO_PRESENTES) {
      wait();
    }
  }

  public void run() {
    while(true) {
      try {
        Thread.sleep((int)(5000 + Math.random() * 10000));

        System.out.print("\nPapai Noel acordou");
        System.out.print(", tem " + filaElfos.size() + " elfos na fila");
        System.out.println(" e " + filaRenas.size() + " renas na fila");

        this.entregar();
        this.discutir();

        this.estado = EstadoPapaiNoel.DORMINDO;

        System.out.println("Papai Noel voltou a dormir\n");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
