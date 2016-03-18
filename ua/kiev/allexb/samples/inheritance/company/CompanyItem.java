package ua.kiev.allexb.samples.inheritance.company;

/**
 * <p>
 * Данный абстрактный класс описывает абстрактное понятие структурной единицы
 * компании. Он содержит в себе информацию об имени единицы, ее уникальном
 * идентификаторе и ежигодных затратах на нее.
 * </p>
 * 
 * @author Alexander Bogomolnyy
 * @author You can see more code by Alexander Bogomolnyy in githab repository:
 *         <a href="https://github.com/alllexb?tab=repositories">https://github.
 *         com/alllexb</a>
 * @version 1.0.0
 */
public abstract class CompanyItem {
	/** Имя структурной единицы */
	private String name;
	/** Уникальный идентификатор структурной единицы */
	private String id;
	/** Ежигодные затраты на структурную единицицу */
	private double annualCost;

	/**
	 * Конструктор класса {@link CompanyItem}, принимающий два параметра.
	 * 
	 * @param name
	 *            имя структурной единицы;
	 * @param id
	 *            уникальный идентификатор структурной единицы.
	 */
	public CompanyItem(String name, String id) {
		this.name = name;
		this.id = id;
	}

	/**
	 * Public метод класса {@link CompanyItem}, возвращающий имя структурной
	 * единицы компании.
	 * 
	 * @return имя структурной единицы.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Public метод класса {@link CompanyItem}, возвращающий уникальный
	 * идентификатор структурной единицы компании.
	 * 
	 * @return уникальный идентификатор структурной единицы.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Protected метод класса {@link CompanyItem} для установки значения
	 * ежигодных затрат на структурную единицу компании.
	 * 
	 * @param annualCost
	 *            значение ежигодных затрат на структурную единицу.
	 */
	protected void setAnnualCost(double annualCost) {
		this.annualCost = annualCost;
	}

	/**
	 * Public метод класса {@link CompanyItem}, возвращающий значение ежигодных
	 * затрат на структурную единицу компании.
	 * 
	 * @return значение ежигодных затрат на структурную единицу.
	 */
	public double getAnnualCost() {
		return annualCost;
	};

}
