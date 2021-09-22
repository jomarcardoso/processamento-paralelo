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
    notify();
  }

  public void gerenciarFila() {
    // resolver as threads com mais prioridade que foram setadas já
    // Elfo elfo = filaElfos.get(0);

    // synchronized(elfo) {
    //   notify();
    // }

    while(true) {
      System.out.println("total renas " + this.filaRenas.size());

      if (this.filaRenas.size() == 8) {
        int count = 0;

        System.out.println("rou rou rou vou entregar presentes");

        while(this.filaRenas.size() > count) {
          this.filaRenas.get(count).notify();
          count++;
        }
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
