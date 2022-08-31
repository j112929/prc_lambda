package I;

class Location {
    Location next;
    String name;

    public Location(String name) {
        this.name = name;
        next = null;
    }
}

public class HyperLoop {
    public static void main(String[] args) {
        Location s = new Location("1");
        s.next = new Location("2");
        s.next.next = s;
//                new Location("1");
        HyperLoop hyperLoop = new HyperLoop();
        Location e = hyperLoop.detectFault(s);
        System.out.println(e.name);
        System.out.println(e.next.name);
    }

    public Location detectFault(Location start) {
        Location tmpLoc1 = start;
        Location tmpLoc2 = start;

        while (tmpLoc2 != null && tmpLoc2.next != null) {
            System.out.println("2:" + tmpLoc2);
            System.out.println("1:" + tmpLoc1);
            tmpLoc2 = tmpLoc2.next.next;
            tmpLoc1 = tmpLoc1.next;
            if (tmpLoc1 == tmpLoc2) {
                break;
            }
        }
        System.out.println("2-:" + tmpLoc2.name);
        System.out.println("2-.:" + tmpLoc2.next);
        if (tmpLoc2 == null || tmpLoc2.next == null) {
            return null;
        }

        tmpLoc1 = start;
        while (tmpLoc1 != tmpLoc2) {
            System.out.println("-2:" + tmpLoc2);
            System.out.println("-1:" + tmpLoc1);
            tmpLoc1 = tmpLoc1.next;
            tmpLoc2 = tmpLoc2.next;
        }
        System.out.println("--2:" + tmpLoc2.name);
        return tmpLoc2;
    }
}