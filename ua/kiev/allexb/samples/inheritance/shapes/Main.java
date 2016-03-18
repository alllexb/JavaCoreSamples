package ua.kiev.allexb.samples.inheritance.shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Данный класс демонстрирует возможности работы с класcами
 * {@link ShapeProcessor}, {@link Shape}, {@link Circle}, {@link Rectangle}.
 * </p>
 * 
 * @author Alexander Bogomolnyy
 * @author You can see more code by Alexander Bogomolnyy in githab repository:
 *         <a href="https://github.com/alllexb?tab=repositories">https://github.
 *         com/alllexb</a>
 * @version 1.0.0
 * @see Shape
 * @see Circle
 * @see Rectangle
 * @see ShapeProcessor
 */
public class Main {

	/**
	 * Точка входа для запуска программы.
	 * 
	 * @param args
	 *            не используются в коде данного метода.
	 */
	public static void main(String[] args) {
		// путь к файлу хранения/чтения данных
		String file = "./src/main/java/ua/kiev/allexb/samples/inheritance/shapes/source/objects.dat";

		// коллекция геометрических фигур
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Rectangle(0, 0, 10, 10));
		shapes.add(new Circle(5, 5, 10));
		shapes.add(new Rectangle(10, 10, 7, 18));
		shapes.add(new Circle(15, -5, 4));

		// инициализация класса работы с коллекциями геометрических фигур
		ShapeProcessor processor = new ShapeProcessor();
		// добавление всех фигур во внутреннюю колекцию объекта processor
		processor.addAllShapes(shapes);
		// добавление отдельной фигуры во внутреннюю колекцию объекта processor
		processor.addShape(new Circle(-5, 25, 8));
		// вывод всех фигур внутренней коллекции объекта processor в консоль
		processor.display();
		System.out.println();

		// попытка записи всех фигур внутренней коллекция объекта processor в
		// файл
		if (processor.exportToFile(file)) {
			System.out.println("Data export to file completed successful!");
		} else {
			System.out.println("Something wrong with data source. Data wasn't exported.");
		}

		// очистка внутренней коллекции объекта processor
		processor.removeAll();
		// попытка вывода пустой внутренней коллекции объекта processor в
		// консоль
		processor.display();

		// попытка заполнения внутренней коллекция объекта processor из файл
		if (processor.addFromFile(file)) {
			System.out.println("Data import from file completed successful!");
			System.out.println();
			processor.display();
		} else {
			System.out.println("Something wrong with data source. Data wasn't downloaded.");
		}

		System.out.println();
		// поиск элемента с максимальной площадью во внутренней коллекции
		// объекта processor
		Shape max = processor.getMaxBySquere();
		System.out.println("Shape with maximal square: " + max.toString());
		// перемещение объекта с максимальной площадью на плоскости в позицию с
		// координатами (15,15)
		max.moveTo(15, 15);
		System.out.println("Shape with maximal square after moving: " + max.toString());
		System.out.println();

		// сортировка внутренней коллекции объекта processor в порядке
		// возрастания площадей фигур
		processor.upSort();
		// вывод всех фигур внутренней коллекции объекта processor в консоль
		// после сортировки
		processor.display();

		System.out.println();

		// сортировка внутренней коллекции объекта processor в порядке убывания
		// площадей фигур
		processor.downSort();
		// вывод всех фигур внутренней коллекции объекта processor в консоль
		// после сортировки
		processor.display();

	}
}
