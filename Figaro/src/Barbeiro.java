public class Barbeiro extends Thread {

    int idBarbeiro;
    Barbearia barbearia;

    public Barbeiro(int idBarbeiro, Barbearia barbearia) {
        this.idBarbeiro = idBarbeiro;
        this.barbearia = barbearia;
    }

    public void run() {
        while(true) {
            try {
                barbearia.cortar(idBarbeiro);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
