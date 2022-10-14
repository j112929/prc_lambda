package DB;

import java.util.Optional;

public class ProccessedTransaction extends ATransaction{
    private Object id;
    private String status;
    public ProccessedTransaction(){

    }
    public ProccessedTransaction(Object id, String status){
        this.id = id;
        this.status = status;
    }
    public Object getId() {
        return id!= null ? id : "";
    }

    public Optional<String> getStatus() {
        return Optional.of(status);
    }

    public void setId(long id){
        this.id = id;
    }
    public void setStatus(String status){
        this.status = status;
    }

}
