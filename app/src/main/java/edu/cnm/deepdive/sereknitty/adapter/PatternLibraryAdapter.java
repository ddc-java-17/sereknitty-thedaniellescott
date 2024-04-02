package edu.cnm.deepdive.sereknitty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.sereknitty.databinding.ItemPatternListBinding;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * This {@link Adapter} is the joining element between the data and the view model. This class sends
 * the {@link List} of {@code patterns} to the
 * {@link edu.cnm.deepdive.sereknitty.viewmodel.PatternLibraryViewModel} and populates the layout
 * with data
 */
public class PatternLibraryAdapter extends Adapter<ViewHolder> {

  private final List<Pattern> patterns;
  private final LayoutInflater inflater;
  private final OnPatternClickListener listener;

  /**
   * This constructor is the
   *
   * @param context
   * @param patterns
   * @param listener
   */
  public PatternLibraryAdapter(Context context, List<Pattern> patterns,
      OnPatternClickListener listener) {
    this.patterns = patterns;
    this.inflater = LayoutInflater.from(context);
    this.listener = listener;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    ItemPatternListBinding binding = ItemPatternListBinding.inflate(inflater, viewGroup, false);
    return new Holder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    ((Holder) viewHolder).bind(i);
  }

  @Override
  public int getItemCount() {
    return patterns.size();
  }

  private class Holder extends ViewHolder {

    private final ItemPatternListBinding binding;

    private Holder(@NonNull ItemPatternListBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    void bind(int position) {
      // If you have interactable stuff in your RecyclerView, the listeners go here.
      Pattern pattern = patterns.get(position);
//      binding.patternPicture.setImageURI();
      binding.patternName.setText(pattern.getPatternName());
      binding.patternSubtext.setText(pattern.getPatternDescription());
      binding.getRoot().setOnClickListener((view) -> listener.onPatternClick(pattern, position, view));
    }
  }

  @FunctionalInterface
  public interface OnPatternClickListener {

    void onPatternClick(Pattern pattern, int position, View view);

  }

}
