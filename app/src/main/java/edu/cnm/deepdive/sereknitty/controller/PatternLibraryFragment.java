package edu.cnm.deepdive.sereknitty.controller;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.databinding.FragmentPatternLibraryBinding;
import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass. Use the {@link PatternLibraryFragment} factory
 * method to create an instance of this fragment.
 */
public class PatternLibraryFragment extends Fragment {

  private FragmentPatternLibraryBinding binding;

  public PatternLibraryFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    binding = FragmentPatternLibraryBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binding.addPattern.setOnClickListener((button) ->
        Navigation.findNavController(button)
            .navigate(PatternLibraryFragmentDirections.navigateToPatternBuilder()));

  }
}