public class Barbeiro extends Thread {

    private Fila fila;

    private Barbeiro

    public Barbeiro(Fila clientes, String nome) {
        super(nome);
        this.fila = clientes;
    }

    public void atender() {
        synchronized (fila) {
            /* Verifica se há clientes no sofá */
            if (fila.getSofaVazio() == true) {

            }
        }
    }

}
