import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        calculationInArray(4, 4);
        calculationInMatrix(4, 4);
    }

    public static void calculationInArray(int N, int M) {//N - количество символов от 0 до N-1, M - количество элементов массива
        String[] symbolArray = new String[N];//массив допустимых символов
        for (int i = 0; i < N; i++) {
            symbolArray[i] = String.valueOf(i);//заполнение массива символами 0..N
        }
        BigInteger[] pow = new BigInteger[(M + 1)];//массив для степеней числа N
        pow[0] = new BigInteger("1");
        for (int i = 1; i <= M; i++) {
            pow[i] = new BigInteger(String.valueOf(pow[(i - 1)].multiply(BigInteger.valueOf(N))));//вычисление количества комбинаций
        }
        //перебор всех комбинаций
        for (BigInteger i = new BigInteger(String.valueOf(0)); i.compareTo(pow[M]) < 0; i = i.add(BigInteger.valueOf(1))) {
            String[] arr = new String[M];
            //вычисляем элементы комбинации
            for (int j = 0; j < M; j++) {
                arr[j] = symbolArray[((i.divide(pow[j])).mod(BigInteger.valueOf(N))).intValue()];
            }
            //вывод в консоль
            for (String ch : arr) {
                System.out.print(ch + " ");
            }
            System.out.println("\nНомер комбинации: " + i);
        }
    }

    public static void calculationInMatrix(int N, int M) {//N - количество символов от 0 до N-1, M - количество элементов массива
        if ((Math.sqrt(M)) % 1 != 0) {
            return;//если из элементов не построить матрицу - return
        }
        int length = (int) Math.sqrt(M);
        String[] symbolArray = new String[N];//массив допустимых символов
        for (int i = 0; i < N; i++) {
            symbolArray[i] = String.valueOf(i);//заполнение массива символами 0..N
        }
        BigInteger[] pow = new BigInteger[(M + 1)];//массив для степеней числа N
        pow[0] = new BigInteger("1");
        for (int i = 1; i <= M; i++) {
            pow[i] = new BigInteger(String.valueOf(pow[(i - 1)].multiply(BigInteger.valueOf(N))));//вычисление количества комбинаций
        }
        //перебор всех комбинаций
        for (BigInteger i = new BigInteger(String.valueOf(0)); i.compareTo(pow[M]) < 0; i = i.add(BigInteger.valueOf(1))) {
            String[][] arr = new String[length][length];
            //вычисляем элементы комбинации
            for (int j = 0; j < M; j++) {
                int i1 = ((i.divide(pow[j])).mod(BigInteger.valueOf(N))).intValue();
                if (j < length) {
                    arr[0][j] = symbolArray[i1];
                } else {
                    arr[j / length][j % length] = symbolArray[i1];
                }
            }
            for (int j = 0; j < length; j++) {
                System.out.println();
                for (int k = 0; k < length; k++) {
                    System.out.printf("[%s]", arr[j][k]);
                }
            }
            System.out.println("\nНомер комбинации: " + i);
        }
    }
}
