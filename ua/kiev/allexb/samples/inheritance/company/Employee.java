package ua.kiev.allexb.samples.inheritance.company;

/**
 * <p>
 * Данный класс наследует абстрактный класс {@link CompanyItem} и определяет
 * понятие - "сотрудник компании".
 * </p>
 * 
 * @author Alexander Bogomolnyy
 * @author You can see more code by Alexander Bogomolnyy in githab repository:
 *         <a href="https://github.com/alllexb?tab=repositories">https://github.
 *         com/alllexb</a>
 * @version 1.0.0
 * @see CompanyItem
 */
public class Employee extends CompanyItem {

	/**
	 * Конструктор класса {@link Employee}, принимающий три параметра.
	 * 
	 * @param name
	 *            имя сотрудника;
	 * @param id
	 *            уникальный идентификатор сотрудника;
	 * @param annualCost
	 *            ежигодные затраты на сотрудникаю.
	 */
	public Employee(String name, String id, double annualCost) {
		super(name, id);
		this.setAnnualCost(annualCost);
	}

	/**
	 * Public метод класса {@link Employee} для установки значения ежигодных
	 * затрат на структурную единицу компании. Данный метод переопределяет
	 * protected метод абстрактного класса {@link CompanyItem}, расширяя область
	 * его видимости до public.
	 * 
	 * @param annualCost
	 *            значение ежигодных затрат на сотрудника.
	 */
	@Override
	public void setAnnualCost(double annualCost) {
		super.setAnnualCost(annualCost);
	}

}
