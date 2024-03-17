package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.sereknitty.model.entity.Stitch;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface StitchDao {

  @Insert
  Single<String> insert(Stitch stitch);

  @Query("SELECT * FROM stitch WHERE stitch_name = :name")
  LiveData<Stitch> select(String name);

}
