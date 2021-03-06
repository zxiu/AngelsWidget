package angel.zhuoxiu.widget.color;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;

/**
 * Created by zxui on 29/04/15.
 */
class ColorPickerDialog extends AlertDialog {


    protected ColorPickerDialog(Context context) {
        super(context);
    }

    public static class Builder extends AlertDialog.Builder {
        ColorPickerListener colorPickerListener;
        int[] colors;

        public Builder(Context context) {
            super(context);
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        public Builder(Context context, int theme) {
            super(context, theme);
        }

        public void setColorPickerListener(ColorPickerListener colorPickerListener) {
            this.colorPickerListener = colorPickerListener;
        }

        public void setColors(int... colors) {
            this.colors = colors;
        }

        @Override
        public AlertDialog show() {
            ColorPickerView colorPickerView = new ColorPickerView(getContext());
            colorPickerView.setColors(colors);
            colorPickerView.setColorPickedListener(colorPickerListener);
            this.setView(colorPickerView);
            AlertDialog dialog = super.show();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            return dialog;
        }
    }

}
