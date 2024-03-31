package edu.cnm.deepdive.sereknitty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.model.Stitch;
import java.util.List;

public class StitchesAdapter extends ArrayAdapter {

  private final LayoutInflater inflater;

  public StitchesAdapter(@NonNull Context context, @NonNull List<Stitch> stitches) {
    super(context, R.layout.item_stitches, stitches);
    inflater = LayoutInflater.from(context);
  }

}
