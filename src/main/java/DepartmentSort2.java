import java.util.*;

public class DepartmentSort2 {

    /**
     * Codes of departments that need to be sorted.
     */
    private final String[] departmentsCode;

    /**
     * Local List contains codes of departments.
     */
    private List<List<String>> allocatedCodes = new ArrayList<>();

    /**
     * Constructor.
     * @param departmentsCode - Codes of departments that need to be sorted.
     */
    public DepartmentSort2(String[] departmentsCode) {
        this.departmentsCode = departmentsCode;
        parseCodes();
    }

    /**
     * Ascend sort department codes
     * @return sorted department codes in String[]
     */
    public String[] departmentSortAscend() {
        Comparator<List<String>> comparator = ascendOrDescendComparator(1);
        allocatedCodes.sort(comparator);
        return toStringArray();
    }
    /**
     * Descend sort department codes
     * @return sorted department codes in String[]
     */

    public String[] departmentSortDescend() {
        Comparator<List<String>> comparator = ascendOrDescendComparator(-1);
        allocatedCodes.sort(comparator);
        return toStringArray();
    }

    /**
     *Converts a string with department code to an local List.
     */
    private void parseCodes() {
        for (String currentCode : departmentsCode) {
            String separator = "\\\\";
            String[] splitCodes = currentCode.split(separator);
            List<String> currentArray = new ArrayList<>();
            for (int i = 0; i < splitCodes.length; i++) {
                currentArray.add(splitCodes[i]);
                addCode(currentArray);
            }
        }
    }

    /**
     * Add passed array of department code in local List if not exist.
     * @param codesArray new array of department code
     */
    private void addCode(List<String> codesArray) {
        List<String> newCodes = new ArrayList<>();
        newCodes.addAll(codesArray);

        if (!allocatedCodes.contains(newCodes)) {
            allocatedCodes.add(newCodes);
        }
    }

    /**
     * Convert local List to String[].
     * @return - sorted department codes in String[]
     */
    private String[] toStringArray() {
        String[] result = new String[allocatedCodes.size()];
        for (List<String> currentCode : allocatedCodes) {
            StringBuilder sb = new StringBuilder();
            for (String partCode : currentCode) {
                sb.append(partCode);
                if (currentCode.indexOf(partCode) < currentCode.size() - 1) {
                    sb.append("\\");
                }
            }
            result[allocatedCodes.indexOf(currentCode)] = sb.toString();
        }

        return result;
    }

    /**
     * Comparator for sorting.
     * @param ascend 1 - ascend sort, -1 - descend sort.
     * @return comparator
     */
    private Comparator<List<String>> ascendOrDescendComparator(int ascend) {
        Comparator<List<String>> comparator = new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int result = 0;

                Iterator<String> it1 = o1.iterator();
                Iterator<String> it2 = o2.iterator();
                while (it1.hasNext() && it2.hasNext() && result == 0) {
                    result = ascend * it1.next().compareTo(it2.next());
                }
                if (result == 0) {
                    result = Integer.valueOf(o1.size()).compareTo(Integer.valueOf(o2.size()));
                }
                return result;
            }
        };
        return  comparator;
    }
}
