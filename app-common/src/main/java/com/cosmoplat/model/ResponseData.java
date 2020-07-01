package com.cosmoplat.model;

/**
 * @author 27279
 */
public class ResponseData<T>  {
    private Integer code;
    private String message;
    private T data;
    private Long ts;

    public ResponseData() {
    }

    public ResponseData(Integer code, String message, Long ts) {
        this.code = code;
        this.message = message;
        this.ts = ts;
    }

    public ResponseData(Integer code, String message, T data, Long ts) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.ts = ts;
    }

    public boolean success() {
        return RepStatus.SUCCESS.equals(this.code);
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public Long getTs() {
        return this.ts;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseData)) {
            return false;
        } else {
            ResponseData<?> other = (ResponseData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label59;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label59;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$ts = this.getTs();
                Object other$ts = other.getTs();
                if (this$ts == null) {
                    if (other$ts != null) {
                        return false;
                    }
                } else if (!this$ts.equals(other$ts)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseData;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $ts = this.getTs();
        result = result * 59 + ($ts == null ? 43 : $ts.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResponseData(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ", ts=" + this.getTs() + ")";
    }
}
