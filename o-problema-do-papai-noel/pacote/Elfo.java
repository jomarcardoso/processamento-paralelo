package pacote;

public class Elfo extends Thread implements Servical {
  SecretariaPapaiNoel secretariaPapaiNoel;

  public Elfo(SecretariaPapaiNoel secretariaPapaiNoel) {
    super();

    this.secretariaPapaiNoel = secretariaPapaiNoel;
  }

  private void irParaFila() {
    try{
      this.secretariaPapaiNoel.adicionarAFila(this);
      this.wait();
    } catch(InterruptedException e){
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    this.setPriority(Thread.MIN_PRIORITY);
    this.irParaFila();
  }

  @Override
  public void trabalhar() {
    // TODO Auto-generated method stub

  }
}
