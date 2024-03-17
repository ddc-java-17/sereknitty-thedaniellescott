package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface RowDao {

  @Insert
  Single<Long> insert(Row row);

  @Query("SELECT * FROM row WHERE row_id = :id")
  LiveData<Row> select(Long id);

  @Update
  Single<Integer> update(Row row);

  default Single<Row> updateAndPassThrough(Row row) {
    return update(row)
        .map((count) -> row);
  }

  @Delete
  Single<Integer> delete(Row row);

}
