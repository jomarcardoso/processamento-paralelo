package noel;

import java.util.ArrayList;

public class PapaiNoel extends Thread {
  private ArrayList<Rena> filaRenas = new ArrayList<Rena>();
  private ArrayList<Elfo> filaElfos = new ArrayList<Elfo>();
  private EstadoPapaiNoel estado = EstadoPapaiNoel.DORMINDO;

  synchronized private void entregar() throws InterruptedException {
    if(this.filaRenas.size() >= 9) {

      System.out.println("\nPapai Noel acordou");
      System.out.println("tem " + filaRenas.size() + " renas na fila");
      System.out.println("partiu entregar presentes");

      this.estado = EstadoPapaiNoel.DISTRIBUINDO_PRESENTES;
      notifyAll();
      this.estado = EstadoPapaiNoel.ACORDADO;
      notifyAll();

      this.filaRenas.clear();
      System.out.println("acabou o natal nao precisa mais fazer entregas");
    }
  }

  synchronized private void discutir() throws InterruptedException {
    if(this.filaElfos.size() >= 3) {
      System.out.println("\nPapai Noel acordou");
      System.out.println("tem 3 elfos na fila");
      System.out.println("partiu discutir com os elfos");

      this.estado = EstadoPapaiNoel.DISCUTINDO_PROJETOS;
      notifyAll();
      System.out.println("acabou de ajudar os elfos");
      this.estado = EstadoPapaiNoel.ACORDADO;
      notifyAll();

      this.filaElfos.clear();
    }
  }

  synchronized public void adicionarElfoAFila(Elfo elfo) throws InterruptedException {
    if (this.filaElfos.size() >= 3) {
      System.out.println(this.filaElfos.get(2).name);
      System.out.println(elfo.name + " nao pode ser atendido, fila cheia");

      return;
    }

    this.filaElfos.add(elfo);
    notifyAll();
    System.out.println(elfo.name + " foi para a fila");

    while(this.filaElfos.contains(elfo)) {
      wait();
    }

    System.out.println(elfo.name + " foi atendido");
  }

  synchronized public void adicionarRenaAFila(Rena rena) throws InterruptedException {
    System.out.println(rena.name + " foi para a fila");
    this.filaRenas.add(rena);
    notifyAll();

    while(this.filaRenas.contains(rena)) {
      wait();
    }

    System.out.println(rena.name + " foi atendida");
  }

  synchronized public void dormirAteQue() {
    try {
      while(true) {
        this.entregar();
        this.discutir();

        if (this.estado != EstadoPapaiNoel.DORMINDO) {
          this.estado = EstadoPapaiNoel.DORMINDO;
          System.out.println("Papai Noel voltou a dormir\n");
        }


        wait();
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void run() {
    this.dormirAteQue();
  }
}
