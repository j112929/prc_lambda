package sigma.hibernate;

import java.util.Stack;

public class Test {
    public static void main(String[] args) throws Exception {
//        Faculty order1 = new Faculty(1, "Racquets", "J", "222 Senator", 23,1,1);
//        SessionFactory factory =  new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//        session.persist(order1);
//        tx.commit();
//        session.close();
        String input = "(())[]{}";
        System.out.println(sol(input));

    }

    /*public static void main(String[] args) throws Exception{
        Faculty f = new Faculty();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc?useSSL=false",
                "root","root");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Faculty");

        while(rs.next()){
            f.id=rs.getLong(1);
            f.first_name = rs.getString(2);
            f.last_name = rs.getString(3);
            f.city = rs.getString(4);
            f.age = rs.getInt(5);
            f.salary = rs.getInt(6);
            f.department_id = rs.getInt(7);
            System.out.println(f);
        }

    }*/

    public static boolean sol(String input) {
        Stack<Character> s = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                s.push(c);
            }
            if (!s.isEmpty()) {
                char c1 = s.peek();
                if ((c == ')' && c1 == '(')
                        || (c == ']' && c1 == '[')
                        || (c == '}' && c1 == '{')) {
                    s.pop();
                }

            }
        }
        return s.isEmpty();
    }
}
