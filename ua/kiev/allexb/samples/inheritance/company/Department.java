package ua.kiev.allexb.samples.inheritance.company;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Данный класс наследует абстрактный класс {@link CompanyItem} и определяет
 * понятие - "отдел компании".
 * </p>
 * 
 * @author Alexander Bogomolnyy
 * @author You can see more code by Alexander Bogomolnyy in githab repository:
 *         <a href="https://github.com/alllexb?tab=repositories">https://github.
 *         com/alllexb</a>
 * @version 1.0.0
 * @see CompanyItem
 */
public class Department extends CompanyItem {
	/**
	 * Коллекция, содержащая сотрудников отдела и прочие единицы стуктуры
	 * компании, относящиеся к данному отделу.
	 */
	private List<CompanyItem> companyItems = new ArrayList<>();

	/**
	 * Конструктор класса {@link Department}, принимающий два параметра.
	 * 
	 * @param name
	 *            наименование отдела;
	 * @param id
	 *            уникальный идентификатор отдела.
	 */
	public Department(String name, String id) {
		super(name, id);
	}

	/**
	 * Public метод класса {@link Department} добавляющий единицу компании,
	 * входящую в данный отдел.
	 * 
	 * @param item
	 *            сотрудник отдела или иная единица стуктуры компании,
	 *            относящиеся к данному отделу.
	 */
	public void addCompanyItem(CompanyItem item) {
		companyItems.add(item);
	}

	/**
	 * Public метод класса {@link Department}, возвращающий коллекцию
	 * структурных единиц компании, входящих в данный отдел.
	 * 
	 * @return кллекция структурных единиц компании, входящих в данный отдел.
	 */
	public List<CompanyItem> getCompanyItems() {
		return companyItems;
	}

	/**
	 * Public метод класса {@link Department}, возвращающий значение ежигодных
	 * затрат на отдел. Данное значение вычисляется на основании коллекции
	 * структурных единиц компании, входящих в данный отдел. Данный метод
	 * переопределяет public метод абстрактного класса {@link CompanyItem}.
	 * 
	 * @return значение ежигодных затрат на отдел.
	 */
	@Override
	public double getAnnualCost() {
		// calculation of annual cost
		double itemsAnnualCost = 0;
		for (CompanyItem item : companyItems) {
			itemsAnnualCost += item.getAnnualCost();
		}
		double internalCosts = Math.random() * 100000;
		this.setAnnualCost(itemsAnnualCost + internalCosts);
		return super.getAnnualCost();
	}

}
