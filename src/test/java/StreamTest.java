import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liang.guo
 * @since 2022年08月23日 10:22
 **/
public class StreamTest {

    @Test
    public void testFilter(){
        List<String> arr = new ArrayList<>(Arrays.asList("1", "2", "3"));
        System.out.println(arr.stream().filter(x -> x.equals("2")).collect(Collectors.toList()));
    }
}
