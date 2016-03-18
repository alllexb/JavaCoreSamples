package ua.kiev.allexb.samples.inheritance.company;

import java.text.DecimalFormat;

/**
 * <p>
 * Данный класс демонстрирует возможности работы с класcами {@link CompanyItem},
 * {@link Employee}, {@link Department}.
 * </p>
 * 
 * @author Alexander Bogomolnyy
 * @author You can see more code by Alexander Bogomolnyy in githab repository:
 *         <a href="https://github.com/alllexb?tab=repositories">https://github.
 *         com/alllexb</a>
 * @version 1.0.0
 * @see CompanyItem
 * @see Employee
 * @see Department
 */
public class Main {

	public static void main(String[] args) {
		// создание нескольких структурных единиц компании на основе сотрудников
		CompanyItem employee = new Employee("Mike", "pd-10001", 45054.87);
		CompanyItem employee1 = new Employee("Jime", "pd-10856", 12054.87);
		CompanyItem employee2 = new Employee("Jake", "pd-10732", 10054.87);
		CompanyItem employee3 = new Employee("Jil", "pd-10548", 19554.87);
		// создание структурной единицы компании на основе отдела
		CompanyItem department = new Department("Developers", "pd-10000");
		// добавление нескольких сотрудников в отдел
		((Department) department).addCompanyItem(employee1);
		((Department) department).addCompanyItem(employee2);
		((Department) department).addCompanyItem(employee3);
		// ввод ежигодных расходов на одного из сотрудников компании и на один
		// из ее отделов
		System.out.println("Enployee annual cost: " + new DecimalFormat("$#####.##").format(employee.getAnnualCost()));
		System.out.println("Department annual cost: " + new DecimalFormat("$#####.##").format(department.getAnnualCost()));
	}

}
