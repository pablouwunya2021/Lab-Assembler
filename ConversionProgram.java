import java.util.Scanner;

public class ConversionProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Convertir número entero a binario de 8 bits");
            System.out.println("2. Convertir número binario de 8 bits a complemento a dos");
            System.out.println("3. Convertir número hexadecimal de 3 dígitos a decimal");
            System.out.println("4. Convertir número decimal a hexadecimal de 3 dígitos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            
            switch(option) {
                case 1:
                    System.out.print("Ingrese un número entero: ");
                    int num = scanner.nextInt();
                    System.out.println("El número en binario de 8 bits es: " + convertirABinario(num));
                    break;
                case 2:
                    System.out.print("Ingrese un número binario de 8 bits: ");
                    String binario = scanner.next();
                    System.out.println("El complemento a dos es: " + complementoADos(binario));
                    break;
                case 3:
                    System.out.print("Ingrese un número hexadecimal de 3 dígitos: ");
                    String hex = scanner.next();
                    System.out.println("El número en decimal es: " + convertirADecimal(hex));
                    break;
                case 4:
                    System.out.print("Ingrese un número decimal que pueda representarse con 3 dígitos hexadecimales: ");
                    int decimal = scanner.nextInt();
                    System.out.println("El número en hexadecimal es: " + convertirAHexadecimal(decimal));
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
            
        } while(option != 5);
        
        scanner.close();
    }
    
    // Método para convertir un número entero a binario de 8 bits
    public static String convertirABinario(int num) {
        String binario = Integer.toBinaryString(num);
        if (binario.length() < 8) {
            // Agregar ceros a la izquierda si el número binario tiene menos de 8 bits
            binario = String.format("%08d", Integer.parseInt(binario));
        }
        return binario;
    }
    
    // Método para convertir un número binario de 8 bits a complemento a dos
    public static String complementoADos(String binario) {
        // Si el número es positivo, simplemente se devuelve tal cual
        if (binario.charAt(0) == '0') {
            return binario;
        } else {
            // Si es negativo, se calcula el complemento a uno y luego se suma 1
            StringBuilder complemento = new StringBuilder();
            for (int i = 0; i < binario.length(); i++) {
                complemento.append(binario.charAt(i) == '0' ? '1' : '0');
            }
            int carry = 1;
            for (int i = complemento.length() - 1; i >= 0; i--) {
                if (complemento.charAt(i) == '1' && carry == 1) {
                    complemento.setCharAt(i, '0');
                } else if (complemento.charAt(i) == '0' && carry == 1) {
                    complemento.setCharAt(i, '1');
                    carry = 0;
                }
            }
            return complemento.toString();
        }
    }
    
    // Método para convertir un número hexadecimal de 3 dígitos a decimal
    public static int convertirADecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }
    
    // Método para convertir un número decimal a hexadecimal de 3 dígitos
    public static String convertirAHexadecimal(int decimal) {
        return String.format("%03X", decimal);
    }
}
