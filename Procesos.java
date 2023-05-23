import javax.swing.JOptionPane;

public class Procesos {
	
	String[] nombresArray;
	String[] resultadosArray;
	int contador;
	
	public Procesos() {
		nombresArray = new String[100];
		resultadosArray = new String[100];
		contador = 0;
		iniciar();
	}
		
	public void iniciar() {
		System.out.println("Ingresa");

		int opcion;
		do {
			opcion = mostrarMenu();
			switch (opcion) {
				case 1:
					ingresarDatos();
					calcularIMC();
					break;
				case 2:
					imprimirListas();
					break;
				case 3:
					consultarPorNombre();
					break;
				case 4:
					System.out.println("¡Hasta luego!");
					break;
				default:
					System.out.println("Opción inválida. Por favor, selecciona una opción válida del menú.");
					break;
			}
		} while (opcion != 4);
	}
	
	private int mostrarMenu() {
		String mensaje = "Seleccione una opción:\n" +
						 "1. Ingresar datos\n" +
						 "2. Imprimir listas\n" +
						 "3. Consultar por nombre\n" +
						 "4. Salir";
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}
	
	private void consultarPorNombre() {
		String nombreConsulta = JOptionPane.showInputDialog("Ingrese el nombre a buscar");

		boolean encontrado = false;
		for (int i = 0; i < contador; i++) {
			if (nombresArray[i].equalsIgnoreCase(nombreConsulta)) {
				System.out.println("Si existe " + nombreConsulta + ", tiene " + resultadosArray[i]);
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("NO existe");
		}
	}

	public void imprimirListas() {
		System.out.println("********RESULTADOS**********");
		for (int i = 0; i < contador; i++) {
			System.out.println(nombresArray[i] + ", resultado: " + resultadosArray[i]);
		}
		System.out.println("*****************************");
	}

	private void ingresarDatos() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
		double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
		double talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));
		
		nombresArray[contador] = nombre;
		contador++;
	}

	private void calcularIMC() {
		double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
		double talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));
		double imc = peso / (talla * talla);
		System.out.println("El IMC es: " + imc);
		
		String result = "";
		
		if (imc < 18) {
			result = "Anorexia";
		} else if (imc >= 18 && imc < 20) {
			result = "Delgadez";
		} else if (imc >= 20 && imc < 27) {
			result = "Normalidad";
		} else if (imc >= 27 && imc < 30) {
			result = "Obesidad 1";
		} else if (imc >= 30 && imc < 35) {
			result = "Obesidad 2";
		} else if (imc >= 35 && imc < 40) {
			result = "Obesidad 3";
		} else if (imc >= 40) {
			result = "Obesidad Morbida";
		}

		resultadosArray[contador - 1] = result;
		System.out.println("El Resultado es: " + result);
	}
}
