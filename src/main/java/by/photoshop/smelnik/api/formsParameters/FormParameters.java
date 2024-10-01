package by.photoshop.smelnik.api.formsParameters;

import java.util.LinkedHashMap;
import java.util.Map;

public class FormParameters {
    private Map<String, Object> formParams = new LinkedHashMap<>();

    public FormParameters setLogin(Object login) {
        formParams.put("login", login);
        return this;
    }

    public FormParameters setType(Object type) {
        formParams.put("type", type);
        return this;
    }

    public FormParameters setEmail(Object email) {
        formParams.put("email", email);
        return this;
    }

    public FormParameters setPhone(Object phone) {
        formParams.put("tel", phone);
        return this;
    }

    public FormParameters setPassword(Object password) {
        formParams.put("password", password);
        return this;
    }

    public Map<String, Object> build() {
        return formParams;
    }
}
