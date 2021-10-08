package noel;

import java.util.ArrayList;

public class PapaiNoel extends Thread {
  private ArrayList<Rena> filaRenas = new ArrayList<Rena>();
  private ArrayList<Elfo> filaElfos = new ArrayList<Elfo>();
  private final Object lockRena = new Object();
  private final Object lockElfo = new Object();
  private EstadoPapaiNoel estado = EstadoPapaiNoel.DORMINDO;

  private void entregar() throws InterruptedException {
    if(filaRenas.size() >= 9) {
      System.out.println("\nPapai Noel acordou");
      System.out.println("tem " + filaRenas.size() + " renas na fila");

      System.out.println("partiu entregar presentes");
      Thread.sleep(3000);
      estado = EstadoPapaiNoel.DISTRIBUINDO_PRESENTES;

      System.out.println("acabou o natal nao precisa mais fazer entregas");
      synchronized(lockRena) {
        filaRenas.clear();
      }
      notifyAll();
    }
  }

  private void discutir() throws InterruptedException {
    if(filaElfos.size() >= 3) {
      System.out.println("\nPapai Noel acordou");
      System.out.println("tem 3 elfos na fila");

      System.out.println("partiu discutir com os elfos");
      Thread.sleep(1000);
      estado = EstadoPapaiNoel.DISCUTINDO_PROJETOS;

      System.out.println("acabou de ajudar os elfos");
      synchronized(lockElfo) {
        filaElfos.remove(0);
        filaElfos.remove(0);
        filaElfos.remove(0);
      }
      notifyAll();
    }
  }

  public void adicionarElfoAFila(Elfo elfo) throws InterruptedException {
    synchronized(lockElfo) {
      filaElfos.add(elfo);
    }

    System.out.println(elfo.nome + " foi para a fila");
    aguardarNaFilaDosElfos(elfo);
  }

  synchronized public void aguardarNaFilaDosElfos(Elfo elfo) throws InterruptedException {
    notifyAll();

    while(filaElfos.contains(elfo)) {
      wait();
    }
  }

  public void adicionarRenaAFila(Rena rena) throws InterruptedException {
    System.out.println(rena.nome + " foi para a fila");

    synchronized(lockRena) {
      filaRenas.add(rena);
    }

    aguardarNaFilaDasRenas(rena);

    System.out.println(rena.nome + " foi atendida");
  }

  synchronized public void aguardarNaFilaDasRenas(Rena rena) throws InterruptedException {
    notifyAll();

    while(filaRenas.contains(rena)) {
      wait();
    }
  }

  synchronized public void dormirAteQue() {
    try {
      while(true) {
        entregar();
        discutir();

        if (estado != EstadoPapaiNoel.DORMINDO) {
          estado = EstadoPapaiNoel.DORMINDO;
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
    dormirAteQue();
  }
}
