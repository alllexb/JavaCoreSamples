package ua.kiev.allexb.samples.inheritance.shapes;

/**
 * <p>
 * Данный класс описывает понятие геометрического круга, определяя
 * первоначальные координаты его центра на плоскости. Данный класс наследует
 * абстарактный класс {@link Shape} и предоставляет все public методы класса
 * родителя, адаптируя их к конкретной реализации для круга.
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
public class Circle extends Shape {

	/** Версия класса, используемая при работе с сериализацией */
	private static final long serialVersionUID = 1078080221586652945L;

	/** Радиус круга */
	private int r;

	/**
	 * Конструктор класса {@link Circle} принимающий три параметра.
	 * 
	 * @param x
	 *            координата X цетра круга на плоскости;
	 * @param y
	 *            координата Y центра круга на плоскости;
	 * @param r
	 *            радиус круга.
	 */
	public Circle(int x, int y, int r) {
		super(x, y);
		this.r = r;
	}

	/**
	 * Public метод класса {@link Circle} для работы с кругом.
	 * 
	 * @return радиус круга
	 */
	public int getR() {
		return r;
	}

	/**
	 * Public метод класса {@link Circle} для установки/изменения радиуса круга.
	 * 
	 * @param r
	 *            радиус круга
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * Переопределенный public метод класса {@link Shape} для определения
	 * площади круга.
	 * 
	 * @return площадь круга.
	 */
	@Override
	public double square() {
		return Math.PI * r * r;
	}
}
