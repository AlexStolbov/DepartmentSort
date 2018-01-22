import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class DepartmentSort {

    private final String[] deparmentCode;

    public DepartmentSort(String[] deparmentCode) {
        this.deparmentCode = deparmentCode;
    }

    public String[] departmentSortAscend() {
        return createFullHierarchy(new TreeSet<>());
    }

    public String[] departmentSortDescend() {
        Comparator comparatorDesc = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = o1.compareTo(o2);

                if (res != 0) {
                    res = -res;

                    if (o1.indexOf(o2) == 0) {
                        res = 1;
                    }
                    if (o2.indexOf(o1) == 0) {
                        res = -1;
                    }

                }
                return res;
            }
        };

        return createFullHierarchy(new TreeSet<>(comparatorDesc));
    }

    private String[] createFullHierarchy(Set<String> hierarchy) {
        for (String currentCode : deparmentCode) {
            String[] currentHierarchy = appendAllCodes(currentCode);
            for (String fullCode : currentHierarchy) {
                hierarchy.add(fullCode);
            }
        }

        return hierarchy.toArray(new String[0]);
    }

    private String[] appendAllCodes(String anyDeparmentCode) {
        String separator = "\\\\";
        String[] splitCodes = anyDeparmentCode.split(separator);
        String[] allDepartmentCode = new String[splitCodes.length];
        for (int i = 0; i < splitCodes.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y <= i; y++) {
                if (y > 0) {
                    sb.append("\\");
                }
                sb.append(splitCodes[y]);
            }
            allDepartmentCode[i] = sb.toString();
        }
        return allDepartmentCode;
    }

}
