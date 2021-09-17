import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Barbearia {

    int capacidadeMax = 20;

    public static void main(String[] args) {
        Random random = new Random();

        Fila sofa = new Fila(4);
        Fila salao = new Fila(16);

        Barbeiro b1 = new Barbeiro(sofa, "Rossini");
        Barbeiro b2 = new Barbeiro(sofa, "Figaro");
        Barbeiro b3 = new Barbeiro(sofa, "Giachino");

        b1.start();
        b2.start();
        b3.start();

        while (true) {
            if (random.nextInt(1000) > 100) {
                // Verifica se há espaço na barbearia e adiciona cliente onde puder
                if (!sofa.getFilaLotada() && !salao.getFilaLotada()) {
                    if (!sofa.getFilaLotada()) {
                        sofa.addCliente(new Cliente(UUID.randomUUID().toString()));
                    } else {
                        salao.addCliente(new Cliente(UUID.randomUUID().toString()));
                    }
                }
            }
        }
    }

    public boolean barbeariaCheia(Fila sofa, Fila salao) {
        return sofa.getFilaLotada() && salao.getFilaLotada();
    }


}
