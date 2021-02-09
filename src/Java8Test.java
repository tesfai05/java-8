
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tesfai.model.Employee;
import com.tesfai.model.User;

public class Java8Test {

	private static void findDuplicatePrimitive(int[] inputArray) {
		Set<Integer> uniqueElements = new HashSet<Integer>();
		Set<Integer> duplicateElements = Arrays.stream(inputArray).filter(i -> !uniqueElements.add(i)).boxed()
				.collect(Collectors.toSet());
		System.out.println(duplicateElements);

	}

	private static void findDuplicatesObject(List<String> list) {
		Set<String> uniqueElements = new HashSet<>();
		Set<String> result = list.stream().filter(i -> !uniqueElements.add(i)).collect(Collectors.toSet());
		System.out.println(result);

	}

	private static void removeDuplacates(List<String> str) {

		Set<String> uniqueStr = new HashSet<>();

		Set<String> dupStr = str.stream().filter(s -> uniqueStr.add(s)).collect(Collectors.toSet());

		System.out.println(dupStr);

	}

	private static void flatMapping() {
		List<List<String>> list = Arrays.asList(Arrays.asList("block", "cobalt"),
				Arrays.asList("meet", "embedded", "deemed"));

		List<String> l = list.stream().flatMap(Collection::stream).collect(Collectors.toList());

		System.out.println(l);
	}

	private static Map<String, List<Employee>> employeesInEachDept(List<Employee> employeesList) {
		return employeesList.stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
	}

	private static Map<String, Long> numberOfEmployeesInEachDept(List<Employee> employeesList) {
		return employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}

	private static Map<String, Employee> topPaidEmployeesInEachDept(List<Employee> employeesList) {
		return employeesList.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary())), Optional::get)));
	}

	private static IntSummaryStatistics numericStatistics(List<Integer> numbers) {
		return numbers.stream().mapToInt((x) -> x).summaryStatistics();
	}

//	reverse the string using traditional way
	private static String reverseUsingLambda(String string){
        StringBuilder reverseString=new StringBuilder();
        String[] words=string.split("");

        for (int i=words.length-1;i>=0;i--){
            reverseString.append(words[i]);
        }
        return reverseString.toString();
    }
