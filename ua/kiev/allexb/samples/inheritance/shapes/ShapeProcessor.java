package ua.kiev.allexb.samples.inheritance.shapes;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * Данный класс хранит в себе коллекцию объектов класса {@link Shape} и
 * предоставлет методы для заполнения этой поллекция одиночными оъектами,
 * коллекциями объектов полученных в качестве параметров метода, а также
 * загрузку, серриализованых в файл, объектов из файла по его имени. Дает
 * возможность определить объект с минимальной площадью и отсоритовать объекты
 * по площади в порядке ее возрастания/убывания. Предоставляет методы очиски
 * содерживого хранимой коллекции, а также вывода содержимого в консоль.
 * </p>
 * 
 * @author Alexander Bogomolnyy
 * @author You can see more code by Alexander Bogomolnyy in githab repository:
 *         <a href="https://github.com/alllexb?tab=repositories">https://github.
 *         com/alllexb</a>
 * @version 1.0.0
 * @see Shape
 * @see java.util.Collections Collections
 */
public class ShapeProcessor {
	/** Коллекция хранимых объектов */
	private List<Shape> shapes = null;

	/**
	 * Конструктор без параметров класса {@link ShapeProcessor}. Инициализирует
	 * внутреннюю колекцию занного класса как {@link ArrayList}.
	 */
	public ShapeProcessor() {
		shapes = new ArrayList<>();
	}

	/**
	 * Конструктор класса {@link ShapeProcessor}, принимающий на вход коллекцию
	 * объектов класса {@link Shape}, реализующую интерфейс {@link List}.
	 * 
	 * @param shapes
	 *            коллекция объектов класса {@link Shape}, реализующая интерфейс
	 *            {@link List}.
	 */
	public ShapeProcessor(List<Shape> shapes) {
		this.shapes = shapes;
	}

	/**
	 * Public метод класса {@link ShapeProcessor} для добавления одного элемента
	 * во внутреннюю колекцию данного класса.
	 * 
	 * @param shape
	 *            объект класса {@link Shape} или его наследник.
	 */
	public void addShape(Shape shape) {
		this.shapes.add(shape);
	}

	/**
	 * Public метод класса {@link ShapeProcessor} для добавления коллекции
	 * элементов во внутреннюю колекцию данного класса.
	 * 
	 * @param shapes
	 *            коллекция объектов класса {@link Shape} или его наследников,
	 *            реализующая интерфейс {@link Collection}.
	 */
	public void addAllShapes(Collection<Shape> shapes) {
		this.shapes.addAll(shapes);
	}

