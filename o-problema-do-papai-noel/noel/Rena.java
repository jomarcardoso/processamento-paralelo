package noel;

public class Rena extends Thread {
  PapaiNoel papaiNoel;
  String name;

  public Rena(String name, PapaiNoel papaiNoel) {
    super();

    this.papaiNoel = papaiNoel;
    this.name = name;
  }

  private void aproveitarFerias() throws InterruptedException {
    System.out.println(this.name + " de ferias");
    Thread.sleep((int)(25000 + Math.random() * 5000));
  }

  private void irParaFila() throws InterruptedException {
    papaiNoel.adicionarRenaAFila(this);
  }

  @Override
  public void run() {
    try {
      while(true) {
        this.aproveitarFerias();
        this.irParaFila();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
