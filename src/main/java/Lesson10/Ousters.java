package Lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

interface Filter {
boolean criteria (String string);
}
class MyFilter implements Filter{

    @Override
    public boolean criteria(String string) {
        return false;
    }
}

public class Ousters {
    public static void main(String[] args) {
        String [] months = new String[] {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"
        };
        Collection<String> result = filter(
                new MyFilter(),
                new ArrayList<>(Arrays.asList("January", "February", "March", "April", "May",
                        "June", "July", "August", "September", "October", "November", "December"))
        );

        System.out.println(result);

    }

    public static Collection<String> filter(Filter f, Collection<String> strings)
    {
        List<String> ret = new ArrayList<>();
        for(String s: strings)
            if(f.criteria(s))
                ret.add(s);
        return ret;
    }
}

