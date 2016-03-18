package ua.kiev.allexb.samples.inheritance.shapes;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * <p>
 * Данный класс описывает абстрактное понятие геометрической фигуры, определяя
 * ее первоначальные координаты на плоскости и предлагая три основных public
 * метода по работе с данной фигурой. Метод {@link #move(int, int)} позволяет
 * перемещать фигуру на плоскости, используя смещение координат на указанное
 * значение по осям X и Y, метод {@link #moveTo(int, int)} позволяет перемещать
 * фигуру в указанное положение на плоскости, используя координаты по осям X и
 * Y, метод {@link #square()} возвращает площадь фигуры. Метод {@link #square()}
 * является абстрактным и требует переопределения для конкретного типа фигур.
 * </p>
 * <p>
 * Данный клас имплементирует интерфейс {@link java.io.Serializable
 * Serializable}, что дает возможность выполнять его серриализацию для
 * дальнейшего использования в потоках объектного вывода/ввода.
 * </p>
 * <p>
 * Данный клас имплементирует интерфейс {@link java.lang.Comparable Comparable},
 * что дает возможность хранить данный объект в коллекциях, поддерживающих
 * упорядоченное хранение данных, а также выполнять сортировку коллекция
 * объектов класса {@link Shape} с использованием инструментов предлагаемых в
 * {@link java.util.Collections Collections}. Спавнение выполняется по площади
 * фигур.
 * </p>
 * 
 * @author Alexander Bogomolnyy
 * @author You can see more code by Alexander Bogomolnyy in githab repository:
 *         <a href="https://github.com/alllexb?tab=repositories">https://github.
 *         com/alllexb</a>
 * @version 1.0.0
 * @see java.io.Serializable Serializable
 * @see java.lang.Comparable Comparable
 */
public abstract class Shape implements Serializable, Comparable<Shape> {

	/** Версия класса, используемая при работе с сериализацией */
	private static final long serialVersionUID = -181624374322872567L;

	/** Координата X объекта на плоскости */
	private int x;
	/** Координата Y объекта на плоскости */
	private int y;

	/**
	 * Конструктор класса {@link Shape} принимающий два параметра.
	 * 
	 * @param x
	 *            координата X объекта на плоскости;
	 * @param y
	 *            координата Y объекта на плоскости;
	 */
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Абстрактный метод определения площади фигуры. Требует переопределения в
	 * класса наследниках.
	 * 
	 * @return площадь фигуры.
	 */
	public abstract double square();

	/**
	 * Public метод класса {@link Shape}, предназначен для смещения фигуры на
	 * плоскости, на определенное значение координат по осям X и Y.
	 * 
	 * @param x
	 *            смещение объекта на плоскости по оси X;
	 * @param y
	 *            смещение объекта на плоскости по оси Y;
	 */
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Public метод класса {@link Shape}, предназначен для перемещения фигуры в
	 * указанное место на плоскости, согласно координат X и Y.
	 * 
	 * @param x
	 *            координата X объекта на плоскости;
	 * @param y
	 *            координата Y объекта на плоскости;
	 */
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Public метод класса {@link Shape} для работы с координатами по оси X.
	 * 
	 * @return координату по оси X для данной фигуры
	 */
	public int getX() {
		return x;
	}

	/**
	 * Public метод класса {@link Shape} для работы с координатами по оси Y.
	 * 
	 * @return координату по оси Y для данной фигуры
	 */
	public int getY() {
		return y;
	}

	/**
	 * Public метод интерфейса {@link java.lang.Comparable Comparable},
	 * возвращающий 0 - при равенстве площадей фигур, число <0 - когда площадь
	 * фигуры, переданной в параметре, больше площади данной фигуры, число >0 -
	 * когда площадь фигуры, переданной в параметре, меньше площади данной
	 * фигуры.
	 * 
	 * @param shape
	 *            фигура для сравнения, должна быть объектом класса
	 *            {@link Shape} или его наследника.
	 * @return 0 - при равенстве площадей фигур; <0 - при условии, что площадь
	 *         фигуры, переданной в параметре, больше площади данной фигуры; >0
	 *         - при условии, что площадь фигуры, переданной в параметре, меньше
	 *         площади данной фигуры.
	 */
	@Override
	public int compareTo(Shape shape) {
		return (int) (this.square() - shape.square());
	}

	/**
	 * Переопределенный public метод класса {@link Object} для представления
	 * состояния объекта в виде, удобном для восприятия пользователем .
	 * 
	 * @return строку в формате "Shape [type = 'наименование типа объекта' ", x
	 *         = 'координата X', y = 'координата Y'
	 *         ", square = 'площадь фигуры']"
	 */
	@Override
	public String toString() {
		String square = new DecimalFormat("####.##").format(square());
		return "Shape [type = " + getClass().getSimpleName() + ", x = " + x + ", y = " + y + ", square = " + square
				+ "]";
	}

}
