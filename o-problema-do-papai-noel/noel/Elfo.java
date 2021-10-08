package noel;

public class Elfo extends Thread {
  PapaiNoel papaiNoel;
  String nome;

  public Elfo(String nome, PapaiNoel papaiNoel) {
    super();

    this.papaiNoel = papaiNoel;
    this.nome = nome;
  }

  private void fabricarBrinquedos() throws InterruptedException {
    System.out.println(nome + " fabricando brinquedos");
    Thread.sleep((int)(4000 + Math.random() * 35000));
  }

  private void irParaFila() throws InterruptedException {
    papaiNoel.adicionarElfoAFila(this);
  }

  @Override
  public void run() {
    try {
      while(true) {
        fabricarBrinquedos();
        irParaFila();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
