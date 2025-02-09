public class Box<T> {
    private T valor;

    public Box(T val) {
        this.valor = val;
    }

    public void setValor(T val){
        valor = val;
    }

    public T getValor(){
        return valor;
    }

    public static void main(String[] args){
        Box<Integer> valorInt = new Box<>(4);

        System.out.println("Valor inteiro: " + valorInt.getValor());
    }

    
}

