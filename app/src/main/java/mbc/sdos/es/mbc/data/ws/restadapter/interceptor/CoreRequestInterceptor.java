package mbc.sdos.es.mbc.data.ws.restadapter.interceptor;

import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class CoreRequestInterceptor implements Interceptor {
  private Pair<String, String> acceptLanguageHeader = new Pair<>("Accept-Language", "es-ES");
  private Pair<String, String> accept = new Pair<>("Accept-Encoding", "application/json");
  private Pair<String, String> acceptEncoding = new Pair<>("Accept", "gzip");
  private Pair<String, String> contentType = new Pair<>("Content-Type", "application/json");
  private Pair<String, String> contentEncoding = new Pair<>("Content-Encoding", "gzip");
  private Pair<String, String> deviceHeader = new Pair<>("Device", this.getDeviceName());
  private Pair<String, String> versionHeader = new Pair<>("Version", "0.0.0");
  private List<Pair<String, String>> extraHeaders = new ArrayList<>();

  public CoreRequestInterceptor() {
  }

  public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();
    Builder builder = original.newBuilder()
        .header(this.acceptLanguageHeader.first, this.acceptLanguageHeader.second)
        .header(this.accept.first, this.accept.second)
        //.header(this.acceptEncoding.first, this.acceptEncoding.second)
        //.header(this.contentType.first, this.contentType.second)
        //.header(this.contentEncoding.first, this.contentEncoding.second)
        .header(this.deviceHeader.first, this.deviceHeader.second)
        .header(this.versionHeader.first, this.versionHeader.second);

    for (Pair<String, String> header : this.extraHeaders) {
      builder.addHeader(header.first, header.second);
    }

    Request request1 = builder.build();
    return chain.proceed(request1);
  }

  @NonNull
  private String getDeviceName() {
    String res;
    String manufacturer = Build.MANUFACTURER;
    String model = Build.MODEL;
    if (model.startsWith(manufacturer)) {
      res = model;
    } else {
      res = manufacturer + "||" + model;
    }

    res = res + "||Android" + VERSION.RELEASE;
    return res;
  }

  public CoreRequestInterceptor setAcceptLanguageHeader(String acceptLanguageHeader) {
    this.acceptLanguageHeader = new Pair<>("Accept-Language", acceptLanguageHeader);
    return this;
  }

  public CoreRequestInterceptor setDeviceHeader(String deviceHeader) {
    this.deviceHeader = new Pair<>("Device", deviceHeader);
    return this;
  }

  public CoreRequestInterceptor setVersionHeader(String versionHeader) {
    this.versionHeader = new Pair<>("Version", versionHeader);
    return this;
  }

  public CoreRequestInterceptor addExtraHeader(String name, String value) {
    this.extraHeaders.add(new Pair<>(name, value));
    return this;
  }

  public String getDeviceHeader() {
    return this.deviceHeader.second;
  }

  public String getAcceptLanguageHeader() {
    return this.acceptLanguageHeader.second;
  }

  public String getVersionHeader() {
    return this.versionHeader.second;
  }

  public List<Pair<String, String>> getExtraHeaders() {
    return this.extraHeaders;
  }
}

