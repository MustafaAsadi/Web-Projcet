import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String x = "male";
        List<Person> people = List.of(
                new Person("Mustafa", "male"),
                new Person("issa", "homo"),
                new Person("abdallah", "male"),
                new Person("Lina", "female")
        );
        List<Person> MALE = people.stream()
                .filter(person -> x.equals(person.getGender()))
                .collect(Collectors.toList());
        MALE.forEach(System.out::println);
        Function<Integer, Integer> doubling = number -> number * 2;
        Function<Integer, Integer> incr = number -> number + 1;
        Function<Integer, Integer> finalop = doubling.andThen(incr);
        int num = finalop.apply(34);
        System.out.println(num);
        BiFunction<Integer, Integer, Integer> IncThenMulti = (inc, mult) -> (inc * mult) + 1;
        int y = IncThenMulti.apply(34, 2);
        System.out.println(y);

        String dateString = "2002-11-21";
        LocalDate parsedDate = LocalDate.parse(dateString);


        customer s = new customer("mustafa", "0786888787", "ads", parsedDate);
        CustomerRegisterValidation.isEmailValid()
                .and(CustomerRegisterValidation.isPhoneNumberValid())
                .and(CustomerRegisterValidation.isAdult());
        greet(s);
        greetv2.accept(s);
        greetv3.accept(s, false);
        System.out.println(isPhoneValid.and(contians3).test("0786888787"));
        System.out.println(message.get());
        boolean isHeMustafa = people.stream()
                .anyMatch(person -> person.getName().equals("Mustafa"));
        System.out.println(isHeMustafa);
        Optional.ofNullable("a").ifPresentOrElse(value -> System.out.println(value), () -> System.out.println("weak"));

        customer ak = new customer("mustafa", "+0786888787", "anythin@ggmail.com", parsedDate);
        ValidationResult Result = CustomerRegisterValidation.isEmailValid()
                .and(CustomerRegisterValidation.isPhoneNumberValid())
                .and(CustomerRegisterValidation.isAdult())
                .apply(ak);
        System.out.println(Result);

        if (Result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(Result.name());
        }

        hello("mustafa", null, () -> {
            System.out.println("the last name is not provided ");
        });

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(5);

        double zzx = list.stream().mapToDouble(integer -> integer.doubleValue()).average().orElse(0.0);
        System.out.println(zzx);


        List<String> slist = new ArrayList<>();
        slist.add("AAA");
        slist.add("ahmad");
        slist.add("alocardo");
        slist.add("diavlo");
        slist.add("mustafa");

        List<String> lower = slist.stream().map(gg -> gg.toLowerCase()).collect(Collectors.toList());
        System.out.println(lower.get(0));
        int BOOM = list.stream().filter(value -> value %2==0).mapToInt(integer -> integer.intValue()).sum();
        System.out.println(BOOM);
        int sus = list.stream().filter(value -> value%2 != 0).mapToInt(integer -> integer.intValue()).sum();
        System.out.println(sus);
        List<Integer> amogus = list.stream().distinct().collect(Collectors.toList());
        System.out.println(amogus);
        long counter = slist.stream().filter(value -> value.startsWith("A")).count();
        System.out.println(counter);
        List<String> h = slist.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(h);
        int min = list.stream().min(Integer::compare).orElse(null);
        System.out.println(min);
        List<Integer> dob = list.stream().map(value -> value*value).collect(Collectors.toList());
        System.out.println(dob);
        int longest =slist.stream().map(value -> value.length()).max((integer,newinteger)-> Integer.compare(integer,newinteger)).get();
        System.out.println(longest);
        long duplicates= slist.stream().flatMap(value -> Arrays.stream(value.split(" "))).distinct().count();
        System.out.println(duplicates);
        int sos = list.stream().filter(value -> value%2==0).mapToInt(value -> value*value).sum();
        System.out.println(sos);


    }
    static Consumer<customer> greetv2 = customer ->  System.out.println("Hello Mr." + customer.customerName + " thanks for registering, your number is:"+customer.number);
    static BiConsumer<customer,Boolean> greetv3 = (customer,showPhone) ->  System.out.println("Hello Mr." + customer.customerName + " thanks for registering, your number is:"+(showPhone ? customer.number : "nigga dont see that number"));
    static Predicate<String> isPhoneValid = Phone -> Phone.startsWith("07") & Phone.length()==10;

    static Predicate<String> contians3 = Phone -> Phone.contains("3");
    static Supplier<List<String>> message = () -> List.of(
            "HI",
            "HOW",
            "ARE",
            "YOU"
    );
    static void hello (String firstName , String lastName ,Runnable callback) {
        System.out.println(firstName);
        if(lastName !=null) {
            System.out.println(lastName);
        }
        else {
            callback.run();
        }
    }
        public static void greet (customer customer) {
            System.out.println("Hello Mr." + customer.customerName + " thanks for registering, your number is:"+customer.number);
        }
    }
