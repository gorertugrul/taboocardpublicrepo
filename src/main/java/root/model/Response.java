package root.model;

import java.time.LocalDateTime;

public class Response {
    private String result;
    private String message;
    private LocalDateTime dateCreated;

    public Response(String result, String message) {
        this.result = result;
        this.message = message;
        this.dateCreated=LocalDateTime.now();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
