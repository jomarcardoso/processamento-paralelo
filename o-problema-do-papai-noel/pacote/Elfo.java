package pacote;

public class Elfo extends Thread {
  SecretariaPapaiNoel secretariaPapaiNoel;
  String name;

  public Elfo(String name, SecretariaPapaiNoel secretariaPapaiNoel) {
    super();

    this.secretariaPapaiNoel = secretariaPapaiNoel;
    this.name = name;
  }

  private void aproveitarFerias() throws InterruptedException {
    System.out.println(this.name + " de ferias");
    Thread.sleep((int)(1000 + Math.random() * 5000));
  }

  private synchronized void irParaFila() throws InterruptedException {
    System.out.println(this.name + " na fila");
    this.setPriority(Thread.MIN_PRIORITY);
    secretariaPapaiNoel.adicionarElfoAFila(this);
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
