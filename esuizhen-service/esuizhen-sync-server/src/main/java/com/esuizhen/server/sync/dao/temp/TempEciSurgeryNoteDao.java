package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.SurgeryNoteRes;
import com.esuizhen.server.sync.model.temp.SyncEciSurgeryNote;

public interface TempEciSurgeryNoteDao {

	void insert(SyncEciSurgeryNote eciSurgeryNote);

    List<SurgeryNoteRes> getSyncSurgeryNote(TBatchDetailInfo detail);
}
