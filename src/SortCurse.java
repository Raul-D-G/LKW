import Ruta.Cursa;

import java.util.Comparator;

public class SortCurse implements Comparator<Cursa> {
    @Override
    public int compare(Cursa o1, Cursa o2) {
        return o2.getPret() - o1.getPret();
    }
}
