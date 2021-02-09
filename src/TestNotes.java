import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Notes {

	private int id;
	private String tagName;
	private long tagId;

	public Notes(int id, String tagName, long tagId) {
		this.id = id;
		this.tagName = tagName;
		this.tagId = tagId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	@Override
	public String toString() {
		return String.format("Notes [id=%s, tagName=%s, tagId=%s]", id, tagName, tagId);
	}

}

public class TestNotes {

	public static void main(String[] args) throws IOException {

		List<Notes> noteLst = new ArrayList<>();
		noteLst.add(new Notes(1, "note1", 11));
		noteLst.add(new Notes(2, "note2", 22));
		noteLst.add(new Notes(3, "note3", 33));
		noteLst.add(new Notes(4, "note6", 44));
		noteLst.add(new Notes(5, "note5", 55));
		noteLst.add(new Notes(6, "note4", 66));
		
		
		List<Notes> notes = Arrays.asList(
				new Notes(1, "note1", 11),
				new Notes(2, "note2", 22),
				new Notes(3, "note3", 33),
				new Notes(4, "note4", 44),
				new Notes(5, "note5", 55),
				new Notes(6, "note4", 66)
		);

		// use third mergeFunction argument (oldValue, newValue) -> oldValue
		// solved the duplicated key issue by considering old value
		Map<String, Long> notesRecords = noteLst.stream().collect(Collectors.toMap(Notes::getTagName, Notes::getTagId,
				(oldNote, newNote) -> oldNote, LinkedHashMap::new));

		System.out.println("Notes : " + notesRecords);

		List<String> names = Arrays.asList("Zemen", "Aman", "Weldu", "Berhe");
		List<String> sortednames = names.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted Names : " + sortednames);

		Collections.sort(names, (n1, n2) -> n1.compareTo(n2));

		System.out.println("Names : " + names);
		
		Collections.reverse(names);
		
		System.out.println("Reverse names : " + names);
//		Random random = new Random();
//		random.ints(1,10).limit(10).forEach(System.out::println);

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// get list of unique squares
		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println(squaresList);

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// get count of empty string
		int count = (int) strings.stream().filter(s -> s.isEmpty()).count();

		System.out.println(count);

		noteLst.stream().forEach(x -> x.setTagName("xx"));

		System.out.println("xx " + noteLst);

		List<Integer> n = Arrays.asList(3, 2, 2, 3, 7, 3, 5,6);
		
		IntSummaryStatistics stats = n.stream().mapToInt(x -> x).summaryStatistics();
		
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Average value in List : " + stats.getAverage());
		System.out.println("Sum of all in List : " + stats.getSum());
		System.out.println("Total number of elements in List : " + stats.getCount());

		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);

		LocalDate nextDay = today.plus(1, ChronoUnit.DAYS);
		System.out.println("Next day: " + nextDay);

		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week: " + nextWeek);

		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + nextMonth);

		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next year: " + nextYear);

		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Next decade: " + nextDecade);

		LocalDate nextCentury = today.plus(1, ChronoUnit.CENTURIES);
		System.out.println("Next century: " + nextCentury);

//		Instant now = CurrentDate.toInstant();
		Instant now = Instant.now();
		System.out.println("instance : " + now);

		int arr[][] = new int[6][];
		System.out.println("======="+Arrays.toString(arr));

		Object[] nam = new String[3];
		nam[1] = new String("string object");
		 // nam[0] = new Integer(0);

		// System.out.println(" bbbbb "+nam[0]);
		System.out.println(" >>>>> " + nam[1]);

		
		File f=new File("/Users/tesfaigebrekidan/Desktop/test.docx");
		f.createNewFile();
		
		
		
	}
}

/*
 * class Chararrayinput { public static void main(String[] args) { String obj =
 * "abcdefgh"; int length = obj.length(); char c[] = new char[length];
 * obj.getChars(0, length, c, 0); CharArrayReader input1 = new
 * CharArrayReader(c); CharArrayReader input2 = new CharArrayReader(c, 1, 4);
 * int i; int j; try { while((i = input1.read()) == (j = input2.read())) {
 * System.out.print((char)i); } } catch (IOException e) { e.printStackTrace(); }
 * } }
 *
 * 
 * 
 * A.
 * 
 * abcde B.
 * 
 * abcd C.
 * 
 * abc D.
 * 
 * none of the mentioned
 * 
 */
