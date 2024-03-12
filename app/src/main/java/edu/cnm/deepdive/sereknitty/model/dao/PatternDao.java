package edu.cnm.deepdive.sereknitty.model.dao;

import android.app.VoiceInteractor.CompleteVoiceRequest;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.StitchLocation;
import edu.cnm.deepdive.sereknitty.model.entity.User;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface PatternDao {

  // TODO: 2/26/2024 Implement SQL queries for pattern searches

  @Insert
  Single<Long> insert(Pattern pattern);

  @Query("SELECT * FROM pattern WHERE pattern_id = :id")
  LiveData<Pattern> select(Long id);

  @Update
  LiveData<Pattern> updatePattern(Pattern pattern);

  // Frog the pattern... PERMANENTLY! ;P
  @Delete
  Single<Integer> delete(Pattern pattern);

}
