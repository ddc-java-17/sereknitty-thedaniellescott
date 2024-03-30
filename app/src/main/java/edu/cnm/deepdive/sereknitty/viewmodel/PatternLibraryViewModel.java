package edu.cnm.deepdive.sereknitty.viewmodel;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.User;
import edu.cnm.deepdive.sereknitty.service.PatternRepository;
import edu.cnm.deepdive.sereknitty.service.UserRepository;
import java.util.List;
import javax.inject.Inject;

@HiltViewModel
public class PatternLibraryViewModel extends ViewModel implements DefaultLifecycleObserver {

  private final PatternRepository patternRepository;
  private final UserRepository userRepository;
  private User currentUser;

  @Inject
  public PatternLibraryViewModel(PatternRepository patternRepository, UserRepository userRepository) {
    this.patternRepository = patternRepository;
    this.userRepository = userRepository;
  }

  public LiveData<List<Pattern>> getPatterns() {
    return patternRepository.getAll();
  }
}
