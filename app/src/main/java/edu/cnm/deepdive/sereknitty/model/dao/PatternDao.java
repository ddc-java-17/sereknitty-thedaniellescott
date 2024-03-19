package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.User;
import io.reactivex.rxjava3.core.Single;
import java.util.List;

@Dao
public interface PatternDao {

  // TODO: 2/26/2024 Implement SQL queries for pattern searches

  @Insert
  Single<Long> insert(Pattern pattern);

  @Query("SELECT * FROM pattern WHERE pattern_id = :id")
  LiveData<Pattern> select(Long id);

  @Update
  Single<Integer> update(Pattern pattern);

  default Single<Pattern> updateAndPassThrough(Pattern pattern) {
    return update(pattern)
        .map((count) -> pattern);
  }

  // TODO: 3/18/2024 set up recall for currentRowId

  @Query("SELECT * FROM pattern")
  LiveData<List<Pattern>> select();

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), deletes
   * {@code pattern} from the database and invokes the subscribing
   * {@link io.reactivex.rxjava3.functions.Consumer} with the number of records modified.
   *
   * @param pattern {@link Pattern} instance to be deleted.
   * @return {@link Single} that will (when subscribed to) delete {@code pattern} from the database.
   */
  @Delete
  Single<Integer> delete(Pattern pattern);

}
