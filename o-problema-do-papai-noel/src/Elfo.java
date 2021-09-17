public class Elfo extends Thread {
  SecretariaDoNoel secretariaDoNoel;

  public Elfo(SecretariaDoNoel secretariaDoNoel) {
    super();
  }

  private void irParaFila() {

  }

  public void run() {
    while (true) {
      try{
        Thread.sleep((int)(Math.random() * 1000));
        this.irParaFila();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
