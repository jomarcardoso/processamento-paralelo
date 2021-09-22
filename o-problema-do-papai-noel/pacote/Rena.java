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
    this.notify();
    // this.wait();
  }

  private void irParaFila() throws InterruptedException {
    System.out.println(this.name + " na fila");

    this.setPriority(Thread.MAX_PRIORITY);
    papaiNoel.adicionarRenaAFila(this);

    System.out.println(this.name + " entregando presentes");
  }

  @Override
  public void run() {
    synchronized(this) {
      try {
        this.aproveitarFerias();
        this.irParaFila();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
