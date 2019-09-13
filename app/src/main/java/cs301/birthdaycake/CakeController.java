package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cv) {
        cakeView = cv;
        cakeModel = cv.getCakeModel();
    }

    @Override
    public void onClick(View v) {
        Log.d("cakeController", "clicked");
        cakeModel.candlesLit = !cakeModel.candlesLit;
        if (!cakeModel.candlesLit) {
            ((Button) v).setText("Relight");
        }
        else {
            ((Button) v).setText("Blow Out");
        }
        cakeView.invalidate();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.candleSwitch)
        {
            cakeModel.hasCandles = isChecked;
        }
        else if (buttonView.getId() == R.id.switch1)
        {
            cakeModel.hasFrosting = isChecked;
        }
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        cakeModel.numCandles = progress;
        cakeView.invalidate();
    }

    @Override
    //remains empty
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    //remains empty
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
