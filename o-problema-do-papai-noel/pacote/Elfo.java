package pacote;

public class Elfo extends Thread {
  PapaiNoel papaiNoel;

  public Elfo(PapaiNoel papaiNoel) {
    super();
  }

  private void irParaFila() {
    try{
      this.papaiNoel.adicionarElfoAFila(this);
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
}
