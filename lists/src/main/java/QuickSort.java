import java.util.LinkedList;
import java.util.stream.Collectors;

public class QuickSort <T extends Comparable<T>>{
    public static <T extends Comparable<T>> LinkedList<T> quickSortLinkedList(LinkedList<T> linkedList){
        if (linkedList.size() < 2){
            return linkedList;
        }
        else {
            T pivot = linkedList.getFirst();

            LinkedList<T> greaterThenPivot = linkedList.subList(1, linkedList.size())
                    .stream()
                    .filter(e -> e.compareTo(pivot) > 0)
                    .collect(Collectors.toCollection(LinkedList::new));

            LinkedList<T> lessThenPivot = linkedList.subList(1, linkedList.size())
                    .stream()
                    .filter(e -> e.compareTo(pivot) < 0)
                    .collect(Collectors.toCollection(LinkedList::new));

            LinkedList<T> returnList = new LinkedList<>();
            returnList.addAll(quickSortLinkedList(lessThenPivot));
            returnList.add(pivot);
            returnList.addAll(quickSortLinkedList(greaterThenPivot));

            return returnList;
        }
    }
}