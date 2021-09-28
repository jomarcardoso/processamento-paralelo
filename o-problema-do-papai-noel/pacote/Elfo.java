package pacote;

public class Elfo extends Thread implements Servical {
  PapaiNoel papaiNoel;

  public Elfo(PapaiNoel papaiNoel) {
    super();
  }

  private void irParaFila() {
    try{
      this.papaiNoel.adicionarAFila(this);
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
