package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.StitchLocation;
import io.reactivex.rxjava3.core.Single;
import java.util.List;

@Dao
public interface StitchLocationDao {

  @Insert
  List<Long> insert(StitchLocation stitchLocation);

  @Query("SELECT * FROM stitch_location WHERE stitch_location_id = :id")
  LiveData<StitchLocation> select(Long id);

  @Update
  LiveData<StitchLocation> updateStitchLocation(StitchLocation stitchLocation);

  @Delete
  Single<Integer> delete(StitchLocation stitchLocation);

}
