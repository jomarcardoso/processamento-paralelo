import java.util.Random;

public class BarbeiroDorminhoco {

    public static void main(String args[]) throws InterruptedException {

        int qntMaxClientes = 20;
        int qntMaquininhas = 1;
        int qntBarbeiros = 3;
        int qntSofa = 4;
        int idCliente = 1;
        Random random = new Random();

        Barbearia barbearia = new Barbearia(qntBarbeiros, qntMaxClientes, qntSofa, qntMaquininhas);

        for (int i = 1; i <= qntBarbeiros; i++) {
            Barbeiro barbeiro = new Barbeiro(i, barbearia);
            barbeiro.start();
        }

        while (idCliente < 200) {
            Thread.sleep(random.nextInt(5));
            Cliente cliente = new Cliente(idCliente, barbearia);
            idCliente++;
            cliente.start();
        }
    }

}
