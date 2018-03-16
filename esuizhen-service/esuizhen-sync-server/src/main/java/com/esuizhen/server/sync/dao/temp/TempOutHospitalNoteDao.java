package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.OuthospitalNoteRes;
import com.esuizhen.server.sync.model.temp.SyncOutHospitalNote;

public interface TempOutHospitalNoteDao {

	void insert(SyncOutHospitalNote outHospitalNote);

    List<OuthospitalNoteRes> getSyncOutHospitalNote(TBatchDetailInfo detail);

}
