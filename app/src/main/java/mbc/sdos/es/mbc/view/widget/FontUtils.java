package mbc.sdos.es.mbc.view.widget;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Map;
import java.util.TreeMap;

public class FontUtils {
  private static Map<String, Typeface> typefaceMap = new TreeMap<>();

  public static Typeface getTypeface(String fontName, Context context) {
    Typeface typeface = typefaceMap.get(fontName);
    if (typeface == null) {
      typeface = Typeface.createFromAsset(context.getAssets(),
          "fonts/" + fontName);
      typefaceMap.put(fontName, typeface);
    }
    return typeface;
  }
}
