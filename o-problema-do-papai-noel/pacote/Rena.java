package pacote;

public class Rena extends Thread {
  PapaiNoel papaiNoel;
  String name;

  public Rena(String name, PapaiNoel papaiNoel) {
    super();

    this.papaiNoel = papaiNoel;
    this.name = name;
  }

  private void aproveitarFerias() throws InterruptedException {
    System.out.println(this.name + " de férias");
    Thread.sleep((int)(Math.random() * 10000));
  }

  private synchronized void irParaFila() throws InterruptedException {
    System.out.println(this.name + " na fila");

    this.setPriority(Thread.MAX_PRIORITY);
    papaiNoel.adicionarRenaAFila(this);
  }

  @Override
  public void run() {
    try {
      this.aproveitarFerias();
      this.irParaFila();

      while(papaiNoel.getEstado() != EstadoPapaiNoel.DISTRIBUINDO_PRESENTES) {
        // wait();
      }

      notify();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
