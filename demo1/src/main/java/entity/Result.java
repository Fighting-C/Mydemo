package entity;

/**
 * @PackageName:entity
 * @Date:2022/3/1210:51
 **/
public class Result {

    private int code=20000;
    private String status="success";
    private Object data;
    private  String token;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
    }


}
