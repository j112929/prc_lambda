package DB;

import java.util.*;
import java.util.stream.Stream;

public class A {
    public static void main(String[] args) {
        List<PendingTransaction> pending = Arrays.asList(new PendingTransaction(null, ""),
                new PendingTransaction(1, "PENDING"), new PendingTransaction(2, "PENDING"));

        List<ProccessedTransaction> p1 =  Arrays.asList(new ProccessedTransaction(1,"DONE"));
        List<ProccessedTransaction> p2 =  Arrays.asList(new ProccessedTransaction(2,""));
        List<Stream<ProccessedTransaction>> processed = Arrays.asList(p1.stream(),p2.stream());

        A a = new A();
        System.out.println(Arrays.toString(a.filter(pending.stream(), processed.stream()).toArray()));
    }

    public Stream<PendingTransaction> filter(Stream<PendingTransaction> pending,
                                      Stream<Stream<ProccessedTransaction>> processed){
        if(pending == null ) return Stream.empty();
        Map<Object, String> pendingMap = new HashMap<>();
        List<PendingTransaction> ans = new ArrayList<>();
        pending.forEach(e->{
            if (e.getId() == null || e.getId()=="") {
                ans.add(e);
                return;
            }
            if(e.getStatus().isPresent()) {
                pendingMap.put(e.getId(), e.getStatus().get());
            }
        });
        processed.forEach(e->{
            e.forEach(r->{
                if (r.getId() == null || r.getId() == "") {
                    return;
                }
                if (pendingMap.containsKey(r.getId())
                        && r.getStatus().get().equals("DONE")) {
                    pendingMap.remove( r.getId());
                }
            });
        });

        if(!pendingMap.isEmpty()){
            pendingMap.keySet().forEach(id -> {
                ans.add(new PendingTransaction(id,pendingMap.get(id)));
            });
        }
        return ans.stream();
    }
}
