package learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmpoyeeTest {

	public static void main(String[] args) {
		EmployeeWithComparable emp1 = new EmployeeWithComparable("Neeraj", 36, 4200);
		EmployeeWithComparable emp2 = new EmployeeWithComparable("Amit", 38, 430);
		EmployeeWithComparable emp3 = new EmployeeWithComparable("Anil", 43, 4800);

		List<EmployeeWithComparable> empList = new ArrayList<>();

		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		Comparator<EmployeeWithComparable> compEmployeeByAge = (x, y) -> {

			return x.getAge() == y.getAge() ? 0 : x.getAge() < y.getAge() ? -1 : 1;

		};

		Comparator<EmployeeWithComparable> compEmployeeBySalary = (x, y) -> {

			return x.getSalary() == y.getSalary() ? 0 : x.getSalary() < y.getSalary() ? 1 : -1;

		};

		Collections.sort(empList);
		
		System.out.println("#########################################");
		System.out.println("Employee sorted by name");

		empList.forEach(System.out::println);

		Collections.sort(empList, compEmployeeBySalary);
		System.out.println("#########################################");
		System.out.println("Employee sorted by Salary");
		
		empList.forEach(System.out::println);
		System.out.println("#########################################");
		System.out.println("Employee sorted by Age");
		
		Collections.sort(empList, compEmployeeByAge);

		empList.forEach(System.out::println);

		// =========================================================================================================================//

		// Map - Function Usage

		Function<EmployeeWithComparable, EmployeeWithComparable> increaseSalary = (e) -> {
			e.setSalary((float) (e.getSalary() * 1.10));
			return e;
		};
		
		empList= empList.parallelStream().map(increaseSalary).collect(Collectors.toList());
		System.out.println("#########################################");
		System.out.println("Employee salary Increased");
		empList.forEach(System.out::println);
		
		// Filter - Predicate Usage : Keep employees <= 40
		
		Predicate<EmployeeWithComparable> youngEmployees = e -> e.getAge() <= 40;
		
		System.out.println("#########################################");
		System.out.println("Young Employee <= 40");
		
		empList= empList.parallelStream().filter(youngEmployees).collect(Collectors.toList());
		
		empList.forEach(System.out::println);
		
		// For Each - Consumer Usage
		
		Consumer<EmployeeWithComparable> displayEmployeeNameOnly = e -> System.out.println(e.getName());
		
		System.out.println("#########################################");
		System.out.println("Print Names of Employees");
		
		empList.forEach(displayEmployeeNameOnly);
		
		// Reduce - BinaryOperator Usage
		
		List<Integer> integers = new ArrayList<>();
		
		integers.add(0);
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		integers.add(5);
		
		
		BinaryOperator<Integer> sumAccumulator = (x,y) -> x+y;
		
		Optional<Integer> reduce = integers.parallelStream().reduce(sumAccumulator);
		
		System.out.println("#########################################");
		System.out.println("Printing Sum");
		
		System.out.println(reduce.isPresent()?reduce.get():"");
		
		
		
		List<Color> colors = new ArrayList<>();
		colors.add(new Color("Red"));
		colors.add(new Color("Blue"));
		colors.add(new Color("Green"));
		colors.add(new Color("Ping"));
		colors.add(new Color("Yellow"));
		colors.add(new Color("Orange"));
		
		BinaryOperator<Color> mergeColors = (x,y) -> {
			x.setName(x.getName()+" "+ y.getName());
			return x;
		};
		
		
		Optional<Color> makeRainbow = colors.parallelStream().reduce(mergeColors);
		
		System.out.println(makeRainbow.isPresent()?makeRainbow.get().getName():"");
		
		makeRainbow.ifPresent(e -> System.out.println(e.getName()));
		
		
		

	}

}
