package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.pojo.PatternLocation;
import edu.cnm.deepdive.sereknitty.model.pojo.PatternWithRows;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;

/**
 * Provides CRUD operations on {@link Pattern} entity instances. {@code INSERT}, {@code UPDATE}, and
 * {@code DELETE} operations are implemented as ReactiveX {@link Single} tasks, which execute on
 * subscription; some {@code SELECT} tasks are implemented using {@link LiveData} queries, which
 * execute on observation, or (if already being observed) on Room-based updates to the underlying
 * tables.
 */
@Dao
public interface PatternDao {

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), inserts
   * {@code pattern} into the database and invokes the subscribing {@link Consumer} with the
   * auto-generated primary key value of the inserted record.
   *
   * @param pattern {@link Pattern} instance to be inserted.
   * @return {@link Single} that will (when subscribed to) insert {@code pattern} into the database.
   */
  @Insert
  Single<Long> insert(Pattern pattern);

  /**
   * Constructs and returns a {@link LiveData}-based query of a single pattern, using the primary
   * key value. When observed (or when the contents of the {@code pattern} table are modified using
   * Room methods), the query is executed.
   *
   * @param id Unique identifier (primary key value) of the {@link Pattern} instance of interest.
   * @return {@link LiveData} that can be observed for the {@link Pattern} instance of interest.
   */
  @Transaction
  @Query("SELECT * FROM pattern WHERE pattern_id = :id")
  LiveData<PatternWithRows> select(Long id);

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), updates
   * {@code pattern} to the database.
   *
   * @param pattern {@link Pattern} instance to be updated.
   * @return {@link Single} that will update {@code pattern} to the database.
   */
  @Update
  Single<Integer> update(Pattern pattern);

  /**
   * Updates and passes through a particular pattern, to avoid repeated queries.
   *
   * @param pattern {@link Pattern} to be updated.
   * @return {@link Single} of the updated {@code pattern}.
   */
  default Single<Pattern> updateAndPassThrough(Pattern pattern) {
    return update(pattern)
        .map((count) -> pattern);
  }

  /**
   * Constructs and returns a {@link LiveData}-based query of a single pattern, using the primary
   * key value. When observed (or when the contents of the {@code patternLocation} table are
   * modified using Room methods), the query is executed.
   *
   * @param patternId Unique identifier (primary key value) of the {@link Pattern} instance of
   *                  interest.
   * @return {@link LiveData} that can be observed for the {@link Pattern} instance of interest.
   */
  @Transaction
  @Query("SELECT p.*, r.current_stitch_id FROM pattern AS p "
      + "JOIN `row` AS r ON p.current_row_id = r.row_id "
      + "WHERE p.pattern_id = :patternId")
  LiveData<PatternLocation> getLocation(long patternId);

  /**
   * Constructs and returns a {@link LiveData}-based query of a {@link List} of {@link Pattern}
   * entities. When observed (or when the contents of the {@code pattern} table are modified using
   * Room methods), the query is executed.
   *
   * @return {@link LiveData} that can be observed for the {@link Pattern} instances of interest.
   */
  @Query("SELECT * FROM pattern")
  LiveData<List<Pattern>> select();

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), deletes
   * {@code pattern} from the database and invokes the subscribing {@link Consumer} with the number
   * of records modified.
   *
   * @param pattern {@link Pattern} instance to be deleted.
   * @return {@link Single} that will (when subscribed to) delete {@code pattern} from the database.
   */
  @Delete
  Single<Integer> delete(Pattern pattern);

}
