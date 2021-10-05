package noel;

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

  private void irParaFila() throws InterruptedException {
    papaiNoel.adicionarElfoAFila(this);
  }

  @Override
  public void run() {
    try {
      while(true) {
        this.fabricarBrinquedos();
        this.irParaFila();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
