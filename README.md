# UDPHandler4J

Um Framework desenvolvido em Java com o propósito de facilitar a criação de servidores que rodam em portas UDP. Conta com sistema de filas, e está sempre sendo otimizado.

## 1.0 Iniciando o servidor

### 1.1 Crie um pacote onde ficarão todas as suas classes que irão herdar de um Packet (com.yan.udphandler4j.packets). Nele, crie uma classe e um método que irá fazer o registro do seu pacote no Framework.

```
public static void register() {
    PacketHandler.registerJavaPacket(Package.getPackage("com.yan.udphandler4jexample.packets"));
}
```

### 1.2 Na classe principal do seu projeto, no método main, chame a função register e a função UDPHandler4J.run(args)

```
public static void main(String[] args) {
    PacketUtils.register();        
    UDPHandler4J.run(args);
}
```

## 2.0 Criando um packet

### 2.1 Crie uma classe dentro do pacote definido (1.2), extenda ela da classe Packet e implemente todos os métodos.

Lembrando que o primeiro byte do pacote é reservado para o Framework, e nele você deve enviar o id do seu pacote.

```
public class MyPacket extends Packet {

    private int id;
    
    /**
     * Pode ser substituido por return id, porém é aconselhável atribuir um valor para o pacote
     * @return 
     */
    @Override
    public int getId() {
        return 3;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void handle(DatagramPacket datagramPacket) {
        //Faça seu código aqui
    }
    
}
```

## Projeto exemplo
Link para o projeto exemplo: https://github.com/Arkasher/UDPHandler4JExample

Agora basta executar o projeto