//  reverse the string using stream
    private static String reverse(String string) {
        String reverseString=Stream.of(string).map(word->new StringBuilder(word).reverse()).
                collect(Collectors.joining(""));
        return reverseString;
    }


    public interface ReverseStringUsingLambda {
        public void reverseString(String s);
    }
	
    private static void skipDemo () {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10).filter(i -> i % 2 == 0)
                .skip(2)
                .forEach(i -> System.out.print(i + " "));

    }
    private static void limitDemo () {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9,10).filter(i -> i % 2 == 0)
                .limit(2)
                .forEach(i -> System.out.print(i + " "));

    }
    
    
    
    
	public static void main(String[] args) {

		/* ******************** ONE ************************ */
		System.out.println("======================ONE=======================");
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee("John", "FINANCE", 1000));
		employeesList.add(new Employee("Tim", "IT", 5000));
		employeesList.add(new Employee("Ryan", "IT", 2000));
		employeesList.add(new Employee("Tom", "FINANCE", 20000));
		employeesList.add(new Employee("Allen", "IT", 90000));
		employeesList.add(new Employee("Tom", "ENGINEERING", 40000));

		// Top paid employees in each dept
		Map<String, Employee> topPaidEmployees = topPaidEmployeesInEachDept(employeesList);

		// Get all employees dept count
		Map<String, Long> eachDeptCount = numberOfEmployeesInEachDept(employeesList);

		// Group employees by dept
		Map<String, List<Employee>> groupByDept = employeesInEachDept(employeesList);
		System.out.println("\nTop paid Employees : " + topPaidEmployees);
		System.out.println("\nEach Dept Count : " + eachDeptCount);
		System.out.println("\nGroup by Dept : " + groupByDept);

		/* ******************** TWO ************************ */
		System.out.println("=======================TWO======================");
		List<String> str = Arrays.asList("abc", "asd", "wer", "wer", "asd", "ert");
		int[] ints = new int[] { 111, 222, 222, 333, 444, 444, 555 };
		findDuplicatesObject(str);
		removeDuplacates(str);
		findDuplicatePrimitive(ints);

		/* ******************** THREE ************************ */
		System.out.println("======================THREE=======================");
		flatMapping();

		/* ******************** FOUR ************************ */
		System.out.println("========================FOUR=====================");
		List<Integer> numbers = Arrays.asList(8, 3, 4, 1, 7, 3);
		IntSummaryStatistics summaryStatistics = numericStatistics(numbers);
		System.out.println("Count : " + summaryStatistics.getCount());
		System.out.println("Max : " + summaryStatistics.getMax());
		System.out.println("Min : " + summaryStatistics.getMin());
		System.out.println("Sum : " + summaryStatistics.getSum());
		System.out.println("Average : " + summaryStatistics.getAverage());

		/* ******************** FIVE ************************ */
		System.out.println("=======================FIVE======================");

		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e))// This method exists mainly to support debugging
				.map(String::toUpperCase).peek(e -> System.out.println("Mapped value: " + e))
				.collect(Collectors.toList());
		System.out.println("=============================================");
		Stream<Employee> userStream = Stream.of(new Employee("Tom", "ADMIN", 2000),
				new Employee("Ryan", "FINANCE", 4000), new Employee("Tim", "IT", 2000));
		// userStream.forEach(System.out::println);
		userStream.peek(u -> u.setName(u.getName().toUpperCase())).forEach(System.out::println);

		/* ******************** SIX ************************ */
		System.out.println("=======================SIX======================");
		Random random=new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
        
        
        /* ******************** SEVEN ************************ */
		System.out.println("=====================SEVEN========================");
        
        List<Integer> numberList= Arrays.asList(2,4,6,8);
        int result=numberList.stream().reduce(0,(total,element)-> total+element);
        System.out.println(result);

        List<String> letters= Arrays.asList("a","b","c","d","e","f");
        String output=letters.stream().reduce("",(String::concat));
        String outputConcatenate=letters.stream().reduce("",(string,element)->string.toUpperCase()+element.toLowerCase());
        System.out.println(output);
        System.out.println(outputConcatenate);

        List<User> users=Arrays.asList(new User("Alem",20), new User("Gebre",28));
        int computedAges=users.stream().reduce(0,(ageResult,user)->ageResult + user.getAge(),Integer::sum);
        System.out.println(computedAges);
        
        /* ******************** EIGHT ************************ */
		System.out.println("=======================EIGHT======================");
		
		String string="hello";
        //1st way
        System.out.println("1st way : "+reverseUsingLambda(string));
        //2nd way
        System.out.println("2nd way : "+reverse(string));
        //3rd way
        ReverseStringUsingLambda reverse=(String s)->{
            StringBuilder r=new StringBuilder();
            String[] words=s.split("");
            for (int i=words.length-1;i>=0;i--) {
                r.append(words[i]);
            }
            System.out.println("3rd way : " +r);
        };
        reverse.reverseString("hello");
		
        /* ******************** NINE ************************ */
     	System.out.println("=======================NINE======================");
        skipDemo();
        System.out.println();
        limitDemo();
        System.out.println();
        
        
        /* ******************** TEN ************************ */
     	System.out.println("=======================TEN======================");
     	// Create an array list for doubles.
        List<Integer> al1 =Arrays.asList(1,2,-3,-4,5);

        // Use tryAdvance() to display(action) contents of arraylist.
        System.out.print("Contents of list:\n");

        // getting Spliterator object on al1
        Spliterator<Integer> splitr = al1.spliterator();

        // Use tryAdvance() to display(action) contents of arraylist.
        // Notice how lambda expression is used to implement accept method
        // of Consumer interface

        while(splitr.tryAdvance((n) -> System.out.print(n+" ")));
        System.out.println("\n++++++++++++++++++++++++++++++++++");

        // Use tryAdvance() for getting absolute values(action) of contents of list.
        // Create new list that contains absolute values.
        List<Integer> al2 = new ArrayList<>();
        splitr = al1.spliterator();

        // Here our action is to get absolute values
        // Notice how lambda expression is used to implement accept method
        // of Consumer interface
        while(splitr.tryAdvance((n) -> al2.add(Math.abs(n))));
        System.out.print("Absolute values of contents of list:\n");

        // getting Spliterator object on al2
        splitr = al2.spliterator();
        while(splitr.tryAdvance((n) -> System.out.print(n+" ")));
        
        System.out.println("\n++++++++++++++++++++++++++++++++++");

        //To perform hasNext() and next() operations in single statement using forEachRemaining() method.
        Spliterator<Integer> spliterator = al1.spliterator();
        spliterator.forEachRemaining(n->System.out.print(n+" "));
        System.out.println();
        
		/* ******************** Employee class ************************ */
		System.out.println("====================== Employee class=======================");
		Employee e = new Employee("", "", 0);

		Class c1 = e.getClass();

		// Printing type of object using c1.
		System.out.println(c1.getName());

		// getting all methods in an array
		Method m[] = c1.getDeclaredMethods();
		for (Method method : m)
			System.out.print(method.getName() + ", ");
		System.out.println();
		// getting all fields in an array
		Field f[] = c1.getDeclaredFields();
		for (Field field : f)
			System.out.print(field.getName() + ", ");

	}

}
