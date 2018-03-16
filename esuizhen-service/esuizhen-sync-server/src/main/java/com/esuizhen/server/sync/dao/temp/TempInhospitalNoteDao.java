package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.InhospitalNoteRes;
import com.esuizhen.server.sync.model.temp.SyncInhospitalNote;

public interface TempInhospitalNoteDao {

	void insert(SyncInhospitalNote inhospitalNote);

    List<InhospitalNoteRes> getSyncInhospitalNote(TBatchDetailInfo detail);
    
}
