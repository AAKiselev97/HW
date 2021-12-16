import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        calculationInArray(4, 4);
        calculationInMatrix(4, 4);
    }

    public static void calculationInArray(int sum, int element) {
        String[] symbolArray = new String[sum];//массив допустимых символов
        for (int i = 0; i < sum; i++) {
            symbolArray[i] = String.valueOf(i);//заполнение массива символами 0..sum
        }
        BigInteger[] pow = new BigInteger[(element + 1)];//массив для степеней числа sum
        pow[0] = new BigInteger("1");
        for (int i = 1; i <= element; i++) {
            pow[i] = new BigInteger(String.valueOf(pow[(i - 1)].multiply(BigInteger.valueOf(sum))));//вычисление количества комбинаций
        }
        //перебор всех комбинаций
        for (BigInteger i = new BigInteger(String.valueOf(0)); i.compareTo(pow[element]) < 0; i = i.add(BigInteger.valueOf(1))) {
            String[] arr = new String[element];
            //вычисляем элементы комбинации
            for (int j = 0; j < element; j++) {
                arr[j] = symbolArray[((i.divide(pow[j])).mod(BigInteger.valueOf(sum))).intValue()];
            }
            //вывод в консоль
            for (String ch : arr) {
                System.out.print(ch + " ");
            }
            System.out.println("\nНомер комбинации: " + i);
        }
    }

    public static void calculationInMatrix(int sum, int element) {
        if ((Math.sqrt(element)) % 1 != 0) {
            return;//если из элементов не построить матрицу - return
        }
        int N = (int) Math.sqrt(element);
        String[] symbolArray = new String[sum];//массив допустимых символов
        for (int i = 0; i < sum; i++) {
            symbolArray[i] = String.valueOf(i);//заполнение массива символами 0..sum
        }
        BigInteger[] pow = new BigInteger[(element + 1)];//массив для степеней числа sum
        pow[0] = new BigInteger("1");
        for (int i = 1; i <= element; i++) {
            pow[i] = new BigInteger(String.valueOf(pow[(i - 1)].multiply(BigInteger.valueOf(sum))));//вычисление количества комбинаций
        }
        //перебор всех комбинаций
        for (BigInteger i = new BigInteger(String.valueOf(0)); i.compareTo(pow[element]) < 0; i = i.add(BigInteger.valueOf(1))) {
            String[][] arr = new String[N][N];
            //вычисляем элементы комбинации
            for (int j = 0; j < element; j++) {
                int i1 = ((i.divide(pow[j])).mod(BigInteger.valueOf(sum))).intValue();
                if (j < N) {
                    arr[0][j] = symbolArray[i1];
                } else {
                    arr[j / N][j % N] = symbolArray[i1];
                }
            }
            for (int j = 0; j < N; j++) {
                System.out.println();
                for (int k = 0; k < N; k++) {
                    System.out.printf("[%s]", arr[j][k]);
                }
            }
            System.out.println("\nНомер комбинации: " + i);
        }
    }
}
