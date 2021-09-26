public class BarbeiroDorminhoco {

    public static void main(String args[]) {

        int qntMaxClientes = 20;
        int qntMaquininhas = 1;
        int qntBarbeiros = 3;
        int qntSofa = 4;
        int idCliente = 1;

        Barbearia barbearia = new Barbearia(qntBarbeiros, qntMaxClientes, qntSofa, qntMaquininhas);

        for (int i = 1; i <= qntBarbeiros; i++) {
            Barbeiro barbeiro = new Barbeiro(i, barbearia);
            barbeiro.start();
        }

        while (true) {
            Cliente cliente = new Cliente(idCliente, barbearia);
            idCliente++;
            cliente.start();
        }
    }

}
