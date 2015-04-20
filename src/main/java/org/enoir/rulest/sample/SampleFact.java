package org.enoir.rulest.sample;

import com.google.gson.annotations.SerializedName;
import org.enoir.rulest.model.Fact;

/**
 * Created by frank on 2015/4/20.
 */
public class SampleFact extends Fact {
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
