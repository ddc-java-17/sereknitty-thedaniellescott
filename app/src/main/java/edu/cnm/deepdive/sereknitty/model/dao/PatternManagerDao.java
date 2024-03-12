package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.PatternManager;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface PatternManagerDao {

  @Insert
  Single<Long> insert(PatternManager patternManager);

  @Query("SELECT * FROM pattern_manager WHERE pattern_manager_id = :id")
  LiveData<PatternManager> select(Long id);

  // TODO: 3/3/2024 Write @Query to link pattern_id and stitch_location_id.

}