	/**
	 * Public метод класса {@link ShapeProcessor} для добавления элементов
	 * хранящихся в файле. Файл должен быть создан на основе сериализованых
	 * объектов класса {@link Shape} или его наследников.
	 * 
	 * @param filePath
	 *            путь к файлу, хранящему данные об объектах класса
	 *            {@link Shape} или его наследникиках.
	 * @return true - в случае удачного выполнения операции чтения файла и
	 *         сохранения данных во внутреннюю колекцию данного класса; false -
	 *         в случае возникновения ошибок связаных с поиском файла, чтением
	 *         файла или форматом данных в файле.
	 */
	public boolean addFromFile(String filePath) {
		ObjectInputStream ois = null;
		List<Shape> shapes = new ArrayList<>();
		try {
			ois = new ObjectInputStream(new FileInputStream(filePath));
			Shape object = null;
			do {
				object = (Shape) ois.readObject();
				shapes.add(object);
			} while (true);
		} catch (StreamCorruptedException ex) {
			return false;
		} catch (EOFException ex) {
			if (shapes.isEmpty()) {
				return false;
			} else {
				this.addAllShapes(shapes);
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * Public метод класса {@link ShapeProcessor} для записи данных об объектах
	 * хранящихся в коллекции в файл. Коллекция записываемых объектов поступает
	 * в качестве параметра к методу. Коллекция должна содержать объекты класса
	 * {@link Shape} или его наследников. В файл записываются объекты в
	 * серриализованом виде.
	 * 
	 * @param filePath
	 *            путь к файлу для записи.
	 * @param shapes
	 *            коллекция объектов класса {@link Shape} или его наследников.
	 * @return true - в случае удачного выполнения операции записи в файл; false
	 *         - в случае возникновения ошибок связаных с поиском места
	 *         расположения файла или доступом к файлу, а также в случае попытки
	 *         записи коллекции не содержащей ни одного элемента или коллекции,
	 *         которая не существует - null.
	 */
	public boolean exportToFile(String filePath, Collection<Shape> shapes) {
		if (shapes == null || shapes.isEmpty()) {
			return false;
		}
		ObjectOutputStream oout = null;
		try {
			oout = new ObjectOutputStream(new FileOutputStream(filePath));
			for (Shape shape : shapes) {
				oout.writeObject(shape);
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oout != null) {
				try {
					oout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * Public метод класса {@link ShapeProcessor} для записи данных об объектах
	 * хранящихся во внутренней коллекции данного класса в файл. В файл
	 * записываются объекты в серриализованом виде.
	 * 
	 * @param filePath
	 *            путь к файлу для записи.
	 * 
	 * @return true - в случае удачного выполнения операции записи в файл; false
	 *         - в случае возникновения ошибок связаных с поиском места
	 *         расположения файла или доступом к файлу, а также в случае попытки
	 *         записи коллекции не содержащей ни одного элемента.
	 */
	public boolean exportToFile(String filePath) {
		return this.exportToFile(filePath, this.shapes);
	}

	/**
	 * Public метод класса {@link ShapeProcessor}, возвращающий ссылку на
	 * внутреннюю коллекцию данного класса.
	 * 
	 * @return ссылку на внутреннюю коллекцию данного класса.
	 */
	public List<Shape> getShapes() {
		return shapes;
	}

	/**
	 * Public метод класса {@link ShapeProcessor}, возвращающий ссылку на
	 * элемент внутренней коллекции с максимальной площадью.
	 * 
	 * @return элемент с максимальной площадью; null - в случае отсутствия
	 *         элементов в коллекции.
	 */
	public Shape getMaxBySquere() {
		if (shapes.isEmpty()) {
			return null;
		}
		return Collections.max(shapes);
	}

	/**
	 * Public метод класса {@link ShapeProcessor}, удаляющий все элементы из
	 * внутреней коллекции данного класса.
	 */
	public void removeAll() {
		Iterator<Shape> iterator = this.shapes.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}

	/**
	 * Public метод класса {@link ShapeProcessor}, выводящий в консоль все
	 * элементы внутеренней коллекции данного класса. В случае пустой коллекции
	 * выводиться информационное сообщение о том, что внутренняя коллекция
	 * пуста.
	 */
	public void display() {
		if (shapes.isEmpty()) {
			System.out.println("Inner collection is empty!");
		} else {
			for (Shape shape : shapes) {
				System.out.println(shape.toString());
			}
		}
	}

	/**
	 * Public метод класса {@link ShapeProcessor}, выводящий сортировку элементов
	 * внутренней коллекции данного класса в порядке убывания площадей
	 * содержащихся в ней фигур.
	 */
	public void downSort() {
		Collections.sort(this.shapes, new Comparator<Shape>() {
			// компаратор, для реверса последовательности расположения элементов
			// базируется на метода compareTo класса Shape
			@Override
			public int compare(Shape shape1, Shape shape2) {
				return 0 - shape1.compareTo(shape2);
			}
		});
	}

	/**
	 * Public метод класса {@link ShapeProcessor}, выводящий сортировку элементов
	 * внутренней коллекции данного класса в порядке возрастания площадей
	 * содержащихся в ней фигур.
	 */
	public void upSort() {
		Collections.sort(this.shapes);
	}
}
