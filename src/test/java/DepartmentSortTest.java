import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartmentSortTest {

    @Test
    public void whenAscendSortThenAscendSort() {
        String[] departmentCodes = new String[7];
        departmentCodes[0] = "K1\\SK1";
        departmentCodes[1] = "K2\\SK1\\SSK1";
        departmentCodes[2] = "K2\\SK1\\SSK2";
        departmentCodes[3] = "K1\\SK1\\SSK1";
        departmentCodes[4] = "K2";
        departmentCodes[5] = "K1\\SK2";
        departmentCodes[6] = "K1\\SK1\\SSK2";

        String[] departmentCodesSorted = new String[9];
        departmentCodesSorted[0] = "K1";
        departmentCodesSorted[1] = "K1\\SK1";
        departmentCodesSorted[2] = "K1\\SK1\\SSK1";
        departmentCodesSorted[3] = "K1\\SK1\\SSK2";
        departmentCodesSorted[4] = "K1\\SK2";
        departmentCodesSorted[5] = "K2";
        departmentCodesSorted[6] = "K2\\SK1";
        departmentCodesSorted[7] = "K2\\SK1\\SSK1";
        departmentCodesSorted[8] = "K2\\SK1\\SSK2";

        //First version on TreeSet<>
        //DepartmentSort ds = new DepartmentSort(departmentCodes);

        //Second version on List<List<String>>
        DepartmentSort2 ds = new DepartmentSort2(departmentCodes);

        String[] result = ds.departmentSortAscend();
        //String[] result = ds.departmentSortDescend();

//        System.out.println("-----------------------" + result.length);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

        assertThat(departmentCodesSorted, is(result));
    }

    @Test
    public void whenDescendSortThenDescendSort() {
        String[] departmentCodes = new String[7];
        departmentCodes[0] = "K1\\SK1";
        departmentCodes[1] = "K2\\SK1\\SSK1";
        departmentCodes[2] = "K2\\SK1\\SSK2";
        departmentCodes[3] = "K1\\SK1\\SSK1";
        departmentCodes[4] = "K2";
        departmentCodes[5] = "K1\\SK2";
        departmentCodes[6] = "K1\\SK1\\SSK2";

        String[] departmentCodesSorted = new String[9];
        departmentCodesSorted[0] = "K2";
        departmentCodesSorted[1] = "K2\\SK1";
        departmentCodesSorted[2] = "K2\\SK1\\SSK2";
        departmentCodesSorted[3] = "K2\\SK1\\SSK1";
        departmentCodesSorted[4] = "K1";
        departmentCodesSorted[5] = "K1\\SK2";
        departmentCodesSorted[6] = "K1\\SK1";
        departmentCodesSorted[7] = "K1\\SK1\\SSK2";
        departmentCodesSorted[8] = "K1\\SK1\\SSK1";

        DepartmentSort2 ds = new DepartmentSort2(departmentCodes);

        String[] result = ds.departmentSortDescend();

        assertThat(departmentCodesSorted, is(result));
    }

}
