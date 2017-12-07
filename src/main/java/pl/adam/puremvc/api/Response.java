package pl.adam.puremvc.api;

public class Response<T> {
    private T response;

    public Response() {
    }

    public Response(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
