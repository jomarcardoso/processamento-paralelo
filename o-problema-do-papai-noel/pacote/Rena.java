package pacote;

public class Rena extends Thread {
  SecretariaPapaiNoel secretariaPapaiNoel;
  String name;

  public Rena(String name, SecretariaPapaiNoel secretariaPapaiNoel) {
    super();

    this.secretariaPapaiNoel = secretariaPapaiNoel;
    this.name = name;
  }

  private void aproveitarFerias() throws InterruptedException {
    System.out.println(this.name + " de ferias");
    Thread.sleep((int)(15000 + Math.random() * 5000));
  }

  private synchronized void irParaFila() throws InterruptedException {
    System.out.println(this.name + " na fila");
    this.setPriority(Thread.MAX_PRIORITY);
    secretariaPapaiNoel.adicionarRenaAFila(this);
  }

  @Override
  public void run() {
    try {
      while(true) {
        this.aproveitarFerias();
        this.irParaFila();
        Thread.sleep((int)(1000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
