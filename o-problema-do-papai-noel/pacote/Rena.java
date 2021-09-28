package pacote;

public class Rena extends Thread implements Servical {
  SecretariaPapaiNoel secretariaPapaiNoel;
  String name;

  public Rena(String name, SecretariaPapaiNoel secretariaPapaiNoel) {
    super();

    this.secretariaPapaiNoel = secretariaPapaiNoel;
    this.name = name;
  }

  private void aproveitarFerias() throws InterruptedException {
    System.out.println(this.name + " de férias");
    Thread.sleep((int)(Math.random() * 10000));
  }

  private synchronized void irParaFila() throws InterruptedException {
    // System.out.println(this.name + " na fila");
    this.setPriority(Thread.MAX_PRIORITY);
    secretariaPapaiNoel.adicionarAFila(this);
  }

  @Override
  public void run() {
    try {
      this.aproveitarFerias();
      this.irParaFila();

      // while(papaiNoel.getEstado() != EstadoPapaiNoel.DISTRIBUINDO_PRESENTES) {
        // wait();
      // }

      // notify();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void trabalhar() {
    // TODO Auto-generated method stub

  }
}
