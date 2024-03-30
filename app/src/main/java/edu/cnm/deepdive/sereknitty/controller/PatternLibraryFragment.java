package edu.cnm.deepdive.sereknitty.controller;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.sereknitty.R;
import edu.cnm.deepdive.sereknitty.adapter.PatternLibraryAdapter;
import edu.cnm.deepdive.sereknitty.databinding.FragmentPatternLibraryBinding;
import edu.cnm.deepdive.sereknitty.viewmodel.PatternLibraryViewModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass. Use the {@link PatternLibraryFragment} factory
 * method to create an instance of this fragment.
 */
@AndroidEntryPoint
public class PatternLibraryFragment extends Fragment {

  private static final String TAG = PatternLibraryFragment.class.getSimpleName();
  private FragmentPatternLibraryBinding binding;
  private PatternLibraryViewModel viewModel;
  

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
    ViewModelProvider provider = new ViewModelProvider(requireActivity());
    viewModel = provider.get(PatternLibraryViewModel.class);
    getLifecycle().addObserver(viewModel);
    LifecycleOwner owner = getViewLifecycleOwner();
    viewModel
        .getPatterns()
        .observe(owner, (patterns) -> {
          PatternLibraryAdapter adapter = new PatternLibraryAdapter(requireContext(), patterns,
              (pattern, position, clickedView) -> {
                // TODO: 3/30/2024 Move to the pattern reader fragment with the selected pattern.
                Log.d(TAG, pattern.getPatternName() + " was clicked at position " + position);
          });
          binding.patternLibraryList.setAdapter(adapter);
        });
    binding.addPattern.setOnClickListener((button) ->
        Navigation.findNavController(button)
            .navigate(PatternLibraryFragmentDirections.navigateToPatternBuilder()));


  }
}