package ua.kiev.allexb.samples.inheritance.shapes;

/**
 * <p>
 * Данный класс описывает понятие геометрического прямоугольника, определяя
 * первоначальные координаты левой верхней вершины на плоскости. Данный класс
 * наследует абстарактный класс {@link Shape} и предоставляет все public методы
 * класса родителя, адаптируя их к конкретной реализации для прямоугольника.
 * </p>
 * <p>
 * Данный клас имплементирует интерфейс {@link java.io.Serializable
 * Serializable}, что дает возможность выполнять его серриализацию для
 * дальнейшего использования в потоках объектного вывода/ввода.
 * </p>
 * 
 * @author Alexander Bogomolnyy
 * @author You can see more code by Alexander Bogomolnyy in githab repository:
 *         <a href="https://github.com/alllexb?tab=repositories">https://github.
 *         com/alllexb</a>
 * @version 1.0.0
 * @see java.io.Serializable Serializable
 * @see Shape
 */
public class Rectangle extends Shape {
	/** Версия класса, используемая при работе с сериализацией */
	private static final long serialVersionUID = -2508643841117415747L;
	/** Ширина прямоугольника */
	private int wight;
	/** Высота прямоугольника */
	private int hight;

	/**
	 * Конструктор класса {@link Rectangle} принимающий четыре параметра.
	 * 
	 * @param x
	 *            координата X левой верхней вершины прямоугольника на
	 *            плоскости;
	 * @param y
	 *            координата Y левой верхней вершины прямоугольника на
	 *            плоскости;
	 * @param wight
	 *            ширина прямоугольника;
	 * @param hight
	 *            высота прямоугольника;
	 */
	public Rectangle(int x, int y, int wight, int hight) {
		super(x, y);
		this.wight = wight;
		this.hight = hight;
	}

	/**
	 * Public метод класса {@link Rectangle}} для работы с прямоугольником.
	 * 
	 * @return ширину прямоугольника
	 */
	public int getWight() {
		return wight;
	}

	/**
	 * Public метод класса {@link Rectangle} для установки/изменения ширины прямоугольника.
	 * 
	 * @param wight
	 *            ширина прямоугольника
	 */
	public void setWight(int wight) {
		this.wight = wight;
	}

	/**
	 * Public метод класса {@link Rectangle}} для работы с прямоугольником.
	 * 
	 * @return высоту прямоугольника
	 */
	public int getHight() {
		return hight;
	}

	/**
	 * Public метод класса {@link Rectangle} для установки/изменения высоты прямоугольника.
	 * 
	 * @param hight
	 *            высота прямоугольника
	 */
	public void setHight(int hight) {
		this.hight = hight;
	}

	/**
	 * Переопределенный public метод класса {@link Shape} для определения
	 * площади прямоугольника.
	 * 
	 * @return площадь прямоугольника.
	 */
	@Override
	public double square() {
		return wight * hight;
	}

}
