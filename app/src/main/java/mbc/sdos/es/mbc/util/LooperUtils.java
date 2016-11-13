package mbc.sdos.es.mbc.util;

import android.os.Handler;
import android.os.Looper;

public class LooperUtils {
  private LooperUtils() {

  }

  public static boolean isUi() {
    return Looper.myLooper() == Looper.getMainLooper();
  }

  public static void runOnUi(Runnable runnable) {
    new Handler(Looper.getMainLooper()).post(runnable);
  }
}
