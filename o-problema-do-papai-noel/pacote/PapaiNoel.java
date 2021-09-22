package pacote;

import java.util.ArrayList;

public class PapaiNoel extends Thread {
  private EstadoPapaiNoel estado;
  private ArrayList<Elfo> filaElfos = new ArrayList<Elfo>();
  private ArrayList<Rena> filaRenas = new ArrayList<Rena>();

  public EstadoPapaiNoel getEstado() {
    return estado;
  }

  public void setEstado(EstadoPapaiNoel estado) {
    System.out.println("Papai Noel " + estado);
    this.estado = estado;
  }

  public void adicionarElfoAFila(Elfo elfo) throws InterruptedException {
    this.filaElfos.add(elfo);
    elfo.wait();
  }

  public void adicionarRenaAFila(Rena rena) throws InterruptedException {
    this.filaRenas.add(rena);
    rena.wait();
  }

  public void gerenciarFila() {
    // resolver as threads com mais prioridade que foram setadas já
    // Elfo elfo = filaElfos.get(0);

    // synchronized(elfo) {
    //   notify();
    // }

    boolean applicationRun = true;

    while(applicationRun) {
      System.out.println("total renas " + this.filaRenas.size());

      if (this.filaRenas.size() == 8) {
        // int count = 0;

        // System.out.println("rou rou rou vou entregar presentes");

        this.setEstado(EstadoPapaiNoel.DISTRIBUINDO_PRESENTES);

        // notifyAll();

        // while(this.filaRenas.size() > count) {
        //   // this.filaRenas.get(count).notify();
        //   // this.filaRenas.get(count).vai();
        //   count++;
        // }

        applicationRun = false;
      }
    }
  }

  // @Override
  // public void run() {
  //   while (true) {
  //     try{
  //       Thread.sleep((int)(Math.random() * 1000));
  //       this.gerenciarFila();
  //     }
  //     catch (InterruptedException e) {
  //       e.printStackTrace();
  //     }
  //   }
  // }
}
