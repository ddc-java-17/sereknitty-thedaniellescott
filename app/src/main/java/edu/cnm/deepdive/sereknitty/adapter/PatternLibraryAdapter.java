package edu.cnm.deepdive.sereknitty.adapter;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.sereknitty.databinding.ItemPatternListBinding;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.viewmodel.PatternLibraryViewModel;
import java.util.List;

/**
 * This {@link Adapter} is the joining element between the data and the view model. This class sends
 * the {@link List} of {@code patterns} to the {@link PatternLibraryViewModel} and populates the
 * layout with data
 */
public class PatternLibraryAdapter extends Adapter<ViewHolder> {

  private final List<Pattern> patterns;
  private final LayoutInflater inflater;
  private final OnPatternClickListener listener;

  /**
   * This constructor initializes {@code patterns}, {@code inflater}, and {@code listener}
   *
   * @param context  {@link Context} is the global information from the activity that allows us to
   *                 share information across multiple fragments
   * @param patterns {@link List} of {@link Pattern} instances that the user has created and saved.
   * @param listener {@link OnPatternClickListener} that listens for when a pattern in the
   *                 {@link RecyclerView} is tapped and initiates whatever code is attached to it.
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

    /**
     * This code binds the view object and interactions with the view to the data.
     *
     * @param position This is the position of the pattern in the {@link RecyclerView}
     */
    void bind(int position) {
      // If you have interactable stuff in your RecyclerView, the listeners go here.
      Pattern pattern = patterns.get(position);
//      binding.patternPicture.setImageURI();
      binding.patternName.setText(pattern.getPatternName());
      binding.patternSubtext.setText(pattern.getPatternDescription());
      binding.getRoot()
          .setOnClickListener((view) -> listener.onPatternClick(pattern, position, view));
    }
  }

  /**
   * This functional interface is an {@link OnClickListener} that allows me to listen for when a
   * {@code pattern} is clicked in the {@link RecyclerView}.
   */
  @FunctionalInterface
  public interface OnPatternClickListener {

    /**
     * This method is the key to keeping this interface a functional interface, so I can use it in
     * the {@link Holder#bind(int) bind} method above.
     *
     * @param pattern  The instance of {@link Pattern}  the user selected from the
     *                 {@link RecyclerView}.
     * @param position The position of the selected {@code pattern} in the {@link RecyclerView}.
     * @param view     The {@link View} object that holds the {@link RecyclerView}.
     */
    void onPatternClick(Pattern pattern, int position, View view);

  }

}
