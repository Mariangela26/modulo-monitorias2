package com.unisimon.monitorias.common.infraestructura.interceptor;

public class HttpRequestContextHolder {
    private HttpRequestContextHolder() {
        super();
    }

    private static final ThreadLocal<String> AUTHORIZATION_HOLDER = new ThreadLocal<>();

    public static void setAuthorization(String authorization) {
        AUTHORIZATION_HOLDER.set(authorization);
    }

    public static String getAuthorization() {
        return AUTHORIZATION_HOLDER.get();
    }

    public static void clearAuthorization() {
        AUTHORIZATION_HOLDER.remove();
    }
}
