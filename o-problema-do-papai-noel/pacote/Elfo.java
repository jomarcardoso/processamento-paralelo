package pacote;

public class Elfo extends Thread {
  PapaiNoel papaiNoel;
  String name;

  public Elfo(String name, PapaiNoel papaiNoel) {
    super();

    this.papaiNoel = papaiNoel;
    this.name = name;
  }

  private void fabricarBrinquedos() throws InterruptedException {
    System.out.println(this.name + " fabricando brinquedos");
    Thread.sleep((int)(4000 + Math.random() * 35000));
  }

  private synchronized void irParaFila() throws InterruptedException {
    System.out.println(this.name + " na fila");
    this.setPriority(Thread.MIN_PRIORITY);
    papaiNoel.adicionarElfoAFila(this);
  }

  @Override
  public void run() {
    try {
      while(true) {
        this.fabricarBrinquedos();
        this.irParaFila();
        Thread.sleep((int)(1000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
