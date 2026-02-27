    package clasesGenericas;

    import java.util.Arrays;

    public class ListaGenerica<T> {
        private T[] elementos;
        private int numElementos;
        private static final int CAPACIDAD_INICIAL = 5;

        public ListaGenerica() {
            elementos = (T[]) new Object[CAPACIDAD_INICIAL];
            this.numElementos = 0;
        }

        public void agregarElemento(T elemento) {
            asegurarCapacidad();
            elementos[numElementos] = elemento;
            numElementos++;
        }

        @SuppressWarnings("unchecked")
        private void asegurarCapacidad() {
            if (numElementos >= elementos.length) {
                int nuevaCapacidad = elementos.length + 20;
                T[] nuevoArray = Arrays.copyOf(elementos, nuevaCapacidad);
                elementos = nuevoArray;
            }
        }

        @Override
        public String toString() {
            String arrayPrint = "[";
            for(int i = 0; i < numElementos; i++) {
                arrayPrint += elementos[i];
                if(i < numElementos - 1) {
                    arrayPrint += ", ";
                }
            }
            return arrayPrint + "]";
        }
    }
