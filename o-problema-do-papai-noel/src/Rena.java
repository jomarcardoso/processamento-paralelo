public class Rena extends Thread {
  PapaiNoel papaiNoel;

  public Rena(PapaiNoel papaiNoel) {
    super();
  }

  private void irParaFila() {
    try{
      this.papaiNoel.adicionarRenaAFila(this);
      this.wait();
    } catch(InterruptedException e){
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    this.setPriority(Thread.MAX_PRIORITY);
    this.irParaFila();
  }
}
