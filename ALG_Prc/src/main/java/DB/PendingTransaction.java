package DB;

import java.util.Optional;

public class PendingTransaction extends ATransaction{
    private Object id;
    private String status;

    public PendingTransaction(){

    }
    public PendingTransaction(Object id, String status){
        this.id = id;
        this.status = status;
    }
    public Object getId() {
        return id!= null ? id : "";
    }

    public Optional<String> getStatus() {
        return Optional.of(status);
    }

    public void setId(Object id){
        this.id = id;
    }
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "PendingTransaction{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
