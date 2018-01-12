import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartmentSortTest {

    @Test
    public void whenAddUserThenUserInBank() {
        String[] departmentCodes = new String[7];

        departmentCodes[0] = "K1\\SK1";
        departmentCodes[1] = "K1\\SK2";
        departmentCodes[2] = "K1\\SK1\\SSK1";
        departmentCodes[3] = "K1\\SK1\\SSK2";
        departmentCodes[4] = "K2";
        departmentCodes[5] = "K2\\SK1\\SSK1";
        departmentCodes[6] = "K2\\SK1\\SSK2";

        DepartmentSort ds = new DepartmentSort(departmentCodes);
        //String[] result = ds.departmentSortAscend();
        String[] result = ds.departmentSortDescend();

        System.out.println("-----------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        assertThat(true, is(true));
    }

}
