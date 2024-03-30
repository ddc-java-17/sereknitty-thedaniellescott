package edu.cnm.deepdive.sereknitty.controller;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.databinding.FragmentPatternBuilderDialogBinding;

/**
 * This {@link DialogFragment} is the dialogue that will pop up on navigating to the
 * {@link PatternBuilderFragment}. Its purpose is to ask the user to give the dimensions of their
 * new pattern so the pattern builder can build a blank "canvas" in the correct dimensions.
 */
@AndroidEntryPoint
public class PatternBuilderDialogFragment extends DialogFragment {

  private FragmentPatternBuilderDialogBinding binding;

  public PatternBuilderDialogFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    return super.onCreateDialog(savedInstanceState);
  }
}
