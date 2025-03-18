import java.util.ArrayList;

public class MergeSort <T extends Comparable<T>>{

    public static <T extends Comparable<T>> ArrayList<T> mergeSortArrayList(ArrayList<T> arrayList){
        if (arrayList.size() <= 1){
            return arrayList;
        }
        else {
            int middle = arrayList.size() / 2;

            ArrayList<T> leftArrayList = new ArrayList<>(arrayList.subList(0, middle));
            ArrayList<T> rightArrayList = new ArrayList<>(arrayList.subList(middle, arrayList.size()));

            return mergeArrayList(mergeSortArrayList(leftArrayList), mergeSortArrayList(rightArrayList));
        }
    }

    private static <T extends Comparable<T>> ArrayList<T> mergeArrayList(ArrayList<T> leftArrayList, ArrayList<T> rightArrayList){
        ArrayList<T> resultArrayList = new ArrayList<>();

        while (!leftArrayList.isEmpty() & !rightArrayList.isEmpty()){

            if (leftArrayList.get(0).compareTo(rightArrayList.get(0)) < 0){
                resultArrayList.add(leftArrayList.get(0));
                leftArrayList.remove(0);
            }
            else {
                resultArrayList.add(rightArrayList.get(0));
                rightArrayList.remove(0);
            }
        }

        if (!leftArrayList.isEmpty()){
            resultArrayList.addAll(leftArrayList);
        }
        if (!rightArrayList.isEmpty()){
            resultArrayList.addAll(rightArrayList);
        }

        return resultArrayList;
    }
}