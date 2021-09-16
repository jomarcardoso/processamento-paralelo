# Barbearia de Hilzer

William Stallings (Stallings, 2012) apresenta uma versão mais complicada do problema
da barbearia, que ele atribui a Ralph Hilzer da Universidade da Califórnia. O problema
consiste em uma barbearia com três barbeiros e três cadeiras próprias de barbeiros,
também existe uma série de lugares para que os clientes possam esperar. Tanto os
barbeiros quanto os clientes devem ser implementados como Threads.

**Requisitos:**

- três cadeiras;
- três barbeiros;
- uma sala de espera com um sofá de quatro lugares;
- o número total de clientes permitidos na barbearia é 20;
- nenhum cliente entrará se a capacidade do local estiver satisfeita;
- se o cliente entrou e tiver lugar no sofá ele se senta, caso contrário ele espera em pé;
- quando um barbeiro está livre para atender, o cliente que está a mais tempo no
  sofá é atendido e o que está a mais tempo em pé se senta;
- qualquer barbeiro pode aceitar pagamento, mas somente um cliente pode pagar
  por vez, porque só há uma POS;
- os barbeiros dividem o seu tempo entre cortar cabelo, receber pagamento e dormir enquanto esperam por um cliente.

> Referencias: Stallings, W., & Paul, G. K. (2012). Operating systems: internals and design principles (Vol. 9).
> New York: Pearson

## Projeto

```bash
javac src/Main.java -d dist
cd dist && java Main
```
