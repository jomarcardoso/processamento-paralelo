import java.util.Random;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        Fila sofa = new Fila(4);
        Fila salao = new Fila(16);

        Barbearia barbearia = new Barbearia(sofa, salao);

        Barbeiro b1 = new Barbeiro(barbearia, "Rossini");
        Barbeiro b2 = new Barbeiro(barbearia, "Figaro");
        Barbeiro b3 = new Barbeiro(barbearia, "Giachino");

        b1.start();
        b2.start();
        b3.start();

        while (true) {
            if (random.nextInt(1000) > 100) {
                Cliente cliente = new Cliente(UUID.randomUUID().toString(), barbearia);
                cliente.start();
            }
        }
    }

}
