public class Fila {

   int quantidadeLugares;

    private Cliente[] lugares = new Cliente[quantidadeLugares];

    public Fila(int quantidadeLugares) {
        for (int i = 0; i < quantidadeLugares; i++) {
            lugares[i] = null;
        }
    }

    public Cliente addCliente(Cliente arg) {
        Cliente cliente = arg;

        for (int i = 0; i < quantidadeLugares; i++) {
            if (lugares[i] == null) {
                lugares[i] = arg;
                break;
            }
        }

        return cliente;
    }

    public Cliente removePrimeiroCliente() {
        Cliente cliente = lugares[0];
        lugares[0] = null;

        for (int i = 1; i < quantidadeLugares; i++) {
            if (lugares[i] != null) {
                lugares[i - 1] = lugares[i];
                lugares[i] = null;
            }
        }

        return cliente;
    }

    public boolean getFilaVazia() {
        boolean vazia = true;

        for (int i = 0; i < quantidadeLugares; i++) {
            if (lugares[i] != null) {
                vazia = false;
                break;
            }
        }

        return vazia;
    }

    public boolean getFilaLotada() {
        boolean lotada = true;

        for (int i = 0; i < quantidadeLugares; i++) {
            if (lugares[i] == null) {
                lotada = false;
                break;
            }
        }

        return lotada;
    }

//    public int getQtdClientes() {
//        int qtd=0;
//
//        for (int i = 0; i < quantidadeLugares; i++) {
//            if (lugares[i] != null) {
//                qtd++;
//            }
//        }
//
//        return qtd;
//    }

}
