import java.util.Arrays;
import java.util.Objects;

 class LauraArrayList<E> {

    //atributes
    private Object[] data;
    private int size;
    private int capacity;

    public LauraArrayList() {
        // new Object[capacity] for better flexibility
        this.capacity = 10;
        this.data = new Object[capacity];
        this.size = 0;
    }

    public void add(Object o) {
        if(size == capacity) {
            duplicateCapacity();
        }
        data[size++] = o; //Adiciona o elemento e na posição size do array data.
        //Incrementa o tamanho da lista (size) em 1, já que um novo elemento foi adicionado.
    }

    private void duplicateCapacity() {
        capacity *= 2;

        //cria novo array
        Object[] newArray = new Object[capacity];

        //Copia os elementos do array antigo para o novo array:
        for(int i = 0; i <size; i++){
            System.out.println("copiando arquivo"+data[i]);
            newArray[i] = data[i];
        }

        //Atualiza a referência do array interno:
        data = newArray;

    }

    public void add( int index, Object element ){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Limite fora");
        }

        if(size == capacity){
            duplicateCapacity();
        }

        for (int i = size; i > index; i--){
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public void remove( int index ){
        //primeira coisa- se falar de indice, tem que verificar se ta dentro do indice
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException("Limite fora");
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        // Limpa a referência do último elemento para evitar vazamentos de memória
        data[size - 1] = null;

        // Reduz o tamanho da lista
        size--;
    }

    public boolean remove( Object element ){
        //busca o elemento
        //se data[element] === i
        if(contains(element)){
            int index = indexOf(element);
            remove(index);
            return true;
            // dentro do método remove ele vai: limpa referencia do ultimo elemento, reduz tamanho da list
            // retorna true pois elemento foi removido com sucesso
        }
        return false;
    }

    public void set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        data[index] = element;
    }

    public Object get( int index ){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        return data[index];
    }

    public int indexOf(Object o) {
        //retorna o índice da primeira ocorrência de um objeto específico na lista, ou -1 se não encontrado.
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public Object[] toArray(){
        Object[] array = new Object[size];
        for(int i = 0; i < size; i++) {
            array[i] = data[i];
        }
        return array;
    }

    public boolean contains(Object o){
        return indexOf(o) >= 0;
    }

    //   public boolean contains(Object o) {
//        for (int i = 0; i < size; i++) {
//            if (o.equals(data[i])) {
//                return true;
//            }
//        }
//        return false;
//    }

    public String toString() {
        return Arrays.toString(Arrays.stream(data)
                .filter(Objects::nonNull)
                //Converte o array resultante em uma string formatada
                .toArray());
    }

}
