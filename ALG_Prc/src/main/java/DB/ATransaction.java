package DB;

import java.util.Optional;

public abstract class ATransaction {

    private Object id;
    private String status;

    public Object getId() {
        return id != null ?  id : "";
    }

    public void setId(long id) {
        this.id = id;
    }

    public Optional<String> getStatus() {
        return Optional.of(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
